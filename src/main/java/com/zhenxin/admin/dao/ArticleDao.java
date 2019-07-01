package com.zhenxin.admin.dao;

import com.zhenxin.admin.ArticleExample;
import com.zhenxin.pojo.Article;

public class ArticleDao {
    public static ArticleExample findById(int userId){
        ArticleExample articleExample=new ArticleExample();
        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return articleExample;
    }

    public static int insertArticle(Article article){
return  0;
    }






}
