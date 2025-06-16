package com.gn.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/receive/*")
public class DataFilter extends HttpFilter implements Filter {
       

    public DataFilter() {
        super();
    }


	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	    // 1. 요청이 필터를 지나가기 전에 할 작업
	    System.out.println("[DataFilter] 요청 가로챔");

	    // 2. 다음 필터나 서블릿으로 요청을 넘김
	    chain.doFilter(request, response);

	    // 3. 서블릿의 작업과 응답이 끝나고 클라이언트로 가기 전에 할 작업
	    System.out.println("[DataFilter] 응답 가로챔");
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
