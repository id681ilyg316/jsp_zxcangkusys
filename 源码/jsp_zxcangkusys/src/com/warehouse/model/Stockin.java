package com.warehouse.model;

/**
 * 入库实体类
 * 
 * @author admin
 *
 */
public class Stockin {
	private int stockin_id; // 入库id，主键自增长
	private String stockin_guid; // 入库guid，使用uuid
	private String goods_guid; // 入库商品，使用商品guid
	private int stockin_num; // 入库数量
	private String stockin_date; // 入库日期
	private String goods_name; // 商品名称

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getStockin_id() {
		return stockin_id;
	}

	public void setStockin_id(int stockin_id) {
		this.stockin_id = stockin_id;
	}

	public String getStockin_guid() {
		return stockin_guid;
	}

	public void setStockin_guid(String stockin_guid) {
		this.stockin_guid = stockin_guid;
	}

	public String getGoods_guid() {
		return goods_guid;
	}

	public void setGoods_guid(String goods_guid) {
		this.goods_guid = goods_guid;
	}

	public int getStockin_num() {
		return stockin_num;
	}

	public void setStockin_num(int stockin_num) {
		this.stockin_num = stockin_num;
	}

	public String getStockin_date() {
		return stockin_date;
	}

	public void setStockin_date(String stockin_date) {
		this.stockin_date = stockin_date;
	}

}
