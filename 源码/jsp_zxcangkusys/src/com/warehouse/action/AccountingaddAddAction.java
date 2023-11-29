package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.warehouse.model.Accounting;
import com.warehouse.model.Accountingadd;
import com.warehouse.service.AccountingaddService;
import com.warehouse.service.impl.AccountingaddServiceImpl;

/**
 * 账务金额添加
 * @author admin
 *
 */
@WebServlet("/accountingaddAdd")
public class AccountingaddAddAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AccountingaddService service = new AccountingaddServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		String flag = req.getParameter("flag");
		if("queryByAccountingguid".equals(flag)) {
			queryByAccountingguid(req, resp);
		}
		else if("add".equals(flag)){
			add(req, resp);
		}
	}
	
	/**
	 * 根据账务guid获取账务信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void queryByAccountingguid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accounting_guid = req.getParameter("accounting_guid");
		Accounting accounting = null;
		try {
			accounting = service.queryByAccountingguid(accounting_guid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().write(JSONObject.toJSONString(accounting));
	}
	
	/**
	 * 添加账务金额
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String submitDatat = req.getParameter("submitData");
		Accountingadd accountingadd = JSON.parseObject(submitDatat,Accountingadd.class);
		int i = 0;
		try {
			i = service.accountingaddAdd(accountingadd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i > 0) {
			resp.getWriter().write("添加账务金额功");
		}else {
			resp.getWriter().write("添加账务金额失败");
		}
	}
}
