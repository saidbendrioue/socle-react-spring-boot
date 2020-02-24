package com.example.socle.web;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socle.dto.UserDto;
import com.example.socle.service.IUserService;


/**
 *
 * @author S.BENDRIOUE
 * 
 */
@RestController
@RequestMapping("api/user")
//@PreAuthorize("!hasAuthority('USER')")
public class UserController {

	@Autowired
	private IUserService service;

	@GetMapping
	public Collection<UserDto> list() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public UserDto get(@PathVariable("id") final Long id) {
		return service.findById(id);
	}

	@PostMapping
	public void store(@Valid @RequestBody final UserDto entity) {
		if (entity.getId() != null)
			service.update(entity);
		else
			service.save(entity);
	}

	@DeleteMapping
	public void delete(@Valid @RequestBody final UserDto entities) {
		service.delete(entities);
	}
}
