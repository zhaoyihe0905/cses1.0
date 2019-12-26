package com.sinosoft.cses.view.cses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
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

    public Task(String areaName, String coverageName,String flowName,JTextArea textArea) {
        this.areaName = areaName;
        this.flowName = flowName;
        this.coverageName = coverageName;
        this.textArea = textArea;
        this.doIt();
    }

    /**
     * 手动执行主流程
     */
    public void doIt(){
        System.out.println("你的选择是："+areaName+"的"+coverageName+"的"+flowName);
        if (textArea!=null){
            textArea.append("["+new Date()+"]:你的选择是："+areaName+"的"+coverageName+"的"+flowName+"\n");
        }
    }
}
