package com.guiro.tech.controller;

import com.guiro.tech.dto.ArticleDto;
import com.guiro.tech.dto.ResponseDto;
import com.guiro.tech.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto art) {

        ArticleDto created = articleService.createArticle(art);
        UriComponents uri = UriComponentsBuilder.fromPath("localhost:8080/api/article/{id}").buildAndExpand(created.getId());
        return ResponseEntity.created(uri.toUri()).body(created);

    }

    // path/{id}
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable("id") int id) {

        ArticleDto getArticle = articleService.getArticleById(id);
        return ResponseEntity.ok(getArticle);

    }


    @GetMapping
    public ResponseEntity<Page<ArticleDto>> getAllArticles(@PageableDefault(size = 2, sort = "id") Pageable pageable) {
        var articles = articleService.getAllArticle(pageable);
        return ResponseEntity.ok(articles);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDto> updateArticle(@RequestBody ArticleDto art,
                                                    @PathVariable("id") int id) {
        var articleUpdate = articleService.updateArticle(id, art);
        return ResponseEntity.ok(articleUpdate);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deletearticle(@PathVariable("id") int id) {
        articleService.deleteArticle(id);
        return ResponseEntity.ok(new ResponseDto("Article delete successfully, with id :" + id));
    }


}
