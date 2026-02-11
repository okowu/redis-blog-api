package com.okowu.app.blogapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Comment {
    private Article article;
    private Author author;
    private Integer commentCount;
}
