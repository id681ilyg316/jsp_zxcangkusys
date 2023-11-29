package com.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.warehouse.dao.GoodsDao;
import com.warehouse.dao.StockinDao;
import com.warehouse.dao.StockoutDao;
import com.warehouse.dao.impl.GoodsDaoImpl;
import com.warehouse.dao.impl.StockinDaoImpl;
import com.warehouse.dao.impl.StockoutDaoImpl;
import com.warehouse.model.Goods;
import com.warehouse.model.Stockout;
import com.warehouse.service.StockoutService;
import com.warehouse.utils.UUIDUtils;

/**
 * 出库信息业务层
 * @author admin
 *
 */
public class StockoutServiceImpl implements StockoutService {

	StockoutDao dao = new StockoutDaoImpl();
	
	/**
	 * 入库信息添加
	 */
	public int stockoutAdd(Stockout stockout) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		stockout.setStockout_date(date);
		
		//根据入库guid获取入库时的商品guid
		String stockinguid = stockout.getStockin_guid();
		StockinDao stockinDao = new StockinDaoImpl();
		String goods_guid = stockinDao.getStockinGoodsguid(stockinguid);
		stockout.setGoods_guid(goods_guid);
		
		//根据货品guid获取货品的入库单价
		GoodsDao goodsDao = new GoodsDaoImpl();
		Goods goods = goodsDao.queryByGoodsGuid(goods_guid);
		double goodsprice = goods.getGoods_place();
		
		//设置出库总价，盈利
		double stockoutmoney = stockout.getStockout_num() * stockout.getStockout_unitprice();
		double stockinmoeny = stockout.getStockout_num() * goodsprice;
		double profit = stockoutmoney - stockinmoeny;
		stockout.setStockout_money(stockoutmoney);
		stockout.setStockout_profit(profit);
		
		stockout.setStockout_guid(UUIDUtils.getId());
		
		return dao.stockoutAdd(stockout);
	}

	/**
	 * 遍历出库信息
	 */
	public List<Stockout> stockoutList(int pageIndex, int pageSize, String goods_guid) throws Exception {
		return dao.stockoutList(pageIndex,pageSize,goods_guid);
	}

	/**
	 * 统计出库信息总记录数
	 */
	public int stockoutqueryCount(String goods_guid) throws Exception {
		return dao.stockoutqueryCount(goods_guid);
	}

}
