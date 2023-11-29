package com.warehouse.model;

/**
 * 管理员实体类
 * 
 * @author admin
 *
 */
public class Admin {
	private int admin_id; // 管理员编号
	private String admin_guid; // 管理员guid
	private String admin_name; // 管理员姓名
	private String admin_username; // 管理员登录名
	private String admin_pwd; // 管理员登录密码
	private int admin_sex; // 管理员性别
	private String admin_phone; // 管理员电话
	private String admin_cardid; // 管理员身份证号码
	private String admin_date; // 管理员注册日期
	private int admin_del = 0; // 管理员是否删除-管理员是否删除0：否 1：是
	private int admin_authority; // 管理员权限-管理员级别 1：普通管理员  2：超级管理员

	public int getAdmin_authority() {
		return admin_authority;
	}

	public void setAdmin_authority(int admin_authority) {
		this.admin_authority = admin_authority;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_guid() {
		return admin_guid;
	}

	public void setAdmin_guid(String admin_guid) {
		this.admin_guid = admin_guid;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_pwd() {
		return admin_pwd;
	}

	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}

	public String getAdmin_phone() {
		return admin_phone;
	}

	public void setAdmin_phone(String admin_phone) {
		this.admin_phone = admin_phone;
	}

	public String getAdmin_cardid() {
		return admin_cardid;
	}

	public void setAdmin_cardid(String admin_cardid) {
		this.admin_cardid = admin_cardid;
	}

	public int getAdmin_del() {
		return admin_del;
	}

	public void setAdmin_del(int admin_del) {
		this.admin_del = admin_del;
	}

	public int getAdmin_sex() {
		return admin_sex;
	}

	public void setAdmin_sex(int admin_sex) {
		this.admin_sex = admin_sex;
	}

	public String getAdmin_date() {
		return admin_date;
	}

	public void setAdmin_date(String admin_date) {
		this.admin_date = admin_date;
	}
}
