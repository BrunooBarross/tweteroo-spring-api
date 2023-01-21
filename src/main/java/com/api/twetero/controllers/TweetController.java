package com.api.twetero.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.twetero.models.Tweet;
import com.api.twetero.services.TweetService;

@RestController
@RequestMapping(value = "/api/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @GetMapping
    public Page<Tweet> list(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "5") int size) {
        return service.findAll(page, size);
    }
}
