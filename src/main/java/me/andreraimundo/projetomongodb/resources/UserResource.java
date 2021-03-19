package me.andreraimundo.projetomongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import me.andreraimundo.projetomongodb.domain.User;
import me.andreraimundo.projetomongodb.dto.UserDTO;
import me.andreraimundo.projetomongodb.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());//converte para uma lista dto
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}",  method = RequestMethod.GET)
    public ResponseEntity <UserDTO> findByd(@PathVariable String id){
        User obj = userService.findById(id);    
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity <Void> insert(@RequestBody UserDTO objDto){ //@RequestBody passar um dto em uma requisição
        User obj = userService.fromDTO(objDto); //converte para userDTO
        obj = userService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();//retorno 201 de criação 
    }

    @RequestMapping(value="/{id}",  method = RequestMethod.DELETE)
    public ResponseEntity <Void> delete(@PathVariable String id){
       userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
