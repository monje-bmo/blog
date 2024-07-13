package com.guiro.tech.controller;

import com.guiro.tech.dto.ArticleDto;
import com.guiro.tech.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/articule")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto art) {

        ArticleDto created = articleService.createArticle(art);
        UriComponents uri = UriComponentsBuilder.fromPath("localhost:8080/articule/{id}").buildAndExpand(created.getId());
        return ResponseEntity.created(uri.toUri()).body(created);

    }

    // path/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable int id) {

        ArticleDto getArticle =  articleService.getArticleById(id);
        return ResponseEntity.ok(getArticle);

    }

}
