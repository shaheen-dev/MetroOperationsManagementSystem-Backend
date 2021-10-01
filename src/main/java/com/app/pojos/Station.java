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
@Table(name = "station")
public class Station extends BaseEntity {

	@Column(length = 30,nullable = false, name = "s_name")
	private String name;
	
	@Column(nullable = false)
	private double latitude;
	
	@Column(nullable = false)
	private double longitude;
	
	
}
