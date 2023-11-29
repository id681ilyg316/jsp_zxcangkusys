package com.warehouse.service;

import java.util.List;

import com.warehouse.model.Purchase;

public interface PurchaseService {

	int purchaseAdd(Purchase purchase) throws Exception ;

	List<Purchase> purchaseList(int pageIndex, int pageSize, String accounting_guid, String goods_guid) throws Exception ;

	int queryCount(String accounting_guid, String goods_guid) throws Exception ;

}
