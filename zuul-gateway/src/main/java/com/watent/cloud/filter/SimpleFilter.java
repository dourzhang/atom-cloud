package com.watent.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul filters store request and state information in (and share it by means of) the RequestContext.
 * We’re using that to get at the HttpServletRequest,
 * and then we log the HTTP method and URL of the request before it is sent on its way.
 */
public class SimpleFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

    /**
     * 过滤器类型
     *
     * @return 前置过滤器
     * <p>
     * Zuul has four standard filter types:
     * pre      filters are executed before the request is routed,
     * route    filters can handle the actual routing of the request,
     * post     filters are executed after the request has been routed, and
     * error    filters execute if an error occurs in the course of handling the request.
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 相对其他过滤器的执行顺序
     *
     * @return 顺序
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 执行过滤器的判断逻辑
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器功能
     *
     * @return a objects
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }

}