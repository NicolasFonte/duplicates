package com.nicolasf.duplicates.cache;

import static com.nicolasf.duplicates.cache.RLEncoder.decodeRL;
import static com.nicolasf.duplicates.cache.RLEncoder.encodeRL;

import java.util.List;
import java.util.stream.Collectors;

public class DuplicatesCache {

    private static String data = "";

    /**
     * This will be populated by schedule with reasonable time
     * No reason for now to enable thread safety.
     */
    public static void addFreshEntries(List<String> entries) {
        data = "";
        String concatenatedEntries = entries.stream().collect(Collectors.joining());
        data = encodeRL(concatenatedEntries);
    }

    public static String getEntry(int index) {
        String decodedFromRLE = decodeRL(data);
        return String.valueOf(decodedFromRLE.charAt(index));
    }

}
