package org.sdf0sdf.serviceapp.entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "claim_status")
public class ClaimStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private String name;
	
	public static final ClaimStatus CLAIM_STATUS_NEW = new ClaimStatus(1, "");
	
	ClaimStatus(){
		
	}

	public ClaimStatus(int id, @NotEmpty String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ClaimStatus get() {
		return this;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClaimStatus [id=" + id + ", name=" + name + "]";
	}
	
}
