package com.tka.OrganizationSystem.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name ="eid")
//	List<Employee> list;
//	
//	public Country() {
//		
//	}
	
	public Country(String cname) {
		super();
		this.cname = cname;
	}
	
//	public int getCid() {
//		return cid;
//	}
//	public void setCid(int cid) {
//		this.cid = cid;
//	}
//	public String getCname() {
//		return cname;
//	}
//	public void setCname(String cname) {
//		this.cname = cname;
//	}
//	
//	@Override
//	public String toString() {
//		return "Country [cid=" + cid + ", cname=" + cname + "]";
//	}
	
	
}
