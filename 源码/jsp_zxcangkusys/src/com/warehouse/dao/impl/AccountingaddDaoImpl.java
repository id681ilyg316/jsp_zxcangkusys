package com.warehouse.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.warehouse.dao.AccountingaddDao;
import com.warehouse.model.Accounting;
import com.warehouse.model.Accountingadd;
import com.warehouse.utils.DataSourceUtils;

/**
 * 新增账务持久层
 * @author admin
 *
 */
public class AccountingaddDaoImpl implements AccountingaddDao {

	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	
	/**
	 * 新增账务信息遍历
	 */
	public List<Accountingadd> accountingaddList(int pageIndex, int pageSize, String accounting_guid) throws Exception {
		String sql = "select a.*,b.accounting_name from tb_accounting b,tb_accounting_add a where a.accounting_guid=b.accounting_guid and a.accounting_guid=? limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Accountingadd.class),accounting_guid,pageIndex*pageSize,pageSize);
	}

	/**
	 * 新增账务信息总记录数
	 */
	public int accountingaddQueryCount(String accounting_guid) throws Exception {
		String sql = "select count(*) from tb_accounting b,tb_accounting_add a where a.accounting_guid=b.accounting_guid and a.accounting_guid=?";
		return ((Long)qr.query(sql, new ScalarHandler<>(),accounting_guid)).intValue();
	}

	/**
	 * 根据账务guid获取账务信息
	 */
	public Accounting queryByAccountingguid(String accounting_guid) throws Exception {
		String sql = "select * from tb_accounting where accounting_guid=?";
		return qr.query(sql, new BeanHandler<>(Accounting.class),accounting_guid);
	}

	/**
	 * 添加新增额度信息
	 */
	public int accountingaddAdd(Accountingadd accountingadd) throws Exception {
		String sql = "insert into tb_accounting_add(accounting_add_guid,accounting_guid,accounting_add_date,accounting_add_money) values(?,?,?,?)";
		return qr.update(sql,accountingadd.getAccounting_add_guid(),accountingadd.getAccounting_guid(),
							accountingadd.getAccounting_add_date(),accountingadd.getAccounting_add_money());
	}

}
