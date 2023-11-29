package com.warehouse.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.warehouse.dao.GoodsDao;
import com.warehouse.model.Goods;
import com.warehouse.utils.DataSourceUtils;
import com.warehouse.utils.StringUtil;

/**
 * 货品信息持久层
 * 
 * @author admin
 *
 */
public class GoodsDaoImpl implements GoodsDao {

	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

	/**
	 * 添加货品信息
	 */
	public int goodsadd(Goods goods) throws Exception {
		String sql = "insert into tb_goods (goods_guid,goods_name,type_guid,goods_price,goods_supplier,goods_place,goods_date,goods_retailprice,goods_desc) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		return qr.update(sql, goods.getGoods_guid(), goods.getGoods_name(), goods.getType_guid(),
				goods.getGoods_price(), goods.getGoods_supplier(), goods.getGoods_place(), goods.getGoods_date(),
				goods.getGoods_retailprice(), goods.getGoods_desc());
	}

	/**
	 * 遍历货品信息
	 */
	public List<Goods> goodsList(int pageIndex, int pageSize, String goods_name, String type_guid) throws Exception {
		String sql = "select g.*,gt.type_name from tb_goods g,tb_goodstype gt where g.type_guid=gt.type_guid";
		if (StringUtil.isNotEmpty(goods_name)) {
			sql += " and g.goods_name like '%" + goods_name + "%'";
		}
		if (StringUtil.isNotEmpty(type_guid)) {
			sql += " and gt.type_guid ='" + type_guid + "'";
		}
		sql += " order by g.goods_date desc limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Goods.class), pageIndex * pageSize, pageSize);
	}

	/**
	 * 统计货品总记录数
	 */
	public int goodsQueryCount(String goods_name, String type_guid) throws Exception {
		String sql = "select count(*) from tb_goods g,tb_goodstype gt where g.type_guid=gt.type_guid";
		if (StringUtil.isNotEmpty(goods_name)) {
			sql += " and g.goods_name like '%" + goods_name + "%'";
		}
		if (StringUtil.isNotEmpty(type_guid)) {
			sql += " and gt.type_guid ='" + type_guid + "'";
		}
		return ((Long) qr.query(sql, new ScalarHandler<>())).intValue();
	}

	/**
	 * 删除货品信息
	 */
	public int goodsDelete(String goods_guid) throws Exception {
		int i = 0;
		String[] strs = goods_guid.split(",");
		for (int a = 0; a < strs.length; a++) {
			String sql = "delete from tb_goods where goods_guid ='" + strs[a] + "'";
			i = qr.update(sql);
		}
		return i;
	}

	/**
	 * 根据货品guid获取货品信息
	 */
	public Goods queryByGoodsGuid(String goods_guid) throws Exception {
		String sql = "select * from tb_goods where goods_guid=?";
		return qr.query(sql, new BeanHandler<>(Goods.class), goods_guid);
	}

	/**
	 * 更新货品信息
	 */
	public int goodsUpdate(Goods goods) throws Exception {
		String sql = "update tb_goods set goods_name=?,type_guid=?,goods_price=?,goods_supplier=?,goods_place=?,goods_retailprice=?,goods_desc=? where goods_guid=?";
		return qr.update(sql, goods.getGoods_name(), goods.getType_guid(), goods.getGoods_price(),
				goods.getGoods_supplier(), goods.getGoods_place(), goods.getGoods_retailprice(), goods.getGoods_desc(),
				goods.getGoods_guid());
	}

	/**
	 * 获取商品名称
	 */
	public List<Goods> goodsNameList() throws Exception {
		String sql = "select goods_guid,goods_name from tb_goods";
		return qr.query(sql, new BeanListHandler<>(Goods.class));
	}

}
