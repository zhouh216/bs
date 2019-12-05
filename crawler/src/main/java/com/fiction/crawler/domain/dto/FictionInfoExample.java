package com.fiction.crawler.domain.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FictionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FictionInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andFictionNameIsNull() {
            addCriterion("fiction_name is null");
            return (Criteria) this;
        }

        public Criteria andFictionNameIsNotNull() {
            addCriterion("fiction_name is not null");
            return (Criteria) this;
        }

        public Criteria andFictionNameEqualTo(String value) {
            addCriterion("fiction_name =", value, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameNotEqualTo(String value) {
            addCriterion("fiction_name <>", value, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameGreaterThan(String value) {
            addCriterion("fiction_name >", value, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameGreaterThanOrEqualTo(String value) {
            addCriterion("fiction_name >=", value, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameLessThan(String value) {
            addCriterion("fiction_name <", value, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameLessThanOrEqualTo(String value) {
            addCriterion("fiction_name <=", value, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameLike(String value) {
            addCriterion("fiction_name like", value, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameNotLike(String value) {
            addCriterion("fiction_name not like", value, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameIn(List<String> values) {
            addCriterion("fiction_name in", values, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameNotIn(List<String> values) {
            addCriterion("fiction_name not in", values, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameBetween(String value1, String value2) {
            addCriterion("fiction_name between", value1, value2, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionNameNotBetween(String value1, String value2) {
            addCriterion("fiction_name not between", value1, value2, "fictionName");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorIsNull() {
            addCriterion("fiction_author is null");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorIsNotNull() {
            addCriterion("fiction_author is not null");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorEqualTo(String value) {
            addCriterion("fiction_author =", value, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorNotEqualTo(String value) {
            addCriterion("fiction_author <>", value, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorGreaterThan(String value) {
            addCriterion("fiction_author >", value, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("fiction_author >=", value, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorLessThan(String value) {
            addCriterion("fiction_author <", value, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorLessThanOrEqualTo(String value) {
            addCriterion("fiction_author <=", value, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorLike(String value) {
            addCriterion("fiction_author like", value, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorNotLike(String value) {
            addCriterion("fiction_author not like", value, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorIn(List<String> values) {
            addCriterion("fiction_author in", values, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorNotIn(List<String> values) {
            addCriterion("fiction_author not in", values, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorBetween(String value1, String value2) {
            addCriterion("fiction_author between", value1, value2, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andFictionAuthorNotBetween(String value1, String value2) {
            addCriterion("fiction_author not between", value1, value2, "fictionAuthor");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andIsOverIsNull() {
            addCriterion("is_over is null");
            return (Criteria) this;
        }

        public Criteria andIsOverIsNotNull() {
            addCriterion("is_over is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverEqualTo(String value) {
            addCriterion("is_over =", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotEqualTo(String value) {
            addCriterion("is_over <>", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverGreaterThan(String value) {
            addCriterion("is_over >", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverGreaterThanOrEqualTo(String value) {
            addCriterion("is_over >=", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverLessThan(String value) {
            addCriterion("is_over <", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverLessThanOrEqualTo(String value) {
            addCriterion("is_over <=", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverLike(String value) {
            addCriterion("is_over like", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotLike(String value) {
            addCriterion("is_over not like", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverIn(List<String> values) {
            addCriterion("is_over in", values, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotIn(List<String> values) {
            addCriterion("is_over not in", values, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverBetween(String value1, String value2) {
            addCriterion("is_over between", value1, value2, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsOverNotBetween(String value1, String value2) {
            addCriterion("is_over not between", value1, value2, "isOver");
            return (Criteria) this;
        }

        public Criteria andFictionSizeIsNull() {
            addCriterion("fiction_size is null");
            return (Criteria) this;
        }

        public Criteria andFictionSizeIsNotNull() {
            addCriterion("fiction_size is not null");
            return (Criteria) this;
        }

        public Criteria andFictionSizeEqualTo(String value) {
            addCriterion("fiction_size =", value, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeNotEqualTo(String value) {
            addCriterion("fiction_size <>", value, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeGreaterThan(String value) {
            addCriterion("fiction_size >", value, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeGreaterThanOrEqualTo(String value) {
            addCriterion("fiction_size >=", value, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeLessThan(String value) {
            addCriterion("fiction_size <", value, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeLessThanOrEqualTo(String value) {
            addCriterion("fiction_size <=", value, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeLike(String value) {
            addCriterion("fiction_size like", value, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeNotLike(String value) {
            addCriterion("fiction_size not like", value, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeIn(List<String> values) {
            addCriterion("fiction_size in", values, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeNotIn(List<String> values) {
            addCriterion("fiction_size not in", values, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeBetween(String value1, String value2) {
            addCriterion("fiction_size between", value1, value2, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionSizeNotBetween(String value1, String value2) {
            addCriterion("fiction_size not between", value1, value2, "fictionSize");
            return (Criteria) this;
        }

        public Criteria andFictionTypeIsNull() {
            addCriterion("fiction_type is null");
            return (Criteria) this;
        }

        public Criteria andFictionTypeIsNotNull() {
            addCriterion("fiction_type is not null");
            return (Criteria) this;
        }

        public Criteria andFictionTypeEqualTo(Integer value) {
            addCriterion("fiction_type =", value, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeNotEqualTo(Integer value) {
            addCriterion("fiction_type <>", value, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeGreaterThan(Integer value) {
            addCriterion("fiction_type >", value, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fiction_type >=", value, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeLessThan(Integer value) {
            addCriterion("fiction_type <", value, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeLessThanOrEqualTo(Integer value) {
            addCriterion("fiction_type <=", value, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeIn(List<Integer> values) {
            addCriterion("fiction_type in", values, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeNotIn(List<Integer> values) {
            addCriterion("fiction_type not in", values, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeBetween(Integer value1, Integer value2) {
            addCriterion("fiction_type between", value1, value2, "fictionType");
            return (Criteria) this;
        }

        public Criteria andFictionTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("fiction_type not between", value1, value2, "fictionType");
            return (Criteria) this;
        }

        public Criteria andSexTypeIsNull() {
            addCriterion("sex_type is null");
            return (Criteria) this;
        }

        public Criteria andSexTypeIsNotNull() {
            addCriterion("sex_type is not null");
            return (Criteria) this;
        }

        public Criteria andSexTypeEqualTo(Integer value) {
            addCriterion("sex_type =", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeNotEqualTo(Integer value) {
            addCriterion("sex_type <>", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeGreaterThan(Integer value) {
            addCriterion("sex_type >", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex_type >=", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeLessThan(Integer value) {
            addCriterion("sex_type <", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sex_type <=", value, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeIn(List<Integer> values) {
            addCriterion("sex_type in", values, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeNotIn(List<Integer> values) {
            addCriterion("sex_type not in", values, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeBetween(Integer value1, Integer value2) {
            addCriterion("sex_type between", value1, value2, "sexType");
            return (Criteria) this;
        }

        public Criteria andSexTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sex_type not between", value1, value2, "sexType");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumIsNull() {
            addCriterion("subscription_num is null");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumIsNotNull() {
            addCriterion("subscription_num is not null");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumEqualTo(Integer value) {
            addCriterion("subscription_num =", value, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumNotEqualTo(Integer value) {
            addCriterion("subscription_num <>", value, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumGreaterThan(Integer value) {
            addCriterion("subscription_num >", value, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("subscription_num >=", value, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumLessThan(Integer value) {
            addCriterion("subscription_num <", value, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumLessThanOrEqualTo(Integer value) {
            addCriterion("subscription_num <=", value, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumIn(List<Integer> values) {
            addCriterion("subscription_num in", values, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumNotIn(List<Integer> values) {
            addCriterion("subscription_num not in", values, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumBetween(Integer value1, Integer value2) {
            addCriterion("subscription_num between", value1, value2, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andSubscriptionNumNotBetween(Integer value1, Integer value2) {
            addCriterion("subscription_num not between", value1, value2, "subscriptionNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumIsNull() {
            addCriterion("collect_num is null");
            return (Criteria) this;
        }

        public Criteria andCollectNumIsNotNull() {
            addCriterion("collect_num is not null");
            return (Criteria) this;
        }

        public Criteria andCollectNumEqualTo(Integer value) {
            addCriterion("collect_num =", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotEqualTo(Integer value) {
            addCriterion("collect_num <>", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumGreaterThan(Integer value) {
            addCriterion("collect_num >", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_num >=", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumLessThan(Integer value) {
            addCriterion("collect_num <", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumLessThanOrEqualTo(Integer value) {
            addCriterion("collect_num <=", value, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumIn(List<Integer> values) {
            addCriterion("collect_num in", values, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotIn(List<Integer> values) {
            addCriterion("collect_num not in", values, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumBetween(Integer value1, Integer value2) {
            addCriterion("collect_num between", value1, value2, "collectNum");
            return (Criteria) this;
        }

        public Criteria andCollectNumNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_num not between", value1, value2, "collectNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNull() {
            addCriterion("click_num is null");
            return (Criteria) this;
        }

        public Criteria andClickNumIsNotNull() {
            addCriterion("click_num is not null");
            return (Criteria) this;
        }

        public Criteria andClickNumEqualTo(Integer value) {
            addCriterion("click_num =", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotEqualTo(Integer value) {
            addCriterion("click_num <>", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThan(Integer value) {
            addCriterion("click_num >", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_num >=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThan(Integer value) {
            addCriterion("click_num <", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumLessThanOrEqualTo(Integer value) {
            addCriterion("click_num <=", value, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumIn(List<Integer> values) {
            addCriterion("click_num in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotIn(List<Integer> values) {
            addCriterion("click_num not in", values, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumBetween(Integer value1, Integer value2) {
            addCriterion("click_num between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andClickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("click_num not between", value1, value2, "clickNum");
            return (Criteria) this;
        }

        public Criteria andExtIsNull() {
            addCriterion("ext is null");
            return (Criteria) this;
        }

        public Criteria andExtIsNotNull() {
            addCriterion("ext is not null");
            return (Criteria) this;
        }

        public Criteria andExtEqualTo(String value) {
            addCriterion("ext =", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotEqualTo(String value) {
            addCriterion("ext <>", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThan(String value) {
            addCriterion("ext >", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtGreaterThanOrEqualTo(String value) {
            addCriterion("ext >=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThan(String value) {
            addCriterion("ext <", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLessThanOrEqualTo(String value) {
            addCriterion("ext <=", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtLike(String value) {
            addCriterion("ext like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotLike(String value) {
            addCriterion("ext not like", value, "ext");
            return (Criteria) this;
        }

        public Criteria andExtIn(List<String> values) {
            addCriterion("ext in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotIn(List<String> values) {
            addCriterion("ext not in", values, "ext");
            return (Criteria) this;
        }

        public Criteria andExtBetween(String value1, String value2) {
            addCriterion("ext between", value1, value2, "ext");
            return (Criteria) this;
        }

        public Criteria andExtNotBetween(String value1, String value2) {
            addCriterion("ext not between", value1, value2, "ext");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}