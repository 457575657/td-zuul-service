/**  
 *@Copyright:Copyright (c) 2010-2017  
 *@Company:东莞团贷网互联网科技服务有限公司
  www.tuandai.com 
 */  
package com.example;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**  
 *<p> </p>
 *@Author:Yips
 *@Since:2017年1月20日 下午3:15:07 
 *@Version:1.1.0  
 */
public class AccessFilter extends ZuulFilter {
    
    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("accessToken");
        if(accessToken == null) {
            logger.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("access token ok");
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public String filterType() {
        return "pre";
    }

}
