package br.com.ronald.glucose.model.dto;

import br.com.ronald.glucose.model.Pacient;

import java.time.LocalDate;

public record PacientEnrollDetailsDTO(Long id, String name, String email, String message) {

    public PacientEnrollDetailsDTO(Pacient pacient){
        this(pacient.getId(), pacient.getName(), pacient.getEmail(), "Enroll successfully done!");
    }
}
