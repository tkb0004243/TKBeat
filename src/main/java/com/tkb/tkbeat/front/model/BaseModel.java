package com.tkb.tkbeat.front.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
	
	@Column(name="status")
	private String status;
	
	@Column(name="create_by")
	private String create_by;
	
	@Column(name="update_by")
	private String update_by;
	
	@Column(name="create_time")
	private String create_time;
	
	@Column(name="update_time")
	private String update_time;

}
