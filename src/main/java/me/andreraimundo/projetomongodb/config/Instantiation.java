package me.andreraimundo.projetomongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import me.andreraimundo.projetomongodb.domain.User;
import me.andreraimundo.projetomongodb.repository.UserRepository;

@Configuration
public class Instatiantion implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();//deleta toda colecao user do mongodb ao inicializar o metodo

       User andre = new User (null, "Andre", "9000andre@gmail.com");     
       User raimundo = new User (null, "Raimundo", "9000andre01@gmail.com");     
       User rodrigues = new User (null, "Rodrigues", "9000andre02@gmail.com");   
       
       userRepository.saveAll(Arrays.asList(andre, raimundo, rodrigues));
    }
    
}
