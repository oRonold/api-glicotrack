package br.com.ronald.glucose.service;

import br.com.ronald.glucose.model.Pacient;
import br.com.ronald.glucose.model.dto.NewPasswordDTO;
import br.com.ronald.glucose.model.dto.PacientEnrollDTO;
import br.com.ronald.glucose.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PacientService {

    @Autowired
    private PacientRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public Pacient enroll(PacientEnrollDTO dto){
        Pacient pacient = new Pacient(dto, encoder.encode(dto.password()));
        return repository.save(pacient);
    }

    public Pacient changePassword(NewPasswordDTO dto){
        if(repository.findbyEmail(dto.email()) == null){
            throw new RuntimeException("Email does not exists");
        }
        var pacient = repository.findbyEmail(dto.email());
        pacient.setPassword(dto.password());
        return repository.save(pacient);
    }
}
