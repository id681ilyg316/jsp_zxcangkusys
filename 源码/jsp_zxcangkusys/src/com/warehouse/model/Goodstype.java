package com.warehouse.model;

/**
 * 货品类别实体类
 * 
 * @author admin
 *
 */
public class Goodstype {
	private int type_id; // 类别id，使用主键自增长
	private String type_guid; // 类别guid，使用uuid
	private String type_name; // 类别名称
	private String type_date; // 类别添加日期
	private String type_desc; // 类别描述

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType_guid() {
		return type_guid;
	}

	public void setType_guid(String type_guid) {
		this.type_guid = type_guid;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public String getType_date() {
		return type_date;
	}

	public void setType_date(String type_date) {
		this.type_date = type_date;
	}

	public String getType_desc() {
		return type_desc;
	}

	public void setType_desc(String type_desc) {
		this.type_desc = type_desc;
	}
}
