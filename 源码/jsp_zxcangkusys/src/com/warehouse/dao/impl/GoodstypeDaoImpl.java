package com.warehouse.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.warehouse.dao.GoodstypeDao;
import com.warehouse.model.Goodstype;
import com.warehouse.utils.DataSourceUtils;
import com.warehouse.utils.StringUtil;


/**
 * 货品类别持久层
 * @author admin
 *
 */
public class GoodstypeDaoImpl implements GoodstypeDao {

	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	
	/**
	 * 添加货品类别信息
	 */
	public int goodstypeAdd(Goodstype goodstype) throws Exception {
		String sql = "insert into tb_goodstype (type_guid,type_name,type_date,type_desc) values(?,?,?,?)";
		return qr.update(sql,goodstype.getType_guid(),goodstype.getType_name(),goodstype.getType_date(),goodstype.getType_desc());
	}

	/**
	 * 遍历货品类别信息
	 */
	public List<Goodstype> goodstypeList(int pageIndex, int pageSize, String typeName) throws Exception {
		String sql = "select * from tb_goodstype where 1=1";
		if(StringUtil.isNotEmpty(typeName)) {
			sql += " and type_name like '%"+typeName+"%'";
		}
		sql += " limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Goodstype.class),pageIndex*pageSize,pageSize);
	}

	/**
	 * 统计货品类别总记录数
	 */
	public int goodstypequeryCount(String typeName) throws Exception {
		String sql = "select count(*) from tb_goodstype where 1=1";
		if(StringUtil.isNotEmpty(typeName)) {
			sql += " and type_name like '%"+typeName+"%'";
		}
		return ((Long)qr.query(sql, new ScalarHandler<>())).intValue();
	}

	/**
	 * 货品类别信息删除
	 */
	public int goodstypeDelete(String type_guid) throws Exception {
		int i = 0;
		String[] strs = type_guid.split(",");
		for(int a = 0 ;a < strs.length;a++) {
			String sql = "delete from tb_goodstype where type_guid ='"+strs[a]+"'";
			i = qr.update(sql);
		}
		return i;
	}

	/**
	 * 判断类别下是否存在货品
	 */
	public int selecttypeguid(String type_guid) throws Exception {
		int num = 0;
		String[] strs = type_guid.split(",");
		for(int a = 0;a < strs.length;a++) {
			String sql = "select count(*) from tb_goods where type_guid='"+strs[a]+"'";
			int n = ((Long)qr.query(sql, new ScalarHandler<>())).intValue();
			num = num + n;
		}
		return num;
	}

	/**
	 * 获取货品类别名称
	 */
	public List<Goodstype> goodstypeNameList() throws Exception {
		String sql = "select type_guid,type_name from tb_goodstype";
		return qr.query(sql, new BeanListHandler<>(Goodstype.class));
	}

}
