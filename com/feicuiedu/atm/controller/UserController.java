package com.feicuiedu.atm.controller;

import com.feicuiedu.atm.dao.impl.UserDaoImpl;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.service.SystemService;
import com.feicuiedu.atm.view.UserView;

import java.util.Scanner;

/**
 * ���ܲ˵�
 * @author wang
 */
public class UserController{
	
	private User user;
	private UserView userView;
	private UserDaoImpl userDaoImpl;
	private SystemService systemService;

	public UserController(User user){
		this.user =user;
	}
	
	Scanner input = new Scanner(System.in);
	
	/**
	 * ��ʾ����ѡ��
	 */
	public void userControllerFunction(){
		
		while(true){
			
			//��ʾ����ѡ�� 1.��ѯ 2.ת�� 3.��� 4.ȡ��  5.������һ�� 6.�˿�  ����.��������
			userView = new UserView();
			userView.userViewPage();
			
			String num=input.next();

			//1.��ѯ
			if(num.equals("1")){
				userDaoImpl = new UserDaoImpl(user);
				userDaoImpl.query();

			// 2.ת��
			} else if(num.equals("2")){
				userDaoImpl = new UserDaoImpl(user);
				userDaoImpl.transfer();

			//3.��� 
			} else if(num.equals("3")){
				userDaoImpl = new UserDaoImpl(user);
				userDaoImpl.deposit();

			//4.ȡ��  
			} else if(num.equals("4")){
				userDaoImpl = new UserDaoImpl(user);
				userDaoImpl.withdraw();

			//5.������һ��
			} else if(num.equals("5")){
				System.out.println("������һ��!");
				//��¼���� 1.��¼ 2.�˿� ����.��������
				systemService = new SystemService(user);
				systemService.pageLogin();
				
			//6.�˿� 
			} else if(num.equals("6")){
				System.out.println("�˿��ɹ�!");
				System.exit(0);
			
			//����.��������
			} else{
				System.out.println("�밴����ʾ��������!");
				continue;
			}			
		}
	}
}