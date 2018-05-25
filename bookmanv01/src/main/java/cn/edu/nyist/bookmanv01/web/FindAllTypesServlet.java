package cn.edu.nyist.bookmanv01.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.nyist.bookmanv01.biz.TypeBiz;
import cn.edu.nyist.bookmanv01.biz.impl.TypeBizImpl;
import cn.edu.nyist.bookmanv01.vo.TypeVo;


@WebServlet("/findAllTypes")
public class FindAllTypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FindAllTypesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、获取参数
		//2、调用业务层
		TypeBiz typeBiz=new TypeBizImpl();
		List<TypeVo> ls=typeBiz.findAllTypes();
		//3、给用户个响应
		request.setAttribute("ls", ls);
		request.getRequestDispatcher("bookAdd.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
