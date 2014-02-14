package pl.mmajcherski.faker;

public class Faker {

    public static final String DIGIT_MARKER = "#";
    public static final String LETTER_MARKER = "?";

    private static final TextGenerator DIGIT_GENERATOR = new RandomDigitGenerator();
    private static final TextGenerator LETTER_GENERATOR = new RandomLetterGenerator();

    public static String numerify(String text) {
        return new TextReplacer(text).replaceAll(DIGIT_MARKER, DIGIT_GENERATOR);
    }

    public static String textify(String text) {
        return new TextReplacer(text).replaceAll(LETTER_MARKER, LETTER_GENERATOR);
    }

    public static String bothify(String text) {
        return textify(numerify(text));
    }

}
