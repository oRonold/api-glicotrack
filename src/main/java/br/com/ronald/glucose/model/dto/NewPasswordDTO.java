package br.com.ronald.glucose.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record NewPasswordDTO(
        @Email
        @NotBlank
        String email,
        @NotBlank
        String password) {
}
