package com.customerview;

import com.customer.Customer;
/**
 * CustomerList为Customer对象的管理模块，内部使用数组管理一组Customer对象
 * @author Eser Tired
 *
 */
public class CustomerList {

	Customer[] customers;// 用来保存客户对象的数组
	private int total = 0;// 记录已保存客户对象的数量

	/**
	 * 构造器，用来初始化customers数组
	 * @param totalCustomer 指定customers数组的最大空间
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	
	/**
	 * 将参数customer添加到数组中最后一个客户对象记录之后
	 * @param customer
	 * @return 添加成功返回true；false表示数组已满，无法添加
	 */
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length){
			extendArray(1);
		}
		customers[total] = customer;
		total++;
		return true;
		
		
	}
	
	/**
	 * 用参数customer替换数组中由index指定的对象
	 * @param index   index指定所替换对象在数组中的位置，从0开始
	 * @param cust customer指定替换的新客户对象 
	 * @return 替换成功返回true；false表示索引无效，无法替换
	 */
	public boolean replaceCustomer(int index, Customer cust){
		if(total - 1 <= index){
			return false;
		}
		customers[index] = cust;
		return true;
	}
	
	/**
	 * 从数组中删除参数index指定索引位置的客户对象记录
	 * @param index 指定所删除对象在数组中的索引位置，从0开始
	 * @return 删除成功返回true；false表示索引无效，无法删除
	 */
	public boolean deleteCustomer(int index){
		if(total - 1 < index){
			return false;
		}
		for(int i = index; i < total; i++){
			customers[index] = customers[index + 1];
		}
		customers[total--] = null;
		return true;
	}
	
	/**
	 * 返回数组中记录的所有客户对象
	 * @return Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同。
	 */
	public Customer[] getAllCustomers() {
		Customer[] cust = new Customer[total];
		for(int i = 0; i < total; i++){
			cust[i] = customers[i];
		}
		return cust;
		
	}
	
	
	/**
	 * 返回参数index指定索引位置的客户对象记录
	 * @param index index指定所要获取的客户在数组中的索引位置，从0开始
	 * @return 封装了客户信息的Customer对象
	 */
	public Customer getCustomer(int index) {
		return this.customers[index];
	}
	
	/**
	 * 获取已存用户数量
	 * @return
	 */
	public int getTotal(){
		return total;
	}
	
	/**
	 * 改变存储数据列表的长度
	 * @param vector 小于0为减小5单位长度，大于0为延长5单位长度
	 */
	public void extendArray(int vector){
		
		Customer[] newCustomers;
		if(total >= 0){
			if(vector > 0){
				newCustomers = new Customer[total + 5];
			}else if(vector < 0){
				newCustomers = new Customer[total - 5];
			}else{
				return;
			}
		}else{
			return;
		}
		
		
		//复制数据
		for (int i = 0; i < total; i++){
			newCustomers[i] = customers[i];
		}
		
		customers = newCustomers;
		
		
	}

}
