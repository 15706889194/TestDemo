package com.zhenxin.controller;
import com.zhenxin.annotation.TokenToUser;
import com.zhenxin.pojo.Article;
import com.zhenxin.pojo.JsonData;
import com.zhenxin.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

/**
 * blog管理
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService  articleService;
    @RequestMapping("/list")
    @ResponseBody
    /**
     * 根据用户查询相关的博客记录
     */

    public JsonData  findArticleById(@TokenToUser int userId){
        List<Article> list =new ArrayList<Article>();
        list =articleService.findArticleById(userId);
        return JsonData.buildSuccess(list);
    }

    /**
     * 新增blog信息
     * @param article
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public JsonData  addArticle(@RequestBody Article article){
        int result= articleService.addArticle(article);
        if(result!=0){
            return JsonData.buildSuccess("新增blog成功");
        }else{
            return JsonData.buildSuccess(-1,"新增blog失败");
        }
    }

    /**
     * 删除blog信息
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public JsonData  deleteArticle( int  articleId){
        int result= articleService.deleteArticle(articleId);
        if(result!=0){
            return JsonData.buildSuccess("删除blog成功");
        }else{
            return JsonData.buildSuccess(-1,"删除blog失败");
        }
    }

    /**
     * 修改blog信息
     * @param article
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public JsonData updtaeArticle(@RequestBody  Article article){
        int result=articleService.updtaeArticle(article);
        if(result!=0){
            return JsonData.buildSuccess("修改blog成功");
        }else{
            return JsonData.buildSuccess(-1,"修改blog失败");
        }
    }








}
