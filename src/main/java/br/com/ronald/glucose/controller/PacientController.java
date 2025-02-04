package br.com.ronald.glucose.controller;

import br.com.ronald.glucose.model.Pacient;
import br.com.ronald.glucose.model.dto.PacientEnrollDTO;
import br.com.ronald.glucose.model.dto.PacientEnrollDetailsDTO;
import br.com.ronald.glucose.service.PacientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacients")
public class PacientController {

    @Autowired
    private PacientService service;

    @PostMapping
    @Transactional
    public ResponseEntity<PacientEnrollDetailsDTO> enroll(@RequestBody @Valid PacientEnrollDTO dto, UriComponentsBuilder builder){
        Pacient pacient = service.enroll(dto);
        URI uri = builder.path("/{id}").buildAndExpand(pacient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacientEnrollDetailsDTO(pacient));
    }
}
