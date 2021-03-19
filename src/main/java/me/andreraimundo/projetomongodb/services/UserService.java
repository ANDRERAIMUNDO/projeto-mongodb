package me.andreraimundo.projetomongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.projetomongodb.domain.User;
import me.andreraimundo.projetomongodb.dto.UserDTO;
import me.andreraimundo.projetomongodb.repository.UserRepository;
import me.andreraimundo.projetomongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById (String id){
       Optional<User> obj = userRepository.findById(id);
       return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não foi encontrado"));
    }
    public User insert(User obj){
        return userRepository.insert(obj);
    }
    public User fromDTO (UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}
