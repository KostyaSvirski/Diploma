package by.bsuir.diplom.orchestration.service;

import by.bsuir.diplom.orchestration.client.AccountServiceClient;
import by.bsuir.diplom.orchestration.model.AccountEditDto;
import by.bsuir.diplom.orchestration.model.BlockReasonDto;
import by.bsuir.diplom.orchestration.model.UserAccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountServiceClient accountServiceClient;

    public UserAccountDto getAccount(long id) {
        return accountServiceClient.getAccount(id);
    }

    public UserAccountDto getMe() {
        var details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        return accountServiceClient.getAccount(1);
    }

    public void editAccount(long id, AccountEditDto dto) {
        accountServiceClient.editAccount(id, dto);
    }

    public void deleteAccount(long id){
        accountServiceClient.deleteAccount(id);
    }

    public void blockAccount(long id, BlockReasonDto dto) {
        accountServiceClient.blockAccount(id, dto);
    }

    public void unblockAccount(long id) {
        accountServiceClient.unblockAccount(id);
    }

}
