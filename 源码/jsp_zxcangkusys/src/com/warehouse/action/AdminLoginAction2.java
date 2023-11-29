package com.warehouse.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.warehouse.model.Admin;
import com.warehouse.service.AdminService;
import com.warehouse.service.impl.AdminServiceImpl;

/**
 * 管理员登录
 * 
 * @author admin
 *
 */
@WebServlet("/adminLogin2")
public class AdminLoginAction2 extends HttpServlet {

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
		PrintWriter out = resp.getWriter();
		String admin_username = req.getParameter("username");
		String admin_pwd = req.getParameter("password");
		AdminService service = new AdminServiceImpl();
		Admin admin = null;
		try {
			admin = service.login(admin_username, admin_pwd);
			if (admin == null) {
				out.write("1");
			} else {
				int authority = admin.getAdmin_authority();
				if(authority == 1) {
					out.write("2");
				}else {
					out.write("3");
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.flush();
		out.close();
	}
}
