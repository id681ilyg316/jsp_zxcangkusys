package com.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.warehouse.dao.AdminDao;
import com.warehouse.dao.impl.AdminDaoImpl;
import com.warehouse.model.Admin;
import com.warehouse.service.AdminService;
import com.warehouse.utils.UUIDUtils;

public class AdminServiceImpl implements AdminService{

	AdminDao dao = new AdminDaoImpl();
	/**
	 * 管理员登录
	 */
	public Admin login(String admin_username, String admin_pwd) throws Exception {
		return dao.login(admin_username, admin_pwd);
	}

	/**
	 * 添加管理员信息
	 */
	public int adminAdd(Admin admin) throws Exception{
		admin.setAdmin_guid(UUIDUtils.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		admin.setAdmin_date(date);
		return dao.adminAdd(admin);
	}

	/**
	 * 遍历管理员信息
	 */
	public List<Admin> adminList(int pageIndex, int pageSize, String adminUsername, String adminName) throws Exception {
		return dao.adminList(pageIndex,pageSize,adminUsername,adminName);
	}

	/**
	 * 查询管理员总记录数
	 */
	public int queryCount(String adminUsername, String adminName) throws Exception {
		return dao.queryCount(adminUsername, adminName);
	}

	/**
	 * 验证用户名是否存在
	 */
	public Boolean isExistUsername(String admin_username) throws Exception {
		return dao.isExistUsername(admin_username);
	}

	/**
	 * 遍历删除的管理员信息
	 */
	public List<Admin> adminDelList(int pageIndex, int pageSize, String adminUsername, String adminName)
			throws Exception {
		return dao.adminDelList(pageIndex,pageSize,adminUsername,adminName);
	}

	/**
	 * 查询删除的管理员总记录数
	 */
	public int queryDelCount(String adminUsername, String adminName) throws Exception {
		return dao.queryDelCount(adminUsername, adminName);
	}

	/**
	 * 管理员信息删除
	 */
	public int adminDelete(String admin_guid) throws Exception {
		return dao.adminDelete(admin_guid);
	}

	/**
	 * 根据管理员guid获取管理员信息
	 */
	public Admin queryByAdminGuid(String admin_guid) throws Exception {
		return dao.queryByAdminGuid(admin_guid);
	}

	/**
	 * 更新管理员信息
	 */
	public int adminUpdate(Admin admin) throws Exception {
		return dao.adminUpdate(admin);
	}

	/**
	 * 管理员信息还原
	 */
	public int adminRollback(String admin_guid) throws Exception {
		return dao.adminRollback(admin_guid);
	}

}
