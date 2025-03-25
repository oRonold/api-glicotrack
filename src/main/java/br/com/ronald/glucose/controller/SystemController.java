package br.com.ronald.glucose.controller;

import br.com.ronald.glucose.model.dto.LoginDTO;
import br.com.ronald.glucose.model.dto.TokenDTO;
import br.com.ronald.glucose.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO dto){
        String token = loginService.login(dto);
        return ResponseEntity.ok().header("Set-cookie", token).body("Authentication successfully");
    }
}
