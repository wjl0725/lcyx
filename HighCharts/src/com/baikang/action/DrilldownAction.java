//package com.baikang.action;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//
//import com.baikang.dao.DrillldownDao;
//import com.baikang.entity.Drilldown;
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;
//
//@Controller
//@Scope("prototype")
//@SuppressWarnings("serial")
//public class DrilldownAction extends ActionSupport implements
//		ModelDriven<Drilldown> {
//	private Drilldown drilldown;
//
//	private JSONObject result;
//	@Resource
//	private DrillldownDao drillldownDao;
//
//	public String getAll() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		Map<String, Object> datamap = new HashMap<String, Object>();
//
//		List<Object> datamaps = new ArrayList<Object>();
//		List<Object> maps = new ArrayList<Object>();
//		List<String> yearMonthList = drillldownDao.getYearAndMonth();
//		if (yearMonthList != null) {
//			for (int i = 0; i < yearMonthList.size(); i++) {
//				List<Object> lists = new ArrayList<Object>();
//				List<Drilldown> drilldowns = drillldownDao
//						.getDrilldown(yearMonthList.get(i));
//				double total = 0;
//				for (Drilldown drilldown : drilldowns) {
//					List<Object> list = new ArrayList<Object>();
//					total += Double.parseDouble(drilldown.getMoney());
//					list.add(drilldown.getPurposeName());
//					list.add(Double.valueOf(drilldown.getMoney()));
//					lists.add(JSONArray.fromObject(list));
//				}
//				map.put("name", yearMonthList.get(i));
//				map.put("y", total);
//				map.put("drilldown", yearMonthList.get(i));
//
//				datamap.put("name", yearMonthList.get(i));
//				datamap.put("id", yearMonthList.get(i));
//				datamap.put("data", JSONArray.fromObject(lists));
//				datamaps.add(JSONObject.fromObject(datamap));
//				maps.add(JSONObject.fromObject(map));
//			}
//		}
//		result = new JSONObject();
//
//		result.put("maps", JSONArray.fromObject(maps));
//		result.put("datamaps", JSONArray.fromObject(datamaps));
//
//		return "json";
//	}
//
//	public Drilldown getModel() {
//		if (drilldown == null) {
//			drilldown = new Drilldown();
//		}
//		return drilldown;
//	}
//
//	public JSONObject getResult() {
//		return result;
//	}
//
//	public void setResult(JSONObject result) {
//		this.result = result;
//	}
//
//}
