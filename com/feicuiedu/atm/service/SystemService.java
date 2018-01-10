package com.feicuiedu.atm.service;

import java.util.Scanner;

import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.view.LoginView;

/**
 * 登录判断
 * @author wang
 */
public class SystemService {
	
	private User user;
	private SystemService systemService;
	private LoginView loginView;
	
	public SystemService(User user){
		this.user =user;
	}
	
	Scanner input = new Scanner(System.in);
	
	/**
	 * 用户选择操作
	 */
	public void pageLogin(){
		
		//用户选择操作 1.登录 2.退卡 其他.重新输入
		while(true){
			//显示登录界面
			loginView = new LoginView();
			loginView.loginViewPage();
			
			String select = input.next();
			
			//为"1",登录
			if(select.equals("1")){
				systemService = new SystemService(user);
				systemService.loginJudgement();
				break;
				
			//为"2"，退卡
			} else if(select.equals("2")){
				System.exit(0);
				
			//其他.重新输入
			} else {
				System.out.println("请按照提示进行操作！");
				continue;
			}
			continue;
		}
	}
	
	/**
	 * 判断账户密码是否正确
	 */
	public void loginJudgement(){
		
		//判断账户密码是否正确.账户长度是否位12
		while(true){	
					
			// 显示操作提示"请输入卡号:(想直接退出就输入exit)"
			System.out.println("请输入卡号:");
			String account = input.next();
			
			//输入exit，直接退卡!
			if(account.equals("exit")){
				System.exit(0);
				
			//账户长度不为12.重新输入
			} else if (!(account.length()==12)) {
				System.out.println("账号不是12位，请重新进行输入!");
				continue;
			
			//账号不为"370120180104"且不为"exit"
			} else if ((!account.equals(user.getAccountNumber()))&&(!account.equals("exit"))) {
				System.out.println("账号不存在，请重新进行输入!");
				continue;
			}
			
			while(true){
				// 显示操作提示"请输入密码:(想直接退卡就输入exit)"
				System.out.println("请输入密码:");
				String password = input.next();
				
				//输入exit，直接退卡！
				if (password.equals("exit")) {
					System.exit(0);
					
				//密码不为"123456"且不为"exit"
				} else if (!password.equals(user.getPassword())&&(!password.equals("exit"))) {
					System.out.println("密码输入错误，请重新进行输入!");
					continue;
					
				//卡号为"370120180104",密码为"123456"
				} else if(account.equals(user.getAccountNumber())&&password.equals(user.getPassword())){
					System.out.println("登录成功!");				
					break;
				}
				break;
			}
			break;
		}
	}
}
