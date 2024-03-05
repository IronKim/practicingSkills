package dev.be.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

    private final EmailService emailService;

    public void asyncCall_1() { // 비동기 O
        System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());
        emailService.sendEmail();
        emailService.sendEmailWithCustomThreadPool();
    }

    public void asyncCall_2() { // 인스턴스 객체 생성 / 비동기 X
        System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());
        EmailService emailService = new EmailService();
        emailService.sendEmail();
        emailService.sendEmailWithCustomThreadPool();
    }

    public void asyncCall_3() { // 내부 메소드를 Async로 호출 / 비동기 X
        System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
        sendMail();
    }

    @Async
    public void sendMail() {
        System.out.println("[sendMail] :: " + Thread.currentThread().getName());
    }

}
