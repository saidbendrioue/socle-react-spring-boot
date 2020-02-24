package com.example.socle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.socle.dto.UserDto;
import com.example.socle.exceptions.ElementNotFoundException;
import com.example.socle.mapper.IUserMapper;
import com.example.socle.model.User;
import com.example.socle.repository.UserRepository;

/**
 *
 * @author S.BENDRIOUE
 * 
 */
@Service
@Transactional
public class UserService implements IUserService {

	/** User mapper */
	@Autowired
	private IUserMapper mapper;

	/** User repository */
	@Autowired
	private UserRepository repository;

	@Override
	@Transactional(readOnly = true)
	public UserDto findById(final Long id) {

		final Optional<User> dao = repository.findById(id);

		if (dao.isPresent()) {
			return mapper.asDto(dao.get());
		} else {
			throw new ElementNotFoundException(User.class, id);
		}
	}

	@Override
	public UserDto save(final UserDto dto) {
		final User dao = mapper.asDao(dto);
		return mapper.asDto(repository.save(dao));
	}

	@Override
	public void update(final UserDto dto) {

		final Optional<User> dao = repository.findById(dto.getId());

		if (dao.isPresent()) {
			repository.save(mapper.asDao(dto));
		} else {
			throw new ElementNotFoundException(User.class, dto.getId());
		}
	}

	@Override
	public void delete(final UserDto dto) {
		repository.delete(mapper.asDao(dto));
	}

	@Override
	public List<UserDto> findAll() {		
		List<User> daos = repository.findAll();
		return mapper.asDtos(daos);
	}

	@Override
	public UserDto findByUsername(String username) {
		return mapper.asDto(repository.findByUsername(username));
	}
}
