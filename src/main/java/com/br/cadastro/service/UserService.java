package com.br.cadastro.service;

import com.br.cadastro.exception.NotFoundUserException;
import com.br.cadastro.model.dto.UserDTO;
import com.br.cadastro.model.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);
    void deleteById(Long id) throws NotFoundUserException;
    List<UserDTO> getAll();
    List<UserEntity> filter(UserEntity filter);
    UserDTO updateUser(Long id, UserDTO userDTO) throws NotFoundUserException;

}
