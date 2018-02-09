package com.sim.manager.view;

public class Result {


    public static final int NOTFOND = 404;

    public static final int SUCCESS = 200;

    public static final int ERROR = 500;

    public static final int NOTAUTH = 401;

    public static final int PARAMERROR = 403;


    public Result(int code, Object body) {
        this.code = code;
        this.body = body;
    }

    public Result(int code) {
        this.code = code;
    }
    public Result() {
    }

    private int code;

    private Object body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
