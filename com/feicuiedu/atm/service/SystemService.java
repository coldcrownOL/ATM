package com.feicuiedu.atm.service;

import java.util.Scanner;

import com.feicuiedu.atm.entity.User;
import com.feicuiedu.atm.view.LoginView;

/**
 * ��¼�ж�
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
	 * �û�ѡ�����
	 */
	public void pageLogin(){
		
		//�û�ѡ����� 1.��¼ 2.�˿� ����.��������
		while(true){
			//��ʾ��¼����
			loginView = new LoginView();
			loginView.loginViewPage();
			
			String select = input.next();
			
			//Ϊ"1",��¼
			if(select.equals("1")){
				systemService = new SystemService(user);
				systemService.loginJudgement();
				break;
				
			//Ϊ"2"���˿�
			} else if(select.equals("2")){
				System.exit(0);
				
			//����.��������
			} else {
				System.out.println("�밴����ʾ���в�����");
				continue;
			}
			continue;
		}
	}
	
	/**
	 * �ж��˻������Ƿ���ȷ
	 */
	public void loginJudgement(){
		
		//�ж��˻������Ƿ���ȷ.�˻������Ƿ�λ12
		while(true){	
					
			// ��ʾ������ʾ"�����뿨��:(��ֱ���˳�������exit)"
			System.out.println("�����뿨��:");
			String account = input.next();
			
			//����exit��ֱ���˿�!
			if(account.equals("exit")){
				System.exit(0);
				
			//�˻����Ȳ�Ϊ12.��������
			} else if (!(account.length()==12)) {
				System.out.println("�˺Ų���12λ�������½�������!");
				continue;
			
			//�˺Ų�Ϊ"370120180104"�Ҳ�Ϊ"exit"
			} else if ((!account.equals(user.getAccountNumber()))&&(!account.equals("exit"))) {
				System.out.println("�˺Ų����ڣ������½�������!");
				continue;
			}
			
			while(true){
				// ��ʾ������ʾ"����������:(��ֱ���˿�������exit)"
				System.out.println("����������:");
				String password = input.next();
				
				//����exit��ֱ���˿���
				if (password.equals("exit")) {
					System.exit(0);
					
				//���벻Ϊ"123456"�Ҳ�Ϊ"exit"
				} else if (!password.equals(user.getPassword())&&(!password.equals("exit"))) {
					System.out.println("����������������½�������!");
					continue;
					
				//����Ϊ"370120180104",����Ϊ"123456"
				} else if(account.equals(user.getAccountNumber())&&password.equals(user.getPassword())){
					System.out.println("��¼�ɹ�!");				
					break;
				}
				break;
			}
			break;
		}
	}
}
