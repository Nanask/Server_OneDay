package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.ToDoListVO;

public interface ToDoListService {
	
	public List<ToDoListVO> selectAll();
	public ToDoListVO findById(Long td_seq);
	public List<ToDoListVO> findByDate(String td_date);
	
	public void insert();
	public void update();
	public void delete();

}
