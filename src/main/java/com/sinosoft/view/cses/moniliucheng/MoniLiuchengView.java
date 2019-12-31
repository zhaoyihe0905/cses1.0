package com.sinosoft.view.cses.moniliucheng;


import com.sinosoft.master.service.SysConfigService;
import lombok.Data;

import javax.swing.*;

import com.sinosoft.view.cses.Quartz;
import com.sinosoft.view.cses.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.*;
@Data
@Service
public class MoniLiuchengView extends JFrame{
    //注入需要的类
    @Autowired
    private SysConfigService sysConfigService;
    //获取窗口的值
     private static String areaName="";
     private static String coverageName="";
     private static String flowName="";

    JPanel north = new JPanel();
    JPanel center = new JPanel();
    JPanel south = new JPanel();
    JPanel eaet = new JPanel();
    JPanel west = new JPanel();

    private JTextArea textArea =null;
    private JScrollPane jScorollPane;
    public MoniLiuchengView(){
    }
    //初始化模块
    public MoniLiuchengView(boolean flag) {
       if(flag==true){
           //初始化界面
           this.init();
           this.setTitle("客服服务体验系统");
           this.setResizable(true);
           //this.setLocation(210, 210);
           this.setSize(680, 440);
           this.setResizable(false);
           this.CenterWin();
           this.setDefaultCloseOperation(EXIT_ON_CLOSE);
           this.setVisible(true);
       }
    }

    /**
     * 布局
     */
    public void init() {
        this.textArea = new JTextArea(20,80);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        Font f = new Font("宋体", Font.PLAIN, 12);
        textArea.setForeground(Color.blue);
        textArea.setFont(f);
        jScorollPane = new JScrollPane(textArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        center.add(jScorollPane);
        this.setLayout(new BorderLayout());
        this.northPanel();
        this.southPanel();
        this.add(north, BorderLayout.NORTH);
        this.add(center, BorderLayout.CENTER);
        this.add(south,BorderLayout.SOUTH);
    }

    /**
     * 窗口居中显示
     */
    void CenterWin() {
        int windowWidth = this.getWidth(); //获得窗口宽
        int windowHeight = this.getHeight(); //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        this.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//设置窗口居中显示
    }

    /**
     * 选择行-布局
     */
    void northPanel(){
        north.setLayout(new BoxLayout(north,BoxLayout.X_AXIS));
        //定时启动
        north.add(this.quartz());
        //地区选择
        north.add(this.areaCode());
        //险种选择
        north.add(this.CoverageCode());
        //接口选择
        north.add(this.Interface());
        //执行任务
        north.add(this.doIt());
    }
    void southPanel(){
        south.setLayout(new BoxLayout(south,BoxLayout.X_AXIS));
        //清除
        south.add(this.remove());
    }

    /**
     * 获取定时启动按钮JPanel
     * @return
     */
    JPanel quartz (){
        JPanel quartz = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        quartz.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.LEFT);
        //定时启动
        JButton button =new JButton("启动定时");
        button.doClick();
        button.addActionListener(Event-> new Quartz());
        quartz.add(button);
        return quartz;
    }

    /**
     * 获取地区选择JPanel
     * @return
     */
    JPanel areaCode(){
        JPanel area = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        area.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.LEFT);
        area.add(new Label("Area:"));
        JComboBox jTextCombo =this.getComboBox();
        jTextCombo.addItem("北京");
        jTextCombo.addItem("上海");
        //添加下拉框监听，获取选项值
        jTextCombo.addActionListener(Event->this.setAreaName(jTextCombo.getSelectedItem().toString()));
        area.add(jTextCombo);
        return area;
    }

    /**
     * 险种选择JPanel
     * @return
     */
    JPanel CoverageCode(){
        JPanel coverage = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        coverage.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.LEFT);
        coverage.add(new Label("Coverage:"));
        JComboBox jTextCombo =this.getComboBox();
        jTextCombo.addItem("商业险");
        jTextCombo.addItem("交强险");
        //添加下拉框监听，获取选项值
        jTextCombo.addActionListener(Event->this.setCoverageName(jTextCombo.getSelectedItem().toString()));
        coverage.add(jTextCombo);
        return  coverage;
    }

    /**
     * 接口选择JPanel
     * @return
     */
    JPanel Interface(){
        JPanel interfaceJpanel= new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        interfaceJpanel.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.LEFT);
        interfaceJpanel.add(new Label("Flow:"));
        JComboBox jTextCombo =this.getComboBox();
        jTextCombo.addItem("投保环节");
        jTextCombo.addItem("批改环节");
        jTextCombo.addItem("全流程");
        //添加下拉框监听，获取选项值
        jTextCombo.addActionListener(Event-> this.setFlowName(jTextCombo.getSelectedItem().toString()));
        interfaceJpanel.add(jTextCombo);
        return  interfaceJpanel;
    }
    /**
     * 获取执行任务按钮JPanel
     * @return
     */
    JPanel doIt(){
        JPanel quartz = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        quartz.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.LEFT);
        //定时启动
        JButton button =new JButton("执行任务");
        button.doClick();
        //参数依次是：地区、险种、流程
        button.addActionListener(Event-> new Task(areaName,coverageName,flowName,textArea,button,sysConfigService));
        quartz.add(button);
        return quartz;
    }
    /**
     * 获取下拉框
     * @return
     */
    private JComboBox getComboBox() {
        JComboBox jTextCombo =new JComboBox();
        jTextCombo.setPreferredSize(new java.awt.Dimension(70, 25));
        jTextCombo.addItem("-请选择-");
        return jTextCombo;
    }
    /**
     * 获取清除输出框内容按钮JPanel
     * @return
     */
    JPanel remove (){
        JPanel quartz = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        quartz.setLayout(flowLayout);
        flowLayout.setAlignment(FlowLayout.LEFT);
        //定时启动
        JButton button =new JButton("清除");
        button.doClick();
        button.addActionListener(Event-> textArea.setText(""));
        quartz.add(button);
        return quartz;
    }

    /**
     * 赋值
     * @param areaName
     */
    public void setAreaName(String areaName){
        this.areaName = areaName;
    }
    public void setCoverageName(String coverageName){
        this.coverageName = coverageName;
    }
    public void setFlowName(String flowName){
        this.flowName = flowName;
    }

}
