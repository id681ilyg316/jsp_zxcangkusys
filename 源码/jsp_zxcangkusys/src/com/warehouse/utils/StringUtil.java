package com.warehouse.utils;

/**
 * 字符串处理类
 * @author admin
 *
 */
public class StringUtil {
	
	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isEmpty(int id) {
		if(!"".equals(id)&&id==0) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 判断不是空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean isNotEmpty(int id) {
		if(!"".equals(id)&&id==0) {
			return true;
		}else {
			return false;
		}
	}
}
