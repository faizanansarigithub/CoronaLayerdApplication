package com.fa.service;

import com.fa.bo.CoronaBO;
import com.fa.dao.CoronaDAO;
import com.fa.dao.CoronaDAOImpl;
import com.fa.dto.CoronaDTO;

public class CoronaSerivesImpl implements CoronaServices {
	private CoronaDAO dao;
	public CoronaSerivesImpl() {
		dao=new CoronaDAOImpl();
	}

	@Override
	public String register(CoronaDTO dto) throws Exception {
		CoronaBO bo=null;
		int count=0;
		String result=null;
		bo=new CoronaBO();
		bo.setPname(dto.getPname());
		bo.setAddrs(dto.getAddrs());
		bo.setAge(dto.getPage());
		bo.setGender(dto.getGender());
		bo.setMobile(dto.getMobile());
		
		count=dao.insert(bo);
		if(count==0)
			result="OOPs Registration is FAILED";
		else
			result="Registration is Seccessfull";
		return result;
	}

}
