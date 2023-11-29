package com.warehouse.dao;

import java.util.List;

import com.warehouse.model.Accounting;

public interface AccountingDao {

	int accountingAdd(Accounting accounting)throws Exception;

	List<Accounting> accountingList(int pageIndex, int pageSize, String accountingName, String accountingLevel)throws Exception;

	int accountingQueryCount(String accountingName, String accountingLevel)throws Exception;

	int accountingUpdateMoney(String accountingguid, double accounting_add_money)throws Exception;

	List<Accounting> accountingNameList()throws Exception;

	int updateMoney(String accounting_guid, double total)throws Exception;

	int accountingDelete(String accounting_guid)throws Exception;

}
