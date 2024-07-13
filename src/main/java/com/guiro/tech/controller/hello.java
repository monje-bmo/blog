package com.guiro.tech.controller;


import com.guiro.tech.dto.ArticleDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class hello {

    @GetMapping("/hello")
    public String hello_world() {
        ArticleDto dto =new ArticleDto(1,"hello", "World","youtube.com");
        return "Hello";
    }

}
