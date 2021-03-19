package me.andreraimundo.projetomongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.projetomongodb.domain.User;
import me.andreraimundo.projetomongodb.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
