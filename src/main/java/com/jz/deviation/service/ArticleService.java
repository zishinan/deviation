package com.jz.deviation.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jz.deviation.common.Finalvalue;
import com.jz.deviation.dao.ArticleDao;
import com.jz.deviation.model.Article;

@Service
@Transactional(rollbackFor={Exception.class, RuntimeException.class})
public class ArticleService {
	private static final Logger logger = Logger.getLogger(ArticleService.class);
	@Autowired
	private ArticleDao articleDao;
//	@Autowired
//	private Values values;
	
	public List<Article> save(List<Article> articles){
		long curTime = System.currentTimeMillis();
		for (Article article : articles) {
			article.setCreateTime(curTime);
			article.setUpdateTime(curTime);
		}
		articleDao.save(articles);
		return articles;
	}
	
	public List<Article> findByPidAndPage(long pid,int page) {
		Pageable pageable = new PageRequest(page, Finalvalue.PAGE_SIZI);
		Page<Article> articles = articleDao.findByParentModelIdAndDeletedFalse(pid,pageable);
		return articles.getContent();
	}

	public List<Article> update(List<Article> articles) {
		long curTime = System.currentTimeMillis();
		List<Article> result = new ArrayList<Article>();
		for (Article article : articles) {
			Article exist = articleDao.findOne(article.getModelId());
			exist.setTitle(article.getTitle());
			exist.setContent(article.getContent());
			exist.setUpdateTime(curTime);
			result.add(exist);
		}
		return result;
	}

	public List<Article> delete(List<Article> articles) {
		long curTime = System.currentTimeMillis();
		List<Article> result = new ArrayList<Article>();
		for (Article article : articles) {
			Article exist = articleDao.findOne(article.getModelId());
			exist.setDeleted(true);
			exist.setUpdateTime(curTime);
			result.add(exist);
		}
		return result;
	}
	
}
