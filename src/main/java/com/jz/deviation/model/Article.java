package com.jz.deviation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;

import com.jz.deviation.common.CommonModel;

/**
 * 文章
 * @author yangxi
 */
@Entity
@Table(name = "article")
@DynamicUpdate(true)
public class Article extends CommonModel implements Serializable{
	private static final long serialVersionUID = -3646308004668890794L;
	private long parentModelId;//父节点id
	private String title;//标题
	@Type(type = "text")
	private String content;//文章内容
	private long readCount;//阅读数
	private long authUserId;//作者id
	private long starCount;//点赞数
	private long level;//节点层级，0表示开篇
	public long getParentModelId() {
		return parentModelId;
	}
	public void setParentModelId(long parentModelId) {
		this.parentModelId = parentModelId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getReadCount() {
		return readCount;
	}
	public void setReadCount(long readCount) {
		this.readCount = readCount;
	}
	public long getAuthUserId() {
		return authUserId;
	}
	public void setAuthUserId(long authUserId) {
		this.authUserId = authUserId;
	}
	public long getStarCount() {
		return starCount;
	}
	public void setStarCount(long starCount) {
		this.starCount = starCount;
	}
	public long getLevel() {
		return level;
	}
	public void setLevel(long level) {
		this.level = level;
	}
}
