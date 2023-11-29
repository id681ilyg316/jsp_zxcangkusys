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
import com.warehouse.model.Accounting;
import com.warehouse.service.AccountingService;
import com.warehouse.service.impl.AccountingServiceImpl;

/**
 * 财务信息遍历
 * @author admin
 *
 */
@WebServlet("/accountingList")
public class AccountingListAction extends HttpServlet{

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
		String accountingName = req.getParameter("accountingName");
		String accountingLevel = req.getParameter("accountingLevel");
		try {
			List<Accounting> list = new ArrayList<Accounting>();
			AccountingService service = new AccountingServiceImpl();
			list = service.accountingList(pageIndex,pageSize,accountingName,accountingLevel);
			int total = service.accountingQueryCount(accountingName,accountingLevel);
			HashMap json = new HashMap();
			json.put("total", total);
			json.put("data", list);
			resp.getWriter().write(JSONObject.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
