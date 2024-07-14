package com.guiro.tech.service;

import com.guiro.tech.dto.ArticleDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto);

    ArticleDto getArticleById(int id);

    Page<ArticleDto> getAllArticle(Pageable pageable);
}
