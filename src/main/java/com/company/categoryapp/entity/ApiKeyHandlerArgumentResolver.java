package com.company.categoryapp.entity;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ApiKeyHandlerArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //return true if the object came from ApiKey class
        return ApiKey.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String value = webRequest.getHeader("api-key");

        if(!value.equals("1234")){
            throw new ApiKeyException("Unauthorized: Please Input api-key 1234");
        }
        else{
            return new ApiKey(value);
        }
    }
}
