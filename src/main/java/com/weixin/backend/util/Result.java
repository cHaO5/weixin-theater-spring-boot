package com.weixin.backend.util;

public class Result {
    private String code;
    private String message;
    private Object data;

    public String getCode() {
        return code;
    }

    private void setCode(ResultCode code) {
        this.code = code.val();
    }

    public Object getData() {
        return data;
    }

    private void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public Result() {
        this.setCode(ResultCode.SUCCESS);
        this.setMessage("成功！");
    }

    public Result(ResultCode code) {
        this.setCode(code);
        this.setMessage(code.msg());
    }

//    public Result(ResultCode code, String message) {
//        this.setCode(code);
//        this.setMessage(message);
//    }

    public Result(ResultCode code, String message, Object data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    public Result(ResultCode code, Object data) {
        this.setCode(code);
        this.setMessage(code.msg());
        this.setData(data);
    }
}