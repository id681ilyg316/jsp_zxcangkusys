package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.warehouse.model.Admin;
import com.warehouse.service.AdminService;
import com.warehouse.service.impl.AdminServiceImpl;

/**
 * 管理员信息添加
 * @author admin
 *
 */
@WebServlet("/adminAdd")
public class AdminAddAction extends HttpServlet{

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
		Admin admin = JSON.parseObject(submitData, Admin.class);
		try {
			AdminService service = new AdminServiceImpl();
			int i = service.adminAdd(admin);
			if(i > 0) {
				resp.getWriter().write("管理员信息添加成功");
			}else {
				resp.getWriter().write("管理员信息添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
