package cn.edu.nyist.bookmanv01.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.nyist.bookmanv01.biz.AdminBiz;
import cn.edu.nyist.bookmanv01.biz.impl.AdminBizImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1、获取用户输入
				String name=request.getParameter("name");
				String pwd=request.getParameter("pwd");
				//要先判断验证码是否正确，正确在去数据库查询，不正常就不查询，防止DDOS攻击
				String vcode=request.getParameter("vcode");
				HttpSession session = request.getSession();  
				String serverVcode=(String) session.getAttribute("validateCode");
				if (!serverVcode.equalsIgnoreCase(vcode)) {//验证码不区分大小写
					request.setAttribute("msg", "验证码错误");
					request.setAttribute("name", name);
					request.getRequestDispatcher("login.jsp").forward(request, response);
					return ;
				}
				AdminBiz adminBiz=new AdminBizImpl();
				boolean rets=adminBiz.adminBook(name,pwd);
				/*//2、到数据库查询
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
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					DsUtil.free(rs, stmt, conn);
				}*/
				//3、根据查询返回结果
				if (rets) {
					request.getSession().setAttribute("loginSession", "1");
					response.sendRedirect("main.jsp");
				}else {
					request.setAttribute("msg", "用户名或密码错误");
					request.setAttribute("name", name);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
	}


