package com.warehouse.model;

/**
 * 货品信息实体类
 * 
 * @author admin
 *
 */
public class Goods {
	private int goods_id; // 商品id，使用自增长
	private String goods_guid; // 商品guid，使用uuid值
	private String goods_name; // 商品名称
	private String type_guid; // 商品类别，使用类别guid
	private float goods_price; // 商品单价
	private int goods_supplier; // 商品供应商
	private int goods_place; // 商品产地
	private String goods_date; // 商品添加日期
	private String goods_retailprice; // 商品零售价
	private String goods_desc; // 商品描述
	private String type_name; // 类别名称

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	public int getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public String getGoods_guid() {
		return goods_guid;
	}

	public void setGoods_guid(String goods_guid) {
		this.goods_guid = goods_guid;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getType_guid() {
		return type_guid;
	}

	public void setType_guid(String type_guid) {
		this.type_guid = type_guid;
	}

	public float getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}

	public int getGoods_supplier() {
		return goods_supplier;
	}

	public void setGoods_supplier(int goods_supplier) {
		this.goods_supplier = goods_supplier;
	}

	public int getGoods_place() {
		return goods_place;
	}

	public void setGoods_place(int goods_place) {
		this.goods_place = goods_place;
	}

	public String getGoods_date() {
		return goods_date;
	}

	public void setGoods_date(String goods_date) {
		this.goods_date = goods_date;
	}

	public String getGoods_retailprice() {
		return goods_retailprice;
	}

	public void setGoods_retailprice(String goods_retailprice) {
		this.goods_retailprice = goods_retailprice;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}
}
