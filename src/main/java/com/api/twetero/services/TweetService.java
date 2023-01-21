package com.api.twetero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.twetero.models.Tweet;
import com.api.twetero.repositories.TweetRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;

    public Page<Tweet> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return new PageImpl<>(
                repository.findAll(),
                pageRequest,
                size);
    }
}