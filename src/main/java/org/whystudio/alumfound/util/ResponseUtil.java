package org.whystudio.alumfound.util;

import org.whystudio.alumfound.vo.Response;

/**
 * @author qkmc
 */
public class ResponseUtil {

    private final static Integer SUCCESS_STATUS = 100;
    private final static Integer FAIL_STATUS = -100;

    public static <T> Response<T> custom(Integer status, String message, T data){
        return new Response<>(status, message, data);
    }

    public static Response successWithoutData(String message) {
        return new Response(SUCCESS_STATUS, message, null);
    }

    public static Response failWithoutData(String message) {
        return new Response(FAIL_STATUS, message, null);
    }

    public static <T> Response<T> autoJudgeByData(T data) {
        return (null == data)? new Response<T>(FAIL_STATUS, "未找到数据", data):
                new Response<T>(SUCCESS_STATUS, "success", data);
    }
}
