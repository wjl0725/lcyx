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
//import com.baikang.dao.TemperatureDao;
//import com.baikang.entity.Temperature;
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;
//
//@Controller
//@Scope("prototype")
//@SuppressWarnings("serial")
//public class TemperatureAction extends ActionSupport implements
//		ModelDriven<Temperature> {
//	@Resource
//	private TemperatureDao temperatureDao;
//	private Temperature temperature;
//	private JSONObject result;
//
//	public Temperature getModel() {
//		if (temperature == null) {
//			temperature = new Temperature();
//		}
//		return temperature;
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
//	public String getAll() {
//		List<Object> cityList = temperatureDao.findCity();
//		List<Object> monthList = temperatureDao.findMonth();
//		List<Object> list = new ArrayList<Object>();
//		List<Object> months = new ArrayList<Object>();
//		for (Object object : monthList) {
//			months.add(object + "月份");
//		}
//		for (Object city : cityList) {
//			Map<String, Object> maps = new HashMap<String, Object>();
//			List<Object> temperaturnList = new ArrayList<Object>();
//			for (Object month : monthList) {
//				Object temperature = temperatureDao
//						.findTemperature(Integer.parseInt(month.toString()),
//								city.toString()).get(0).getTemperature();
//				temperaturnList.add(temperature);
//			}
//			maps.put("name", city);
//			maps.put("data", JSONArray.fromObject(temperaturnList));
//			list.add(JSONObject.fromObject(maps));
//		}
//		result = new JSONObject();
//		result.put("list", JSONArray.fromObject(list));
//		result.put("month", JSONArray.fromObject(months));
//		return "json";
//	}
//
//	public String getTificationAll() {
//		List<Object> cityList = temperatureDao.findCity();
//		List<Object> monthList = temperatureDao.findMonth();
//		List<Object> list = new ArrayList<Object>();
//		List<Object> months = new ArrayList<Object>();
//		for (Object object : monthList) {
//			months.add(object + "月份");
//		}
//		for (Object city : cityList) {
//			Map<String, Object> maps = new HashMap<String, Object>();
//			List<Object> temperaturnList = new ArrayList<Object>();
//			for (Object month : monthList) {
//				Temperature temperature = temperatureDao.findTemperature(
//						Integer.parseInt(month.toString()), city.toString())
//						.get(0);
//				if (temperature.getSymbol() != null) {
//
//					Map<String, Object> symbolMaps = new HashMap<String, Object>();
//					Map<String, Object> symbolMap = new HashMap<String, Object>();
//					symbolMap.put("symbol", "url("+temperature.getSymbol()+")");
//					symbolMaps.put("marker", JSONObject.fromObject(symbolMap));
//					symbolMaps.put("y", temperature.getTemperature());
//					temperaturnList.add(JSONObject.fromObject(symbolMaps));
//				} else {
//					temperaturnList.add(temperature.getTemperature());
//				}
//			}
//			maps.put("name", city);
//			maps.put("data", JSONArray.fromObject(temperaturnList));
//			list.add(JSONObject.fromObject(maps));
//		}
//		result = new JSONObject();
//		result.put("list", JSONArray.fromObject(list));
//		result.put("month", JSONArray.fromObject(months));
//		return "json";
//	}
//}
