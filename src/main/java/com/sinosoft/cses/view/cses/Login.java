package com.sinosoft.cses.view.cses;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public Login(){
        //第一步：设置窗口
        this.setTitle("客服服务体验系统");
        this.setSize(350,250);
        //窗口居中
        this.CenterWin();
        //窗口图标更改

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //第二步：创建面板，面板用来划分区域
        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        //此时我们已经有了可操作区域panel1了，我们要执行自定义方法进行组件添加
        this.ComponentPanel(panel);
        //添加面板
        this.add(panel);
        this.setVisible(true);
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

    /**
     * 添加组件到面板
     * @param panel
     */
    void ComponentPanel(JPanel panel){
        //布局
        //通知框
        JTextArea textArea = new JTextArea(100,100);
        textArea.setBounds(18,25,300,60);
        textArea.setDisabledTextColor(Color.red);
        new Message().loginMessage(textArea);
        textArea.setEnabled(false);
        //设置透明
        panel.add(textArea);

        panel.setLayout(null);
        //创建JLabel - 用户名输入框
        JLabel username = new JLabel("用户名：");
        //指定左上角位置x,y,指定大小w,h
        username.setBounds(50,100,80,25);
        panel.add(username);
        //创建文本域用于输入
        JTextField userText = new JTextField();
        userText.setBounds(100,100,150,25);
        panel.add(userText);
        //重复以上 - 密码输入框
        JLabel password = new JLabel("密     码:");
        password.setBounds(50,135,80,25);
        panel.add(password);
        JTextField passText = new JTextField();
        passText.setBounds(100,135,150,25);
        panel.add(passText);

        //登录按钮
        JButton login = new JButton("登录");
        login.setBounds(70,170,100,25);
        login.doClick();
        login.addActionListener(Event->this.verifyLogin(userText,passText));
        panel.add(login);
        //联系管理员按钮
        JButton admin = new JButton("联系管理员");
        admin.setBounds(180,170,100,25);
        //绑定事件
        admin.doClick();
        admin.addActionListener(Event-> JOptionPane.showMessageDialog(null,"QQ：939694105"));
        panel.add(admin);

    }

    /**
     * 校验用户名密码是否正确
     */
    void verifyLogin(JTextField username,JTextField password){
        //获取输入的用户名和密码
        String usernameText = username.getText();
        String passwordText = password.getText();

        if("".equals(usernameText)||usernameText==null){
            JOptionPane.showMessageDialog(null,"用户名不能为空");
            return;
    }
        if("".equals(passwordText)||passwordText==null){
            JOptionPane.showMessageDialog(null,"密码不能为空");
            return;
        }
        //关闭登录界面
        this.dispose();
        //验证通过，打开系统界面
        new MoniLiucheng();
    }
}
