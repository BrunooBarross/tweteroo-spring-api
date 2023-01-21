package com.api.twetero.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.twetero.dto.TweetDTO;
import com.api.twetero.models.Tweet;
import com.api.twetero.services.TweetService;

import jakarta.validation.Valid;

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

	@PostMapping
	public ResponseEntity<Tweet> insertTweet(@RequestHeader(value = "User") String userName,
			@RequestBody @Valid TweetDTO tweet) {
		Tweet obj = service.insertTweet(tweet, userName);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(location).body(obj);
	}

	@GetMapping(value = "/{userName}")
	public ResponseEntity<List<Tweet>> tweetByUser(@PathVariable String userName) {
		List<Tweet> obj = service.getAllUserTweets(userName);
		return ResponseEntity.ok().body(obj);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidation(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();

			errors.put(fieldName, errorMessage);
		});

		return errors;
	}
}
