package by.bsuir.diplom.orchestration.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class DepositDto extends CreateDepositDto {

    private long id;
    private long userId;
    private LocalDateTime timeOfStartingDeposit;
    private long currentSumOfDeposit;
}
