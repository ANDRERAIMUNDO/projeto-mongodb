package me.andreraimundo.projetomongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.andreraimundo.projetomongodb.domain.Post;
import me.andreraimundo.projetomongodb.repository.PostRepository;
import me.andreraimundo.projetomongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Post findById (String id){
        Optional<Post> user = postRepository.findById(id);
        return user.orElseThrow(()->new ObjectNotFoundException("Coleção não encontrada")); 
     }
}
