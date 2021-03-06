package com.bikeshare.ncs.bean;

import java.util.ArrayList;
import java.util.List;

public class NcsHourUsageExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public NcsHourUsageExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
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
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdIsNull() {
            addCriterion("bikeinfo_id is null");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdIsNotNull() {
            addCriterion("bikeinfo_id is not null");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdEqualTo(Long value) {
            addCriterion("bikeinfo_id =", value, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdNotEqualTo(Long value) {
            addCriterion("bikeinfo_id <>", value, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdGreaterThan(Long value) {
            addCriterion("bikeinfo_id >", value, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("bikeinfo_id >=", value, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdLessThan(Long value) {
            addCriterion("bikeinfo_id <", value, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdLessThanOrEqualTo(Long value) {
            addCriterion("bikeinfo_id <=", value, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdIn(List<Long> values) {
            addCriterion("bikeinfo_id in", values, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdNotIn(List<Long> values) {
            addCriterion("bikeinfo_id not in", values, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdBetween(Long value1, Long value2) {
            addCriterion("bikeinfo_id between", value1, value2, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andBikeinfoIdNotBetween(Long value1, Long value2) {
            addCriterion("bikeinfo_id not between", value1, value2, "bikeinfoId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNull() {
            addCriterion("region_id is null");
            return (Criteria) this;
        }

        public Criteria andRegionIdIsNotNull() {
            addCriterion("region_id is not null");
            return (Criteria) this;
        }

        public Criteria andRegionIdEqualTo(Long value) {
            addCriterion("region_id =", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotEqualTo(Long value) {
            addCriterion("region_id <>", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThan(Long value) {
            addCriterion("region_id >", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("region_id >=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThan(Long value) {
            addCriterion("region_id <", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdLessThanOrEqualTo(Long value) {
            addCriterion("region_id <=", value, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdIn(List<Long> values) {
            addCriterion("region_id in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotIn(List<Long> values) {
            addCriterion("region_id not in", values, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdBetween(Long value1, Long value2) {
            addCriterion("region_id between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andRegionIdNotBetween(Long value1, Long value2) {
            addCriterion("region_id not between", value1, value2, "regionId");
            return (Criteria) this;
        }

        public Criteria andDayIdIsNull() {
            addCriterion("day_id is null");
            return (Criteria) this;
        }

        public Criteria andDayIdIsNotNull() {
            addCriterion("day_id is not null");
            return (Criteria) this;
        }

        public Criteria andDayIdEqualTo(Long value) {
            addCriterion("day_id =", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotEqualTo(Long value) {
            addCriterion("day_id <>", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdGreaterThan(Long value) {
            addCriterion("day_id >", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("day_id >=", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdLessThan(Long value) {
            addCriterion("day_id <", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdLessThanOrEqualTo(Long value) {
            addCriterion("day_id <=", value, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdIn(List<Long> values) {
            addCriterion("day_id in", values, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotIn(List<Long> values) {
            addCriterion("day_id not in", values, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdBetween(Long value1, Long value2) {
            addCriterion("day_id between", value1, value2, "dayId");
            return (Criteria) this;
        }

        public Criteria andDayIdNotBetween(Long value1, Long value2) {
            addCriterion("day_id not between", value1, value2, "dayId");
            return (Criteria) this;
        }

        public Criteria andHourIsNull() {
            addCriterion("hour is null");
            return (Criteria) this;
        }

        public Criteria andHourIsNotNull() {
            addCriterion("hour is not null");
            return (Criteria) this;
        }

        public Criteria andHourEqualTo(Integer value) {
            addCriterion("hour =", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotEqualTo(Integer value) {
            addCriterion("hour <>", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThan(Integer value) {
            addCriterion("hour >", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourGreaterThanOrEqualTo(Integer value) {
            addCriterion("hour >=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThan(Integer value) {
            addCriterion("hour <", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourLessThanOrEqualTo(Integer value) {
            addCriterion("hour <=", value, "hour");
            return (Criteria) this;
        }

        public Criteria andHourIn(List<Integer> values) {
            addCriterion("hour in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotIn(List<Integer> values) {
            addCriterion("hour not in", values, "hour");
            return (Criteria) this;
        }

        public Criteria andHourBetween(Integer value1, Integer value2) {
            addCriterion("hour between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andHourNotBetween(Integer value1, Integer value2) {
            addCriterion("hour not between", value1, value2, "hour");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNull() {
            addCriterion("temperature is null");
            return (Criteria) this;
        }

        public Criteria andTemperatureIsNotNull() {
            addCriterion("temperature is not null");
            return (Criteria) this;
        }

        public Criteria andTemperatureEqualTo(Double value) {
            addCriterion("temperature =", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotEqualTo(Double value) {
            addCriterion("temperature <>", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThan(Double value) {
            addCriterion("temperature >", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureGreaterThanOrEqualTo(Double value) {
            addCriterion("temperature >=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThan(Double value) {
            addCriterion("temperature <", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureLessThanOrEqualTo(Double value) {
            addCriterion("temperature <=", value, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureIn(List<Double> values) {
            addCriterion("temperature in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotIn(List<Double> values) {
            addCriterion("temperature not in", values, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureBetween(Double value1, Double value2) {
            addCriterion("temperature between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andTemperatureNotBetween(Double value1, Double value2) {
            addCriterion("temperature not between", value1, value2, "temperature");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageIsNull() {
            addCriterion("register_usage is null");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageIsNotNull() {
            addCriterion("register_usage is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageEqualTo(Long value) {
            addCriterion("register_usage =", value, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageNotEqualTo(Long value) {
            addCriterion("register_usage <>", value, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageGreaterThan(Long value) {
            addCriterion("register_usage >", value, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageGreaterThanOrEqualTo(Long value) {
            addCriterion("register_usage >=", value, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageLessThan(Long value) {
            addCriterion("register_usage <", value, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageLessThanOrEqualTo(Long value) {
            addCriterion("register_usage <=", value, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageIn(List<Long> values) {
            addCriterion("register_usage in", values, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageNotIn(List<Long> values) {
            addCriterion("register_usage not in", values, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageBetween(Long value1, Long value2) {
            addCriterion("register_usage between", value1, value2, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andRegisterUsageNotBetween(Long value1, Long value2) {
            addCriterion("register_usage not between", value1, value2, "registerUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageIsNull() {
            addCriterion("unregister_usage is null");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageIsNotNull() {
            addCriterion("unregister_usage is not null");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageEqualTo(Long value) {
            addCriterion("unregister_usage =", value, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageNotEqualTo(Long value) {
            addCriterion("unregister_usage <>", value, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageGreaterThan(Long value) {
            addCriterion("unregister_usage >", value, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageGreaterThanOrEqualTo(Long value) {
            addCriterion("unregister_usage >=", value, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageLessThan(Long value) {
            addCriterion("unregister_usage <", value, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageLessThanOrEqualTo(Long value) {
            addCriterion("unregister_usage <=", value, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageIn(List<Long> values) {
            addCriterion("unregister_usage in", values, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageNotIn(List<Long> values) {
            addCriterion("unregister_usage not in", values, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageBetween(Long value1, Long value2) {
            addCriterion("unregister_usage between", value1, value2, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andUnregisterUsageNotBetween(Long value1, Long value2) {
            addCriterion("unregister_usage not between", value1, value2, "unregisterUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageIsNull() {
            addCriterion("total_usage is null");
            return (Criteria) this;
        }

        public Criteria andTotalUsageIsNotNull() {
            addCriterion("total_usage is not null");
            return (Criteria) this;
        }

        public Criteria andTotalUsageEqualTo(Long value) {
            addCriterion("total_usage =", value, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageNotEqualTo(Long value) {
            addCriterion("total_usage <>", value, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageGreaterThan(Long value) {
            addCriterion("total_usage >", value, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageGreaterThanOrEqualTo(Long value) {
            addCriterion("total_usage >=", value, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageLessThan(Long value) {
            addCriterion("total_usage <", value, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageLessThanOrEqualTo(Long value) {
            addCriterion("total_usage <=", value, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageIn(List<Long> values) {
            addCriterion("total_usage in", values, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageNotIn(List<Long> values) {
            addCriterion("total_usage not in", values, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageBetween(Long value1, Long value2) {
            addCriterion("total_usage between", value1, value2, "totalUsage");
            return (Criteria) this;
        }

        public Criteria andTotalUsageNotBetween(Long value1, Long value2) {
            addCriterion("total_usage not between", value1, value2, "totalUsage");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated do_not_delete_during_merge Fri Apr 24 12:51:23 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ncs_hour_usage
     *
     * @mbg.generated Fri Apr 24 12:51:23 CST 2020
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