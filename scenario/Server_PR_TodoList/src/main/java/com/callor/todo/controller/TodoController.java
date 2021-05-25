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
		
		if(subPath.equals("/search")) {
			ReqController.forward(req, resp, "search");
			System.out.println("subPath:" + subPath);
			
		}else if(subPath.equals("/view")) {	
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			ToDoListVO tdVO = tdService.findById(td_seq);
			req.setAttribute("TD", tdVO);
			
			ReqController.forward(req, resp, "view");
			
		}else if(subPath.equals("/insert")) {
			
			ToDoListVO tdVO = new ToDoListVO();
			
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd"); // 날짜
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss"); // 시간
			
			Date date = new Date(System.currentTimeMillis());
			
			tdVO.setTd_seq(0L);
			tdVO.setTd_date(sd.format(date));
			tdVO.setTd_time(st.format(date));
			
			req.setAttribute("TD", tdVO);
			
			ReqController.forward(req, resp, "insert");
			
			
		}else if(subPath.equals("/update")) {
			
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			
			ToDoListVO tdVO = tdService.findById(td_seq);
			
			req.setAttribute("TD", tdVO);
			ReqController.forward(req, resp, "insert");
					
		}else if(subPath.equals("/delete")) {
			
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
			tdService.delete(td_seq);
			resp.sendRedirect("/todo");
			
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
		
//		System.out.println(td_date);
		
		ToDoListVO tdVO = new ToDoListVO();
		
		tdVO.setTd_date(td_date);
		tdVO.setTd_time(td_time);
		tdVO.setTd_writer(td_writer);
		tdVO.setTd_place(td_place);
		
		if(subPath.equals("/search")) {
			
			String strDate = req.getParameter("td_date");
			List<ToDoListVO> tdList = tdService.findByDate(strDate);
			req.setAttribute("TDLIST", tdList);
//			System.out.println(subPath);
			ReqController.forward(req, resp, "search");
			
		}else if(subPath.equals("/update")) {
			
			String strSeq = req.getParameter("td_seq");
			Long td_seq = Long.valueOf(strSeq);
//			System.out.println(tdVO.toString());
			tdVO.setTd_seq(td_seq);
			tdService.update(tdVO);
			resp.sendRedirect("/todo/");
			
		}else if(subPath.equals("/insert")) {
			
			tdService.insert(tdVO);
			System.out.println(tdVO);
			resp.sendRedirect("/todo/");
		}
		
		
		
	}
	
	

}
