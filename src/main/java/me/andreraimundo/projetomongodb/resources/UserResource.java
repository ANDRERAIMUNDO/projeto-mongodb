package me.andreraimundo.projetomongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.andreraimundo.projetomongodb.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity <List<User>> findAll(){
        User andre = new User( "1", "Andre Raimundo", "9000andre@gmail.com");
        User raimundo = new User( "2", "Raimundo Andre", "9000andr@gmail.com");
        List<User> list  = new ArrayList<>();
        list.addAll(Arrays.asList(andre, raimundo));
        return ResponseEntity.ok().body(list);
    }
}
