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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.warehouse.model.Accounting;
import com.warehouse.model.Goods;
import com.warehouse.model.Purchase;
import com.warehouse.service.AccountingService;
import com.warehouse.service.GoodsService;
import com.warehouse.service.PurchaseService;
import com.warehouse.service.impl.AccountingServiceImpl;
import com.warehouse.service.impl.GoodsServiceImpl;
import com.warehouse.service.impl.PurchaseServiceImpl;

/**
 * 采购信息添加
 * 
 * @author admin
 *
 */
@WebServlet("/purchaseAdd")
public class PurchaseAddAction extends HttpServlet {

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
		String action = req.getParameter("action");
		// 获取货品信息名称
		if ("getGoodsName".equals(action)) {
			GoodsService service = new GoodsServiceImpl();
			List<Goods> list1 = null;
			List<HashMap> list2 = new ArrayList<HashMap>();
			try {
				list1 = service.goodsNameList();
				HashMap json = null;
				for (Goods goods : list1) {
					json = new HashMap();
					json.put("goods_name", goods.getGoods_name());
					json.put("id", goods.getGoods_guid());
					list2.add(json);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.getWriter().write(JSONObject.toJSONString(list2));
		}

		// 获取财务信息名称
		if ("getAccountingName".equals(action)) {
			AccountingService service = new AccountingServiceImpl();
			List<Accounting> list1 = null;
			List<HashMap> list2 = new ArrayList<HashMap>();
			try {
				list1 = service.accountingNameList();
				HashMap json = null;
				for (Accounting accounting : list1) {
					json = new HashMap();
					json.put("accounting_name", accounting.getAccounting_name());
					json.put("id", accounting.getAccounting_guid());
					list2.add(json);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.getWriter().write(JSONObject.toJSONString(list2));
		}

		// 采购信息添加
		if ("add".equals(action)) {
			String submitData = req.getParameter("submitData");
			Purchase purchase = JSON.parseObject(submitData, Purchase.class);
			PurchaseService service = new PurchaseServiceImpl();
			try {
				int i = service.purchaseAdd(purchase);
				if (i > 0) {
					resp.getWriter().write("采购信息添加成功");
				} else {
					resp.getWriter().write("采购信息添加失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
