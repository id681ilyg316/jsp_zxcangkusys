package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.warehouse.service.GoodsService;
import com.warehouse.service.impl.GoodsServiceImpl;

/**
 * 货品信息删除
 * @author admin
 *
 */
@WebServlet("/goodsDelete")
public class GoodsDeleteAction extends HttpServlet {

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
		String goods_guid = req.getParameter("goods_guid");
		GoodsService service = new GoodsServiceImpl();
		try {
			int i = service.goodsDelete(goods_guid);
			if(i > 0) {
				resp.getWriter().write("货品信息删除成功");
			}else {
				resp.getWriter().write("货品信息删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
