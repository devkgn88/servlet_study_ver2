package com.gn.common.filter;

import java.io.IOException;

import com.gn.common.wrapper.MsgRequestWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class MsgFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("[MsgFilter]요청 가로챔");
		
		// HttpServletRequest로 캐스팅하고 Wrapper로 감쌈
        MsgRequestWrapper wrappedRequest = new MsgRequestWrapper((HttpServletRequest) request);

        // 다음 서블릿/필터에게 넘김
        chain.doFilter(wrappedRequest, response);
        
		System.out.println("[MsgFilter]응답 가로챔");
		
	}

}
