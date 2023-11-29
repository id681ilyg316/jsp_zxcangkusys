package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.warehouse.service.AdminService;
import com.warehouse.service.impl.AdminServiceImpl;


/**
 * 管理员信息删除
 * @author admin
 *
 */
@WebServlet("/adminDelete")
public class AdminDeleteAction extends HttpServlet {

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
		String admin_guid = req.getParameter("admin_guid");
		AdminService service = new AdminServiceImpl();
		try {
			int i = service.adminDelete(admin_guid);
			if(i > 0) {
				resp.getWriter().write("管理员删除成功");
			}else {
				resp.getWriter().write("管理员删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
