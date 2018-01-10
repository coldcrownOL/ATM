package com.feicuiedu.atm.controller;

import com.feicuiedu.atm.dao.impl.UserDaoImpl;
import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.service.SystemService;
import com.feicuiedu.atm.view.UserView;

import java.util.Scanner;

/**
 * 功能菜单
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
	 * 显示功能选择
	 */
	public void userControllerFunction(){
		
		while(true){
			
			//显示功能选择 1.查询 2.转账 3.存款 4.取款  5.返回上一级 6.退卡  其他.重新输入
			userView = new UserView();
			userView.userViewPage();
			
			String num=input.next();

			//1.查询
			if(num.equals("1")){
				userDaoImpl = new UserDaoImpl(user);
				userDaoImpl.query();

			// 2.转账
			} else if(num.equals("2")){
				userDaoImpl = new UserDaoImpl(user);
				userDaoImpl.transfer();

			//3.存款 
			} else if(num.equals("3")){
				userDaoImpl = new UserDaoImpl(user);
				userDaoImpl.deposit();

			//4.取款  
			} else if(num.equals("4")){
				userDaoImpl = new UserDaoImpl(user);
				userDaoImpl.withdraw();

			//5.返回上一级
			} else if(num.equals("5")){
				System.out.println("返回上一级!");
				//登录界面 1.登录 2.退卡 其他.重新输入
				systemService = new SystemService(user);
				systemService.pageLogin();
				
			//6.退卡 
			} else if(num.equals("6")){
				System.out.println("退卡成功!");
				System.exit(0);
			
			//其他.重新输入
			} else{
				System.out.println("请按照提示重新输入!");
				continue;
			}			
		}
	}
}