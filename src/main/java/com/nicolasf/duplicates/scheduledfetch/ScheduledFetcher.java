package com.nicolasf.duplicates.scheduledfetch;

import com.nicolasf.duplicates.scheduledfetch.exception.DataNotFetchedClientException;
import com.nicolasf.duplicates.scheduledfetch.service.FetchService;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduledFetcher {

    private final FetchService fetchService;

    public ScheduledFetcher(FetchService fetchService) {
        this.fetchService = fetchService;
    }

    @Scheduled(fixedRateString = "#{${fixedRate} * 1000}")
    public void scheduleDataFetch() throws DataNotFetchedClientException {
        log.info("Making requests to API.");
        try {
            fetchService.fetchEntries();
        } catch (IOException e) {
            log.error("Error when fetching entries on API", e);
            throw new DataNotFetchedClientException("Error when fetching API.", e);
        }
        log.info("Data populated");
    }
}
