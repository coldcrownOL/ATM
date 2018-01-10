package com.feicuiedu.atm.controller;

import com.feicuiedu.atm.controller.UserController;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.service.SystemService;

/**
 * ѡ��ѡ��
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
	 * ѡ�����
	 */
	public void loginControllerFunction(){
		
		//��¼���� 1.��¼ 2.�˿� ����.��������
		systemService = new SystemService(user);
		systemService.pageLogin();
		
		//����ѡ����� 1.��ѯ 2.ת�� 3.��� 4.ȡ�� 5.�˿� ����.��������
		userController = new UserController(user);
		userController.userControllerFunction();
	}
}