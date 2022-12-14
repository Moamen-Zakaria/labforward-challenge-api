package com.labforward.challenge.wordlookupapi.controller;

import com.labforward.challenge.wordlookupapi.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.labforward.challenge.wordlookupapi.model.Report;

@RestController
@RequestMapping("/lookup")
@CrossOrigin(origins = "*")
public class LookUpController {


    public LookUpController(LookupService lookupService) {
        this.lookupService = lookupService;
    }

    private final LookupService lookupService;

    @GetMapping(path = "/report")
    public Report getReport(@RequestParam String text, @RequestParam String keyword) {
        return lookupService.reportText(text, keyword);
    }

    @PostMapping(path = "/report")
    public Report postReport(@RequestParam String text, @RequestParam String keyword) {
        return lookupService.reportText(text, keyword);
    }

}
