package com.warehouse.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.warehouse.dao.StockoutDao;
import com.warehouse.model.Stockout;
import com.warehouse.utils.DataSourceUtils;
import com.warehouse.utils.StringUtil;

/**
 * 出库信息持久层
 * @author admin
 *
 */
public class StockoutDaoImpl implements StockoutDao {

	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	
	/**
	 * 添加出库信息
	 */
	public int stockoutAdd(Stockout stockout) throws Exception {
		String sql = "insert into tb_stockout(stockout_guid,goods_guid,stockout_date,stockout_num,stockin_guid,stockout_people,stockout_money,stockout_profit,stockout_unitprice) values(?,?,?,?,?,?,?,?,?)";
		return qr.update(sql,stockout.getStockout_guid(),stockout.getGoods_guid(),stockout.getStockout_date(),
							stockout.getStockout_num(),stockout.getStockin_guid(),stockout.getStockout_people(),
							stockout.getStockout_money(),stockout.getStockout_profit(),stockout.getStockout_unitprice());
	}

	/**
	 * 遍历出库信息
	 */
	public List<Stockout> stockoutList(int pageIndex, int pageSize, String goods_guid) throws Exception {
		String sql = "select s.*,g.goods_name from tb_stockout s,tb_goods g where s.goods_guid=g.goods_guid ";
		if(StringUtil.isNotEmpty(goods_guid)) {
			sql += " and g.goods_guid='"+goods_guid+"'";
		}
		sql += " limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Stockout.class),pageIndex*pageSize,pageSize);
	}

	/**
	 * 统计出库信息总记录数
	 */
	public int stockoutqueryCount(String goods_guid) throws Exception {
		String sql = "select count(*) from tb_stockout s,tb_goods g where s.goods_guid=g.goods_guid ";
		if(StringUtil.isNotEmpty(goods_guid)) {
			sql += " and g.goods_guid='"+goods_guid+"'";
		}
		return ((Long)qr.query(sql, new ScalarHandler<>())).intValue();
	}

}
