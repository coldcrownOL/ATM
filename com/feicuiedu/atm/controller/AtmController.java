package com.feicuiedu.atm.controller;

import com.feicuiedu.atm.controller.LoginController;
import com.feicuiedu.atm.entity.User;

/**
 * ������
 * @author wang
 */
public class AtmController{
/*	private User user;

	public AtmController(User user){
		this.user =user;
	}*/
	public static void main(String[] args) {
		User user = new User();

		//���õ�¼ѡ��
		LoginController loginController = new LoginController(user);
		loginController.loginControllerFunction();
	}
}