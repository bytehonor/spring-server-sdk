package com.bytehonor.sdk.server.spring.web.response.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.define.bytehonor.code.StandardCode;
import com.bytehonor.sdk.define.bytehonor.result.JsonResponse;
import com.bytehonor.sdk.server.spring.web.response.ResponseBuilder;

public final class DefaultResponseBuilder implements ResponseBuilder {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultResponseBuilder.class);

    @Override
    public JsonResponse<?> build(Object body) {

        JsonResponse<Object> jsonResponse = new JsonResponse<Object>();
        jsonResponse.setCode(StandardCode.OK);
        jsonResponse.setMessage(StandardCode.SUCCESS);
        jsonResponse.setData(body);

        if (LOG.isDebugEnabled()) {
            LOG.debug("ErrorCode:{}", jsonResponse.getCode());
        }

        return jsonResponse;
    }

}
