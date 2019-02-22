package cn.test.lms.bean;

public class Authority {
    private Integer userId;

    private String autority;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAutority() {
        return autority;
    }

    public void setAutority(String autority) {
        this.autority = autority == null ? null : autority.trim();
    }
}