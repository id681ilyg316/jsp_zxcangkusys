package com.warehouse.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.warehouse.model.Goods;
import com.warehouse.model.Goodstype;
import com.warehouse.service.GoodsService;
import com.warehouse.service.GoodstypeService;
import com.warehouse.service.impl.GoodsServiceImpl;
import com.warehouse.service.impl.GoodstypeServiceImpl;

/**
 * 货品信息添加
 * 
 * @author admin
 *
 */
@WebServlet("/goodsAdd")
public class GoodsAddAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		String action = req.getParameter("action");
		// 获取货品类别信息
		if ("getTypeName".equals(action)) {
			GoodstypeService service = new GoodstypeServiceImpl();
			List<Goodstype> list1 = null;
			List<HashMap> list2 = new ArrayList<HashMap>();
			try {
				list1 = service.goodstypeNameList();
				HashMap json = null;
				for (Goodstype goodstype : list1) {
					json = new HashMap();
					json.put("type_name", goodstype.getType_name());
					json.put("id", goodstype.getType_guid());
					list2.add(json);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.getWriter().write(JSONObject.toJSONString(list2));
		}

		// 货品信息添加
		if ("add".equals(action)) {
			String submitData = req.getParameter("submitData");
			Goods goods = JSON.parseObject(submitData, Goods.class);
			GoodsService service = new GoodsServiceImpl();
			try {
				int i = service.goodsadd(goods);
				if (i > 0) {
					resp.getWriter().write("货品信息添加成功");
				} else {
					resp.getWriter().write("货品信息添加失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
