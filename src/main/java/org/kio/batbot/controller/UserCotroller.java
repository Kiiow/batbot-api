package org.kio.batbot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.kio.batbot.bo.User;
import org.kio.batbot.dal.IUserRepository;
import org.kio.batbot.domain.UserRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "User", description = "Get Discord users informations")
public class UserCotroller {

    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping(path = "/users")
    @Operation(summary = "Get all users")
    public List<User> getAllUsers(@RequestParam(value = "size", defaultValue = "150", required = false) int size) {
        List<User> userList = iUserRepository.findAllByOrderByXpDesc();
        size = (size > userList.size()) ? userList.size() : size;
        return userList.subList(0, size);
    }

    @GetMapping(path = "/user/{id}")
    @Operation(summary = "Get one user by it's discord id")
    public Optional<User> getUserById(@PathVariable("id") String userId) throws ResponseStatusException {
        Optional<User> aUser = iUserRepository.findById(userId);
        if(!aUser.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found for the id : " + userId);
        return aUser;
    }

    @PutMapping(path = "/user/{id}")
    @Operation(summary = "Update the user informations")
    public User updateUser(@PathVariable("id") String userId, @RequestBody(required = false) UserRequestBody userBody) throws ResponseStatusException {
        Optional<User> aUser = iUserRepository.findById(userId);
        if(!aUser.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found for the id : " + userId);
        User resultUser = aUser.get();
        if(userBody != null) {
            resultUser.setNickname(userBody.getNickname() == null? resultUser.getNickname() : userBody.getNickname());
            resultUser.setUsername(userBody.getUsername() == null? resultUser.getUsername() : userBody.getUsername());
            resultUser.setDiscriminator(userBody.getDiscriminator() == null? resultUser.getDiscriminator() : userBody.getDiscriminator());
            resultUser.setXp(userBody.getXp() == null? resultUser.getXp() : userBody.getXp());
            resultUser.setLevel(userBody.getLevel() == null? resultUser.getLevel() : userBody.getLevel());
            resultUser = iUserRepository.save(resultUser);
        }
        return resultUser;
    }

    @PostMapping(path = "/user")
    @Operation(summary = "Create a new user")
    public User CreateUser(@RequestBody User nUser) throws ResponseStatusException {
        Optional<User> checkUser = iUserRepository.findById(nUser.getId());
        if(checkUser.isPresent()) throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User already exist, if you want to update it check '/user/{id}' POST path", null);
        return iUserRepository.save(nUser);
    }
}
