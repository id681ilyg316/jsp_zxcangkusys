package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.warehouse.service.AccountingService;
import com.warehouse.service.impl.AccountingServiceImpl;

/**
 * 账务信息信息删除
 * 
 * @author admin
 *
 */
@WebServlet("/accountingDelete")
public class AccountingDeleteAction extends HttpServlet {

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
		String accounting_guid = req.getParameter("accounting_guid");
		AccountingService service = new AccountingServiceImpl();
		try {
			int a = service.accountingDelete(accounting_guid);
			if (a > 0) {
				resp.getWriter().write("账务信息删除成功");
			} else {
				resp.getWriter().write("账务信息删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
