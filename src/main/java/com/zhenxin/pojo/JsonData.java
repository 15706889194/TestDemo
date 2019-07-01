package com.zhenxin.pojo;

import java.io.Serializable;

public class JsonData implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer code;
    private String  msg;
    private Object data;

    public JsonData(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public JsonData() {
    }

    public JsonData(Integer code) {
        this.code = code;
    }
    //成功传入数据
    public static JsonData  buildSuccess(){
        return new JsonData(0,null,null);
    }

    public static JsonData  buildSuccess(Object data){
        return new JsonData(0,null,data);
    }


    public static JsonData  buildSuccess(String msg,Object data){
        return new JsonData(0,msg,data);
    }
    public static JsonData  buildSuccess(int code,String msg,Object data){
        return new JsonData(code,msg,data);
    }
    public static JsonData  buildSuccess(int code,String msg){
        return new JsonData(code,msg,null);
    }
    //失败信息
    public static JsonData buildError(String msg) {
        return new JsonData(-1, null, msg);
    }

    // 失败，传入描述信息,状态码
    public static JsonData buildError(String msg, Integer code) {
        return new JsonData(code, null, msg);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}

