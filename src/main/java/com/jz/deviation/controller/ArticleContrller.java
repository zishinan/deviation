package com.jz.deviation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jz.deviation.model.Article;
import com.jz.deviation.service.ArticleService;

@RestController
@RequestMapping("/articles")
@Api("文章接口")
public class ArticleContrller {
	@Autowired
	private ArticleService articleService;

	private static final Logger logger = Logger.getLogger(ArticleContrller.class);

    @RequestMapping(method=RequestMethod.POST)
    @ApiOperation(value="添加文章",notes="添加新的文章")
    public List<Article> add(@RequestBody List<Article> articles) throws Exception {
    	return articleService.save(articles);
    }
    
    @RequestMapping(method=RequestMethod.PUT)
    
    @ApiOperation(value="更新文章",notes="更新文章内容")
    public List<Article> update(@RequestBody List<Article> articles) throws Exception {
    	return articleService.update(articles);
    }
    
    @RequestMapping(method=RequestMethod.DELETE)
    @ApiOperation(value="删除文章",notes="删除文章")
    public List<Article> delete(@RequestBody List<Article> articles) throws Exception {
    	return articleService.delete(articles);
    }
    
    @RequestMapping(value="/parent/{pid}/page/{page}",method=RequestMethod.GET)
    @ApiOperation(value="分页获取文章",notes="必须传入页数")
    public List<Article> getByPage(@PathVariable("pid") long pid,@PathVariable("page") int page) throws Exception {
    	return articleService.findByPidAndPage(pid,page);
    }
    
    
}