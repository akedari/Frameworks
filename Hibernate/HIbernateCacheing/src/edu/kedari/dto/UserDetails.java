package edu.kedari.dto;


import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQuery(name="UserDetails.byId", query="from UserDetails where userId > ?")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from User_Details where userName= ?",resultClass = UserDetails.class)
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	//@Transient	if we do not want column in table
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
