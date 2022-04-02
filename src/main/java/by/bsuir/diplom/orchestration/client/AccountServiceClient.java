package by.bsuir.diplom.orchestration.client;

import by.bsuir.diplom.orchestration.config.YamlPropertySourceFactory;
import by.bsuir.diplom.orchestration.model.AccountEditDto;
import by.bsuir.diplom.orchestration.model.BlockReasonDto;
import by.bsuir.diplom.orchestration.model.UserAccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
@FeignClient(value = "accountServiceClient", url = "${custom.diploma.accountService.url}")
public interface AccountServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/account/{id}")
    UserAccountDto getAccount(@PathVariable long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/account/{id}")
    void editAccount(@PathVariable long id, @RequestBody AccountEditDto accountEditDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "/account/{id}")
    void deleteAccount(@PathVariable long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/account/block/{id}")
    void blockAccount(@PathVariable long id, @RequestBody @Valid BlockReasonDto blockReasonDto);

    @RequestMapping(method = RequestMethod.PATCH, value = "/account/unblock/{id}")
    void unblockAccount(@PathVariable long id);
}
