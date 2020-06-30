package com.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.Dao.UserDao;
/*用户*/
public class User {
	
		private String NickName;//用户名
		private String Password;//密码
		private String RePassword;//重复密码
		private String RealName;//真实姓名
		private int Age;//年龄
		private String Sex;//性别
		private String IDNumber;//身份证号
		private String Phone;//电话号码
		

		private Map<String, String> errors = new HashMap<String, String>(); //错误信息
		
		public String getNickName() {
			return NickName;
		}
		public void setNickName(String nickName) {
			NickName = nickName;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getRePassword() {
			return RePassword;
		}
		public void setRePassword(String rePassword) {
			RePassword = rePassword;
		}
		public String getRealName() {
			return RealName;
		}
		public void setRealName(String realName) {
			RealName = realName;
		}
		public int getAge() {
			return Age;
		}
		public void setAge(int age) {
			Age = age;
		}
		public String getSex() {
			return Sex;
		}
		public void setSex(String sex) {
			Sex = sex;
		}
		public String getIDNumber() {
			return IDNumber;
		}
		public void setIDNumber(String iDNumber) {
			IDNumber = iDNumber;
		}
		public String getPhone() {
			return Phone;
		}
		public void setPhone(String phone) {
			Phone = phone;
		}
		public Map<String, String> getErrors() {
			return errors;
		}
		public void setErrors(String error, String errMsg) {
			if((error != null) && (errMsg != null)){
				errors.put(error, errMsg);
			}else{
				System.out.println("kong");
			}
		}
		
		//判断用户注册内容是否符合格式
		public boolean validate(){
			boolean flag = true;
			if(NickName == null || NickName.trim().equals("")){
				errors.put("NickName", "此项不能为空");
				flag = false;
			}else if(NickName.length()<2 || NickName.length()>10){
				errors.put("NickName", "请输入2-10个字符的用户名");
				flag = false;
			}else if(UserDao.Find_name(NickName) != null){
				errors.put("NickName", "该用户名已占用");
				flag = false;
			}
			if(Password == null || Password.trim().equals("")){
				errors.put("Password", "此项不能为空");
				flag = false;
			}else if(Password.length()<6 || Password.length()>12){
				errors.put("Password", "请输入6-12个字符的密码");
				flag = false;
			}
			if(RePassword == null || RePassword.trim().equals("")){
				errors.put("RePassword", "此项不能为空");
				flag = false;
			}else if(!RePassword.equals(Password)){
				errors.put("RePassword", "两次密码不一致");
				flag = false;
			}
			if(RealName == null || RealName.trim().equals("")){
				errors.put("RealName", "此项不能为空");
				flag = false;
			}else if(RealName.length()<2 || RealName.length()>4){
				errors.put("RealName", "请输入正确姓名");
				flag = false;
			}
			if(Sex == null || Sex.trim().equals("")){
				errors.put("Sex", "此项不能为空");
				flag = false;
			}
			if(IDNumber == null || IDNumber.trim().equals("")){
				errors.put("IDNumber", "此项不能为空");
				flag = false;
			}else if(IDNumber.length() != 18){
				errors.put("IDNumber", "请输入正确身份证号");
				flag = false;
			}else if(UserDao.Find_id(IDNumber) != null){
				errors.put("IDNumber", "该身份证号已注册");
				flag = false;
			}
			if(Phone == null || Phone.trim().equals("")){
				errors.put("Phone", "此项不能为空");
				flag = false;
			}else if(Phone.length() != 11){
				errors.put("Phone", "请输入正确手机号码");
				flag = false;
			}
			return flag;
		}
		
		//判断用户修改内容是否符合格式
		public boolean Modify_validate(){
			boolean flag = true;
			
			if(Password == null || Password.trim().equals("")){
				errors.put("Password", "此项不能为空");
				flag = false;
			}else if(Password.length()<6 || Password.length()>12){
				errors.put("Password", "请输入6-12个字符的密码");
				flag = false;
			}
			if(RePassword == null || RePassword.trim().equals("")){
				errors.put("RePassword", "此项不能为空");
				flag = false;
			}else if(!RePassword.equals(Password)){
				errors.put("RePassword", "两次密码不一致");
				flag = false;
			}
			if(RealName == null || RealName.trim().equals("")){
				errors.put("RealName", "此项不能为空");
				flag = false;
			}else if(RealName.length()<2 || RealName.length()>4){
				errors.put("RealName", "请输入正确姓名");
				flag = false;
			}
			if(Sex == null || Sex.trim().equals("")){
				errors.put("Sex", "此项不能为空");
				flag = false;
			}
			if(IDNumber == null || IDNumber.trim().equals("")){
				errors.put("IDNumber", "此项不能为空");
				flag = false;
			}else if(IDNumber.length() != 18){
				errors.put("IDNumber", "请输入正确身份证号");
				flag = false;
			}
			if(Phone == null || Phone.trim().equals("")){
				errors.put("Phone", "此项不能为空");
				flag = false;
			}else if(Phone.length() != 11){
				errors.put("Phone", "请输入正确手机号码");
				flag = false;
			}
			return flag;
		}
}
