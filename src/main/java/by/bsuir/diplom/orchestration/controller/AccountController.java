package by.bsuir.diplom.orchestration.controller;

import by.bsuir.diplom.orchestration.model.AccountEditDto;
import by.bsuir.diplom.orchestration.model.BlockReasonDto;
import by.bsuir.diplom.orchestration.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@RestController("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAccount(@PathVariable @NotBlank long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAccount(id));
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMyAccount() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getMe());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editAccount(@PathVariable @NotBlank long id, @RequestBody AccountEditDto accountEditDto) {
        service.editAccount(id, accountEditDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Optional.of("Account with id " + id + " was edited"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable @NotBlank long id) {
        service.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Optional.of("Account with id " + id + " was deleted"));
    }

    @PutMapping("/block/{id}")
    public ResponseEntity<?> blockAccount(@PathVariable @NotBlank long id,
                                          @RequestBody @Valid BlockReasonDto blockReasonDto) {
        service.blockAccount(id, blockReasonDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Optional.of("Account with id " + id + " was blocked"));
    }

    @PatchMapping("/unblock/{id}")
    public ResponseEntity<?> unblockAccount(@PathVariable @NotBlank long id) {
        service.unblockAccount(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(Optional.of("Account with id " + id + " was unblocked"));
    }

}

