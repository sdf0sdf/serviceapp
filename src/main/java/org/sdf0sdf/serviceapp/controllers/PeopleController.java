package org.sdf0sdf.serviceapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.sdf0sdf.serviceapp.dao.PersonDAO;
import org.sdf0sdf.serviceapp.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

	private final PersonDAO personDAO;

	@Autowired
	public PeopleController(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@GetMapping()
	public ResponseEntity<List<Person>> index() {
		return new ResponseEntity<List<Person>>(personDAO.index(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Person> show(@PathVariable("id") int id) {
		return new ResponseEntity<Person>(personDAO.show(id), HttpStatus.OK);
	}

	@GetMapping("/new")
	public ResponseEntity<Person> newPerson(@ModelAttribute("person") Person person) {
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@PostMapping()
	@Valid
	public ResponseEntity<String> create(@RequestBody @Valid Person person, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
		}

		personDAO.save(person);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@GetMapping("/{id}/edit")
	public ResponseEntity<Person> edit(@PathVariable("id") int id) {
		return new ResponseEntity<Person>(personDAO.show(id), HttpStatus.OK);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<String> update(@RequestBody @Valid Person person, BindingResult bindingResult,
			@PathVariable("id") int id) {
		if (bindingResult.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
		}

		personDAO.update(id, person);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		personDAO.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
}