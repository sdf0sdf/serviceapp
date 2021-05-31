package org.sdf0sdf.serviceapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.sdf0sdf.serviceapp.dao.ClaimProgressDAO;
import org.sdf0sdf.serviceapp.entitites.ClaimProgress;
import org.sdf0sdf.serviceapp.entitites.ClaimStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/claimprogress")
public class ClaimProgressController {

	private final ClaimProgressDAO claimProgressDAO;

	@Autowired
	public ClaimProgressController(ClaimProgressDAO claimProgressDAO) {
		this.claimProgressDAO = claimProgressDAO;
	}

	@GetMapping("/claim/{claimId}")
	public List<ClaimProgress> show(@PathVariable("claimId") int claimId) {
		return claimProgressDAO.show(claimId);
	}

	@PostMapping()
	@Valid
	public String create(@RequestBody @Valid ClaimProgress claimprogress, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return bindingResult.getAllErrors().toString();
		}
		claimProgressDAO.save(claimprogress);
		return "";
	}
	
	@GetMapping("/claimstatuses")
	public List<ClaimStatus> getServiceCenters() {
		return claimProgressDAO.getClaimStatuses();
	}
}
