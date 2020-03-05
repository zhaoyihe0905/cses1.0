package com.sinosoft.cses.view.login;

import java.rmi.server.UID;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sinosoft.cses.view.moniliucheng.MoniLiuchengView;
import com.sinosoft.master.config.MD5;
import com.sinosoft.master.controller.IpAddr;
import com.sinosoft.master.entity.SysUser;
import com.sinosoft.master.entity.SysUserLog;
import com.sinosoft.master.service.SysConfigService;
import com.sinosoft.master.service.SysUserLogService;
import com.sinosoft.master.service.SysUserService;

@Controller
public class LoginController {
	@Autowired
	private SysUserService sysUserService ;
	@Autowired
	private SysConfigService sysConfigService;
    @Autowired
    private MoniLiuchengView moniLiuchengView;
    @Autowired
    private com.sinosoft.cses.mainFrame mainFrame;
    @Autowired
    private SysUserLogService sysUserLogService;
    
//    @Autowired
//	protected HttpServletRequest request;
//	
//	@Autowired
//	protected HttpServletResponse response;

	/**
     * 校验用户名密码是否正确
     */
    void verifyLogin(JTextField username,JTextField password, LoginView loginView){
    	SysUserLog userLog = new SysUserLog();
    	  userLog.setCreateTime(new Date());
          userLog.setIpaddr(IpAddr.getHostIP());
    	
        //获取输入的用户名和密码
        String usernameText = username.getText();
        String passwordText = password.getText();
        userLog.setUsercode(usernameText);

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
       SysUser user =  sysUserService.findByUserCode(usernameText);
        
        if(user == null){
            JOptionPane.showMessageDialog(null,"用户名不存在");
            userLog.setMessage("0-用户名不存在");
            return;
        }
         String md5 = MD5.backMD5(passwordText).toLowerCase();
        if(!md5.equals(user.getPassword().toLowerCase())){
            JOptionPane.showMessageDialog(null,"密码不正确");
            userLog.setMessage("0-密码不正确");
            userLog.setUid(user.getId());
            return;
        }
        //关闭登录界面
        
        
        //存入session中
//        request.getSession().setAttribute("user", user);
        userLog.setUsercode(user.getUsername());
        userLog.setUid(user.getId());
        userLog.setMessage("1-登录成功");
        sysUserLogService.save(userLog);
        loginView.dispose();
        //验证通过，打开系统界面
/*        String value = sysConfigService.findvalueByCode(SystemConfig.IACA_URL);
//        String lala = BusinessFun.doPost(value, "");
        StringBuffer strBuff = new StringBuffer();
       // Response lala = (new BusinessFun()).doPost(value, "", strBuff);*/
//        mainFrame.main(null);
        mainFrame.init(null);
    }
}
