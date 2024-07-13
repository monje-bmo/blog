package com.guiro.tech.service;

import com.guiro.tech.controller.ArticleController;
import com.guiro.tech.dto.ArticleDto;
import com.guiro.tech.entity.ArticleEntity;
import com.guiro.tech.repository.RepositoryArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto);

    ArticleDto getArticleById(int id);
}
