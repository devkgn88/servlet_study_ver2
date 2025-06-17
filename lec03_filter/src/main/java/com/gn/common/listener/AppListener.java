package com.gn.common.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//@WebListener
public class AppListener implements ServletContextListener {

    public AppListener() {}
    
    @Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("💡 [Listener] 서버 시작 시 호출");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("⚠ [Listener] 서버 종료 시 호출");
    }
	
}
