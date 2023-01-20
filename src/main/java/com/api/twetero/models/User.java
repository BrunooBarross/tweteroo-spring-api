package com.api.twetero.models;

import lombok.Data;

import com.api.twetero.dto.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "TB_USER")
public class User {

    public User (UserDTO user) {
        this.username = user.username();
        this.avatar = user.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 15, nullable = false)
    private String username;
    @Column(length = 400, nullable = false)
    private String avatar;
}
