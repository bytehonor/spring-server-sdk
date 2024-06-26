package com.bytehonor.sdk.server.spring.exception;

import com.bytehonor.sdk.base.spring.response.JsonResponse;
import com.bytehonor.sdk.server.spring.web.constant.StandardCode;

/**
 * @author lijianqiang
 *
 */
public class ErrorConvertor {

    public static JsonResponse<?> convert(Exception e) {
        return bad(e);
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
