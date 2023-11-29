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
import com.warehouse.model.Stockin;
import com.warehouse.model.Stockout;
import com.warehouse.service.StockinService;
import com.warehouse.service.StockoutService;
import com.warehouse.service.impl.StockinServiceImpl;
import com.warehouse.service.impl.StockoutServiceImpl;

/**
 * 出库信息添加
 * 
 * @author ruancq
 *
 */
@WebServlet("/stockoutAdd")
public class StockoutAddAction extends HttpServlet {

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
		// 获取入库编号
		if ("getStockinid".equals(action)) {
			StockinService service = new StockinServiceImpl();
			List<Stockin> list1 = null;
			List<HashMap> list2 = new ArrayList<HashMap>();
			try {
				list1 = service.getStockinidList();
				HashMap json = null;
				for (Stockin stockin : list1) {
					json = new HashMap();
					json.put("stockin_id", stockin.getStockin_id());
					json.put("id", stockin.getStockin_guid());
					list2.add(json);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.getWriter().write(JSONObject.toJSONString(list2));
		}

		// 出库信息添加
		if ("add".equals(action)) {
			String submitData = req.getParameter("submitData");
			Stockout stockout = JSON.parseObject(submitData, Stockout.class);
			StockoutService service = new StockoutServiceImpl();
			try {
				String stockinguid = stockout.getStockin_guid();
				StockinService stockinService = new StockinServiceImpl();
				int stockin_num = stockinService.getStockinNum(stockinguid);
				int num = (int)stockout.getStockout_num();
				if (num > stockin_num) {
					resp.getWriter().write("库存数量不够");
				}else if(num <= stockin_num){
					int i = service.stockoutAdd(stockout);
					if (i > 0) {
						resp.getWriter().write("出库成功");
					} else {
						resp.getWriter().write("出库失败");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
