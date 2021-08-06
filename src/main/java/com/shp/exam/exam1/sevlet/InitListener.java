package com.shp.exam.exam1.sevlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.shp.exam.exam1.app.App;

@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
    	App.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}