package com.jz.deviation.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jz.deviation.common.exception.LogicException;
import com.jz.deviation.model.Article;
import com.jz.deviation.service.ArticleService;

@RestController
@RequestMapping("/articles")
@Api("文章接口")
public class ArticleContrller {
	@Autowired
	private ArticleService articleService;

	private static final Logger logger = Logger.getLogger(ArticleContrller.class);

    @ResponseBody
    @RequestMapping(method=RequestMethod.POST)
    @ApiOperation(value="添加文章",notes="添加新的文章")
    public Article add(@RequestBody Article article) throws LogicException {
    	return articleService.save(article);
    }
    
    
}
