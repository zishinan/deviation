package com.jz.deviation.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.jz.deviation.model.Article;

public interface ArticleDao extends ElasticsearchRepository<Article, Long>{

}
