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
import com.warehouse.model.Purchase;
import com.warehouse.service.PurchaseService;
import com.warehouse.service.impl.PurchaseServiceImpl;

/**
 * 采购信息遍历
 * @author admin
 *
 */
@WebServlet("/purchaseList")
public class PurchaseListAction extends HttpServlet{

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
		String accounting_guid = req.getParameter("accounting_guid");
		String goods_guid = req.getParameter("goods_guid");
		try {
			List<Purchase> list = new ArrayList<Purchase>();
			PurchaseService service = new PurchaseServiceImpl();
			list = service.purchaseList(pageIndex,pageSize,accounting_guid,goods_guid);
			int total = service.queryCount(accounting_guid,goods_guid);
			HashMap json = new HashMap();
			json.put("total", total);
			json.put("data", list);
			resp.getWriter().write(JSONObject.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
