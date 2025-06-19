package com.gn.common.filter;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

    public SessionListener() {}


    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("세션 시작");
    }

    public void sessionDestroyed(HttpSessionEvent se)  {
    	System.out.println("세션 종료");
    }

    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("세션 속성 추가");
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("세션 속성 제거");
    }

    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("세션 속성 대체");
    }
	
}
