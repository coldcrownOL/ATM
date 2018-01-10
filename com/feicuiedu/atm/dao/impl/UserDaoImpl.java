package com.feicuiedu.atm.dao.impl;

import com.feicuiedu.atm.controller.UserController;
import com.feicuiedu.atm.entity.User;

import java.util.Scanner;

/**
 * 功能实现
 * @author wang
 */
public class UserDaoImpl{

	private User user;
	private UserController userController;

	public UserDaoImpl(User user){
		this.user =user;
	}

	Scanner input = new Scanner(System.in);

	//查询
	public void query(){
		
		while(true){	
			
			System.out.println("账户卡号:"+user.getAccountNumber());
			System.out.println("账户所有人:"+user.getUserName());
			System.out.println("余额:"+user.getBalance());
			System.out.println("1.返回上一级");
			System.out.println("2.退卡");

			String num = input.next();
			
			//如果为1，返回上一级
			if(num.equals("1")){
				userController = new UserController(user);
				userController.userControllerFunction();
				
			//如果为2.退卡
			} else if(num.equals("2")){
				System.exit(0);
				
			//其他重新输入
			} else {
				System.out.println("请按照提示重新输入！");
				continue;
			}			
		}
	}
	
	//转账
	public void transfer(){

	}
	
	//存款
	public void deposit(){
		
		double balance;
		
		while(true){
			System.out.println("您的余额为:"+user.getBalance());
			System.out.println("请输入存款金额(100元的倍数，不得为0):");
			
			double num = input.nextDouble();

			//100整数，且不为0
			if(num%100 == 0 && num>0){
				balance = num;
				break;	
				
			} else{
				System.out.println("请按照提示重新输入!");
				continue;
			}			
		}	
		
		while(true){
			
			System.out.println("1.确认");		
			System.out.println("2.重新输入");
			System.out.println("3.返回上一级");
			
			String num2=input.next();
			
			//为1.确认存款
			if(num2.equals("1")){
				double amount=user.getBalance();
				user.setBalance(amount+balance);
				System.out.println("存款成功，现在的余额为:"+user.getBalance());
				break;
				
			//为2.重新输入
			} else if(num2.equals("2")){
				//存款方法
				deposit();
				
			//为3.返回上一级
			} else if(num2.equals("3")){	
				break;
							
			//其他重新输入
			} else {
				System.out.println("请按照提示请重新输入！");
				continue;
			}	
			break;
		}	
	}
	
	//取款
	public void withdraw(){
		
		double balance;
		
		while(true){
			System.out.println("您的余额为:"+user.getBalance());
			System.out.println("请输入取款金额(100元的倍数，不得为0):");
			
			double num = input.nextDouble();
			
			//取款金额不得大于余额
			if(num>user.getBalance()){
					System.out.println("取款金额不得大于余额，请重新输入");
					continue;	
					
			//100整数，且不为0
			} else if(num%100 == 0 && num>0){
				balance = num;
				break;
				
			} else {
				System.out.println("请按照提示重新输入!");
				continue;
			}			
		}	
		
		while(true){
			
			System.out.println("1.确认");		
			System.out.println("2.重新输入");
			System.out.println("3.返回上一级");
			
			String num2=input.next();
			
			//为1.确认取款
			if(num2.equals("1")){
				double amount=user.getBalance();
				user.setBalance(amount-balance);
				System.out.println("取款成功，现在的余额为:"+user.getBalance());
				break;
				
			//为2.重新输入
			} else if(num2.equals("2")){
				//取款方法
				withdraw();
				
			//为3.返回上一级
			} else if(num2.equals("3")){	
				break;
				
			//其他重新输入
			} else {
				System.out.println("请按照提示请重新输入！");
				continue;
			}
			break;
		}
	}	
}