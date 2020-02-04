package com.sinosoft.cses.view;

import javax.swing.*;

/**
 * 负责将要通知的信息发布到指定界面上去
 */
public class Message {
    /**
     * 登录界面通知信息发布
     * @param textArea
     */
    public void loginMessage(JTextArea textArea){
        textArea.setText("此系统仅供客服使用");
    }

}
