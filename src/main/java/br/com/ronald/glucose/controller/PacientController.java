package br.com.ronald.glucose.controller;

import br.com.ronald.glucose.model.Pacient;
import br.com.ronald.glucose.model.dto.*;
import br.com.ronald.glucose.service.GlucoseService;
import br.com.ronald.glucose.service.PacientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pacients")
public class PacientController {

    @Autowired
    private PacientService service;

    @Autowired
    private GlucoseService glucoseService;

    @PostMapping
    @Transactional
    public ResponseEntity<PacientEnrollDetailsDTO> enroll(@RequestBody @Valid PacientEnrollDTO dto, UriComponentsBuilder builder){
        Pacient pacient = service.enroll(dto);
        URI uri = builder.path("/{id}").buildAndExpand(pacient.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacientEnrollDetailsDTO(pacient));
    }

    @PutMapping("/forgot-password")
    @Transactional
    public ResponseEntity<PacientNewPasswordDTO> forgotPassword(@RequestBody @Valid NewPasswordDTO dto){
        var pacient = service.changePassword(dto);
        return ResponseEntity.ok().body(new PacientNewPasswordDTO(pacient));
    }

    @PostMapping("/glucose-measure")
    @Transactional
    public ResponseEntity<PacientMeasureDetailsDTO> newGlucoseMeasure(@RequestBody @Valid PacientGlucoseMeasureDTO dto, UriComponentsBuilder builder){
        var glucose = glucoseService.glucoseMeasure(dto);
        var uri = builder.path("/{id}").buildAndExpand(glucose.getId()).toUri();
        return ResponseEntity.created(uri).body(new PacientMeasureDetailsDTO(glucose));
    }
}
