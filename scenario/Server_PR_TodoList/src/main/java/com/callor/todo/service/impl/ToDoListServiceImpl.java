package com.callor.todo.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.callor.todo.config.DBInfo;
import com.callor.todo.config.OracleConnection;
import com.callor.todo.model.ToDoListVO;
import com.callor.todo.service.ToDoListService;

public class ToDoListServiceImpl implements ToDoListService {

	protected Connection dbConn;

	public ToDoListServiceImpl() {
		dbConn = OracleConnection.getDConnection();

	}

	protected List<ToDoListVO> select(PreparedStatement pStr) throws SQLException {

		List<ToDoListVO> tdList = new ArrayList<ToDoListVO>();
		
		ResultSet rSet = pStr.executeQuery();
		
		while(rSet.next()) {
			ToDoListVO tdVo = new ToDoListVO();
			
			tdVo.setTd_seq(rSet.getLong(DBInfo.td_seq));
			tdVo.setTd_date(rSet.getString(DBInfo.td_date));
			tdVo.setTd_time(rSet.getString(DBInfo.td_time));
			tdVo.setTd_writer(rSet.getString(DBInfo.td_writer));
			tdVo.setTd_place(rSet.getString(DBInfo.td_place));
			
			tdList.add(tdVo);
			System.out.println(tdList.toString());
			
		}
		System.out.println(tdList.toString());
		return tdList;

	}

	@Override
	public List<ToDoListVO> selectAll() {
		// TODO 전체정보 검색
		
		String sql = " SELECT * FROM tbl_ToDoList ";
		sql += " ORDER BY td_date DESC, td_time DESC ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<ToDoListVO> tdList = this.select(pStr);
			
			System.out.println(tdList.toString());
			pStr.close();
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ToDoListVO findById(Long td_seq) {
		// TODO seq로 검색하기
		
		String sql = " SELECT * FROM tbl_ToDoList ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, td_seq);
			
			List<ToDoListVO> tdList = this.select(pStr);
			pStr.close();
			
			if(tdList != null && tdList.size() > 0) {
				System.out.println(tdList.toString());
				return tdList.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ToDoListVO> findByDate(String td_date) {
		// TODO 날짜로 검색하기
		
		String sql = " SELECT * FROM tbl_ToDoList ";
		sql += " WHERE td_date = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<ToDoListVO> tdList = this.select(pStr);
			pStr.setString(1, td_date);
			pStr.close();
			return tdList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
