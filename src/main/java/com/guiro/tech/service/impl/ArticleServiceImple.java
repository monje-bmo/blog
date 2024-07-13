package com.guiro.tech.service.impl;

import com.guiro.tech.dto.ArticleDto;
import com.guiro.tech.entity.ArticleEntity;
import com.guiro.tech.exceptions.ResourceNotFoundException;
import com.guiro.tech.mapper.ArticleMapper;
import com.guiro.tech.repository.RepositoryArticle;
import com.guiro.tech.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ArticleServiceImple implements ArticleService {


    private RepositoryArticle repo;

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {

        ArticleEntity article = ArticleMapper.mapToArticleEntity(articleDto);
        ArticleEntity savedArticle = repo.save(article);
        return ArticleMapper.mapToArticle(savedArticle);
    }

    @Override
    public ArticleDto getArticleById(int id) {

        ArticleEntity articleEntity = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Article is not exist with given id :  " + id));
        return ArticleMapper.mapToArticle(articleEntity);
    }

    ;


}
