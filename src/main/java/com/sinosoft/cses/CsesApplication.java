package com.sinosoft.cses;

import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sinosoft.cses.view.cses.mainFrame;

@SpringBootApplication
public class CsesApplication {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//            	new mainFrame();
            	System.out.println(1);
            }
        });
        SpringApplication.run(CsesApplication.class, args);
    }

}
