package com.api.twetero.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotBlank(message = "username não pode ser vazio") 
        String username,
        @NotNull 
        @Size(max = 400, message = "O link do avatar não pode passar de 400 caracteres")
        @Pattern(regexp = "(http(s?):)([\\/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)", message = "Link não compátivel - regex (http(s?):)([\\/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)") 
        String avatar) {

}
