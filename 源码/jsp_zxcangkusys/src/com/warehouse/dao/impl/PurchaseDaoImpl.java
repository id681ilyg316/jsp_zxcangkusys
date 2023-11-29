package com.warehouse.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.warehouse.dao.PurchaseDao;
import com.warehouse.model.Purchase;
import com.warehouse.utils.DataSourceUtils;
import com.warehouse.utils.StringUtil;

/**
 * 采购信息持久层
 * @author admin
 *
 */
public class PurchaseDaoImpl implements PurchaseDao {

	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	
	/**
	 * 采购信息添加
	 */
	public int purchaseAdd(Purchase purchase) throws Exception {
		String sql = "insert into tb_purchase (purchase_guid,goods_guid,purchase_num,purchase_total,purchase_date,purchase_desc,accounting_guid) values(?,?,?,?,?,?,?)";
		return qr.update(sql,purchase.getPurchase_guid(),purchase.getGoods_guid(),purchase.getPurchase_num(),purchase.getPurchase_total(),
							purchase.getPurchase_date(),purchase.getPurchase_desc(),purchase.getAccounting_guid());
	}

	/**
	 * 采购信息遍历
	 */
	public List<Purchase> purchaseList(int pageIndex, int pageSize, String accounting_guid, String goods_guid)
			throws Exception {
		String sql = "select p.*,g.goods_name,a.accounting_name from tb_purchase p,tb_goods g,tb_accounting a where p.goods_guid=g.goods_guid and p.accounting_guid=a.accounting_guid ";
		if(StringUtil.isNotEmpty(accounting_guid)) {
			sql += " and a.accounting_guid='"+accounting_guid+"'";
		}
		if(StringUtil.isNotEmpty(goods_guid)) {
			sql += " and g.goods_guid='"+goods_guid+"'";
		}
		sql += " limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Purchase.class),pageIndex*pageSize,pageSize);
	}

	/**
	 * 统计采购信息数量
	 */
	public int queryCount(String accounting_guid, String goods_guid) throws Exception {
		String sql = "select count(*) from tb_purchase p,tb_goods g,tb_accounting a where p.goods_guid=g.goods_guid and p.accounting_guid=a.accounting_guid ";
		if(StringUtil.isNotEmpty(accounting_guid)) {
			sql += " and a.accounting_guid='"+accounting_guid+"'";
		}
		if(StringUtil.isNotEmpty(goods_guid)) {
			sql += " and g.goods_guid='"+goods_guid+"'";
		}
		return ((Long)qr.query(sql, new ScalarHandler<>())).intValue();
	}

}
