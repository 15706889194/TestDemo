package com.zhenxin.pojo;

import java.util.Date;

/**
 * database table is article
 * @mbg.generated do_not_delete_during_merge
 */
public class Article extends BasePojo {
    /**
     * database column is article.article_id
     * @mbg.generated
     */
    private Integer articleId;

    /**
     * 文章标题
     * database column is article.article_title
     * @mbg.generated
     */
    private String articleTitle;

    /**
     * 用户名
     * database column is article.user_id
     * @mbg.generated
     */
    private Integer userId;

    /**
     * 状态  1.已发布  2.未发布
     * database column is article.article_status
     * @mbg.generated
     */
    private Byte articleStatus;

    /**
     * 文章修改时间
     * database column is article.article_update_time
     * @mbg.generated
     */
    private Date articleUpdateTime;

    /**
     * 创建时间
     * database column is article.article_create_time
     * @mbg.generated
     */
    private Date articleCreateTime;

    /**
     * 是否删除（0表示未删除 1表示已经删除）
     * database column is article.is_deleted
     * @mbg.generated
     */
    private Byte isDeleted;

    /**
     * 用户id
     * database column is article.article_content
     * @mbg.generated
     */
    private String articleContent;

    /**
     * @return the value of article.article_id
     * @mbg.generated
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * @param articleId the value for article.article_id
     * @mbg.generated
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * @return the value of article.article_title
     * @mbg.generated
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * @param articleTitle the value for article.article_title
     * @mbg.generated
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    /**
     * @return the value of article.user_id
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the value for article.user_id
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the value of article.article_status
     * @mbg.generated
     */
    public Byte getArticleStatus() {
        return articleStatus;
    }

    /**
     * @param articleStatus the value for article.article_status
     * @mbg.generated
     */
    public void setArticleStatus(Byte articleStatus) {
        this.articleStatus = articleStatus;
    }

    /**
     * @return the value of article.article_update_time
     * @mbg.generated
     */
    public Date getArticleUpdateTime() {
        return articleUpdateTime;
    }

    /**
     * @param articleUpdateTime the value for article.article_update_time
     * @mbg.generated
     */
    public Date setArticleUpdateTime(Date articleUpdateTime) {
       return  this.articleUpdateTime = articleUpdateTime;
    }

    /**
     * @return the value of article.article_create_time
     * @mbg.generated
     */
    public Date getArticleCreateTime() {

        return articleCreateTime;
    }

    /**
     * @param articleCreateTime the value for article.article_create_time
     * @mbg.generated
     */
    public void setArticleCreateTime(Date articleCreateTime) {
        this.articleCreateTime = articleCreateTime;
    }

    /**
     * @return the value of article.is_deleted
     * @mbg.generated
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the value for article.is_deleted
     * @mbg.generated
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return the value of article.article_content
     * @mbg.generated
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * @param articleContent the value for article.article_content
     * @mbg.generated
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }


}