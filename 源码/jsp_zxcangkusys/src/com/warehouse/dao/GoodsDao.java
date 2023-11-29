package com.warehouse.dao;

import java.util.List;

import com.warehouse.model.Goods;

public interface GoodsDao {

	int goodsadd(Goods goods) throws Exception ;

	List<Goods> goodsList(int pageIndex, int pageSize, String goods_name, String type_guid) throws Exception;

	int goodsQueryCount(String goods_name, String type_guid) throws Exception;

	int goodsDelete(String goods_guid) throws Exception;

	Goods queryByGoodsGuid(String goods_guid)throws Exception;

	int goodsUpdate(Goods goods)throws Exception;

	List<Goods> goodsNameList()throws Exception;

}
