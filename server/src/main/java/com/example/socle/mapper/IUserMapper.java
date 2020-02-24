package com.example.socle.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.socle.dto.UserDto;
import com.example.socle.model.User;

@Mapper(componentModel = "spring")
public interface IUserMapper {

	UserDto asDto(User dao);

	User asDao(UserDto dto);

	List<UserDto> asDtos(List<User> dtos);

	List<User> asDaos(List<UserDto> daos);
}