package com.jackson.shoppingcart.config;

import com.jackson.shoppingcart.config.ApplicationProperties;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class CachingHttpHeadersFilter implements Filter {
    public static final int DEFAULT_DAYS_TO_LIVE = 1461;
    public static final long DEFAULT_SECONDS_TO_LIVE;
    public static final long LAST_MODIFIED;
    private long cacheTimeToLive;
    private ApplicationProperties applicationProperties;

    public CachingHttpHeadersFilter(ApplicationProperties applicationProperties) {
        this.cacheTimeToLive = DEFAULT_SECONDS_TO_LIVE;
        this.applicationProperties = applicationProperties;
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.cacheTimeToLive = TimeUnit.DAYS.toMillis((long)this.applicationProperties.getHttp().getCache().getTimeToLiveInDays());
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        httpResponse.setHeader("Cache-Control", "max-age=" + this.cacheTimeToLive + ", public");
        httpResponse.setHeader("Pragma", "cache");
        httpResponse.setDateHeader("Expires", this.cacheTimeToLive + System.currentTimeMillis());
        httpResponse.setDateHeader("Last-Modified", LAST_MODIFIED);
        chain.doFilter(request, response);
    }

    static {
        DEFAULT_SECONDS_TO_LIVE = TimeUnit.DAYS.toMillis(1461L);
        LAST_MODIFIED = System.currentTimeMillis();
    }
}

