package com.example.socle.service;

import java.util.List;

import com.example.socle.dto.UserDto;

/**
 *
 * @author S.BENDRIOUE
 * 
 */
public interface IUserService {

	List<UserDto> findAll();

	UserDto findById(Long id);

	UserDto findByUsername(String username);

	UserDto save(UserDto dto);

	void update(UserDto dto);

	void delete(final UserDto dto);

}
