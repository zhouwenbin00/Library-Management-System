package cn.test.lms.bean;

import java.util.Date;

public class TbRecord {
    private Integer id;

    private String bookNum;

    private String bookName;

    private String readerName;

    private Date borrowDate;

    private Date returnDate;

    private String status;

    private Double rent;

    private Integer borrowsDays;

    private Integer overDays;

    private Double overRent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookNum() {
        return bookNum;
    }

    public void setBookNum(String bookNum) {
        this.bookNum = bookNum == null ? null : bookNum.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName == null ? null : readerName.trim();
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Integer getBorrowsDays() {
        return borrowsDays;
    }

    public void setBorrowsDays(Integer borrowsDays) {
        this.borrowsDays = borrowsDays;
    }

    public Integer getOverDays() {
        return overDays;
    }

    public void setOverDays(Integer overDays) {
        this.overDays = overDays;
    }

    public Double getOverRent() {
        return overRent;
    }

    public void setOverRent(Double overRent) {
        this.overRent = overRent;
    }
}