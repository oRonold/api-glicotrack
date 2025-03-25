package br.com.ronald.glucose.service;

import br.com.ronald.glucose.model.Pacient;
import br.com.ronald.glucose.model.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String login(LoginDTO dto){
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(dto.email(), dto.password());
        Authentication authentication = authenticationManager.authenticate(user);
        String token = tokenService.createToken((Pacient) authentication.getPrincipal());
        ResponseCookie cookie = ResponseCookie.from("token", token)
                .httpOnly(true)
                .secure(true)
                .sameSite("Strict")
                .maxAge(Duration.ofHours(2))
                .path("/")
                .build();
        return cookie.toString();
    }

}
