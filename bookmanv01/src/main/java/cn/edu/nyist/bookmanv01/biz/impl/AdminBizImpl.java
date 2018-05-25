package cn.edu.nyist.bookmanv01.biz.impl;

import cn.edu.nyist.bookmanv01.biz.AdminBiz;
import cn.edu.nyist.bookmanv01.dao.AdminDao;
import cn.edu.nyist.bookmanv01.dao.impl.AdminDaoImpl;

public class AdminBizImpl implements AdminBiz {

	@Override
	public boolean adminBook(String name, String pwd) {
		AdminDao adminDao=new AdminDaoImpl();
		return adminDao.admin(name,pwd);
	}

}
