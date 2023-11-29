package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.warehouse.model.Admin;
import com.warehouse.service.AdminService;
import com.warehouse.service.impl.AdminServiceImpl;

/**
 * 管理员信息修改
 * @author admin
 *
 */
@WebServlet("/adminUpdate")
public class AdminUpdateAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AdminService service = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		String flag = req.getParameter("flag");
		if("queryByAdminGuid".equals(flag)) {
			queryByAdminGuid(req, resp);
		}else if("update".equals(flag)){
			update(req, resp);
		}
	}
	
	/**
	 * 根据管理员guid获取管理员信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void queryByAdminGuid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String admin_guid = req.getParameter("admin_guid");
		Admin admin = null;
		try {
			admin = service.queryByAdminGuid(admin_guid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().write(JSONObject.toJSONString(admin));
	}
	
	/**
	 * 更新管理员信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String submitDatat = req.getParameter("submitData");
		Admin admin = JSON.parseObject(submitDatat,Admin.class);
		int i = 0;
		try {
			i = service.adminUpdate(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i > 0) {
			resp.getWriter().write("管理员信息修改成功");
		}else {
			resp.getWriter().write("管理员信息修改失败");
		}
	}
}
