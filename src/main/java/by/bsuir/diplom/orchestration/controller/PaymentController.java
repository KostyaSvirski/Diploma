package by.bsuir.diplom.orchestration.controller;

import by.bsuir.diplom.orchestration.model.CreateDepositDto;
import by.bsuir.diplom.orchestration.service.DepositService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final DepositService service;

    @GetMapping
    public ResponseEntity<?> getDeposits() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getDeposits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSpecificDeposit(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getSpecificDeposit(id));
    }

    @PostMapping
    public ResponseEntity<?> createDeposit(@RequestBody CreateDepositDto deposit) {
        service.createDeposit(deposit);
        return ResponseEntity.status(HttpStatus.CREATED).body("Your deposit was applied");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> closeDeposit(@PathVariable long id) {
        service.closeDeposit(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Your deposit was closed");
    }
}
