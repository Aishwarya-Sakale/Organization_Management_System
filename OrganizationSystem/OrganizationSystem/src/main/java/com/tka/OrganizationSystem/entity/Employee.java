package com.tka.OrganizationSystem.entity;

import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String phoneno;
	String department;  //data=> developer,testing,hr,marketing,sales
	String status;   //data=> active,inactive,suspend
	
	@Temporal(TemporalType.TIMESTAMP)
	Date createddtm;
	String createdby;
	@Temporal(TemporalType.TIMESTAMP)
	Date updateddtm;
	String updatedby;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cid")
	Country country;

}
