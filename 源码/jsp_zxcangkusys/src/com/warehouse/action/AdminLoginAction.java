package com.warehouse.action;

import java.io.IOException;

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
@WebServlet("/adminLogin")
public class AdminLoginAction extends HttpServlet {

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
		String admin_username = req.getParameter("username");
		String admin_pwd = req.getParameter("password");
		AdminService service = new AdminServiceImpl();
		Admin admin = null;
		try {
			admin = service.login(admin_username, admin_pwd);
			if (admin == null) {
				req.getRequestDispatcher("/login.html").forward(req, resp);
			} else {
				req.getRequestDispatcher("/index.html").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
