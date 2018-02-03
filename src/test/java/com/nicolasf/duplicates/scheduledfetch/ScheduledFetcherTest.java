package com.nicolasf.duplicates.scheduledfetch;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nicolasf.duplicates.scheduledfetch.exception.DataNotFetchedClientException;
import com.nicolasf.duplicates.scheduledfetch.service.FetchService;
import java.io.IOError;
import java.io.IOException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ScheduledFetcherTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private FetchService fetchService;

    private ScheduledFetcher fetcher;

    @Before
    public void setUp() throws Exception {
        fetcher = new ScheduledFetcher(fetchService);
    }

    @Test
    public void testEntriesAreFetch() throws Exception {
        fetcher.scheduleDataFetch();

        verify(fetchService, only()).fetchEntries();
    }

    @Test
    public void testEntriesFetchErrorThrowsIOException() throws Exception {
        doThrow(new IOException()).when(fetchService).fetchEntries();

        thrown.expectMessage("Error when fetching API.");
        thrown.expect(DataNotFetchedClientException.class);

        fetcher.scheduleDataFetch();
    }

}