package com.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.warehouse.dao.AccountingDao;
import com.warehouse.dao.GoodsDao;
import com.warehouse.dao.PurchaseDao;
import com.warehouse.dao.StockinDao;
import com.warehouse.dao.impl.AccountingDaoImpl;
import com.warehouse.dao.impl.GoodsDaoImpl;
import com.warehouse.dao.impl.PurchaseDaoImpl;
import com.warehouse.dao.impl.StockinDaoImpl;
import com.warehouse.model.Goods;
import com.warehouse.model.Purchase;
import com.warehouse.model.Stockin;
import com.warehouse.service.PurchaseService;
import com.warehouse.utils.UUIDUtils;

/**
 * 采购信息业务层
 * @author admin
 *
 */
public class PurchaseServiceImpl implements PurchaseService {

	PurchaseDao dao = new PurchaseDaoImpl();
	
	/**
	 * 采购信息添加
	 */
//采购信息添加
public int purchaseAdd(Purchase purchase) throws Exception {
	int i = 0;
	//通过货品guid获取货品信息以获取货品的单价
	String goods_guid = purchase.getGoods_guid();
	GoodsDao goodsDao = new GoodsDaoImpl();
	Goods goods = goodsDao.queryByGoodsGuid(goods_guid);
	double price = goods.getGoods_price();
	//获取采购的总价
	String num = purchase.getPurchase_num();
	double total = price * Double.parseDouble(num);
	
	purchase.setPurchase_guid(UUIDUtils.getId());
	purchase.setPurchase_total(total);
	//更新财务的信息
	String accounting_guid = purchase.getAccounting_guid();
	AccountingDao accountingDao = new AccountingDaoImpl();
	int a = accountingDao.updateMoney(accounting_guid,total);
	
	//添加入库
	Stockin stockin = new Stockin();
	stockin.setStockin_guid(UUIDUtils.getId());
	stockin.setGoods_guid(goods_guid);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String date = sdf.format(new Date());
	stockin.setStockin_date(date);
	stockin.setStockin_num(Integer.parseInt(num));
	StockinDao stockinDao = new StockinDaoImpl();
	int s = stockinDao.stockinAdd(stockin);
	
	if(s > 0 && a > 0) {
		i = dao.purchaseAdd(purchase);
	}
	return i;
}

	/**
	 * 采购信息遍历
	 */
	public List<Purchase> purchaseList(int pageIndex, int pageSize, String accounting_guid, String goods_guid)
			throws Exception {
		return dao.purchaseList(pageIndex,pageSize,accounting_guid,goods_guid);
	}

	/**
	 * 统计采购信息数量
	 */
	public int queryCount(String accounting_guid, String goods_guid) throws Exception {
		return dao.queryCount(accounting_guid,goods_guid);
	}

}
