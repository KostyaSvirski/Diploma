package by.bsuir.diplom.orchestration.service;

import by.bsuir.diplom.orchestration.client.PaymentServiceClient;
import by.bsuir.diplom.orchestration.model.CreateDepositDto;
import by.bsuir.diplom.orchestration.model.DepositDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepositService {

    private final PaymentServiceClient paymentServiceClient;

    public List<DepositDto> getDeposits() {
        return paymentServiceClient.getDeposits().getBody();
    }

    public DepositDto getSpecificDeposit(long id) {
        return paymentServiceClient.getSpecificDeposit(id, 0L).getBody();
    }

    public void createDeposit(CreateDepositDto dto) {
        paymentServiceClient.createDeposit(dto, 0L);
    }

    public void closeDeposit(long id) {
        paymentServiceClient.closeDeposit(id, 0L);
    }
}
