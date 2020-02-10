package cn.springcloud.book.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class HealthController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/health")
    public String health() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return String.format("%d healthy", port);
    }
}
