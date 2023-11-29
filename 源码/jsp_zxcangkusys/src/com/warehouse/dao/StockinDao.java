package com.warehouse.dao;

import java.util.List;

import com.warehouse.model.Stockin;

public interface StockinDao {

	int stockinAdd(Stockin stockin)throws Exception;

	List<Stockin> stockinList(int pageIndex, int pageSize, String goods_guid)throws Exception;

	int stockinqueryCount(String goods_guid)throws Exception;

	List<Stockin> getStockinidList()throws Exception;

	int getStockinNum(String stockinguid)throws Exception;

	String getStockinGoodsguid(String stockinguid)throws Exception;

}
