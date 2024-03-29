package cn.itrover.homepage.interceptor;


import cn.itrover.homepage.annotation.ResponseResult;
import cn.itrover.homepage.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author MaYunHao
 * @version 1.0
 * @description  封装返回体
 * @date 2020/2/2 17:22
 */
@Slf4j
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

    /**
     * 标记名称，判断时候修改返回体
     */
    public static final String RESPONSE_RESULT_ANN = "RESPONSE_RESULT_ANN";

    /**
     * 判断是否重写返回体
     * 是否请求 包含了包装注解 标记，没有就直接返回，不重写放回体。
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断请求 是否有包装标记
        ResponseResult responseResultAnn= (ResponseResult)request.getAttribute(RESPONSE_RESULT_ANN);
        System.out.println(responseResultAnn);
        return responseResultAnn == null ? false : true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        if (body instanceof Exception){
            log.error("发生异常 {}",((Exception) body).getMessage());
            return body;
        }

        log.info("重写返回体");
        return Result.success(body);
    }
}
