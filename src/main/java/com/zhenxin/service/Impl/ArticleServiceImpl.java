package com.zhenxin.service.Impl;

import com.alibaba.druid.util.StringUtils;
import com.zhenxin.admin.ArticleMapper;
import com.zhenxin.admin.UserMapper;
import com.zhenxin.admin.dao.ArticleDao;
import com.zhenxin.pojo.Article;
import com.zhenxin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户id查询所有博客
     * @param userId
     * @return
     */

    public List<Article> findArticleById(@RequestParam("user_id")  int userId) {
        List<Article> list =new ArrayList<Article>();
        list=articleMapper.selectByExampleWithBLOBs(ArticleDao.findById(userId));
        return list;
    }

    /**
     * 新增blog
     * @param article
     * @return
     */

    public int addArticle(Article article) {
        if(article.getUserId()==0){
            return 0;
        }
        List<Article> list =new ArrayList<Article>();
        list=articleMapper.selectByExample(ArticleDao.findById(article.getUserId()));
        if(list.size()==0){
            return 0;
        }
        if(StringUtils.isEmpty(article.getArticleTitle())){
            return 0;
        }
        if(0==article.getUserId()){
            return 0;
        }
        article.setArticleCreateTime(new Date());
        article.setIsDeleted(Byte.valueOf("0"));
        int result =articleMapper.insert(article);
        return result;
    }

    /**
     *删除文章
     * @param articleId
     * @return
     */

    public int deleteArticle(int articleId) {
        Article article = new Article();
        article.setIsDeleted(Byte.valueOf("1"));
        article.setArticleUpdateTime(new Date());
        int result = articleMapper.updateByExampleSelective(article, ArticleDao.findById(articleId));
        return result;

    }

    public int updtaeArticle(Article article) {
        if(0==article.getArticleId()){
            return 0;
        }
        article.setArticleUpdateTime(new Date());
        int result = articleMapper.updateByPrimaryKeySelective(article);
        return result;
    }
}
