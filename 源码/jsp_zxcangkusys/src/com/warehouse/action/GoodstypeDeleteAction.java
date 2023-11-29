package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.warehouse.model.Goodstype;
import com.warehouse.service.GoodstypeService;
import com.warehouse.service.impl.GoodstypeServiceImpl;

/**
 * 货品类别信息删除
 * @author admin
 *
 */
@WebServlet("/goodstypeDelete")
public class GoodstypeDeleteAction extends HttpServlet{

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
		String type_guid = req.getParameter("type_guid");
		GoodstypeService service = new GoodstypeServiceImpl();
		try {
			int a = service.selecttypeguid(type_guid);
			if(a == 0) {
				int i = service.goodstypeDelete(type_guid);
				if(i > 0) {
					resp.getWriter().write("货品类别信息删除成功");
				}else {
					resp.getWriter().write("货品类别信息删除失败");
				}
			}else {
				resp.getWriter().write("该类别存在货品无法删除");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
