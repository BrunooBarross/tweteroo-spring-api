package com.api.twetero.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import com.api.twetero.dto.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "TB_USER")
public class User {

	public User() {
		super();
	}
	
	public User(UserDTO user) {
		this.username = user.username();
		this.avatar = user.avatar();
	}

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(length = 15, nullable = false, unique = true)
	private String username;
	@Column(length = 400, nullable = false)
	private String avatar;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Tweet> tweets = new ArrayList<>();

	public Long getId() {
		return id;
	}

}
