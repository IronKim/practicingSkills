package dev.be.async.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync // 비동기 처리를 위한 어노테이션
public class AsyncConfig {
}
