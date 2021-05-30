package org.sdf0sdf.serviceapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.sdf0sdf.serviceapp.dao.ClaimProgressDAO;
import org.sdf0sdf.serviceapp.entitites.ClaimProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/claimprogress")
public class ClaimProgressController {

	private final ClaimProgressDAO claimProgressDAO;

	@Autowired
	public ClaimProgressController(ClaimProgressDAO claimProgressDAO) {
		this.claimProgressDAO = claimProgressDAO;
	}

	@GetMapping("/claim/{claimId}")
	public ResponseEntity<List<ClaimProgress>> show(@PathVariable("claimId") int claimId) {
		return new ResponseEntity<List<ClaimProgress>>(claimProgressDAO.show(claimId), HttpStatus.OK);
	}

	@PostMapping()
	@Valid
	public ResponseEntity<String> create(@RequestBody @Valid ClaimProgress claimprogress, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getAllErrors().toString());
		}
		claimProgressDAO.save(claimprogress);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
