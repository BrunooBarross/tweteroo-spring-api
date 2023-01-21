package com.api.twetero.models;

import com.api.twetero.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_TWEET")
public class Tweet {

    public Tweet(TweetDTO tweet) {
        this.tweet = tweet.tweet();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 280, nullable = false)
    private String tweet;

    @ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
}
