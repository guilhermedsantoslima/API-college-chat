package com.br.cadastro.service.impl;

import com.br.cadastro.exception.NotFoundUserException;
import com.br.cadastro.model.dto.UserDTO;
import com.br.cadastro.model.entity.UserEntity;
import com.br.cadastro.repository.UserRepository;
import com.br.cadastro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();

        user.setEmail(userDTO.getEmail());
        user.setSenha(userDTO.getSenha());
        user.setTelefone(userDTO.getTelefone());

        repository.save(user);

        return userDTO;
    }

    @Override
    public void deleteById(Long id) throws NotFoundUserException{
        repository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserEntity> userEntities = repository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        userEntities.forEach(userEntity -> {
             UserDTO userDTO = new UserDTO();

             userDTO.setEmail(userEntity.getEmail());
             userDTO.setTelefone(userEntity.getTelefone());
             userDTO.setSenha(userEntity.getSenha());

             userDTOS.add(userDTO);
        });

        return userDTOS;
    }

    @Override
    public List<UserEntity> filter(UserEntity filter) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter, matcher);
        List<UserDTO> lista = repository.findAll(example);

        return repository.findAll(example);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) throws NotFoundUserException {
        Optional<UserEntity> userEntities = repository.findById(id);

        if (!userEntities.isPresent()){
            throw new NotFoundUserException();
        }
        userEntities.get().setEmail(userDTO.getEmail());
        userEntities.get().setTelefone(userDTO.getTelefone());
        userEntities.get().setSenha(userDTO.getSenha());

        repository.save(userEntities.get());

        return userDTO;
    }


}
