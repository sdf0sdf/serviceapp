package org.sdf0sdf.serviceapp.entitites;

import java.util.Comparator;

public class ClaimsView extends Claim{
	
	private ClaimProgress claimprogress;
	
	public ClaimsView(){
		
	}
	
	public ClaimsView(Claim claim) {
		super(claim);
		this.claimprogress = getClaimProgress(claim);
	}

	public ClaimProgress getClaimProgress(Claim claim) {
		return claim.getClaimprogresslist().stream().max(Comparator.comparing(ClaimProgress::getClaimprogressdate)).orElse(null);
	}
	
	public ClaimProgress getClaimprogress() {
		return claimprogress;
	}

	public void setClaimprogress(ClaimProgress claimprogress) {
		this.claimprogress = claimprogress;
	}

	@Override
	public String toString() {
		return "ClaimView [claimprogress=" + claimprogress + "]";
	}
	
}
