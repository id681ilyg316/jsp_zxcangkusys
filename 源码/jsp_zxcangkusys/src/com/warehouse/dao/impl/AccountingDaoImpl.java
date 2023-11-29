package com.warehouse.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.warehouse.dao.AccountingDao;
import com.warehouse.model.Accounting;
import com.warehouse.utils.DataSourceUtils;
import com.warehouse.utils.StringUtil;

/**
 * 账务信息持久层
 * 
 * @author admin
 *
 */
public class AccountingDaoImpl implements AccountingDao {

	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

	/**
	 * 添加财务信息
	 */
	public int accountingAdd(Accounting accounting) throws Exception {
		String sql = "insert into tb_accounting(accounting_guid,accounting_name,accounting_money,accounting_date,accounting_used,accounting_balance,accounting_desc,accounting_level) "
				+ "values(?,?,?,?,?,?,?,?)";
		return qr.update(sql, accounting.getAccounting_guid(), accounting.getAccounting_name(),
				accounting.getAccounting_money(), accounting.getAccounting_date(), accounting.getAccounting_used(),
				accounting.getAccounting_balance(), accounting.getAccounting_desc(), accounting.getAccounting_level());
	}

	/**
	 * 遍历财务信息
	 */
	public List<Accounting> accountingList(int pageIndex, int pageSize, String accountingName, String accountingLevel)
			throws Exception {
		String sql = "select * from tb_accounting where 1=1";
		if (StringUtil.isNotEmpty(accountingName)) {
			sql += " and accounting_name like '%" + accountingName + "%'";
		}
		if (StringUtil.isNotEmpty(accountingLevel)) {
			sql += " and accounting_level = '" + accountingLevel + "'";
		}
		sql += " order by accounting_date desc limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Accounting.class), pageIndex * pageSize, pageSize);
	}

	/**
	 * 查询财务总记录数
	 */
	public int accountingQueryCount(String accountingName, String accountingLevel) throws Exception {
		String sql = "select count(*) from tb_accounting where 1=1";
		if (StringUtil.isNotEmpty(accountingName)) {
			sql += " and accounting_name like '%" + accountingName + "%'";
		}
		if (StringUtil.isNotEmpty(accountingLevel)) {
			sql += " and accounting_level = '" + accountingLevel + "'";
		}
		return ((Long) qr.query(sql, new ScalarHandler<>())).intValue();
	}

	/**
	 * 添加财务余额
	 */
	public int accountingUpdateMoney(String accountingguid, double accounting_add_money) throws Exception {
		String sql = "update tb_accounting set accounting_money=accounting_money+?,accounting_balance=accounting_balance+? where accounting_guid=?";
		return qr.update(sql, accounting_add_money, accounting_add_money, accountingguid);
	}

	/**
	 * 获取财务信息名称
	 */
	public List<Accounting> accountingNameList() throws Exception {
		String sql = "select accounting_guid,accounting_name from tb_accounting";
		return qr.query(sql, new BeanListHandler<>(Accounting.class));
	}

	/**
	 * 更新财务余额
	 */
	public int updateMoney(String accounting_guid, double total) throws Exception {
		String sql = "update tb_accounting set accounting_balance=accounting_balance-?,accounting_used=accounting_used+? where accounting_guid=?";
		return qr.update(sql, total, total, accounting_guid);
	}

	/**
	 * 删除账务信息
	 */
	public int accountingDelete(String accounting_guid) throws Exception {
		String sql = "delete from tb_accounting where accounting_guid=?";
		return qr.update(sql, accounting_guid);
	}

}
