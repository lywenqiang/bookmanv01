package cn.edu.nyist.bookmanv01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.nyist.bookmanv01.dao.AdminDao;
import cn.edu.nyist.bookmanv01.util.DsUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean admin(String name, String pwd) {
		//2、到数据库查询
		Connection conn=null;
		//1、将这里换成statement的一个子接口
		PreparedStatement stmt=null;//预编译，能执行动态SQL，提高效率
		ResultSet rs=null;
		boolean ret=false;
		try {
			conn=DsUtil.getConn();
			//2、将SQL语句换成用占位符的写法，不能再用拼接字符串写法
			String sql="select * from t_admin where name=? and pwd=?";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, pwd);
			//3、因为使用了占位符的写法，所以这里不能在传入SQL语句
			rs=stmt.executeQuery();
			if (rs.next()) {
				ret=true;
				return ret;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DsUtil.free(rs, stmt, conn);
		}
		return ret;
	}

}
