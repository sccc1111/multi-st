package com.cn.quarts.model;

import lombok.Data;

import java.util.HashMap;

/**
 * Created by songbo on 2018/7/26.
 */
@Data
public class Result extends HashMap<String, Object> {

    public Result() {
        put("code", 0);
    }

    public static Result ok(Object msg) {
        Result r = new Result();
        r.put("msg", msg);
        return r;
    }

    public static Result error(String msg) {
        return error(500, msg);
    }

    public static Result error(int code, String msg) {
        Result r = new Result();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    @Override
    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
