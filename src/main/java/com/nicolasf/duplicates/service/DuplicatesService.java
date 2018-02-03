package com.nicolasf.duplicates.service;

import com.nicolasf.duplicates.exception.ValueNotFoundException;

public interface DuplicatesService {

    String getFromIndex(int index) throws ValueNotFoundException;

}
