package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.config.DBInfo;
import com.callor.todo.model.ToDoListVO;
import com.callor.todo.service.ToDoListService;
import com.callor.todo.service.impl.ToDoListServiceImpl;

@WebServlet("/todo/*")
public class TodoController extends HttpServlet{
	protected ToDoListService tdService;
	
	public TodoController() {
		tdService = new ToDoListServiceImpl();
	}
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		
		if(subPath.equals("/view")) {
			
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			ToDoListVO tdVO = tdService.findById(td_seq);
			req.setAttribute("TD", tdVO);
			
			ReqController.forward(req, resp, "view");
			
		}else if(subPath.equals("/wirte")) {
			
			
		}
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String subPath = req.getPathInfo();
		
		String td_date = req.getParameter(DBInfo.td_date);
		String td_time = req.getParameter(DBInfo.td_time);
		String td_writer = req.getParameter(DBInfo.td_writer);
		String td_place = req.getParameter(DBInfo.td_place);
		
		ToDoListVO tdVO = new ToDoListVO();
		
		tdVO.setTd_date(td_date);
		tdVO.setTd_time(td_time);
		tdVO.setTd_writer(td_writer);
		tdVO.setTd_place(td_place);
	}
	
	

}
