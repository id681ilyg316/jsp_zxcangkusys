package com.warehouse.model;

/**
 * 出库实体类
 * 
 * @author admin
 *
 */
public class Stockout {
	private int stockout_id; // 出库id，主键自增长
	private String stockout_guid; // 出库guid，使用uuid
	private String goods_guid; // 出库商品，使用商品guid
	private String stockout_date; // 出库日期
	private double stockout_num; // 出库数量
	private String stockin_guid; // 入库编号，使用入库guid
	private String stockout_people; // 客户名称
	private double stockout_money; // 出库总价
	private double stockout_profit; // 出库盈利
	private double stockout_unitprice; // 出库单价
	private int stockin_id; // 入库编号
	private String goods_name; // 货品名称

	public int getStockout_id() {
		return stockout_id;
	}

	public void setStockout_id(int stockout_id) {
		this.stockout_id = stockout_id;
	}

	public String getStockout_guid() {
		return stockout_guid;
	}

	public void setStockout_guid(String stockout_guid) {
		this.stockout_guid = stockout_guid;
	}

	public String getGoods_guid() {
		return goods_guid;
	}

	public void setGoods_guid(String goods_guid) {
		this.goods_guid = goods_guid;
	}

	public String getStockout_date() {
		return stockout_date;
	}

	public void setStockout_date(String stockout_date) {
		this.stockout_date = stockout_date;
	}

	public double getStockout_num() {
		return stockout_num;
	}

	public void setStockout_num(double stockout_num) {
		this.stockout_num = stockout_num;
	}

	public String getStockin_guid() {
		return stockin_guid;
	}

	public void setStockin_guid(String stockin_guid) {
		this.stockin_guid = stockin_guid;
	}

	public String getStockout_people() {
		return stockout_people;
	}

	public void setStockout_people(String stockout_people) {
		this.stockout_people = stockout_people;
	}

	public double getStockout_money() {
		return stockout_money;
	}

	public void setStockout_money(double stockout_money) {
		this.stockout_money = stockout_money;
	}

	public double getStockout_profit() {
		return stockout_profit;
	}

	public void setStockout_profit(double stockout_profit) {
		this.stockout_profit = stockout_profit;
	}

	public double getStockout_unitprice() {
		return stockout_unitprice;
	}

	public void setStockout_unitprice(double stockout_unitprice) {
		this.stockout_unitprice = stockout_unitprice;
	}

	public int getStockin_id() {
		return stockin_id;
	}

	public void setStockin_id(int stockin_id) {
		this.stockin_id = stockin_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
}
