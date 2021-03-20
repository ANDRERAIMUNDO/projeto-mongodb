package me.andreraimundo.projetomongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import me.andreraimundo.projetomongodb.domain.Post;
import me.andreraimundo.projetomongodb.domain.User;
import me.andreraimundo.projetomongodb.repository.PostRepository;
import me.andreraimundo.projetomongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");//formato de data
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));//formato de tempo

        userRepository.deleteAll();//deleta toda colecao user do mongodb ao inicializar o metodo
        postRepository.deleteAll();//deleta toda colecao user do mongodb ao inicializar o metodo

       User andre = new User (null, "Andre", "9000andre@gmail.com");     
       User raimundo = new User (null, "Raimundo", "9000andre01@gmail.com");     
       User rodrigues = new User (null, "Rodrigues", "9000andre02@gmail.com");   
       
      Post post1 = new Post(null, andre,
        simpleDateFormat.parse("20/03/2021"),
        "Saida do Brazil", "Saida autorizada - pronto para transporte");
      Post post2 = new Post(null, raimundo,
        simpleDateFormat.parse("19/03/2021"),
        "Saida da Argentina", "Saida não autorizada - problema no carregamento");

       userRepository.saveAll(Arrays.asList(andre, raimundo, rodrigues));
       postRepository.saveAll(Arrays.asList(post1, post2));
    }
    
}
