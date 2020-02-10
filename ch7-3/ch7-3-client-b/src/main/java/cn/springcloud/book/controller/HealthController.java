package cn.springcloud.book.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @Value("${server.port}")
    private Integer port;

    @GetMapping("/health")
    public String health() {
        return String.format("%d healthy", port);
    }
}
