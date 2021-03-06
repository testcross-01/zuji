package top.testcross.zuji.bean;

import top.testcross.zuji.bean.interfaces.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PamFavoriteExample implements Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public PamFavoriteExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
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

        public Criteria andFavIdIsNull() {
            addCriterion("fav_id is null");
            return (Criteria) this;
        }

        public Criteria andFavIdIsNotNull() {
            addCriterion("fav_id is not null");
            return (Criteria) this;
        }

        public Criteria andFavIdEqualTo(String value) {
            addCriterion("fav_id =", value, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdNotEqualTo(String value) {
            addCriterion("fav_id <>", value, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdGreaterThan(String value) {
            addCriterion("fav_id >", value, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdGreaterThanOrEqualTo(String value) {
            addCriterion("fav_id >=", value, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdLessThan(String value) {
            addCriterion("fav_id <", value, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdLessThanOrEqualTo(String value) {
            addCriterion("fav_id <=", value, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdLike(String value) {
            addCriterion("fav_id like", value, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdNotLike(String value) {
            addCriterion("fav_id not like", value, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdIn(List<String> values) {
            addCriterion("fav_id in", values, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdNotIn(List<String> values) {
            addCriterion("fav_id not in", values, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdBetween(String value1, String value2) {
            addCriterion("fav_id between", value1, value2, "favId");
            return (Criteria) this;
        }

        public Criteria andFavIdNotBetween(String value1, String value2) {
            addCriterion("fav_id not between", value1, value2, "favId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNull() {
            addCriterion("post_id is null");
            return (Criteria) this;
        }

        public Criteria andPostIdIsNotNull() {
            addCriterion("post_id is not null");
            return (Criteria) this;
        }

        public Criteria andPostIdEqualTo(String value) {
            addCriterion("post_id =", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotEqualTo(String value) {
            addCriterion("post_id <>", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThan(String value) {
            addCriterion("post_id >", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdGreaterThanOrEqualTo(String value) {
            addCriterion("post_id >=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThan(String value) {
            addCriterion("post_id <", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLessThanOrEqualTo(String value) {
            addCriterion("post_id <=", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdLike(String value) {
            addCriterion("post_id like", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotLike(String value) {
            addCriterion("post_id not like", value, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdIn(List<String> values) {
            addCriterion("post_id in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotIn(List<String> values) {
            addCriterion("post_id not in", values, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdBetween(String value1, String value2) {
            addCriterion("post_id between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPostIdNotBetween(String value1, String value2) {
            addCriterion("post_id not between", value1, value2, "postId");
            return (Criteria) this;
        }

        public Criteria andPiIdIsNull() {
            addCriterion("pi_id is null");
            return (Criteria) this;
        }

        public Criteria andPiIdIsNotNull() {
            addCriterion("pi_id is not null");
            return (Criteria) this;
        }

        public Criteria andPiIdEqualTo(String value) {
            addCriterion("pi_id =", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotEqualTo(String value) {
            addCriterion("pi_id <>", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThan(String value) {
            addCriterion("pi_id >", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdGreaterThanOrEqualTo(String value) {
            addCriterion("pi_id >=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThan(String value) {
            addCriterion("pi_id <", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLessThanOrEqualTo(String value) {
            addCriterion("pi_id <=", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdLike(String value) {
            addCriterion("pi_id like", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotLike(String value) {
            addCriterion("pi_id not like", value, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdIn(List<String> values) {
            addCriterion("pi_id in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotIn(List<String> values) {
            addCriterion("pi_id not in", values, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdBetween(String value1, String value2) {
            addCriterion("pi_id between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andPiIdNotBetween(String value1, String value2) {
            addCriterion("pi_id not between", value1, value2, "piId");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeIsNull() {
            addCriterion("fav_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeIsNotNull() {
            addCriterion("fav_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeEqualTo(Date value) {
            addCriterion("fav_create_time =", value, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeNotEqualTo(Date value) {
            addCriterion("fav_create_time <>", value, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeGreaterThan(Date value) {
            addCriterion("fav_create_time >", value, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("fav_create_time >=", value, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeLessThan(Date value) {
            addCriterion("fav_create_time <", value, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("fav_create_time <=", value, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeIn(List<Date> values) {
            addCriterion("fav_create_time in", values, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeNotIn(List<Date> values) {
            addCriterion("fav_create_time not in", values, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeBetween(Date value1, Date value2) {
            addCriterion("fav_create_time between", value1, value2, "favCreateTime");
            return (Criteria) this;
        }

        public Criteria andFavCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("fav_create_time not between", value1, value2, "favCreateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pam_favorite
     *
     * @mbggenerated do_not_delete_during_merge Sun Nov 15 12:07:48 GMT+08:00 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pam_favorite
     *
     * @mbggenerated Sun Nov 15 12:07:48 GMT+08:00 2020
     */
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