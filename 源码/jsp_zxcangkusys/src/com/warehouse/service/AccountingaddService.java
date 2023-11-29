package com.warehouse.service;

import java.util.List;

import com.warehouse.model.Accounting;
import com.warehouse.model.Accountingadd;

public interface AccountingaddService {

	List<Accountingadd> accountingaddList(int pageIndex, int pageSize, String accounting_guid)throws Exception;

	int accountingaddQueryCount(String accounting_guid)throws Exception;

	Accounting queryByAccountingguid(String accounting_guid)throws Exception;

	int accountingaddAdd(Accountingadd accountingadd)throws Exception;

}
