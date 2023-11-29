package com.warehouse.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.warehouse.dao.StockinDao;
import com.warehouse.model.Stockin;
import com.warehouse.utils.DataSourceUtils;
import com.warehouse.utils.StringUtil;

/**
 * 入库信息持久层
 * @author admin
 *
 */
public class StockinDaoImpl implements StockinDao {

	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	
	/**
	 * 添加入库信息
	 */
	public int stockinAdd(Stockin stockin) throws Exception {
		String sql = "insert into tb_stockin(stockin_guid,goods_guid,stockin_num,stockin_date) values(?,?,?,?)";
		return qr.update(sql,stockin.getStockin_guid(),stockin.getGoods_guid(),stockin.getStockin_num(),stockin.getStockin_date());
	}

	/**
	 * 遍历入库信息
	 */
	public List<Stockin> stockinList(int pageIndex, int pageSize, String goods_guid)throws Exception {
		String sql = "select s.*,g.goods_name from tb_stockin s,tb_goods g where s.goods_guid=g.goods_guid";
		if(StringUtil.isNotEmpty(goods_guid)) {
			sql += " and g.goods_guid='"+goods_guid+"'";
		}
		sql += " limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Stockin.class),pageIndex*pageSize,pageSize);
	}

	/**
	 * 统计入库信息数量
	 */
	public int stockinqueryCount(String goods_guid)throws Exception {
		String sql = "select count(*) from tb_stockin s,tb_goods g where s.goods_guid=g.goods_guid";
		if(StringUtil.isNotEmpty(goods_guid)) {
			sql += " and g.goods_guid='"+goods_guid+"'";
		}
		return ((Long)qr.query(sql, new ScalarHandler<>())).intValue();
	}

	/**
	 * 获取入库编号
	 */
	public List<Stockin> getStockinidList() throws Exception {
		String sql = "select stockin_id,stockin_guid from tb_stockin";
		return qr.query(sql, new BeanListHandler<>(Stockin.class));
	}

	/**
	 * 通过入库guid获取入库数量
	 */
	public int getStockinNum(String stockinguid) throws Exception {
		String sql = "select stockin_num from tb_stockin where stockin_guid=?";
		return ((Integer)qr.query(sql, new ScalarHandler<>(),stockinguid)).intValue();
	}

	/**
	 * 根据入库guid获取入库时的商品guid
	 */
	public String getStockinGoodsguid(String stockinguid) throws Exception {
		String sql = "select goods_guid from tb_stockin where stockin_guid=?";
		return qr.query(sql,new ScalarHandler<>(),stockinguid);
	}

}
