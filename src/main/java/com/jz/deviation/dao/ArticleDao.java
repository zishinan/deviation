package com.jz.deviation.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jz.deviation.model.Article;

public interface ArticleDao extends PagingAndSortingRepository<Article, Long>{
	public Page<Article> findByParentModelIdAndDeletedFalse(long pid,Pageable pageable);
}
