package by.bsuir.diplom.orchestration.client;

import by.bsuir.diplom.orchestration.config.YamlPropertySourceFactory;
import by.bsuir.diplom.orchestration.model.CreateDepositDto;
import by.bsuir.diplom.orchestration.model.DepositDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
@FeignClient(value = "paymentServiceClient", url = "${custom.diploma.paymentService.url}")
public interface PaymentServiceClient {

    @RequestMapping(method = RequestMethod.GET, value = "/payment")
    ResponseEntity<List<DepositDto>> getDeposits();

    @RequestMapping(method = RequestMethod.GET, value = "/payment/my")
    ResponseEntity<List<DepositDto>> getMyDeposits(long userId);

    @RequestMapping(method = RequestMethod.GET, value = "/payment/{id}")
    ResponseEntity<DepositDto> getSpecificDeposit(long id, long userId);

    @RequestMapping(method = RequestMethod.POST, value = "/payment")
    void createDeposit(CreateDepositDto dto, long userId);

    @RequestMapping(method = RequestMethod.PUT, value = "/payment")
    void closeDeposit(long id, long userId);
}
