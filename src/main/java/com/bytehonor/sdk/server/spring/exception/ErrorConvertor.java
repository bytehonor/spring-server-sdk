package com.bytehonor.sdk.server.spring.exception;

import com.bytehonor.sdk.define.spring.code.StandardCode;
import com.bytehonor.sdk.define.spring.exception.StandardException;
import com.bytehonor.sdk.define.spring.response.JsonResponse;

/**
 * @author lijianqiang
 *
 */
public class ErrorConvertor {

    public static JsonResponse<?> convert(Exception e) {
        if (e instanceof StandardException) {
            return standard((StandardException) e);
        }

        return bad(e);
    }

    /**
     * 有具体定义的
     * 
     * @param se
     * @return
     */
    private static JsonResponse<?> standard(StandardException se) {
        JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
        jsonResponse.setCode(se.getCode());
        jsonResponse.setMessage(format(se));
        return jsonResponse;
    }

    /**
     * 未定义的
     * 
     * @param ex
     * @return
     */
    private static JsonResponse<?> bad(Exception ex) {
        JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
        jsonResponse.setCode(StandardCode.BAD_REQUEST);
        jsonResponse.setMessage(format(ex));
        return jsonResponse;
    }

    /**
     * @param e
     * @return
     */
    public static String format(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(e.getMessage());
        return sb.toString();
    }

    public static String formatx(Exception e) {
        StringBuilder sb = new StringBuilder();
        sb.append(e.getClass().getSimpleName()).append(":").append(e.getMessage());
        return sb.toString();
    }
}
