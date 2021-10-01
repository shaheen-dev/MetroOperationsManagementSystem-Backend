package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trip")
public class Trip extends BaseEntity {

	@Column(nullable = false, name = "route_id")
	private int routeId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Train train;
	
	private String start;
	
	private String end;
}
