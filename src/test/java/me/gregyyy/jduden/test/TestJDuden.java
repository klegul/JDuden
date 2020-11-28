package me.gregyyy.jduden.test;

import me.gregyyy.jduden.JDuden;
import me.gregyyy.jduden.Word;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestJDuden {

    @Test
    public void testWordElefant() throws IOException {
        Word word = JDuden.getWord("Elefant");
        Assert.assertNull(word.getAltSpellings());
        Assert.assertEquals("Elefant", word.getWord());
        Assert.assertEquals("Substantiv, maskulin", word.getWordType());
        Assert.assertEquals("Ele|fant", word.getWordSeparation());
        Assert.assertTrue(word.getMeanings().contains("großes, massiges Säugetier mit grauer, fast unbehaarter Haut, " +
                "sehr großen, beweglichen Ohren, einer zum Rüssel verlängerten Nase und langen, weißen Stoßzähnen") &&
                word.getMeanings().size() == 1);
        Assert.assertTrue(word.getArticles().contains("der") && word.getArticles().size() == 1);
        Assert.assertEquals("mittelhochdeutsch elefant, althochdeutsch elpfant, elafant < " +
                "lateinisch elephantus < griechisch eléphas (Genitiv: eléphantos), zu ägyptisch āb(u), koptisch eb(o)u = " +
                "Elfenbein, Elefant", word.getOrigin());
    }

    @Test
    public void testWordJoghurt() throws IOException {
        Word word = JDuden.getWord("Joghurt");
        Assert.assertEquals("Jogurt", word.getAltSpellings());
        Assert.assertEquals("Joghurt", word.getWord());
        Assert.assertEquals("Substantiv, maskulin, oder Substantiv, feminin, oder Substantiv, Neutrum",
                word.getWordType());
        Assert.assertEquals("Jo|ghurt, Jo|gurt", word.getWordSeparation());
        Assert.assertTrue(word.getMeanings().contains("durch Zusetzen bestimmter Milchsäurebakterien gewonnene Art " +
                "Sauermilch") && word.getMeanings().size() == 1);
        Assert.assertTrue(word.getArticles().contains("der") && word.getArticles().contains("die") &&
                word.getArticles().contains("das") && word.getArticles().size() == 3);
        Assert.assertEquals("türkisch yoğurt", word.getOrigin());
    }

    @Test
    public void testWordWort() throws IOException {
        Word word = JDuden.getWord("Wort");
        Assert.assertNull(word.getAltSpellings());
        Assert.assertEquals("Wort", word.getWord());
        Assert.assertEquals("Substantiv, Neutrum", word.getWordType());
        Assert.assertEquals("Wort", word.getWordSeparation());
        Assert.assertTrue(word.getMeanings().contains("kleinste selbstständige sprachliche Einheit von Lautung " +
                "(2) und Inhalt (2a) bzw. Bedeutung") && word.getMeanings().contains("Wort (1a) in speziellem Hinblick " +
                "auf seinen bestimmten Inhalt, Sinn; Ausdruck, Begriff") && word.getMeanings().contains("etwas, was " +
                "jemand als Ausdruck seiner Gedanken, Gefühle o. Ä. zusammenhängend äußert; Äußerung") &&
                word.getMeanings().contains("Ausspruch") && word.getMeanings().contains("Text, besonders Liedtext") &&
                word.getMeanings().contains("förmliches Versprechen; Versicherung") &&
                word.getMeanings().contains("Kanon, Sammlung heiliger Schriften, besonders die darin enthaltene " +
                        "Glaubenslehre") && word.getMeanings().contains("Logos (4)") && word.getMeanings().size() == 8);
        Assert.assertTrue(word.getArticles().contains("das") && word.getArticles().size() == 1);
        Assert.assertEquals("mittelhochdeutsch, althochdeutsch wort, eigentlich = feierlich Gesprochenes",
                word.getOrigin());
    }

    @Test
    public void testWordShoppen() throws IOException {
        Word word = JDuden.getWord("shoppen");
        Assert.assertNull(word.getAltSpellings());
        Assert.assertEquals("shoppen", word.getWord());
        Assert.assertEquals("schwaches Verb", word.getWordType());
        Assert.assertEquals("shop|pen", word.getWordSeparation());
        Assert.assertTrue(word.getMeanings().contains("einen Einkaufsbummel machen, einkaufen") &&
                word.getMeanings().size() == 1);
        Assert.assertEquals(0, word.getArticles().size());
        Assert.assertEquals("zu englisch to shop, zu: shop, Shop", word.getOrigin());
    }

}
