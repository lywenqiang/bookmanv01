package cn.edu.nyist.bookmanv01.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.edu.nyist.bookmanv01.biz.BookBiz;
import cn.edu.nyist.bookmanv01.biz.impl.BookBiZImpl;
import cn.edu.nyist.bookmanv01.util.MyBeanUtils;
import cn.edu.nyist.bookmanv01.vo.BookVo;

@WebServlet("/bookAdd")
@MultipartConfig
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookAddServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 权限拦截
		/*
		 * if (request.getSession().getAttribute("loginSession")==null||!(request.
		 * getSession().getAttribute("loginSession").equals("1"))) {
		 * //getAttribute没有对象的时候会返回个空，==null放在前面是为了防止
		 * response.sendRedirect("login.jsp"); return; }
		 */
		request.setCharacterEncoding("utf-8");// 解决中文乱码问题
		Part part = request.getPart("photo");
		// 获取到文件名
		String fileName = part.getHeader("Content-Disposition").split(";")[2].split("=")[1].replace("\"", "");
		// 解决IE下错误问题（全限文件名）
		fileName = fileName.lastIndexOf("\\") == -1 ? fileName : fileName.substring(fileName.lastIndexOf("\\") + 1);
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		String newFileName = UUID.randomUUID().toString() + "." + ext;
		part.write(request.getServletContext().getRealPath("upload/" + newFileName));
		// 获取参数
		/*String name = request.getParameter("name");
		String descri = request.getParameter("descri");
		String strPrice = request.getParameter("price");
		double price = Double.parseDouble(strPrice);
		String author = request.getParameter("author");
		String strTid = request.getParameter("tid");
		int tid = Integer.parseInt(strTid);
		String strPubDate=request.getParameter("pubDate");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date pubDate=null;
		try {
			System.out.println(strPubDate);
			System.out.println(pubDate);
				pubDate=sdf.parse(strPubDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		BookVo bookVo=new BookVo();
		/*try {
			BeanUtils.populate(bookVo, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		MyBeanUtils.populate(bookVo, request.getParameterMap(), "yyyy-MM-dd");
		bookVo.setPhoto(newFileName);
		// 调用业务层保存
		BookBiz bookBiz = new BookBiZImpl();
		// 返回受影响的行数
		//int ret = bookBiz.savaBook(name, descri, price, author, tid, newFileName,pubDate);
		int ret = bookBiz.savaBook(bookVo);
		// 给出响应
		response.setContentType("text/html;charset=utf-8");
		if (ret > 0) {
			System.out.println(ret);
			response.getWriter().write("添加成功");
			//request.getRequestDispatcher("main.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "添加失败");
			request.getRequestDispatcher("bookAdd.jsp").forward(request, response);
		}
	}

}
