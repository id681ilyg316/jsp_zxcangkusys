package com.warehouse.model;

/**
 * 采购信息实体类
 * 
 * @author admin
 *
 */
public class Purchase {
	private int purchase_id; // 采购id，使用自增长
	private String purchase_guid; // 采购guid，使用uuid
	private String goods_guid; // 采购商品，获取商品的guid值
	private String purchase_num; // 采购数量
	private double purchase_total; // 采购总价，商品单价*采购数量
	private String purchase_date; // 采购日期
	private String accounting_guid; // 财务guid
	private String purchase_desc; // 采购描述
	private String goods_name; // 货品名称
	private String accounting_name; // 财务名称

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getAccounting_name() {
		return accounting_name;
	}

	public void setAccounting_name(String accounting_name) {
		this.accounting_name = accounting_name;
	}

	public String getPurchase_desc() {
		return purchase_desc;
	}

	public void setPurchase_desc(String purchase_desc) {
		this.purchase_desc = purchase_desc;
	}

	public String getAccounting_guid() {
		return accounting_guid;
	}

	public void setAccounting_guid(String accounting_guid) {
		this.accounting_guid = accounting_guid;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public String getPurchase_guid() {
		return purchase_guid;
	}

	public void setPurchase_guid(String purchase_guid) {
		this.purchase_guid = purchase_guid;
	}

	public String getGoods_guid() {
		return goods_guid;
	}

	public void setGoods_guid(String goods_guid) {
		this.goods_guid = goods_guid;
	}

	public String getPurchase_num() {
		return purchase_num;
	}

	public void setPurchase_num(String purchase_num) {
		this.purchase_num = purchase_num;
	}

	public double getPurchase_total() {
		return purchase_total;
	}

	public void setPurchase_total(double purchase_total) {
		this.purchase_total = purchase_total;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

}
