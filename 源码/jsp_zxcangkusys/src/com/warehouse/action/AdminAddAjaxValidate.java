package com.warehouse.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.warehouse.service.AdminService;
import com.warehouse.service.impl.AdminServiceImpl;


/**
 * 管理员名称验证
 * @author admin
 *
 */
@WebServlet("/adminAddValidate")
public class AdminAddAjaxValidate extends HttpServlet{

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
		String admin_username = req.getParameter("admin_username");
		PrintWriter out = resp.getWriter();
		AdminService adminService = new AdminServiceImpl();
		Boolean flag = null;
		try {
			flag = adminService.isExistUsername(admin_username);
			if(flag) {
				out.print("用户名已被使用");
			}else {
				out.print("用户名可以使用");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
