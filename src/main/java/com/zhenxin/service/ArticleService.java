package com.zhenxin.service;

import com.zhenxin.pojo.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ArticleService {
    List<Article> findArticleById(int userId);

    int  addArticle(Article article);

    int deleteArticle(int articleId);

    int updtaeArticle(Article article);
}
