package com.fa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.fa.bo.CoronaBO;

public class CoronaDAOImpl implements CoronaDAO {
	private static final String DS_JNDI_NAME="java:/comp/env/DsJndi";
	private static final String INSERT_QUERY="INSERT INTO CORONA_REGISTRATION VALUES (SNO_SEQ2.NEXTVAL,?,?,?,?,?)";
	private static final String SELECT_QUERY="SELECT * FROM CORONA_REGISTRATION WHERE PNAME=?";
	@Override
	public int insert(CoronaBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count = 0;
		con=jdbcpooledConnection(DS_JNDI_NAME);
		ps=con.prepareStatement(INSERT_QUERY);
		ps.setString(1, bo.getPname());
		ps.setInt(2, bo.getAge());
		ps.setLong(3, bo.getMobile());
		ps.setString(4, bo.getAddrs());
		ps.setString(5, bo.getGender());
		count=ps.executeUpdate();
		return count;
	}
	private Connection jdbcpooledConnection(String jndi) throws Exception{
		Connection con=null;
		InitialContext ic=null;
		DataSource ds=null;
		ic=new InitialContext();
		ds=(DataSource) ic.lookup(jndi);
		con=ds.getConnection();
		return con;
	}
	@Override
	public ResultSet select(CoronaBO bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		con=jdbcpooledConnection(DS_JNDI_NAME);
		ps=con.prepareStatement(SELECT_QUERY);
		ps.setString(1, bo.getPname());
		return null;
	}
}
