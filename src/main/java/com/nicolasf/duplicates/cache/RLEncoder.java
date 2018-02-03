package com.nicolasf.duplicates.cache;

class RLEncoder {

    static String encodeRL(String repeatedText) {
        if (repeatedText == null || repeatedText.isEmpty()) {
            return "";
        }
        if (repeatedText.length() == 1) {
            return encodeUnit(repeatedText);
        }

        StringBuilder prefix = new StringBuilder();
        int i = 0;
        do {
            prefix.append(repeatedText.charAt(i));
            i++;
        } while (i < repeatedText.length() && repeatedText.charAt(i - 1) == repeatedText.charAt(i));
        if (i < repeatedText.length() && repeatedText.charAt(i - 1) != repeatedText.charAt(i)) {
            return encodeUnit(prefix.toString()) + encodeRL(repeatedText.substring(prefix.length()));
        }

        return encodeUnit(repeatedText);
    }

    private static String encodeUnit(String chaine) {
        return "" + chaine.length() + chaine.charAt(0);

    }

    static String decodeRL(String encoded) {
        StringBuilder decodedText = new StringBuilder();

        char[] encodedChars = encoded.toCharArray();

        int i = 0;
        while (i < encodedChars.length) {
            int repeat = 0;
            while ((i < encodedChars.length) && Character.isDigit(encodedChars[i])) {
                repeat = repeat * 10 + encodedChars[i++] - '0';
            }
            StringBuilder repeatedChar = new StringBuilder();
            while ((i < encodedChars.length) && !Character.isDigit(encodedChars[i])) {
                repeatedChar.append(encodedChars[i++]);
            }

            if (repeat > 0) {
                for (int j = 0; j < repeat; j++) {
                    decodedText.append(repeatedChar.toString());
                }
            } else {
                decodedText.append(repeatedChar.toString());
            }
        }

        return decodedText.toString();
    }
}
