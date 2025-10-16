package ar.com.trilla.demo.infrastructure.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello!";
    }
}
