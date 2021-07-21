package com.fa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fa.dto.CoronaDTO;
import com.fa.service.CoronaSerivesImpl;
import com.fa.service.CoronaServices;
import com.fa.vo.CoronaVO;


@WebServlet("/controller")
public class ServletMailController extends HttpServlet {
	private CoronaServices service;
    
	public void init() throws ServletException {
		service =new CoronaSerivesImpl();
	}

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CoronaVO vo=null;
		CoronaDTO dto=null;
		PrintWriter pw=null;
		String result=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		vo=new CoronaVO();
		vo.setPname(req.getParameter("name"));
		vo.setPage(req.getParameter("page"));
		vo.setAddrs(req.getParameter("addrs"));
		vo.setMobile(req.getParameter("mobile"));
		vo.setGender(req.getParameter("gender"));
		//convert Vo to DTO
		dto=new CoronaDTO();
		dto.setPname(vo.getPname());
		dto.setPage(Integer.parseInt(vo.getPage()));
		dto.setMobile(Long.parseLong(vo.getMobile()));
		dto.setAddrs(vo.getAddrs());
		dto.setGender(vo.getGender());
		try {
			result=service.register(dto);
			pw.println("<h1 style='color:Green;text-align:center'>"+result+"</h1>");
		}
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<br><br> <h1 style='color:red;text-align:center'>Internal Problem</h1>");
		}
		pw.println("<br><br> <a href='Corona_registration.html'>Home</a>");
		pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
