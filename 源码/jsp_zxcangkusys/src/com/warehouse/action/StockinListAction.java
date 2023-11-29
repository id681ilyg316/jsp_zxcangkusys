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
import com.warehouse.model.Stockin;
import com.warehouse.service.StockinService;
import com.warehouse.service.impl.StockinServiceImpl;

/**
 * 入库信息列表
 * @author admin
 *
 */
@WebServlet("/stockinList")
public class StockinListAction extends HttpServlet{

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
		String goods_guid = req.getParameter("goods_guid");
		try {
			List<Stockin> list = new ArrayList<Stockin>();
			StockinService service = new StockinServiceImpl();
			list = service.stockinList(pageIndex,pageSize,goods_guid);
			int total = service.stockinqueryCount(goods_guid);
			HashMap json = new HashMap();
			json.put("total", total);
			json.put("data", list);
			resp.getWriter().write(JSONObject.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
