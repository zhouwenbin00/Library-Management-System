package cn.test.lms.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRecordExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBookNumIsNull() {
            addCriterion("book_num is null");
            return (Criteria) this;
        }

        public Criteria andBookNumIsNotNull() {
            addCriterion("book_num is not null");
            return (Criteria) this;
        }

        public Criteria andBookNumEqualTo(String value) {
            addCriterion("book_num =", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotEqualTo(String value) {
            addCriterion("book_num <>", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumGreaterThan(String value) {
            addCriterion("book_num >", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumGreaterThanOrEqualTo(String value) {
            addCriterion("book_num >=", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumLessThan(String value) {
            addCriterion("book_num <", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumLessThanOrEqualTo(String value) {
            addCriterion("book_num <=", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumLike(String value) {
            addCriterion("book_num like", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotLike(String value) {
            addCriterion("book_num not like", value, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumIn(List<String> values) {
            addCriterion("book_num in", values, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotIn(List<String> values) {
            addCriterion("book_num not in", values, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumBetween(String value1, String value2) {
            addCriterion("book_num between", value1, value2, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNumNotBetween(String value1, String value2) {
            addCriterion("book_num not between", value1, value2, "bookNum");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andReaderNameIsNull() {
            addCriterion("reader_name is null");
            return (Criteria) this;
        }

        public Criteria andReaderNameIsNotNull() {
            addCriterion("reader_name is not null");
            return (Criteria) this;
        }

        public Criteria andReaderNameEqualTo(String value) {
            addCriterion("reader_name =", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotEqualTo(String value) {
            addCriterion("reader_name <>", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameGreaterThan(String value) {
            addCriterion("reader_name >", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameGreaterThanOrEqualTo(String value) {
            addCriterion("reader_name >=", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLessThan(String value) {
            addCriterion("reader_name <", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLessThanOrEqualTo(String value) {
            addCriterion("reader_name <=", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameLike(String value) {
            addCriterion("reader_name like", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotLike(String value) {
            addCriterion("reader_name not like", value, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameIn(List<String> values) {
            addCriterion("reader_name in", values, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotIn(List<String> values) {
            addCriterion("reader_name not in", values, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameBetween(String value1, String value2) {
            addCriterion("reader_name between", value1, value2, "readerName");
            return (Criteria) this;
        }

        public Criteria andReaderNameNotBetween(String value1, String value2) {
            addCriterion("reader_name not between", value1, value2, "readerName");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIsNull() {
            addCriterion("borrow_date is null");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIsNotNull() {
            addCriterion("borrow_date is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowDateEqualTo(Date value) {
            addCriterionForJDBCDate("borrow_date =", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("borrow_date <>", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateGreaterThan(Date value) {
            addCriterionForJDBCDate("borrow_date >", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("borrow_date >=", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateLessThan(Date value) {
            addCriterionForJDBCDate("borrow_date <", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("borrow_date <=", value, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateIn(List<Date> values) {
            addCriterionForJDBCDate("borrow_date in", values, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("borrow_date not in", values, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("borrow_date between", value1, value2, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andBorrowDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("borrow_date not between", value1, value2, "borrowDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNull() {
            addCriterion("return_date is null");
            return (Criteria) this;
        }

        public Criteria andReturnDateIsNotNull() {
            addCriterion("return_date is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDateEqualTo(Date value) {
            addCriterionForJDBCDate("return_date =", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("return_date <>", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThan(Date value) {
            addCriterionForJDBCDate("return_date >", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("return_date >=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThan(Date value) {
            addCriterionForJDBCDate("return_date <", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("return_date <=", value, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateIn(List<Date> values) {
            addCriterionForJDBCDate("return_date in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("return_date not in", values, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("return_date between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andReturnDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("return_date not between", value1, value2, "returnDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRentIsNull() {
            addCriterion("rent is null");
            return (Criteria) this;
        }

        public Criteria andRentIsNotNull() {
            addCriterion("rent is not null");
            return (Criteria) this;
        }

        public Criteria andRentEqualTo(Double value) {
            addCriterion("rent =", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotEqualTo(Double value) {
            addCriterion("rent <>", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThan(Double value) {
            addCriterion("rent >", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentGreaterThanOrEqualTo(Double value) {
            addCriterion("rent >=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThan(Double value) {
            addCriterion("rent <", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentLessThanOrEqualTo(Double value) {
            addCriterion("rent <=", value, "rent");
            return (Criteria) this;
        }

        public Criteria andRentIn(List<Double> values) {
            addCriterion("rent in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotIn(List<Double> values) {
            addCriterion("rent not in", values, "rent");
            return (Criteria) this;
        }

        public Criteria andRentBetween(Double value1, Double value2) {
            addCriterion("rent between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andRentNotBetween(Double value1, Double value2) {
            addCriterion("rent not between", value1, value2, "rent");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysIsNull() {
            addCriterion("borrows_days is null");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysIsNotNull() {
            addCriterion("borrows_days is not null");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysEqualTo(Integer value) {
            addCriterion("borrows_days =", value, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysNotEqualTo(Integer value) {
            addCriterion("borrows_days <>", value, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysGreaterThan(Integer value) {
            addCriterion("borrows_days >", value, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("borrows_days >=", value, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysLessThan(Integer value) {
            addCriterion("borrows_days <", value, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysLessThanOrEqualTo(Integer value) {
            addCriterion("borrows_days <=", value, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysIn(List<Integer> values) {
            addCriterion("borrows_days in", values, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysNotIn(List<Integer> values) {
            addCriterion("borrows_days not in", values, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysBetween(Integer value1, Integer value2) {
            addCriterion("borrows_days between", value1, value2, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andBorrowsDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("borrows_days not between", value1, value2, "borrowsDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysIsNull() {
            addCriterion("over_days is null");
            return (Criteria) this;
        }

        public Criteria andOverDaysIsNotNull() {
            addCriterion("over_days is not null");
            return (Criteria) this;
        }

        public Criteria andOverDaysEqualTo(Integer value) {
            addCriterion("over_days =", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysNotEqualTo(Integer value) {
            addCriterion("over_days <>", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysGreaterThan(Integer value) {
            addCriterion("over_days >", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("over_days >=", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysLessThan(Integer value) {
            addCriterion("over_days <", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysLessThanOrEqualTo(Integer value) {
            addCriterion("over_days <=", value, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysIn(List<Integer> values) {
            addCriterion("over_days in", values, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysNotIn(List<Integer> values) {
            addCriterion("over_days not in", values, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysBetween(Integer value1, Integer value2) {
            addCriterion("over_days between", value1, value2, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("over_days not between", value1, value2, "overDays");
            return (Criteria) this;
        }

        public Criteria andOverRentIsNull() {
            addCriterion("over_rent is null");
            return (Criteria) this;
        }

        public Criteria andOverRentIsNotNull() {
            addCriterion("over_rent is not null");
            return (Criteria) this;
        }

        public Criteria andOverRentEqualTo(Double value) {
            addCriterion("over_rent =", value, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentNotEqualTo(Double value) {
            addCriterion("over_rent <>", value, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentGreaterThan(Double value) {
            addCriterion("over_rent >", value, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentGreaterThanOrEqualTo(Double value) {
            addCriterion("over_rent >=", value, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentLessThan(Double value) {
            addCriterion("over_rent <", value, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentLessThanOrEqualTo(Double value) {
            addCriterion("over_rent <=", value, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentIn(List<Double> values) {
            addCriterion("over_rent in", values, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentNotIn(List<Double> values) {
            addCriterion("over_rent not in", values, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentBetween(Double value1, Double value2) {
            addCriterion("over_rent between", value1, value2, "overRent");
            return (Criteria) this;
        }

        public Criteria andOverRentNotBetween(Double value1, Double value2) {
            addCriterion("over_rent not between", value1, value2, "overRent");
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