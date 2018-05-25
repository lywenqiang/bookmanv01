package cn.edu.nyist.bookmanv01.dao;

import java.util.Date;

public interface BookDao {

	int save(String name, String descri, double price, String author, int tid, String newFileName, Date pubDate);

}
