package com.nicolasf.duplicates.controller;

import com.nicolasf.duplicates.exception.ValueNotFoundException;
import com.nicolasf.duplicates.service.DuplicatesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/duplicates")
public class DuplicatesController {

    private final DuplicatesService duplicatesService;

    public DuplicatesController(DuplicatesService duplicatesService) {
        this.duplicatesService = duplicatesService;
    }

    @GetMapping("/{index}")
    public String getFromIndex(@PathVariable Integer index) throws ValueNotFoundException {
        return duplicatesService.getFromIndex(index);
    }

}
