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

import com.alibaba.fastjson.JSONObject;
import com.warehouse.model.Goods;
import com.warehouse.service.GoodsService;
import com.warehouse.service.impl.GoodsServiceImpl;

/**
 * 货品信息遍历
 * 
 * @author admin
 *
 */
@WebServlet("/goodsList")
public class GoodsListAction extends HttpServlet {

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
		int pageIndex = Integer.parseInt(req.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(req.getParameter("pageSize"));
		String type_guid = req.getParameter("type_guid");
		String goods_name = req.getParameter("goods_name");
		try {
			List<Goods> list = new ArrayList<Goods>();
			GoodsService service = new GoodsServiceImpl();
			list = service.goodsList(pageIndex, pageSize, goods_name, type_guid);
			int total = service.goodsQueryCount(goods_name, type_guid);
			HashMap json = new HashMap();
			json.put("total", total);
			json.put("data", list);
			resp.getWriter().write(JSONObject.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
