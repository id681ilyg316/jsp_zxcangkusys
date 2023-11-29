package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.warehouse.model.Accounting;
import com.warehouse.service.AccountingService;
import com.warehouse.service.impl.AccountingServiceImpl;

/**
 * 财务信息添加
 * @author admin
 *
 */
@WebServlet("/accountingAdd")
public class AccountingAddAction extends HttpServlet{

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
		String submitData = req.getParameter("submitData");
		Accounting accounting = JSON.parseObject(submitData, Accounting.class);
		try {
			AccountingService service = new AccountingServiceImpl();
			int i = service.accountingAdd(accounting);
			if(i > 0) {
				resp.getWriter().write("财务信息添加成功");
			}else {
				resp.getWriter().write("财务信息添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
