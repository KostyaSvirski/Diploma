package by.bsuir.diplom.orchestration.config;

import feign.RequestInterceptor;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("Accept", "application/json" );
            requestTemplate.header("x-api-key", "1");
        };
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    public static class CustomErrorDecoder implements ErrorDecoder {
        @Override
        public Exception decode(String methodKey, Response response) {

            switch (response.status()){
                case 400:
                    return new Exception("BAD REQUEST");
                case 404:
                    return new Exception("NOT FOUND");
                default:
                    return new Exception("Generic error");
            }
        }
    }

}
