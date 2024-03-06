package dev.be.feign.feign.client;

import dev.be.feign.common.dto.BaseRequestInfo;
import dev.be.feign.common.dto.BaseResponseInfo;
import dev.be.feign.feign.config.DemoFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient( // FeignClient 어노테이션을 사용하여 FeignClient를 사용할 수 있게 한다.
        name = "demo-client", // name 속성을 사용하여 FeignClient의 이름을 지정한다.
        url = "${feign.url.prefix}", // url 속성을 사용하여 FeignClient의 url을 지정한다. 이 속성은 application.yml 파일에 정의된다.
        configuration = DemoFeignConfig.class // configuration 속성을 사용하여 FeignClient의 설정을 지정한다.
)
public interface DemoFeignClient {

    @GetMapping("/get") // http://localhost:8080/target_server/get
    ResponseEntity<BaseResponseInfo> callGet(@RequestHeader("CustomHeaderName") String customHeader,
                                             @RequestParam("name") String name,
                                             @RequestParam("age") Long age);

    @PostMapping("/post") // http://localhost:8080/target_server/post
    ResponseEntity<BaseResponseInfo> callPost(@RequestHeader("CustomHeaderName") String customHeader,
                                             @RequestBody BaseRequestInfo baseRequestInfo);

    @GetMapping("/error") // http://localhost:8080/target_server/error
    ResponseEntity<BaseResponseInfo> callErrorDecoder();

}
