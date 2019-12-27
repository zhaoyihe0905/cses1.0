package com.sinosoft.cses.view.cses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

@Data
public class Task {
    /**
     * 选取的地区名
     */
    private String areaName = "";
    /**
     * 选取的流程名
     */
    private String flowName = "";
    /**
     * 选取的险种名
     */
    private String coverageName = "";
    /**
     * 输出框
     */
    private JTextArea textArea = null;
    /**
     * 组件对象按钮
     */
    private JButton button = null;


    public Task(String areaName, String coverageName,String flowName,JTextArea textArea,JButton button) {
        this.areaName = areaName;
        this.flowName = flowName;
        this.coverageName = coverageName;
        this.textArea = textArea;
        this.button = button;
        this.doIt();
}

    /**
     * 手动执行主流程
     */
    public void doIt(){
        if("".equals(areaName)||null==areaName||"-请选择-".equals(areaName)){
            JOptionPane.showMessageDialog(null,"地区不能为空");
            return;
        }
        if("".equals(coverageName)||null==coverageName||"-请选择-".equals(coverageName)){
            JOptionPane.showMessageDialog(null,"险种不能为空");
            return;
        }
        if("".equals(flowName)||null==flowName||"-请选择-".equals(flowName)){
            JOptionPane.showMessageDialog(null,"流程不能为空");
            return;
        }
        if (textArea!=null){
            textArea.append("["+new Date()+"]:你的选择是："+areaName+"的"+coverageName+"的"+flowName+"\n");
        }
        /**
         * 根据areaName获取对应的地址
         * 根据coverageName获取对应的项目名称
         * 根据flowName选择调用方法：1、投保；2、投批；3、投批退；
         */




    }
}
