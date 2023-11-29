package com.warehouse.service;

import java.util.List;

import com.warehouse.model.Admin;

public interface AdminService {

	Admin login(String admin_username, String admin_pwd)throws Exception;

	int adminAdd(Admin admin)throws Exception;

	List<Admin> adminList(int pageIndex, int pageSize, String adminUsername, String adminName)throws Exception;

	int queryCount(String adminUsername, String adminName)throws Exception;

	Boolean isExistUsername(String admin_username)throws Exception;

	List<Admin> adminDelList(int pageIndex, int pageSize, String adminUsername, String adminName)throws Exception;

	int queryDelCount(String adminUsername, String adminName)throws Exception;

	int adminDelete(String admin_guid)throws Exception;

	Admin queryByAdminGuid(String admin_guid)throws Exception;

	int adminUpdate(Admin admin)throws Exception;

	int adminRollback(String admin_guid)throws Exception;

}
