package cn.test.lms.bean;

public class TbUser {
    private Integer id;

    private String username;

    private String password;

    private String bookSet;

    private String readerSet;

    private String borrowSet;

    private String searchSet;

    private String systemSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getBookSet() {
        return bookSet;
    }

    public void setBookSet(String bookSet) {
        this.bookSet = bookSet == null ? null : bookSet.trim();
    }

    public String getReaderSet() {
        return readerSet;
    }

    public void setReaderSet(String readerSet) {
        this.readerSet = readerSet == null ? null : readerSet.trim();
    }

    public String getBorrowSet() {
        return borrowSet;
    }

    public void setBorrowSet(String borrowSet) {
        this.borrowSet = borrowSet == null ? null : borrowSet.trim();
    }

    public String getSearchSet() {
        return searchSet;
    }

    public void setSearchSet(String searchSet) {
        this.searchSet = searchSet == null ? null : searchSet.trim();
    }

    public String getSystemSet() {
        return systemSet;
    }

    public void setSystemSet(String systemSet) {
        this.systemSet = systemSet == null ? null : systemSet.trim();
    }
}