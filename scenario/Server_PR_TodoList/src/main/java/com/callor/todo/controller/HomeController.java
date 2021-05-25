package com.callor.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.callor.todo.model.ToDoListVO;
import com.callor.todo.service.ToDoListService;
import com.callor.todo.service.impl.ToDoListServiceImpl;

@WebServlet("/")
public class HomeController extends HttpServlet{
	protected ToDoListService tdService;
	
	public HomeController() {
		tdService = new ToDoListServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ToDoListVO> tdList = null;
		tdList = tdService.selectAll();
		req.setAttribute("LIST", tdList);
//		ReqController.forward(req, resp, "/home");
		
		ToDoListVO tdVO = new ToDoListVO();
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); // 날짜
		SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss"); // 시간
		
		Date date = new Date(System.currentTimeMillis());
		
		tdVO.setTd_seq(0L);
		tdVO.setTd_date(sd.format(date));
		tdVO.setTd_time(st.format(date));
		
		req.setAttribute("TD", tdVO);
		
		ReqController.forward(req, resp, "home");
	}
	
	
	
	
	

}
