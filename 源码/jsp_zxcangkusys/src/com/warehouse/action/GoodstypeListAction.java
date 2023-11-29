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
import com.warehouse.model.Goodstype;
import com.warehouse.service.GoodstypeService;
import com.warehouse.service.impl.GoodstypeServiceImpl;

/**
 * 货品信息遍历
 * @author admin
 *
 */
@WebServlet("/goodstypeList")
public class GoodstypeListAction extends HttpServlet{

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
		String typeName = req.getParameter("typeName");
		try {
			List<Goodstype> list = new ArrayList<Goodstype>();
			GoodstypeService service = new GoodstypeServiceImpl();
			list = service.goodstypeList(pageIndex,pageSize,typeName);
			int total = service.goodstypequeryCount(typeName);
			HashMap json = new HashMap();
			json.put("total", total);
			json.put("data", list);
			resp.getWriter().write(JSONObject.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
