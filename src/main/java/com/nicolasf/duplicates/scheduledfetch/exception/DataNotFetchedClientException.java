package com.nicolasf.duplicates.scheduledfetch.exception;

import java.io.IOException;

public class DataNotFetchedClientException extends Exception {

    public DataNotFetchedClientException(String message, IOException ex) {
        super(message, ex);
    }
}
