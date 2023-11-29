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
import com.warehouse.model.Accountingadd;
import com.warehouse.service.AccountingaddService;
import com.warehouse.service.impl.AccountingaddServiceImpl;

/**
 * 添加额度信息遍历
 * @author admin
 *
 */
@WebServlet("/accountingaddList")
public class AccountingaddListAction extends HttpServlet{

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
		try {
			List<Accountingadd> list = new ArrayList<Accountingadd>();
			AccountingaddService service = new AccountingaddServiceImpl();
			list = service.accountingaddList(pageIndex,pageSize,accounting_guid);
			int total = service.accountingaddQueryCount(accounting_guid);
			HashMap json = new HashMap();
			json.put("total", total);
			json.put("data", list);
			resp.getWriter().write(JSONObject.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
