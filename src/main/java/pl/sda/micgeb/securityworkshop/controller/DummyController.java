package pl.sda.micgeb.securityworkshop.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DummyController {

    @GetMapping
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello from my api!");
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
//    @Secured("ROLE_ADMIN")
    @GetMapping("/forAdmin")
    public ResponseEntity<String> helloForAdmin() {
        return ResponseEntity.ok("Witaj adminie!");
    }

//    @RolesAllowed("USER")
    @GetMapping("/forUser")
    public ResponseEntity<String> helloForUser() {
        return ResponseEntity.ok("Witaj userze!");
    }

    @GetMapping("/forAll")
    public ResponseEntity<String> helloForAll(){
        return ResponseEntity.ok("Witajcie wszyscy");
    }

//    @RolesAllowed("ADMIN")
    @RolesAllowed({"ADMIN", "USER"})
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(){
        return ResponseEntity.ok("Witajcie wszyscy");
    }

}
