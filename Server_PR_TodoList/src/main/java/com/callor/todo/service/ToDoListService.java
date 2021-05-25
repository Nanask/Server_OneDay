package com.callor.todo.service;

import java.util.List;

import com.callor.todo.model.ToDoListVO;

public interface ToDoListService {
	
	public List<ToDoListVO> selectAll();
	public ToDoListVO findById(Long td_seq);
	public List<ToDoListVO> findByDate(String td_date);
	
	public Integer insert(ToDoListVO tdVO);
	public Integer update(ToDoListVO tdVO);
	public Integer delete(Long seq);

}
