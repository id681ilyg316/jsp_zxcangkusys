package com.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.warehouse.dao.AccountingDao;
import com.warehouse.dao.AccountingaddDao;
import com.warehouse.dao.impl.AccountingDaoImpl;
import com.warehouse.dao.impl.AccountingaddDaoImpl;
import com.warehouse.model.Accounting;
import com.warehouse.model.Accountingadd;
import com.warehouse.service.AccountingaddService;
import com.warehouse.utils.UUIDUtils;

/**
 * 新增账务业务层
 * @author admin
 *
 */
public class AccountingaddServiceImpl implements AccountingaddService {
	
	AccountingaddDao dao = new AccountingaddDaoImpl();
	
	/**
	 * 新增账务信息遍历
	 */
	public List<Accountingadd> accountingaddList(int pageIndex, int pageSize, String accounting_guid) throws Exception {
		return dao.accountingaddList(pageIndex,pageSize,accounting_guid);
	}

	/**
	 * 新增账务信息总记录数
	 */
	public int accountingaddQueryCount(String accounting_guid) throws Exception {
		return dao.accountingaddQueryCount(accounting_guid);
	}

	/**
	 * 根据账务guid获取账务信息
	 */
	public Accounting queryByAccountingguid(String accounting_guid) throws Exception {
		return dao.queryByAccountingguid(accounting_guid);
	}

	/**
	 * 添加账务金额
	 */
	public int accountingaddAdd(Accountingadd accountingadd) throws Exception {
		int i = 0;
		AccountingDao dao2 = new AccountingDaoImpl();
		int a = dao2.accountingUpdateMoney(accountingadd.getAccounting_guid(),accountingadd.getAccounting_add_money());
		if(a > 0 ) {
			accountingadd.setAccounting_add_guid(UUIDUtils.getId());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			accountingadd.setAccounting_add_date(date);
			i = dao.accountingaddAdd(accountingadd);
		}
		return i;
	}

}
