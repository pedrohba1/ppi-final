package com.example.demo.service;

import com.example.demo.dto.user.UserCreationDataDTO;
import com.example.demo.dto.user.UserDataDTO;
import com.example.demo.dto.user.UserPutDTO;
import com.example.demo.entity.User;
import com.example.demo.models.RoleDescription;
import com.example.demo.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDataDTO createUser(UserCreationDataDTO register) {
         Optional<User> user = userRepository.findByUsername(register.getUserName());
        if(user.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT);
        }

        User userData = new User();
        userData.setUsername(register.getUserName());
        userData.setPassword(register.getPassword());
        userData.setRoles(Collections.singleton(RoleDescription.ROLE_USER));

        return new UserDataDTO(userRepository.save(userData));
    }

    public UserDataDTO getUserID(UUID idUser) {
        return new UserDataDTO(userRepository.findById(idUser).orElseThrow(EntityNotFoundException::new));
    }

    public List<UserDataDTO> getAllUsers() {

        List<User> userResponse = userRepository.findAll();
        List<UserDataDTO> listDTO = new ArrayList<>();
        for(User user : userResponse) {
            UserDataDTO userDTO = new UserDataDTO(user);
            listDTO.add(userDTO);
        }
        return listDTO;
    }


    public UserDataDTO putUser(UUID idUser, UserPutDTO putDTO) {
        Optional<User> user = userRepository.findById(idUser);

        if(user.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return new UserDataDTO(userRepository.save(putDTO.toUser(user)));
    }

    public void deleteUser(UUID idUser) {
        Optional<User> user = userRepository.findById(idUser);
        if(user.isEmpty()) {
            throw new EntityNotFoundException();
        }
        userRepository.delete(user.get());
    }
}
