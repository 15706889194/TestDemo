package com.zhenxin.admin;

import com.zhenxin.pojo.Article;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMapper {
    /**
     * @mbg.generated
     */
    long countByExample(ArticleExample example);

    /**
     * @mbg.generated
     */
    int insert(Article record);

    /**
     * @mbg.generated
     */
    int insertSelective(Article record);

    /**
     * @mbg.generated
     */
    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    /**
     * @mbg.generated
     */
    List<Article> selectByExample(ArticleExample example);

    /**
     * @mbg.generated
     */
    Article selectByPrimaryKey(Integer articleId);

    /**
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * @mbg.generated
     */
    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     * @mbg.generated
     */
    int updateByPrimaryKey(Article record);
}