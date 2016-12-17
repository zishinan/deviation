package com.jz.deviation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * 整个易家互动的通用用户
 * 
 * @author yangxi
 */
@Document(indexName = "deviation", type = "article", shards = 1, replicas = 0)  
public class Article{
	@Id
	private long modelId;
	private long createTime;
	private long updateTime;
	private boolean deleted;
	private long parentModelId;
	private String title;
	private String content;
	private long readCount;
	private long authUserId;
	private long chiCount;
	private long level;
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
	public long getModelId() {
		return modelId;
	}
	public void setModelId(long modelId) {
		this.modelId = modelId;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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
	public long getChiCount() {
		return chiCount;
	}
	public void setChiCount(long chiCount) {
		this.chiCount = chiCount;
	}
	public long getLevel() {
		return level;
	}
	public void setLevel(long level) {
		this.level = level;
	}
}
