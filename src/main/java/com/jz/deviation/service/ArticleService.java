package com.jz.deviation.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jz.deviation.dao.ArticleDao;
import com.jz.deviation.model.Article;

@Service
public class ArticleService {
	private static final Logger logger = Logger.getLogger(ArticleService.class);
	@Autowired
	private ArticleDao articleDao;
//	@Autowired
//	private Values values;
	
	public Article save(Article article){
		long curTime = System.currentTimeMillis();
		article.setCreateTime(curTime);
		article.setUpdateTime(curTime);
		articleDao.save(article);
		return article;
	}
	
}
