package com.fiction.crawler.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class FictionContent implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer fictionId;

    private Integer page;

    private String fictionContent;

    private static final long serialVersionUID = 1L;

    public FictionContent(Integer id, Date createTime, Date updateTime, Integer fictionId, Integer page, String fictionContent) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.fictionId = fictionId;
        this.page = page;
        this.fictionContent = fictionContent;
    }

    public FictionContent() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFictionId() {
        return fictionId;
    }

    public void setFictionId(Integer fictionId) {
        this.fictionId = fictionId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getFictionContent() {
        return fictionContent;
    }

    public void setFictionContent(String fictionContent) {
        this.fictionContent = fictionContent == null ? null : fictionContent.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FictionContent other = (FictionContent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getFictionId() == null ? other.getFictionId() == null : this.getFictionId().equals(other.getFictionId()))
            && (this.getPage() == null ? other.getPage() == null : this.getPage().equals(other.getPage()))
            && (this.getFictionContent() == null ? other.getFictionContent() == null : this.getFictionContent().equals(other.getFictionContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getFictionId() == null) ? 0 : getFictionId().hashCode());
        result = prime * result + ((getPage() == null) ? 0 : getPage().hashCode());
        result = prime * result + ((getFictionContent() == null) ? 0 : getFictionContent().hashCode());
        return result;
    }
}