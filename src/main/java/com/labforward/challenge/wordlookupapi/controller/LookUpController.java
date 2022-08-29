package com.labforward.challenge.wordlookupapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labforward.challenge.wordlookupapi.model.Report;

@RestController
@RequestMapping("/lookup")
public class LookUpController {

	@GetMapping(path = "/report")
	public Report getReport() {
		return null;
	}

	@PostMapping(path = "/report")
	public Report postReport() {
		return null;
	}

}
