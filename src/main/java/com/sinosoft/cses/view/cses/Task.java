package com.sinosoft.cses.view.cses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Task(String areaName, String coverageName,String flowName) {
        this.areaName = areaName;
        this.flowName = flowName;
        this.coverageName = coverageName;
        this.doIt();
    }

    /**
     * 手动执行主流程
     */
    public void doIt(){
        System.out.println("你的选择是："+areaName+"的"+coverageName+"的"+flowName);
    }
}
