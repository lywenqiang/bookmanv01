package cn.edu.nyist.bookmanv01.dao;

import cn.edu.nyist.bookmanv01.vo.BookVo;

public interface BookDao {

	//int save(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);
	int save(BookVo bookVo);
}
