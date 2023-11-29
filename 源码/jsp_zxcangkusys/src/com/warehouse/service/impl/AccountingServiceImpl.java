package com.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.warehouse.dao.AccountingDao;
import com.warehouse.dao.impl.AccountingDaoImpl;
import com.warehouse.model.Accounting;
import com.warehouse.service.AccountingService;
import com.warehouse.utils.UUIDUtils;

/**
 * 账务信息业务层
 * @author admin
 *
 */
public class AccountingServiceImpl implements AccountingService {

	AccountingDao dao = new AccountingDaoImpl();
	
	/**
	 * 添加财务信息
	 */
	public int accountingAdd(Accounting accounting) throws Exception {
		accounting.setAccounting_guid(UUIDUtils.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		accounting.setAccounting_date(date);
		accounting.setAccounting_used(0);
		double balance = accounting.getAccounting_money()-accounting.getAccounting_used();
		accounting.setAccounting_balance(balance);
		return dao.accountingAdd(accounting);
	}

	/**
	 * 遍历财务信息
	 */
	public List<Accounting> accountingList(int pageIndex, int pageSize, String accountingName, String accountingLevel)
			throws Exception {
		return dao.accountingList(pageIndex,pageSize,accountingName,accountingLevel);
	}

	/**
	 * 查询财务总记录数
	 */
	public int accountingQueryCount(String accountingName, String accountingLevel) throws Exception {
		return dao.accountingQueryCount(accountingName,accountingLevel);
	}

	/**
	 * 获取财务信息名称
	 */
	public List<Accounting> accountingNameList() throws Exception {
		return dao.accountingNameList();
	}

	/**
	 * 删除账务信息
	 */
	public int accountingDelete(String accounting_guid) throws Exception {
		return dao.accountingDelete(accounting_guid);
	}

}
