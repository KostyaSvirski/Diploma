package by.bsuir.diplom.orchestration.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BlockReasonDto {

    @NotBlank
    private String blockReason;
}
