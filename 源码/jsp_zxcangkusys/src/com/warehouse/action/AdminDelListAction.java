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
import com.warehouse.model.Admin;
import com.warehouse.service.AdminService;
import com.warehouse.service.impl.AdminServiceImpl;

/**
 * 管理员信息遍历
 * @author admin
 *
 */
@WebServlet("/admindelList")
public class AdminDelListAction extends HttpServlet{

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
		String adminUsername = req.getParameter("adminUsername");
		String adminName = req.getParameter("adminName");
		try {
			List<Admin> list = new ArrayList<Admin>();
			AdminService service = new AdminServiceImpl();
			list = service.adminDelList(pageIndex,pageSize,adminUsername,adminName);
			int total = service.queryDelCount(adminUsername,adminName);
			HashMap json = new HashMap();
			json.put("total", total);
			json.put("data", list);
			resp.getWriter().write(JSONObject.toJSONString(json));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
