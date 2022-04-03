package by.bsuir.diplom.orchestration.model;

import lombok.Data;

import java.time.Period;

@Data
public class CreateDepositDto {

    private Period period;
    private double interestPerYear;
    private long firstDeposit;
    private TypeOfCurrency currency;
}
