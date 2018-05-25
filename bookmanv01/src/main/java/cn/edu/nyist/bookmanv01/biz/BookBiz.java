package cn.edu.nyist.bookmanv01.biz;

import cn.edu.nyist.bookmanv01.vo.BookVo;

public interface BookBiz {

	//int savaBook(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);
	

	int savaBook(BookVo bookVo);
}
