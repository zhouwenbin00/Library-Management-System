package cn.test.lms.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装响应信息的类
 */
public class Result implements Serializable {

    //状态码
    private Integer code;

    //信息
    private String msg;

    //响应数据
    private Map<String,Object> data = new HashMap<>();

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(){}

    public static Result ok(){
        return  new Result(200,"ok");
    }

    public  Result addData( String key,Object value){
        this.getData().put(key,value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

}
