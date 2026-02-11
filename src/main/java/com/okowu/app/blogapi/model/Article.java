package com.okowu.app.blogapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    private Long id;
    private String title;
    private String content;
    private Long authorId;
}
