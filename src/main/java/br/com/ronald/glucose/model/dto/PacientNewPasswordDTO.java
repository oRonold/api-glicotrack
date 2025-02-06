package br.com.ronald.glucose.model.dto;

import br.com.ronald.glucose.model.Pacient;

public record PacientNewPasswordDTO(String password, String message) {

    public PacientNewPasswordDTO(Pacient pacient){
        this(pacient.getPassword(), "Password changed succesfully");
    }
}
