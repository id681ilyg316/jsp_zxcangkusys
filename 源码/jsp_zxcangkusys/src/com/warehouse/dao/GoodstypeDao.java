package com.warehouse.dao;

import java.util.List;

import com.warehouse.model.Goodstype;

public interface GoodstypeDao {

	int goodstypeAdd(Goodstype goodstype)throws Exception;

	List<Goodstype> goodstypeList(int pageIndex, int pageSize, String typeName)throws Exception;

	int goodstypequeryCount(String typeName)throws Exception;

	int goodstypeDelete(String type_guid)throws Exception;

	int selecttypeguid(String type_guid)throws Exception;

	List<Goodstype> goodstypeNameList()throws Exception;

}
