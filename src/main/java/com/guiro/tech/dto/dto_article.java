package com.guiro.tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class dto_article {
    private int id;
    private String title;
    private String content;
    private String link;
}
