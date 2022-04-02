package by.bsuir.diplom.orchestration.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AccountController {

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.of(Optional.of("ok"));
    }

}
