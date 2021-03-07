package com.tkb.tkbeat.front.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
	
	@Column(insertable = false,name="status")
	private String status;
	
	@Column(insertable = false,name="create_by")
	private String create_by;
	
	@Column(insertable = false,name="update_by")
	private String update_by;
	
	@Column(insertable = false,name="create_time")
	private String create_time;
	
	@Column(insertable = false,name="update_time")
	private String update_time;

}
