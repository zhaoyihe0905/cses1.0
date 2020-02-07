package com.sinosoft;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.sinosoft.cses.view.login.LoginView;

@SpringBootApplication
public class CsesApplication {

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//            	new mainFrame();
//            	System.out.println(1);
//            }
//        });
//    	SpringApplicationBuilder builder = new SpringApplicationBuilder(mainFrame.class);
//    	builder.headless(false).web(false).run(args);
//        SpringApplication.run(CsesApplication.class, args);
    	ConfigurableApplicationContext context = new SpringApplicationBuilder(
    			CsesApplication.class).headless(false).run(args);

    	LoginView appFrame = context.getBean(LoginView.class);
    	appFrame.setVisible(true);
//		appFrame.setVisible(true);
    }

}
