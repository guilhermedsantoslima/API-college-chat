package com.br.cadastro.rest.controller;

import com.br.cadastro.exception.NotFoundUserException;
import com.br.cadastro.model.dto.UserDTO;
import com.br.cadastro.model.entity.UserEntity;
import com.br.cadastro.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cadastro")
public class UserController {

    @Autowired
    private UserService service;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody @Valid UserDTO userDTO){
        return service.saveUser(userDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UserDTO update(@PathVariable ("id") Long id, @RequestBody @Valid UserDTO userDTO) throws NotFoundUserException {
        return service.updateUser(id, userDTO);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable ("id") Long id) throws NotFoundUserException {
        service.deleteById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> listAll(){
        return service.getAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/filtrar")
    public List<UserEntity> find(UserEntity filter){
        return service.filter(filter);
    }

}
