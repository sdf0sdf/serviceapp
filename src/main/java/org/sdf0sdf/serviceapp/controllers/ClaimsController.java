package org.sdf0sdf.serviceapp.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.sdf0sdf.serviceapp.dao.ClaimDAO;
import org.sdf0sdf.serviceapp.dao.ClaimProgressDAO;
import org.sdf0sdf.serviceapp.entitites.Claim;
import org.sdf0sdf.serviceapp.entitites.ClaimProgress;
import org.sdf0sdf.serviceapp.entitites.ClaimStatus;
import org.sdf0sdf.serviceapp.entitites.ClaimsView;
import org.sdf0sdf.serviceapp.entitites.ProductType;
import org.sdf0sdf.serviceapp.entitites.ServiceCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/claims")
public class ClaimsController {

	private final ClaimDAO claimDAO;
	
	@Autowired
	public ClaimsController(ClaimDAO claimDAO) {
		this.claimDAO = claimDAO;
	}
	
	@GetMapping()
	public ResponseEntity<List<ClaimsView>> index() {
		return new ResponseEntity<List<ClaimsView>>(claimDAO.index(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClaimsView> show(@PathVariable("id") int id) {
		return new ResponseEntity<ClaimsView>(claimDAO.show(id), HttpStatus.OK);
	}

	@PostMapping()
	@Valid
	public ResponseEntity<String> create(@RequestBody @Valid ClaimsView claimsview, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors().toString());
		}

		Claim claim = new Claim(claimsview);
		ClaimProgress claimprogress = new ClaimProgress(claimsview.getClaimprogress());
		claimprogress.setClaim(claim);
		claimprogress.setClaimstatus(ClaimStatus.CLAIM_STATUS_NEW);
		claim.setClaimprogresslist(Arrays.asList(claimprogress));
		claimDAO.save(claim);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping("/{id}/edit")
	public ResponseEntity<Claim> edit(@PathVariable("id") int id) {
		return new ResponseEntity<Claim>(claimDAO.show(id), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid Claim claim, BindingResult bindingResult,
			@PathVariable("id") int id) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
		}

		claim.setId(id);
		claimDAO.update(claim);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		claimDAO.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
	
	@GetMapping("/producttypes")
	public ResponseEntity<List<ProductType>> getProductTypes() {
		return new ResponseEntity<List<ProductType>>(claimDAO.getProductTypes(), HttpStatus.OK);
	}
	
	@GetMapping("/servicecenters")
	public ResponseEntity<List<ServiceCenter>> getServiceCenters() {
		return new ResponseEntity<List<ServiceCenter>>(claimDAO.getServiceCenters(), HttpStatus.OK);
	}
}
