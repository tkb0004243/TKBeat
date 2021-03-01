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
	private String createby;
	
	@Column(name="update_by")
	private String updateby;
	
	@Column(name="create_time")
	private String createtime;
	
	@Column(name="update_time")
	private String updatetime;

}
