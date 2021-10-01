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
@Table(name = "route_details")
public class RouteDetails extends BaseEntity {

	
	@Column(nullable = false,name="route_id")
	private int routeId;
	@Column(nullable = false,name="station_id")
	private int stationId;
	@Column(nullable = false,name="s_order_num")
	private int orderNum;
	
	
	/*
	 * @ManyToOne private Route[] route;
	 * 
	 * @ManyToOne private List<Station> station;
	 */
}
