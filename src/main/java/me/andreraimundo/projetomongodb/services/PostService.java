package me.andreraimundo.projetomongodb.services;

import java.util.Date;
import java.util.List;
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
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(()->new ObjectNotFoundException("Coleção não encontrada")); 
     }

     public List<Post> findByTitle (String text){
         return postRepository.searchTitle  (text);
     }

     public List<Post> fullSearch(String text, Date minDate, Date maxDate){
         maxDate = new Date(maxDate.getTime()+24*60*60*1000);
         return postRepository.FullSearch(text, minDate, maxDate);
     }
}
