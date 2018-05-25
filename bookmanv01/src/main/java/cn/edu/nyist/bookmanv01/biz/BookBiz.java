package cn.edu.nyist.bookmanv01.biz;

import java.util.Date;

public interface BookBiz {

	int savaBook(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);

}
