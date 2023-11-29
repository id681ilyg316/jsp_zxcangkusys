package com.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.warehouse.dao.GoodstypeDao;
import com.warehouse.dao.impl.GoodstypeDaoImpl;
import com.warehouse.model.Goodstype;
import com.warehouse.service.GoodstypeService;
import com.warehouse.utils.UUIDUtils;


/**
 * 货品类别业务层
 * @author admin
 *
 */
public class GoodstypeServiceImpl implements GoodstypeService{

	GoodstypeDao dao = new GoodstypeDaoImpl();
	
	/**
	 * 添加货品类别信息
	 */
	public int goodstypeAdd(Goodstype goodstype) throws Exception {
		goodstype.setType_guid(UUIDUtils.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		goodstype.setType_date(date);
		return dao.goodstypeAdd(goodstype);
	}

	/**
	 * 遍历货品类别信息
	 */
	public List<Goodstype> goodstypeList(int pageIndex, int pageSize, String typeName) throws Exception {
		return dao.goodstypeList(pageIndex,pageSize,typeName);
	}

	/**
	 * 统计货品类别总记录数
	 */
	public int goodstypequeryCount(String typeName) throws Exception {
		return dao.goodstypequeryCount(typeName);
	}

	/**
	 * 删除类别
	 */
	public int goodstypeDelete(String type_guid) throws Exception {
		return dao.goodstypeDelete(type_guid);
	}

	/**
	 * 判断类别下是否存在货品
	 */
	public int selecttypeguid(String type_guid) throws Exception {
		return dao.selecttypeguid(type_guid);
	}

	/**
	 * 获取货品类别名称
	 */
	public List<Goodstype> goodstypeNameList() throws Exception {
		return dao.goodstypeNameList();
	}

}
