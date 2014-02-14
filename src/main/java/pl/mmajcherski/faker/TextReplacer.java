package pl.mmajcherski.faker;

import java.util.StringTokenizer;

class TextReplacer {

    private final String text;

    public TextReplacer(String text) {
        this.text = text;
    }

    public String replaceAll(String stringToReplace, TextGenerator replacementStrategy) {
        StringBuilder outputText = new StringBuilder();
        StringTokenizer st = new StringTokenizer(text, stringToReplace, true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals(stringToReplace)) {
                outputText.append(replacementStrategy.generate());
            } else {
                outputText.append(token);
            }
        }
        return outputText.toString();
    }
}
