package com.customerlist;

import java.util.Scanner;

import com.customer.Customer;
import com.customerview.CustomerList;
import com.util.CMUtility;

public class CustomerView {

	CustomerList culist = new CustomerList(10);
	
	
	public CustomerView() {
		Customer customer = new Customer("张三", '男', 30, "01056253825",
				"abc@email.com");
		culist.addCustomer(customer);
		System.out.println(culist.getTotal());
	}
	
	
	/**
	 * 进入主界面
	 */
	public void enterMainMenu() {
	
		while(true){
			
			
			System.out.println("\n-----------------客户信息管理软件-----------------\n");
			System.out.println("                   1 添 加 客 户");
			System.out.println("                   2 修 改 客 户");
			System.out.println("                   3 删 除 客 户");
			System.out.println("                   4 客 户 列 表");
			System.out.println("                   5 退       出\n");
			System.out.print("                   请选择(1-5)：");
			
			char input = CMUtility.readMenuSelection();
			switch(input){
			case '1':
				addNewCustomer();
				break;
			case '2':
				modifyCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				System.out.println("------------------客户列表-------------------");
				listAllCustomers();
				break;
			case '5':
				System.out.print("\t确认是否退出(Y/N)：");
				char select = CMUtility.readConfirmSelection();
				if(select == 'Y'){
					System.out.println("\t退出完成！！");
					return;
				}else{
					continue;
				}
			}
		}
		
	}
	
	
	/**
	 * 1.添加新客戶
	 */
	private void addNewCustomer() {
		
		//输入信息
		System.out.println("请输入客户姓名：");
		String name = CMUtility.readString(10);
		
		System.out.println("请输入性别（男/女）：");
		char gender = CMUtility.readChar();
		
		System.out.println("请输入年龄：");
		int age = CMUtility.readInt();
		
		System.out.println("请输入11位电话号码：");
		String phoneNumber = CMUtility.readString(11, "无\t");
		
		System.out.println("请输入邮箱地址：");
		String email = CMUtility.readString(21, "无");
		
		//创建单个客户对象
		
		Customer cuts = new Customer(name, gender, age, phoneNumber, email);
		boolean isFlag = culist.addCustomer(cuts);
		if(isFlag){
			System.out.println("-------------添加成功！！！------------------");
			return;
		}
		System.out.println("-------------添加失败！！！------------------");
		
		
	}
	/**
	 * 2.修改客戶
	 */
	private void modifyCustomer() {
		System.out.println();
		
		System.out.println("------------------修改客户-------------------");
		listAllCustomers();
		System.out.print("\t请输入需要修改的客户序号：");
		int choice = CMUtility.readInt();
		if(choice > culist.getTotal()){
			System.out.println("\t输入有误！！");
			return;
		}
		Customer newCustomer = new Customer();
		Customer oldCustomer = culist.getCustomer(choice - 1);
		
		System.out.print("客户姓名（" + oldCustomer.getName() + "):");
		newCustomer.setName(CMUtility.readString(10, oldCustomer.getName()));
		System.out.println();
		
		System.out.print("性别（" + oldCustomer.getGender() + "):");
		newCustomer.setGender(CMUtility.readChar( oldCustomer.getGender() ) );
		System.out.println();
		
		System.out.print("年龄（" + oldCustomer.getAge() + "):");
		newCustomer.setAge(CMUtility.readInt(oldCustomer.getAge()));
		System.out.println();
		
		System.out.print("手机号码（" + oldCustomer.getPhone() + "):");
		newCustomer.setPhone(CMUtility.readString(10, oldCustomer.getPhone()));
		System.out.println();
		
		System.out.print("邮箱地址（" + oldCustomer.getEmail() + "):");
		newCustomer.setEmail(CMUtility.readString(24, oldCustomer.getEmail()));
		System.out.println();
		
		culist.replaceCustomer(choice - 1, newCustomer);
		System.out.println("---------------------修改完毕！！--------------------");
		System.out.println();
		
		
		
	}
	
	/**
	 * 3.刪除客戶
	 */
	private void deleteCustomer(){
		System.out.println();
		System.out.println("--------------------删除客户--------------------");

		listAllCustomers();
		System.out.print("\t\t请输入需要删除的用户序号：");
		int index = CMUtility.readInt();
		boolean delete = culist.deleteCustomer(index - 1);
		if(delete){
			System.out.println("-----------------删除成功！！！-----------------");
		}else{
			System.out.println("--------------删除失败！！！不存在此用户--------------");
		}
		System.out.println();
		
		
	}
	
	/**
	 * 4.显示客户列表
	 */
	private void listAllCustomers(){
		System.out.println();
//		System.out.println("------------------客户列表-------------------");
		System.out.println("序号\t姓名\t性别\t年龄\t电话号码\t\t邮箱地址");
		Customer[] custs = culist.getAllCustomers();
//		custs = culist.getAllCustomers();
		
		for(int i = 0; i < custs.length; i++){
//			System.out.println( (i+1) + "\t" + custs[i].getName() + 
//					"\t" + custs[i].getGender() + 
//					"\t" + custs[i].getAge() +
//					"\t" + custs[i].getPhone() +
//					"\t" + custs[i].getEmail() );
			System.out.println((i+1) + "\t" + custs[i].getDetail());
		}
		System.out.println("--------------------------------------------\n");
		
	}
	
	
	public static void main(String[] args){
		
		CustomerView cusview = new CustomerView();
		cusview.enterMainMenu(); //进入主界面
		
		
	}

	
}
