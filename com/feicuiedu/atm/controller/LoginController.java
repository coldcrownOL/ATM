package com.feicuiedu.atm.controller;

import com.feicuiedu.atm.controller.UserController;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.service.SystemService;

/**
 * 选择选项
 * @author wang
 */
public class LoginController{

	private User user ;
	private UserController userController;
	private SystemService systemService;
	
	public LoginController(User user){
		this.user =user;
	}

	/**
	 * 选择界面
	 */
	public void loginControllerFunction(){
		
		//登录界面 1.登录 2.退卡 其他.重新输入
		systemService = new SystemService(user);
		systemService.pageLogin();
		
		//功能选择界面 1.查询 2.转账 3.存款 4.取款 5.退卡 其他.重新输入
		userController = new UserController(user);
		userController.userControllerFunction();
	}
}