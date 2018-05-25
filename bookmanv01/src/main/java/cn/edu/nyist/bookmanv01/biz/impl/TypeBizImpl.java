package cn.edu.nyist.bookmanv01.biz.impl;

import java.util.List;

import cn.edu.nyist.bookmanv01.biz.TypeBiz;
import cn.edu.nyist.bookmanv01.dao.TypeDao;
import cn.edu.nyist.bookmanv01.dao.impl.TypeDaoJdbcImpl;
import cn.edu.nyist.bookmanv01.vo.TypeVo;

public class TypeBizImpl implements TypeBiz {

	@Override
	public List<TypeVo> findAllTypes() {
		TypeDao typeDao=new TypeDaoJdbcImpl();
		return typeDao.findAll();
	}

}
