package com.warehouse.service;

import java.util.List;

import com.warehouse.model.Accounting;

public interface AccountingService {

	int accountingAdd(Accounting accounting)throws Exception;

	List<Accounting> accountingList(int pageIndex, int pageSize, String accountingName, String accountingLevel)throws Exception;

	int accountingQueryCount(String accountingName, String accountingLevel)throws Exception;

	List<Accounting> accountingNameList()throws Exception;

	int accountingDelete(String accounting_guid)throws Exception;

}
