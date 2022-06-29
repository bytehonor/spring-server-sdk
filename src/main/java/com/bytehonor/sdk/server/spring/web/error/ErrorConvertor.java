package com.bytehonor.sdk.server.spring.web.error;

import com.bytehonor.sdk.define.spring.code.StandardCode;
import com.bytehonor.sdk.define.spring.exception.StandardException;
import com.bytehonor.sdk.define.spring.result.JsonResponse;

/**
 * @author lijianqiang
 *
 */
public class ErrorConvertor {

    public static JsonResponse<?> convert(Exception e) {
        if (e instanceof StandardException) {
            return first((StandardException) e);
        }

        return last(e);
    }

    /**
     * 有具体定义的
     * 
     * @param se
     * @return
     */
    private static JsonResponse<?> first(StandardException se) {
        JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
        jsonResponse.setCode(se.getCode());
        jsonResponse.setMessage(ErrorMessage.format(se));
        return jsonResponse;
    }

    /**
     * 未定义的
     * 
     * @param ex
     * @return
     */
    private static JsonResponse<?> last(Exception ex) {
        JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
        jsonResponse.setCode(StandardCode.BAD_REQUEST);
        jsonResponse.setMessage(ErrorMessage.format(ex));
        return jsonResponse;
    }

}