package dev.be.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    @Async("defaultTaskExecutor") // defaultTaskExecutor 빈을 사용
    public void sendEmail() {
        System.out.println("[sendEmail] :: " + Thread.currentThread().getName());
    }


    @Async("messagingTaskExecutor")  // messagingTaskExecutor 빈을 사용
    public void sendEmailWithCustomThreadPool() {
        System.out.println("[sendEmailWithCustomThreadPool] :: " + Thread.currentThread().getName());
    }

}
