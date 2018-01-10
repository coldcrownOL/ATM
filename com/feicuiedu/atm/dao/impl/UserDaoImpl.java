package com.feicuiedu.atm.dao.impl;

import com.feicuiedu.atm.controller.UserController;
import com.feicuiedu.atm.entity.User;

import java.util.Scanner;

/**
 * ����ʵ��
 * @author wang
 */
public class UserDaoImpl{

	private User user;
	private UserController userController;

	public UserDaoImpl(User user){
		this.user =user;
	}

	Scanner input = new Scanner(System.in);

	//��ѯ
	public void query(){
		
		while(true){	
			
			System.out.println("�˻�����:"+user.getAccountNumber());
			System.out.println("�˻�������:"+user.getUserName());
			System.out.println("���:"+user.getBalance());
			System.out.println("1.������һ��");
			System.out.println("2.�˿�");

			String num = input.next();
			
			//���Ϊ1��������һ��
			if(num.equals("1")){
				userController = new UserController(user);
				userController.userControllerFunction();
				
			//���Ϊ2.�˿�
			} else if(num.equals("2")){
				System.exit(0);
				
			//������������
			} else {
				System.out.println("�밴����ʾ�������룡");
				continue;
			}			
		}
	}
	
	//ת��
	public void transfer(){

	}
	
	//���
	public void deposit(){
		
		double balance;
		
		while(true){
			System.out.println("�������Ϊ:"+user.getBalance());
			System.out.println("����������(100Ԫ�ı���������Ϊ0):");
			
			double num = input.nextDouble();

			//100�������Ҳ�Ϊ0
			if(num%100 == 0 && num>0){
				balance = num;
				break;	
				
			} else{
				System.out.println("�밴����ʾ��������!");
				continue;
			}			
		}	
		
		while(true){
			
			System.out.println("1.ȷ��");		
			System.out.println("2.��������");
			System.out.println("3.������һ��");
			
			String num2=input.next();
			
			//Ϊ1.ȷ�ϴ��
			if(num2.equals("1")){
				double amount=user.getBalance();
				user.setBalance(amount+balance);
				System.out.println("���ɹ������ڵ����Ϊ:"+user.getBalance());
				break;
				
			//Ϊ2.��������
			} else if(num2.equals("2")){
				//����
				deposit();
				
			//Ϊ3.������һ��
			} else if(num2.equals("3")){	
				break;
							
			//������������
			} else {
				System.out.println("�밴����ʾ���������룡");
				continue;
			}	
			break;
		}	
	}
	
	//ȡ��
	public void withdraw(){
		
		double balance;
		
		while(true){
			System.out.println("�������Ϊ:"+user.getBalance());
			System.out.println("������ȡ����(100Ԫ�ı���������Ϊ0):");
			
			double num = input.nextDouble();
			
			//ȡ����ô������
			if(num>user.getBalance()){
					System.out.println("ȡ����ô���������������");
					continue;	
					
			//100�������Ҳ�Ϊ0
			} else if(num%100 == 0 && num>0){
				balance = num;
				break;
				
			} else {
				System.out.println("�밴����ʾ��������!");
				continue;
			}			
		}	
		
		while(true){
			
			System.out.println("1.ȷ��");		
			System.out.println("2.��������");
			System.out.println("3.������һ��");
			
			String num2=input.next();
			
			//Ϊ1.ȷ��ȡ��
			if(num2.equals("1")){
				double amount=user.getBalance();
				user.setBalance(amount-balance);
				System.out.println("ȡ��ɹ������ڵ����Ϊ:"+user.getBalance());
				break;
				
			//Ϊ2.��������
			} else if(num2.equals("2")){
				//ȡ���
				withdraw();
				
			//Ϊ3.������һ��
			} else if(num2.equals("3")){	
				break;
				
			//������������
			} else {
				System.out.println("�밴����ʾ���������룡");
				continue;
			}
			break;
		}
	}	
}