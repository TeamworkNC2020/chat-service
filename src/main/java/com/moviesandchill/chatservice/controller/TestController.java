package com.moviesandchill.chatservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@Tag(name = "Тестовый контролер", description = "контроллер для проверки работоспособности спринга")
public class TestController {

    @GetMapping()
    @Operation(description = "метод, возвращающий строку 'hello world!'")
    private String hello() {
        return "hello world!";
    }
}
