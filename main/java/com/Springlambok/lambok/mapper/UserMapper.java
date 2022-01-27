package com.Springlambok.lambok.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springlambok.lambok.dto.UserDTO;
import com.Springlambok.lambok.entity.User;

@Service
public class UserMapper {
	@Autowired
	private ModelMapper mapper;

	public User convertToEntity(UserDTO dto) {
		User entity = mapper.map(dto, User.class);
		return entity;

	}

	public UserDTO converToDto(User entity) {
		UserDTO dto = mapper.map(entity, UserDTO.class);
		return dto;
	}
}
