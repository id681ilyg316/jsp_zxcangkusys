package com.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.warehouse.dao.GoodsDao;
import com.warehouse.dao.impl.GoodsDaoImpl;
import com.warehouse.model.Goods;
import com.warehouse.service.GoodsService;
import com.warehouse.utils.UUIDUtils;

/**
 * 货品信息业务层
 * 
 * @author admin
 *
 */
public class GoodsServiceImpl implements GoodsService {

	GoodsDao dao = new GoodsDaoImpl();

	/**
	 * 添加货品信息
	 */
	public int goodsadd(Goods goods) throws Exception {
		goods.setGoods_guid(UUIDUtils.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		goods.setGoods_date(date);
		return dao.goodsadd(goods);
	}

	/**
	 * 遍历货品信息
	 */
	public List<Goods> goodsList(int pageIndex, int pageSize, String goods_name, String type_guid) throws Exception {
		return dao.goodsList(pageIndex, pageSize, goods_name, type_guid);
	}

	/**
	 * 统计货品总记录数
	 */
	public int goodsQueryCount(String goods_name, String type_guid) throws Exception {
		return dao.goodsQueryCount(goods_name, type_guid);
	}

	/**
	 * 删除货品信息
	 */
	public int goodsDelete(String goods_guid) throws Exception {
		return dao.goodsDelete(goods_guid);
	}

	/**
	 * 根据货品guid获取货品信息
	 */
	public Goods queryByGoodsGuid(String goods_guid) throws Exception {
		return dao.queryByGoodsGuid(goods_guid);
	}

	/**
	 * 更新货品信息
	 */
	public int goodsUpdate(Goods goods) throws Exception {
		return dao.goodsUpdate(goods);
	}

	/**
	 * 获取商品名称
	 */
	public List<Goods> goodsNameList() throws Exception {
		return dao.goodsNameList();
	}

}
