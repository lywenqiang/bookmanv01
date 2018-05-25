package cn.edu.nyist.bookmanv01.biz.impl;

import cn.edu.nyist.bookmanv01.biz.BookBiz;
import cn.edu.nyist.bookmanv01.dao.BookDao;
import cn.edu.nyist.bookmanv01.dao.impl.BookDaoJdbcImpl;
import cn.edu.nyist.bookmanv01.vo.BookVo;

public class BookBiZImpl implements BookBiz {

	@Override
	public int savaBook(BookVo bookVo) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(bookVo);
	}

}
