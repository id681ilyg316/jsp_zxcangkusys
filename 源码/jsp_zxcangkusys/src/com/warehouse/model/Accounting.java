package com.warehouse.model;

/**
 * 账务信息实体类
 * @author admin
 *
 */
public class Accounting {
	private int accounting_id; // 账务id，主键自增长
	private String accounting_guid;// 账务guid，使用uuid
	private String accounting_name; // 账务名称
	private double accounting_money; // 账务总额
	private String accounting_date; // 账务添加日期
	private double accounting_used = 0.00; // 使用金额
	private double accounting_balance = 0.00; // 剩余金额
	private String accounting_desc; // 账务描述
	private int accounting_level; // 财务等级

	public int getAccounting_id() {
		return accounting_id;
	}

	public void setAccounting_id(int accounting_id) {
		this.accounting_id = accounting_id;
	}

	public String getAccounting_guid() {
		return accounting_guid;
	}

	public void setAccounting_guid(String accounting_guid) {
		this.accounting_guid = accounting_guid;
	}

	public String getAccounting_name() {
		return accounting_name;
	}

	public void setAccounting_name(String accounting_name) {
		this.accounting_name = accounting_name;
	}

	public double getAccounting_money() {
		return accounting_money;
	}

	public void setAccounting_money(double accounting_money) {
		this.accounting_money = accounting_money;
	}

	public String getAccounting_date() {
		return accounting_date;
	}

	public void setAccounting_date(String accounting_date) {
		this.accounting_date = accounting_date;
	}

	public double getAccounting_used() {
		return accounting_used;
	}

	public void setAccounting_used(double accounting_used) {
		this.accounting_used = accounting_used;
	}

	public double getAccounting_balance() {
		return accounting_balance;
	}

	public void setAccounting_balance(double accounting_balance) {
		this.accounting_balance = accounting_balance;
	}

	public String getAccounting_desc() {
		return accounting_desc;
	}

	public void setAccounting_desc(String accounting_desc) {
		this.accounting_desc = accounting_desc;
	}

	public int getAccounting_level() {
		return accounting_level;
	}

	public void setAccounting_level(int accounting_level) {
		this.accounting_level = accounting_level;
	}
}
