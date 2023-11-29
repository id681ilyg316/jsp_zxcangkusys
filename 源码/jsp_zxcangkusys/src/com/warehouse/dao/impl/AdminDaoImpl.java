package com.warehouse.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.warehouse.dao.AdminDao;
import com.warehouse.model.Admin;
import com.warehouse.utils.DataSourceUtils;
import com.warehouse.utils.StringUtil;

/**
 * 管理员信息持久层
 * 
 * @author admin
 *
 */
public class AdminDaoImpl implements AdminDao {

	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());

	/**
	 * 管理员登录
	 */
	public Admin login(String admin_username, String admin_pwd) throws Exception {
		String sql = "select * from tb_admin where admin_username=? and admin_pwd=? limit 1";
		return qr.query(sql, new BeanHandler<>(Admin.class), admin_username, admin_pwd);
	}

	/**
	 * 管理员添加
	 */
	public int adminAdd(Admin admin) throws Exception {
		String sql = "insert into tb_admin (admin_guid,admin_name,admin_username,admin_pwd,admin_phone,admin_cardid,admin_date,admin_del,admin_sex,admin_authority) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		return qr.update(sql, admin.getAdmin_guid(), admin.getAdmin_name(), admin.getAdmin_username(),
				admin.getAdmin_pwd(), admin.getAdmin_phone(), admin.getAdmin_cardid(), admin.getAdmin_date(),
				admin.getAdmin_del(), admin.getAdmin_sex(), admin.getAdmin_authority());
	}

	/**
	 * 遍历管理员信息
	 */
	public List<Admin> adminList(int pageIndex, int pageSize, String adminUsername, String adminName) throws Exception {
		String sql = "select * from tb_admin where admin_del=0";
		if (StringUtil.isNotEmpty(adminUsername)) {
			sql += " and admin_username like '%" + adminUsername + "%'";
		}
		if (StringUtil.isNotEmpty(adminName)) {
			sql += " and admin_name like '%" + adminName + "%'";
		}
		sql += " limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Admin.class), pageIndex * pageSize, pageSize);
	}

	/**
	 * 查询管理员总记录数
	 */
	public int queryCount(String adminUsername, String adminName) throws Exception {
		String sql = "select count(*) from tb_admin where admin_del=0";
		if (StringUtil.isNotEmpty(adminUsername)) {
			sql += " and admin_username like '%" + adminUsername + "%'";
		}
		if (StringUtil.isNotEmpty(adminName)) {
			sql += " and admin_name like '%" + adminName + "%'";
		}
		return ((Long) qr.query(sql, new ScalarHandler<>())).intValue();
	}

	/**
	 * 验证用户名是否存在
	 */
	public Boolean isExistUsername(String admin_username) throws Exception {
		String sql = "select count(*) from tb_admin where admin_username=?";
		int i = ((Long) qr.query(sql, new ScalarHandler<>(), admin_username)).intValue();
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 遍历删除的管理员信息
	 */
	public List<Admin> adminDelList(int pageIndex, int pageSize, String adminUsername, String adminName)
			throws Exception {
		String sql = "select * from tb_admin where admin_del=1";
		if (StringUtil.isNotEmpty(adminUsername)) {
			sql += " and admin_username like '%" + adminUsername + "%'";
		}
		if (StringUtil.isNotEmpty(adminName)) {
			sql += " and admin_name like '%" + adminName + "%'";
		}
		sql += " limit ?,?";
		return qr.query(sql, new BeanListHandler<>(Admin.class), pageIndex * pageSize, pageSize);
	}

	/**
	 * 查询删除的管理员总记录数
	 */
	public int queryDelCount(String adminUsername, String adminName) throws Exception {
		String sql = "select count(*) from tb_admin where admin_del=1";
		if (StringUtil.isNotEmpty(adminUsername)) {
			sql += " and admin_username like '%" + adminUsername + "%'";
		}
		if (StringUtil.isNotEmpty(adminName)) {
			sql += " and admin_name like '%" + adminName + "%'";
		}
		return ((Long) qr.query(sql, new ScalarHandler<>())).intValue();
	}

	/**
	 * 管理员信息删除
	 */
	public int adminDelete(String admin_guid) throws Exception {
		int i = 0;
		String[] strs = admin_guid.split(",");
		for (int a = 0; a < strs.length; a++) {
			String sql = "update tb_admin set admin_del=1 where admin_guid ='" + strs[a] + "'";
			i = qr.update(sql);
		}
		return i;
	}

	/**
	 * 根据管理员guid获取管理员信息
	 */
	public Admin queryByAdminGuid(String admin_guid) throws Exception {
		String sql = "select * from tb_admin where admin_guid=?";
		return qr.query(sql, new BeanHandler<>(Admin.class), admin_guid);
	}

	/**
	 * 更新管理员信息
	 */
	public int adminUpdate(Admin admin) throws Exception {
		String sql = "update tb_admin set admin_username=?,admin_name=?,admin_sex=?,admin_cardid=?,admin_phone=? where admin_guid=?";
		return qr.update(sql, admin.getAdmin_username(), admin.getAdmin_name(), admin.getAdmin_sex(),
				admin.getAdmin_cardid(), admin.getAdmin_phone(), admin.getAdmin_guid());
	}

	/**
	 * 管理员信息还原
	 */
	public int adminRollback(String admin_guid) throws Exception {
		String sql = "update tb_admin set admin_del=0 where admin_guid =?";
		return qr.update(sql, admin_guid);
	}

}
