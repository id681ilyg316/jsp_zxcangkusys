package com.warehouse.service.impl;

import java.util.List;

import com.warehouse.dao.StockinDao;
import com.warehouse.dao.impl.StockinDaoImpl;
import com.warehouse.model.Stockin;
import com.warehouse.service.StockinService;

/**
 * 入库信息业务层
 * @author admin
 *
 */
public class StockinServiceImpl implements StockinService {

	StockinDao dao = new StockinDaoImpl();
	/**
	 * 遍历入库信息
	 */
	public List<Stockin> stockinList(int pageIndex, int pageSize, String goods_guid) throws Exception {
		return dao.stockinList(pageIndex,pageSize,goods_guid);
	}

	/**
	 * 统计入库信息数量
	 */
	public int stockinqueryCount(String goods_guid) throws Exception {
		return dao.stockinqueryCount(goods_guid);
	}

	/**
	 * 获取入库编号
	 */
	public List<Stockin> getStockinidList() throws Exception {
		return dao.getStockinidList();
	}

	/**
	 * 通过入库guid获取入库数量
	 */
	public int getStockinNum(String stockinguid) throws Exception {
		return dao.getStockinNum(stockinguid);
	}

}
