package com.warehouse.model;

/**
 * 新增账务实体类
 * @author admin
 *
 */
public class Accountingadd {
	private int accounting_add_id; // 新增id，主键自增长
	private String accounting_add_guid; // 新增guid
	private String accounting_guid; // 账务guid
	private String accounting_add_date; // 新增日期
	private double accounting_add_money; // 新增金额
	private String accounting_name;	//财务名称
	
	
	public String getAccounting_name() {
		return accounting_name;
	}

	public void setAccounting_name(String accounting_name) {
		this.accounting_name = accounting_name;
	}

	public int getAccounting_add_id() {
		return accounting_add_id;
	}

	public void setAccounting_add_id(int accounting_add_id) {
		this.accounting_add_id = accounting_add_id;
	}

	public String getAccounting_add_guid() {
		return accounting_add_guid;
	}

	public void setAccounting_add_guid(String accounting_add_guid) {
		this.accounting_add_guid = accounting_add_guid;
	}

	public String getAccounting_guid() {
		return accounting_guid;
	}

	public void setAccounting_guid(String accounting_guid) {
		this.accounting_guid = accounting_guid;
	}

	public String getAccounting_add_date() {
		return accounting_add_date;
	}

	public void setAccounting_add_date(String accounting_add_date) {
		this.accounting_add_date = accounting_add_date;
	}

	public double getAccounting_add_money() {
		return accounting_add_money;
	}

	public void setAccounting_add_money(double accounting_add_money) {
		this.accounting_add_money = accounting_add_money;
	}

}
