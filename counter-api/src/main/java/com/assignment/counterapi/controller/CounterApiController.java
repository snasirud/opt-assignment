package com.assignment.counterapi.controller;

import com.assignment.counterapi.service.GenericService;
import com.assignment.counterapi.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/counter-api")
public class CounterApiController {

    @Autowired
    private GenericService userService;

    @Autowired
    private ParagraphService paragraphService;

    @RequestMapping(path = "/search", method = RequestMethod.POST, produces = { "application/json"})
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public ResponseEntity<Object> search(@RequestBody Map<String, List<String>> searchText) {

        var searchResult = paragraphService.search(searchText.get("searchText"));
        return new ResponseEntity<Object>(searchResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/top/{topListing}", method = RequestMethod.GET, produces = {"text/csv"})
    public  ResponseEntity<Object> top(@PathVariable int topListing) {

        var topListingResult = paragraphService.top(topListing);
        return new ResponseEntity<Object>(topListingResult, HttpStatus.OK);
    }

}