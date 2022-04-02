package by.bsuir.diplom.orchestration.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAccountDto {

    private long id;
    private LocalDate dateOfBirth;
    private String name;
    private String surname;

}
