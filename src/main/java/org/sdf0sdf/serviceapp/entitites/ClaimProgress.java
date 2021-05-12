package org.sdf0sdf.serviceapp.entitites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "claims_progress")
public class ClaimProgress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "claim_id", foreignKey=@ForeignKey(name = "fk1_claims_progress"))	
	private Claim claim;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "claim_status_id", foreignKey=@ForeignKey(name = "fk2_claims_progress"))		
	private ClaimStatus claimstatus;
	
	@NotNull
	@Column(length = 300)
	private String comment;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="claim_progress_date")
	private Date claimprogressdate;

	public ClaimProgress() {
		
	}
	public ClaimProgress(int id, @NotNull Claim claim, @NotNull ClaimStatus claimstatus, String comment,
			@NotNull Date claimprogressdate) {
		super();
		this.id = id;
		this.claim = claim;
		this.claimstatus = claimstatus;
		this.comment = comment;
		this.claimprogressdate = claimprogressdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	public ClaimStatus getClaimstatus() {
		return claimstatus;
	}

	public void setClaimstatus(ClaimStatus claimstatus) {
		this.claimstatus = claimstatus;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getClaim_progress_date() {
		return claimprogressdate;
	}

	public void setClaim_progress_date(Date claimprogressdate) {
		this.claimprogressdate = claimprogressdate;
	}

	@Override
	public String toString() {
		return "ClaimProgress [id=" + id + ", claim=" + claim + ", claimstatus=" + claimstatus + ", comment=" + comment
				+ ", claimprogressdate=" + claimprogressdate + "]";
	}
	
}
