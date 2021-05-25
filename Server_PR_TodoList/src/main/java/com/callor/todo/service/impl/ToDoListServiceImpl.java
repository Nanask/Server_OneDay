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
		sql += " ORDER BY td_seq ";
		
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
			pStr.setString(1, td_date);
			List<ToDoListVO> tdList = this.select(pStr);
			pStr.close();
			return tdList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Integer insert(ToDoListVO tdVO) {
		// TODO 추가하기
		String sql = " INSERT INTO tbl_ToDoList ";
		sql += "(td_seq, td_date, td_time, td_writer, td_place)";
		sql += " VALUES(seq_TODOLIST.NEXTVAL, ?, ?, ?, ? ) ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_writer());
			pStr.setString(4, tdVO.getTd_place());
			
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Integer update(ToDoListVO tdVO) {
		// TODO 수정
		
		String sql = " UPDATE tbl_ToDoList SET ";
		sql += " td_date = ?, ";
		sql += " td_time = ?, ";
		sql += " td_writer = ?, ";
		sql += " td_place = ? ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, tdVO.getTd_date());
			pStr.setString(2, tdVO.getTd_time());
			pStr.setString(3, tdVO.getTd_writer());
			pStr.setString(4, tdVO.getTd_place());
			pStr.setLong(5, tdVO.getTd_seq());
			
			
			return pStr.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public Integer delete(Long seq) {
		// TODO 데이터 삭제
		
		String sql = " DELETE FROM tbl_ToDoList ";
		sql += " WHERE td_seq = ? ";
		
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setLong(1, seq);
		
			return pStr.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
