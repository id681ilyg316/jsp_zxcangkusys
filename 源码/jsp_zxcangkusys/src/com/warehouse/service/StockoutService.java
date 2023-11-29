package com.warehouse.service;

import java.util.List;

import com.warehouse.model.Stockout;

public interface StockoutService {

	int stockoutAdd(Stockout stockout)throws Exception;

	List<Stockout> stockoutList(int pageIndex, int pageSize, String goods_guid)throws Exception;

	int stockoutqueryCount(String goods_guid)throws Exception;

}
