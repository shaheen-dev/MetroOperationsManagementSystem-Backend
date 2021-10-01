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
@Table(name = "fair")
public class Fair extends BaseEntity {

	@Column(nullable = false,name="src")
	private int source;
	
	@Column(nullable = false,name="dst")
	private int destination;
	
	@Column(nullable = false)
	private int amount;
	
	@Column(nullable = false,name="dist")
	private int distance;
}
