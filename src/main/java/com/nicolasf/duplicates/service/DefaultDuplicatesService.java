package com.nicolasf.duplicates.service;

import com.nicolasf.duplicates.exception.ValueNotFoundException;
import com.nicolasf.duplicates.cache.DuplicatesCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DefaultDuplicatesService implements DuplicatesService {

    @Override
    public String getFromIndex(int index) throws ValueNotFoundException {
        if (index < 0) {
            throw new ValueNotFoundException("Index cannot be negative");
        }
        String entry;
        try {
            entry = DuplicatesCache.getEntry(index);
        } catch (StringIndexOutOfBoundsException ex) {
            log.error("indexed value required was not populated from API.");
            throw new ValueNotFoundException("No value found from given index! Index too high!");
        }

        return entry;
    }
}
