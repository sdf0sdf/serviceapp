package org.sdf0sdf.serviceapp.entitites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "claims")
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@Length(max = 10)
	@Column(name="claim_no", unique = true)
	private String claimno;

	@NotNull
	@Length(max = 10)
	@Column(unique = true)
	private String sn;

	@NotNull
	@ManyToOne
	@JoinColumn(name="product_type_id", foreignKey = @ForeignKey(name = "fk1_claims"))
	private ProductType producttype;

	@NotNull
	@ManyToOne
	@JoinColumn(name="service_center_id", foreignKey = @ForeignKey(name = "fk2_claims"))
	private ServiceCenter servicecenter;
	
	@JsonIgnore
	@NotNull
	@OneToMany
	@JoinColumn(name="claim_id")
	private List<ClaimProgress> claimprogresslist;
	
	public Claim() {

	}
	public Claim(int id, @NotEmpty @Length(max = 10) String claimno, @NotEmpty @Length(max = 10) String sn,
			@NotNull ProductType producttype, @NotNull ServiceCenter servicecenter, @NotNull List<ClaimProgress> claimprogresslist) {
		super();
		this.id = id;
		this.claimno = claimno;
		this.sn = sn;
		this.producttype = producttype;
		this.servicecenter = servicecenter;
		this.claimprogresslist = claimprogresslist;
	}
	
	public Claim(Claim claim) {
		super();
		this.id = claim.id;
		this.claimno = claim.claimno;
		this.sn = claim.sn;
		this.producttype = claim.producttype;
		this.servicecenter = claim.servicecenter;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public ProductType getProducttype() {
		return producttype;
	}

	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}

	public ServiceCenter getServicecenter() {
		return servicecenter;
	}

	public void setServicecenter(ServiceCenter servicecenter) {
		this.servicecenter = servicecenter;
	}

	public String getClaimno() {
		return claimno;
	}
	public void setClaimno(String claimno) {
		this.claimno = claimno;
	}
	public List<ClaimProgress> getClaimprogresslist() {
		return claimprogresslist;
	}
	public void setClaimprogresslist(List<ClaimProgress> claimprogresslist) {
		this.claimprogresslist = claimprogresslist;
	}
	@Override
	public String toString() {
		return "Claim [id=" + id + ", claimno=" + claimno + ", sn=" + sn + ", producttype=" + producttype
				+ ", servicecenter=" + servicecenter + "]";
	}

}
