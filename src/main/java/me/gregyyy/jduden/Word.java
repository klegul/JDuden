package me.gregyyy.jduden;

import java.util.Arrays;
import java.util.List;

/**
 * This class contains all information about a word after it was queried from duden.de
 */
public class Word {

    private final String word;
    private final String altSpellings;
    private final List<String> articles;
    private final String wordType;
    private final String wordSeparation;
    private final List<String> meanings;
    private final String origin;

    public Word(String word, String altSpellings, List<String> articles, String wordType, String wordSeparation,
                List<String> meanings, String origin) {
        this.word = word;
        this.altSpellings = altSpellings;
        this.articles = articles;
        this.wordType = wordType;
        this.wordSeparation = wordSeparation;
        this.meanings = meanings;
        this.origin = origin;
    }

    /**
     * Get the word
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Get alternative spellings of the word
     * @return alternative spellings
     */
    public String getAltSpellings() {
        return altSpellings;
    }

    /**
     * Get a {@link List} of articles that can be used with this word
     * @return a {@link List} of articles
     */
    public List<String> getArticles() {
        return articles;
    }

    /**
     * Get the type of the word. Words can have multiple types, when you have multiple articles.
     * @return type of the word
     */
    public String getWordType() {
        return wordType;
    }

    /**
     * Get the separated writing of the word.
     *
     * Example: Ele|fant
     * @return separated writing of the word
     */
    public String getWordSeparation() {
        return wordSeparation;
    }

    /**
     * Get meanings of the word. This does not contain examples, grammar or other information from text boxes.
     * @return a {@link List} of meanings of the word
     */
    public List<String> getMeanings() {
        return meanings;
    }

    /**
     * Get the origin of this word
     * @return origin of the word
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Get all information of this word formatted to a string
     * @return formatted information of the word
     */
    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", altSpellings='" + altSpellings + '\'' +
                ", articles='" + Arrays.toString(articles.toArray()) + '\'' +
                ", wordType='" + wordType + '\'' +
                ", wordSeparation='" + wordSeparation + '\'' +
                ", meanings=" + Arrays.toString(meanings.toArray()) +
                ", origin='" + origin + '\'' +
                '}';
    }

}
