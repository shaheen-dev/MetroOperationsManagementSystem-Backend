package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reply")
public class Reply extends BaseEntity {

	@Column(name="complaint_id",nullable = false)
	private int complaintId;
	
	@Column(length = 200,nullable = false)
	private String msg;
	
	@Column(name="admin_id",nullable = false)
	private int adminId;
	
}
