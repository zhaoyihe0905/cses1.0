package com.sinosoft.cses.view.cses;


import javax.swing.*;
import java.awt.*;

public class MoniLiucheng extends JFrame{
    //初始化模块
    public MoniLiucheng() throws HeadlessException {
        this.init();
        this.setTitle("客服服务体验系统");
        this.setResizable(true);
        this.setSize(600, 600);
        this.CenterWin();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    //设置模块布局
    void init(){
        JPanel panel = new JPanel();
        this.add(panel);

    }
    /**
     * 窗口居中显示
     */
    void CenterWin(){
        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示
    }

}
