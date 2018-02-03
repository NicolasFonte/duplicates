package com.nicolasf.duplicates.cache;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class DuplicatesCacheTest {


    @Test
    public void testCacheWorks() {
        List<String> duplicatedEntries = Arrays.asList("A", "A", "A", "B", "B", "C", "C", "C", "C");
        DuplicatesCache.addFreshEntries(duplicatedEntries);

        String entry1 = DuplicatesCache.getEntry(0);
        String entry2 = DuplicatesCache.getEntry(3);
        String entry3 = DuplicatesCache.getEntry(5);

        assertThat(entry1).isEqualTo("A");
        assertThat(entry2).isEqualTo("B");
        assertThat(entry3).isEqualTo("C");
    }

}