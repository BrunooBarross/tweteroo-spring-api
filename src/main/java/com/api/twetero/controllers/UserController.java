package com.api.twetero.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.twetero.dto.UserDTO;
import com.api.twetero.models.User;
import com.api.twetero.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/auth")
public class UserController {
    
    @Autowired
    private UserService service;

    @PostMapping(value = "/sign-up")
    public ResponseEntity<User> singUp(@RequestBody @Valid UserDTO obj) {
        User user = service.insert(obj);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
                return ResponseEntity.created(location).body(user);
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
