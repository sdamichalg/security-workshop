package pl.sda.micgeb.securityworkshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.micgeb.securityworkshop.model.LoginDto;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        return ResponseEntity.ok("user poprawnie zalogowany");
    }
}
