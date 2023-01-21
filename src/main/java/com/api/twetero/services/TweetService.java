package com.api.twetero.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.api.twetero.dto.TweetDTO;
import com.api.twetero.models.Tweet;
import com.api.twetero.models.User;
import com.api.twetero.repositories.TweetRepository;
import com.api.twetero.repositories.UserRepository;

@Service
public class TweetService {

    @Autowired
    private TweetRepository repository;
    
    @Autowired
    private UserRepository userRepository;

    public Page<Tweet> findAll(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        
        return new PageImpl<>(
                repository.findAll(),
                pageRequest,
                size);
    }

    public Tweet insertTweet(TweetDTO req, String userName) {
        try {
        	User user = userRepository.getReferenceByusername(userName);
            if (user == null) {
              return null;
            }
        	Tweet obj = new Tweet(req, user);
			return repository.save(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }
}