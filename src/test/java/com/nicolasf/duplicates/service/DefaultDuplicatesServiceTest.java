package com.nicolasf.duplicates.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.nicolasf.duplicates.cache.DuplicatesCache;
import com.nicolasf.duplicates.exception.ValueNotFoundException;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DefaultDuplicatesServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private DefaultDuplicatesService defaultDuplicatesService;

    @Before
    public void setUp() {
        defaultDuplicatesService = new DefaultDuplicatesService();
    }

    @Test
    public void testGetFromIndexWithValidIndex() throws Exception {
        DuplicatesCache.addFreshEntries(Arrays.asList("A", "A", "A", "B", "B"));

        String indexedEntry = defaultDuplicatesService.getFromIndex(0);

        assertThat("A").isEqualTo(indexedEntry);
    }

    @Test
    public void testGetFromIndexWithNegativeIndexThrowsException() throws Exception {
        DuplicatesCache.addFreshEntries(Arrays.asList("A", "A", "A", "B", "B"));

        thrown.expectMessage("Index cannot be negative");
        thrown.expect(ValueNotFoundException.class);

        defaultDuplicatesService.getFromIndex(-1);
    }

    @Test
    public void testGetFromIndexWithNotBoundIndexThrowsException() throws Exception {
        DuplicatesCache.addFreshEntries(Arrays.asList("A", "A", "A", "B", "B"));

        thrown.expectMessage("No value found from given index! Index too high!");
        thrown.expect(ValueNotFoundException.class);

        defaultDuplicatesService.getFromIndex(10);
    }

}