package org.sdf0sdf.serviceapp.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.sdf0sdf.serviceapp.dao.ClaimDAO;
import org.sdf0sdf.serviceapp.entitites.Claim;
import org.sdf0sdf.serviceapp.entitites.ClaimProgress;
import org.sdf0sdf.serviceapp.entitites.ClaimStatus;
import org.sdf0sdf.serviceapp.entitites.ClaimsView;
import org.sdf0sdf.serviceapp.entitites.ProductType;
import org.sdf0sdf.serviceapp.entitites.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claims")
public class ClaimsController {

	private final ClaimDAO claimDAO;
	
	@Autowired
	public ClaimsController(ClaimDAO claimDAO) {
		this.claimDAO = claimDAO;
	}
	
	@GetMapping()
	public List<ClaimsView> index() {
		return claimDAO.index();
	}

	@GetMapping("/{id}")
	public ClaimsView show(@PathVariable("id") int id) {
		return claimDAO.show(id);
	}

	@PostMapping()
	@Valid
	public String create(@RequestBody @Valid ClaimsView claimsview, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return bindingResult.getAllErrors().toString();
		}

		Claim claim = new Claim(claimsview);
		ClaimProgress claimprogress = new ClaimProgress(claimsview.getClaimprogress());
		claimprogress.setClaim(claim);
		claimprogress.setClaimstatus(ClaimStatus.CLAIM_STATUS_NEW);
		claim.setClaimprogresslist(Arrays.asList(claimprogress));
		claimDAO.save(claim);
		return "";
	}

	@GetMapping("/{id}/edit")
	public Claim edit(@PathVariable("id") int id) {
		return claimDAO.show(id);
	}

	@PatchMapping("/{id}")
	public String update(@RequestBody @Valid Claim claim, BindingResult bindingResult,
			@PathVariable("id") int id) {
		if (bindingResult.hasErrors()) {
			return bindingResult.getAllErrors().toString();
		}

		claim.setId(id);
		claimDAO.update(claim);
		return "";
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		claimDAO.delete(id);
		return "";
	}
	
	@GetMapping("/producttypes")
	public List<ProductType> getProductTypes() {
		return claimDAO.getProductTypes();
	}
	
	@GetMapping("/servicecenters")
	public List<ServiceCenter> getServiceCenters() {
		return claimDAO.getServiceCenters();
	}
}
