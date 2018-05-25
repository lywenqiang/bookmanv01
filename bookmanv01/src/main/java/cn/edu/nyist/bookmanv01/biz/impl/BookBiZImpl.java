package cn.edu.nyist.bookmanv01.biz.impl;

import java.util.Date;

import cn.edu.nyist.bookmanv01.biz.BookBiz;
import cn.edu.nyist.bookmanv01.dao.BookDao;
import cn.edu.nyist.bookmanv01.dao.impl.BookDaoJdbcImpl;

public class BookBiZImpl implements BookBiz {

	@Override
	public int savaBook(String name, String descri, double price, String author, int tid, String newFileName,Date pubDate) {
		BookDao bookDao=new BookDaoJdbcImpl();
		return bookDao.save(name,descri,price,author,tid,newFileName,pubDate);
	}

}
