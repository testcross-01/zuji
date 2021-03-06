package top.testcross.zuji.bean;

import top.testcross.zuji.bean.interfaces.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BmMessageHExample implements Example {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public BmMessageHExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
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
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
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

        public Criteria andMsgIdIsNull() {
            addCriterion("msg_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("msg_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(String value) {
            addCriterion("msg_id =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(String value) {
            addCriterion("msg_id <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(String value) {
            addCriterion("msg_id >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_id >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(String value) {
            addCriterion("msg_id <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(String value) {
            addCriterion("msg_id <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLike(String value) {
            addCriterion("msg_id like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotLike(String value) {
            addCriterion("msg_id not like", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<String> values) {
            addCriterion("msg_id in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<String> values) {
            addCriterion("msg_id not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(String value1, String value2) {
            addCriterion("msg_id between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(String value1, String value2) {
            addCriterion("msg_id not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNull() {
            addCriterion("msg_type is null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNotNull() {
            addCriterion("msg_type is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeEqualTo(Byte value) {
            addCriterion("msg_type =", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotEqualTo(Byte value) {
            addCriterion("msg_type <>", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThan(Byte value) {
            addCriterion("msg_type >", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("msg_type >=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThan(Byte value) {
            addCriterion("msg_type <", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThanOrEqualTo(Byte value) {
            addCriterion("msg_type <=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIn(List<Byte> values) {
            addCriterion("msg_type in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotIn(List<Byte> values) {
            addCriterion("msg_type not in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeBetween(Byte value1, Byte value2) {
            addCriterion("msg_type between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("msg_type not between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdIsNull() {
            addCriterion("msg_ac_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdIsNotNull() {
            addCriterion("msg_ac_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdEqualTo(String value) {
            addCriterion("msg_ac_user_id =", value, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdNotEqualTo(String value) {
            addCriterion("msg_ac_user_id <>", value, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdGreaterThan(String value) {
            addCriterion("msg_ac_user_id >", value, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_ac_user_id >=", value, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdLessThan(String value) {
            addCriterion("msg_ac_user_id <", value, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdLessThanOrEqualTo(String value) {
            addCriterion("msg_ac_user_id <=", value, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdLike(String value) {
            addCriterion("msg_ac_user_id like", value, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdNotLike(String value) {
            addCriterion("msg_ac_user_id not like", value, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdIn(List<String> values) {
            addCriterion("msg_ac_user_id in", values, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdNotIn(List<String> values) {
            addCriterion("msg_ac_user_id not in", values, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdBetween(String value1, String value2) {
            addCriterion("msg_ac_user_id between", value1, value2, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgAcUserIdNotBetween(String value1, String value2) {
            addCriterion("msg_ac_user_id not between", value1, value2, "msgAcUserId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdIsNull() {
            addCriterion("msg_src_id is null");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdIsNotNull() {
            addCriterion("msg_src_id is not null");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdEqualTo(String value) {
            addCriterion("msg_src_id =", value, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdNotEqualTo(String value) {
            addCriterion("msg_src_id <>", value, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdGreaterThan(String value) {
            addCriterion("msg_src_id >", value, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdGreaterThanOrEqualTo(String value) {
            addCriterion("msg_src_id >=", value, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdLessThan(String value) {
            addCriterion("msg_src_id <", value, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdLessThanOrEqualTo(String value) {
            addCriterion("msg_src_id <=", value, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdLike(String value) {
            addCriterion("msg_src_id like", value, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdNotLike(String value) {
            addCriterion("msg_src_id not like", value, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdIn(List<String> values) {
            addCriterion("msg_src_id in", values, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdNotIn(List<String> values) {
            addCriterion("msg_src_id not in", values, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdBetween(String value1, String value2) {
            addCriterion("msg_src_id between", value1, value2, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgSrcIdNotBetween(String value1, String value2) {
            addCriterion("msg_src_id not between", value1, value2, "msgSrcId");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateIsNull() {
            addCriterion("msg_create_date is null");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateIsNotNull() {
            addCriterion("msg_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateEqualTo(Date value) {
            addCriterion("msg_create_date =", value, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateNotEqualTo(Date value) {
            addCriterion("msg_create_date <>", value, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateGreaterThan(Date value) {
            addCriterion("msg_create_date >", value, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("msg_create_date >=", value, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateLessThan(Date value) {
            addCriterion("msg_create_date <", value, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("msg_create_date <=", value, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateIn(List<Date> values) {
            addCriterion("msg_create_date in", values, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateNotIn(List<Date> values) {
            addCriterion("msg_create_date not in", values, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateBetween(Date value1, Date value2) {
            addCriterion("msg_create_date between", value1, value2, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("msg_create_date not between", value1, value2, "msgCreateDate");
            return (Criteria) this;
        }

        public Criteria andMsgContIsNull() {
            addCriterion("msg_cont is null");
            return (Criteria) this;
        }

        public Criteria andMsgContIsNotNull() {
            addCriterion("msg_cont is not null");
            return (Criteria) this;
        }

        public Criteria andMsgContEqualTo(String value) {
            addCriterion("msg_cont =", value, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContNotEqualTo(String value) {
            addCriterion("msg_cont <>", value, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContGreaterThan(String value) {
            addCriterion("msg_cont >", value, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContGreaterThanOrEqualTo(String value) {
            addCriterion("msg_cont >=", value, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContLessThan(String value) {
            addCriterion("msg_cont <", value, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContLessThanOrEqualTo(String value) {
            addCriterion("msg_cont <=", value, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContLike(String value) {
            addCriterion("msg_cont like", value, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContNotLike(String value) {
            addCriterion("msg_cont not like", value, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContIn(List<String> values) {
            addCriterion("msg_cont in", values, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContNotIn(List<String> values) {
            addCriterion("msg_cont not in", values, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContBetween(String value1, String value2) {
            addCriterion("msg_cont between", value1, value2, "msgCont");
            return (Criteria) this;
        }

        public Criteria andMsgContNotBetween(String value1, String value2) {
            addCriterion("msg_cont not between", value1, value2, "msgCont");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bm_message_h
     *
     * @mbggenerated do_not_delete_during_merge Fri Nov 13 23:23:31 GMT+08:00 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table bm_message_h
     *
     * @mbggenerated Fri Nov 13 23:23:31 GMT+08:00 2020
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