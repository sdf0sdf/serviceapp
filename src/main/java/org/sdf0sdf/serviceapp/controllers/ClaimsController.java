package org.sdf0sdf.serviceapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.sdf0sdf.serviceapp.dao.ClaimDAO;
import org.sdf0sdf.serviceapp.entitites.Claim;
import org.sdf0sdf.serviceapp.entitites.ClaimsView;
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

	@GetMapping("/new")
	public ResponseEntity<Claim> newClaim(@ModelAttribute("claim") Claim claim) {
		return new ResponseEntity<Claim>(claim, HttpStatus.OK);
	}

	@PostMapping()
	@Valid
	public ResponseEntity<String> create(@RequestBody @Valid Claim claim, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
		}

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

		claimDAO.update(id, claim);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		claimDAO.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
}
