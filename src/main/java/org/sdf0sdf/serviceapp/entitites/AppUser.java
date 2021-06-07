package org.sdf0sdf.serviceapp.entitites;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Length(max = 10)
	private String username;

	@NotNull
	@Length(max = 10)
	private String password;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "service_center_id", foreignKey = @ForeignKey(name = "fk1_users"))
	private ServiceCenter servicecenter;
	
	/**
	 * 1 - admin rights
	 * 2 - user rights
	 */
	@NotNull
	@Check(constraints = "role in (1, 2)")
	private int role;
	
	public AppUser() {}

	public AppUser(int id, @NotNull @Length(max = 10) String username, @NotNull @Length(max = 10) String password,
			@NotNull ServiceCenter servicecenter, @NotNull int role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.servicecenter = servicecenter;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ServiceCenter getServicecenter() {
		return servicecenter;
	}

	public void setServicecenter(ServiceCenter servicecenter) {
		this.servicecenter = servicecenter;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", servicecenter="
				+ servicecenter + ", role=" + role + "]";
	}
	  
}
