package com.sinosoft.view.cses.login;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sinosoft.master.config.MD5;
import com.sinosoft.master.entity.SysUser;
import com.sinosoft.master.response.Response;
import com.sinosoft.master.service.SysConfigService;
import com.sinosoft.master.service.SysUserService;
import com.sinosoft.view.cses.moniliucheng.MoniLiuchengView;
import com.sinosoft.view.util.SystemConfig;

@Controller
public class LoginController {
	@Autowired
	private SysUserService sysUserService ;
	@Autowired
	private SysConfigService sysConfigService;

	
	/**
     * 校验用户名密码是否正确
     */
    void verifyLogin(JTextField username,JTextField password, LoginView loginView){
        //获取输入的用户名和密码
        String usernameText = username.getText();
        String passwordText = password.getText();

        if("".equals(usernameText)||usernameText==null){
            JOptionPane.showMessageDialog(null,"用户名不能为空");
            username.setText("");
            password.setText("");
            username.requestFocus();//获取焦点
            password.requestFocus();//获取焦点
            return;
    }
        if("".equals(passwordText)||passwordText==null){
            JOptionPane.showMessageDialog(null,"密码不能为空");
            username.setText("");
            password.setText("");
            username.requestFocus();//获取焦点
            password.requestFocus();//获取焦点
            return;
        }
       SysUser sysUser =  sysUserService.findByUserCode(usernameText);
        
        if(sysUser == null){
            JOptionPane.showMessageDialog(null,"用户名不存在");
            return;
        }
         String md5 = MD5.backMD5(passwordText).toLowerCase();
        if(!md5.equals(sysUser.getPassword().toLowerCase())){
            JOptionPane.showMessageDialog(null,"密码不正确");
            return;
        }
        //关闭登录界面
        loginView.dispose();
        //验证通过，打开系统界面
        String value = sysConfigService.findvalueByCode(SystemConfig.IACA_URL);
//        String lala = BusinessFun.doPost(value, "");
//        Response lala = BusinessFun.doPost(value, "");
        
        new MoniLiuchengView();
    }
}
