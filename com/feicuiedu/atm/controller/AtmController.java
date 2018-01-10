package com.feicuiedu.atm.controller;

import com.feicuiedu.atm.controller.LoginController;
import com.feicuiedu.atm.entity.User;

/**
 * 主程序
 * @author wang
 */
public class AtmController{
/*	private User user;

	public AtmController(User user){
		this.user =user;
	}*/
	public static void main(String[] args) {
		User user = new User();

		//调用登录选择
		LoginController loginController = new LoginController(user);
		loginController.loginControllerFunction();
	}
}