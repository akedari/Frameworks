package edu.kedari.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	//@Transient	if we do not want column in table
	private String userName;
	
	@Temporal(TemporalType.DATE)	//saves in date not time
	private Date joinedDate;
	
	@AttributeOverrides({
		
	@AttributeOverride (name = "street",
						 column = @Column(name="HOME_STREET_NAME")),
	@AttributeOverride (name = "city",
						column = @Column(name="HOME_CITY_NAME")),
	@AttributeOverride (name = "state",
	 					column = @Column(name="HOME_STATE_NAME")),
	@AttributeOverride (name = "pincode",
	 					column = @Column(name="HOME_PINCODE"))
	})
	private Address homeAddress;
	
	private Address officeAddress;
	
//	@Lob	large object - for large file or description
	private String description;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_COLLEGES",
				joinColumns=@JoinColumn(name = "USER_ID")
			)
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column (name="College_ID")}, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<College> listOfCollege = new ArrayList();
	
	
	@OneToMany(cascade=CascadeType.PERSIST)
	@JoinColumn(name="VEHICLE_ID")
	private Collection<Vehicle> vehicle = new ArrayList<>();;
	
	

	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	public Collection<College> getListOfCollege() {
		return listOfCollege;
	}
	public void setListOfCollege(Collection<College> listOfCollege) {
		this.listOfCollege = listOfCollege;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
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
