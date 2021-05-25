package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ToDoListVO {
	
	private Long td_seq; //	NUMBER
	private String td_date; //	VARCHAR2(10)
	private String td_time; //	VARCHAR2(10)
	private String td_writer; //	nVARCHAR2(250)
	private String td_place; //	nVARCHAR2(50)


}
