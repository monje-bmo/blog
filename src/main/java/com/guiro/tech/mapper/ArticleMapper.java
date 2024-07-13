package com.guiro.tech.mapper;

import com.guiro.tech.dto.ArticleDto;
import com.guiro.tech.entity.ArticleEntity;

public class ArticleMapper {
    public static ArticleDto mapToArticle(ArticleEntity articleEntity) {
        return new ArticleDto(
                articleEntity.getId(),
                articleEntity.getTitle(),
                articleEntity.getContent(),
                articleEntity.getLink()
        );
    }

    public static ArticleEntity mapToArticleEntity(ArticleDto articleDto) {
        return new ArticleEntity(
                articleDto.getId(),
                articleDto.getTitle(),
                articleDto.getContent(),
                articleDto.getLink()
        );
    }
}
