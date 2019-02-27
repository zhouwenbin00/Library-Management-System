package cn.test.lms.bean;

import java.util.ArrayList;
import java.util.List;

public class TbUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andBookSetIsNull() {
            addCriterion("book_set is null");
            return (Criteria) this;
        }

        public Criteria andBookSetIsNotNull() {
            addCriterion("book_set is not null");
            return (Criteria) this;
        }

        public Criteria andBookSetEqualTo(String value) {
            addCriterion("book_set =", value, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetNotEqualTo(String value) {
            addCriterion("book_set <>", value, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetGreaterThan(String value) {
            addCriterion("book_set >", value, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetGreaterThanOrEqualTo(String value) {
            addCriterion("book_set >=", value, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetLessThan(String value) {
            addCriterion("book_set <", value, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetLessThanOrEqualTo(String value) {
            addCriterion("book_set <=", value, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetLike(String value) {
            addCriterion("book_set like", value, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetNotLike(String value) {
            addCriterion("book_set not like", value, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetIn(List<String> values) {
            addCriterion("book_set in", values, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetNotIn(List<String> values) {
            addCriterion("book_set not in", values, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetBetween(String value1, String value2) {
            addCriterion("book_set between", value1, value2, "bookSet");
            return (Criteria) this;
        }

        public Criteria andBookSetNotBetween(String value1, String value2) {
            addCriterion("book_set not between", value1, value2, "bookSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetIsNull() {
            addCriterion("reader_set is null");
            return (Criteria) this;
        }

        public Criteria andReaderSetIsNotNull() {
            addCriterion("reader_set is not null");
            return (Criteria) this;
        }

        public Criteria andReaderSetEqualTo(String value) {
            addCriterion("reader_set =", value, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetNotEqualTo(String value) {
            addCriterion("reader_set <>", value, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetGreaterThan(String value) {
            addCriterion("reader_set >", value, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetGreaterThanOrEqualTo(String value) {
            addCriterion("reader_set >=", value, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetLessThan(String value) {
            addCriterion("reader_set <", value, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetLessThanOrEqualTo(String value) {
            addCriterion("reader_set <=", value, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetLike(String value) {
            addCriterion("reader_set like", value, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetNotLike(String value) {
            addCriterion("reader_set not like", value, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetIn(List<String> values) {
            addCriterion("reader_set in", values, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetNotIn(List<String> values) {
            addCriterion("reader_set not in", values, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetBetween(String value1, String value2) {
            addCriterion("reader_set between", value1, value2, "readerSet");
            return (Criteria) this;
        }

        public Criteria andReaderSetNotBetween(String value1, String value2) {
            addCriterion("reader_set not between", value1, value2, "readerSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetIsNull() {
            addCriterion("borrow_set is null");
            return (Criteria) this;
        }

        public Criteria andBorrowSetIsNotNull() {
            addCriterion("borrow_set is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowSetEqualTo(String value) {
            addCriterion("borrow_set =", value, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetNotEqualTo(String value) {
            addCriterion("borrow_set <>", value, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetGreaterThan(String value) {
            addCriterion("borrow_set >", value, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetGreaterThanOrEqualTo(String value) {
            addCriterion("borrow_set >=", value, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetLessThan(String value) {
            addCriterion("borrow_set <", value, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetLessThanOrEqualTo(String value) {
            addCriterion("borrow_set <=", value, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetLike(String value) {
            addCriterion("borrow_set like", value, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetNotLike(String value) {
            addCriterion("borrow_set not like", value, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetIn(List<String> values) {
            addCriterion("borrow_set in", values, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetNotIn(List<String> values) {
            addCriterion("borrow_set not in", values, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetBetween(String value1, String value2) {
            addCriterion("borrow_set between", value1, value2, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andBorrowSetNotBetween(String value1, String value2) {
            addCriterion("borrow_set not between", value1, value2, "borrowSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetIsNull() {
            addCriterion("search_set is null");
            return (Criteria) this;
        }

        public Criteria andSearchSetIsNotNull() {
            addCriterion("search_set is not null");
            return (Criteria) this;
        }

        public Criteria andSearchSetEqualTo(String value) {
            addCriterion("search_set =", value, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetNotEqualTo(String value) {
            addCriterion("search_set <>", value, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetGreaterThan(String value) {
            addCriterion("search_set >", value, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetGreaterThanOrEqualTo(String value) {
            addCriterion("search_set >=", value, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetLessThan(String value) {
            addCriterion("search_set <", value, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetLessThanOrEqualTo(String value) {
            addCriterion("search_set <=", value, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetLike(String value) {
            addCriterion("search_set like", value, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetNotLike(String value) {
            addCriterion("search_set not like", value, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetIn(List<String> values) {
            addCriterion("search_set in", values, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetNotIn(List<String> values) {
            addCriterion("search_set not in", values, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetBetween(String value1, String value2) {
            addCriterion("search_set between", value1, value2, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSearchSetNotBetween(String value1, String value2) {
            addCriterion("search_set not between", value1, value2, "searchSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetIsNull() {
            addCriterion("system_set is null");
            return (Criteria) this;
        }

        public Criteria andSystemSetIsNotNull() {
            addCriterion("system_set is not null");
            return (Criteria) this;
        }

        public Criteria andSystemSetEqualTo(String value) {
            addCriterion("system_set =", value, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetNotEqualTo(String value) {
            addCriterion("system_set <>", value, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetGreaterThan(String value) {
            addCriterion("system_set >", value, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetGreaterThanOrEqualTo(String value) {
            addCriterion("system_set >=", value, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetLessThan(String value) {
            addCriterion("system_set <", value, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetLessThanOrEqualTo(String value) {
            addCriterion("system_set <=", value, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetLike(String value) {
            addCriterion("system_set like", value, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetNotLike(String value) {
            addCriterion("system_set not like", value, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetIn(List<String> values) {
            addCriterion("system_set in", values, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetNotIn(List<String> values) {
            addCriterion("system_set not in", values, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetBetween(String value1, String value2) {
            addCriterion("system_set between", value1, value2, "systemSet");
            return (Criteria) this;
        }

        public Criteria andSystemSetNotBetween(String value1, String value2) {
            addCriterion("system_set not between", value1, value2, "systemSet");
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