package com.vuongideas.showsaround.helper;

public class StringHelper {
    public static String toCamelCase(String input) {
        StringBuilder builder = new StringBuilder();        
        String[] words = input.split("\\s+");
        for (String word : words) {
            builder.append(Character.toUpperCase(word.charAt(0)));
            builder.append(word.substring(1));
        }
        return builder.toString();
    }
}
