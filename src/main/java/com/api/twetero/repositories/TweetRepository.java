package com.api.twetero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.twetero.models.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

}
