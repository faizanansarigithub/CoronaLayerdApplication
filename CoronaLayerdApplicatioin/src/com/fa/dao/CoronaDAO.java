package com.fa.dao;

import java.sql.ResultSet;

import com.fa.bo.CoronaBO;

public interface CoronaDAO {
	public int insert(CoronaBO bo)throws Exception;
	public ResultSet select(CoronaBO bo)throws Exception;
}
