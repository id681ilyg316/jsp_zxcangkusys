package com.warehouse.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.warehouse.model.Goods;
import com.warehouse.service.GoodsService;
import com.warehouse.service.impl.GoodsServiceImpl;

/**
 * 货品信息修改
 * @author admin
 *
 */
@WebServlet("/goodsUpdate")
public class GoodsUpdateAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GoodsService service = new GoodsServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String flag = req.getParameter("flag");
		if("queryByGoodsGuid".equals(flag)) {
			queryByAdminGuid(req, resp);
		}else if("update".equals(flag)){
			update(req, resp);
		}
	}
	
	/**
	 * 根据货品guid获取货品信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void queryByAdminGuid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String goods_guid = req.getParameter("goods_guid");
		Goods goods = null;
		try {
			goods = service.queryByGoodsGuid(goods_guid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.getWriter().write(JSONObject.toJSONString(goods));
	}
	
	/**
	 * 更新货品信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-type", "text/html;charset=UTF-8");
		String submitDatat = req.getParameter("submitData");
		Goods goods = JSON.parseObject(submitDatat,Goods.class);
		int i = 0;
		try {
			i = service.goodsUpdate(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i > 0) {
			resp.getWriter().write("货品信息修改成功");
		}else {
			resp.getWriter().write("货品信息修改失败");
		}
	}
}
