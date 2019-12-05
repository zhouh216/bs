package com.fiction.crawler.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class FictionInfo implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String fictionName;

    private String fictionAuthor;

    private String img;

    private String isOver;

    private String fictionSize;

    private Integer fictionType;

    private Integer sexType;

    private Integer subscriptionNum;

    private Integer collectNum;

    private Integer clickNum;

    private String ext;

    private static final long serialVersionUID = 1L;

    public FictionInfo(Integer id, Date createTime, Date updateTime, String fictionName, String fictionAuthor, String img, String isOver, String fictionSize, Integer fictionType, Integer sexType, Integer subscriptionNum, Integer collectNum, Integer clickNum, String ext) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.fictionName = fictionName;
        this.fictionAuthor = fictionAuthor;
        this.img = img;
        this.isOver = isOver;
        this.fictionSize = fictionSize;
        this.fictionType = fictionType;
        this.sexType = sexType;
        this.subscriptionNum = subscriptionNum;
        this.collectNum = collectNum;
        this.clickNum = clickNum;
        this.ext = ext;
    }

    public FictionInfo() {
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

    public String getFictionName() {
        return fictionName;
    }

    public void setFictionName(String fictionName) {
        this.fictionName = fictionName == null ? null : fictionName.trim();
    }

    public String getFictionAuthor() {
        return fictionAuthor;
    }

    public void setFictionAuthor(String fictionAuthor) {
        this.fictionAuthor = fictionAuthor == null ? null : fictionAuthor.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getIsOver() {
        return isOver;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver == null ? null : isOver.trim();
    }

    public String getFictionSize() {
        return fictionSize;
    }

    public void setFictionSize(String fictionSize) {
        this.fictionSize = fictionSize == null ? null : fictionSize.trim();
    }

    public Integer getFictionType() {
        return fictionType;
    }

    public void setFictionType(Integer fictionType) {
        this.fictionType = fictionType;
    }

    public Integer getSexType() {
        return sexType;
    }

    public void setSexType(Integer sexType) {
        this.sexType = sexType;
    }

    public Integer getSubscriptionNum() {
        return subscriptionNum;
    }

    public void setSubscriptionNum(Integer subscriptionNum) {
        this.subscriptionNum = subscriptionNum;
    }

    public Integer getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectNum = collectNum;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
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
        FictionInfo other = (FictionInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getFictionName() == null ? other.getFictionName() == null : this.getFictionName().equals(other.getFictionName()))
            && (this.getFictionAuthor() == null ? other.getFictionAuthor() == null : this.getFictionAuthor().equals(other.getFictionAuthor()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getIsOver() == null ? other.getIsOver() == null : this.getIsOver().equals(other.getIsOver()))
            && (this.getFictionSize() == null ? other.getFictionSize() == null : this.getFictionSize().equals(other.getFictionSize()))
            && (this.getFictionType() == null ? other.getFictionType() == null : this.getFictionType().equals(other.getFictionType()))
            && (this.getSexType() == null ? other.getSexType() == null : this.getSexType().equals(other.getSexType()))
            && (this.getSubscriptionNum() == null ? other.getSubscriptionNum() == null : this.getSubscriptionNum().equals(other.getSubscriptionNum()))
            && (this.getCollectNum() == null ? other.getCollectNum() == null : this.getCollectNum().equals(other.getCollectNum()))
            && (this.getClickNum() == null ? other.getClickNum() == null : this.getClickNum().equals(other.getClickNum()))
            && (this.getExt() == null ? other.getExt() == null : this.getExt().equals(other.getExt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getFictionName() == null) ? 0 : getFictionName().hashCode());
        result = prime * result + ((getFictionAuthor() == null) ? 0 : getFictionAuthor().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getIsOver() == null) ? 0 : getIsOver().hashCode());
        result = prime * result + ((getFictionSize() == null) ? 0 : getFictionSize().hashCode());
        result = prime * result + ((getFictionType() == null) ? 0 : getFictionType().hashCode());
        result = prime * result + ((getSexType() == null) ? 0 : getSexType().hashCode());
        result = prime * result + ((getSubscriptionNum() == null) ? 0 : getSubscriptionNum().hashCode());
        result = prime * result + ((getCollectNum() == null) ? 0 : getCollectNum().hashCode());
        result = prime * result + ((getClickNum() == null) ? 0 : getClickNum().hashCode());
        result = prime * result + ((getExt() == null) ? 0 : getExt().hashCode());
        return result;
    }
}