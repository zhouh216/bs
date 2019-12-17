package com.fiction.crawler.domain.dto;

import com.fiction.crawler.validator.FlagValidator;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    @NotNull(message = "名称不能为空")
    private String name;

    @NotNull(message = "密码不能为空")
    private String password;
    @FlagValidator(value = {"0","1"}, message = "用户状态不正确")
    private Integer status;

    private String collectList;

    private String subscriptionList;

    private static final long serialVersionUID = 1L;

    public User(Integer id, Date createTime, Date updateTime, String name, String password, String collectList, String subscriptionList) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.name = name;
        this.password = password;
        this.collectList = collectList;
        this.subscriptionList = subscriptionList;
    }

    public User() {
        super();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getCollectList() {
        return collectList;
    }

    public void setCollectList(String collectList) {
        this.collectList = collectList == null ? null : collectList.trim();
    }

    public String getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(String subscriptionList) {
        this.subscriptionList = subscriptionList == null ? null : subscriptionList.trim();
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getCollectList() == null ? other.getCollectList() == null : this.getCollectList().equals(other.getCollectList()))
            && (this.getSubscriptionList() == null ? other.getSubscriptionList() == null : this.getSubscriptionList().equals(other.getSubscriptionList()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getCollectList() == null) ? 0 : getCollectList().hashCode());
        result = prime * result + ((getSubscriptionList() == null) ? 0 : getSubscriptionList().hashCode());
        return result;
    }
}