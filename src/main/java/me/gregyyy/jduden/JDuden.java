package me.gregyyy.jduden;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class JDuden {

    /**
     * Get the word from duden.de. See {@link Word} for all information that can be obtained.
     * @param word          the word that will be requested
     * @return              a {@link Word} containing all information that was available on duden.de
     * @throws IOException  will be thrown in exception occurs while querying duden.de
     */
    public static Word getWord(String word) throws IOException {
        Document doc = Jsoup.connect("https://www.duden.de/rechtschreibung/" + word)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 88.69; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6").get();

        String dWord = getElementByClassOrNull(doc, "lemma__main");
        String altSpellings = getElementByClassOrNull(doc, "lemma__alt-spelling");
        List<String> articles = new ArrayList<>();
        if (doc.getElementsByClass("lemma__determiner").size() > 0){
            articles = Arrays.asList(Objects.requireNonNull(getElementByClassOrNull(doc, "lemma__determiner"))
                    .split("(, | oder )"));
        }
        String wordType = getElementByCSSOrNull(doc,
                ".tabloid__main-column > article:nth-child(3) > dl:nth-child(3) > dd:nth-child(2)");

        String wordSeparation = null;
        for(Element element : doc.getElementById("rechtschreibung").children()){
            if(element.className().equals("tuple")){
                boolean valueNext = false;
                for(Element element1 : element.children()){
                    if(element1.className().equals("tuple__key") && element1.text().equals("Worttrennung")){
                        valueNext = true;
                    }else if(valueNext){
                        wordSeparation = element1.text();
                        break;
                    }
                }
            }
        }

        List<String> meanings = new ArrayList<>();
        if(doc.getElementById("bedeutung") != null){
            doc.getElementById("bedeutung").children().stream().filter(element -> element.nodeName().equals("p"))
                    .findFirst().ifPresent(element -> meanings.add(element.text()));
        }else{
            doc.getElementById("bedeutungen").children().stream().filter(element -> element.className().equals("enumeration")).findFirst().ifPresent(element -> {
                for(Element items : element.children()){
                    for(Element entries : items.children()){
                        if(entries.className().equals("enumeration__text")){
                            meanings.add(entries.text());
                        }else if(entries.className().equals("enumeration__sub")){
                            for(Element subitems : entries.children()){
                                for(Element subitemsEntries : subitems.children()){
                                    if(subitemsEntries.className().equals("enumeration__text")) {
                                        meanings.add(subitemsEntries.text());
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }

        AtomicReference<String> origin = new AtomicReference<>();
        if(doc.getElementById("herkunft") != null){
            doc.getElementById("herkunft").children().stream().filter(element -> element.nodeName().equals("p")).findFirst().ifPresent(element -> origin.set(element.text()));
        }

        return new Word(dWord, altSpellings, articles, wordType, wordSeparation, meanings, origin.get());
    }

    private static String getElementByClassOrNull(Document doc, String className){
        if(doc.body().getElementsByClass(className).size() > 0){
            return doc.body().getElementsByClass(className).get(0).text();
        }else{
            return null;
        }
    }

    private static String getElementByCSSOrNull(Document doc, String cssPath){
        if(doc.body().select(cssPath).size() > 0){
            return doc.body().select(cssPath).get(0).text();
        }else{
            return null;
        }
    }

}
