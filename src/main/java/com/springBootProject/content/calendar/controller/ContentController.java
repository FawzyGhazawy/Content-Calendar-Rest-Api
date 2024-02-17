package com.springBootProject.content.calendar.controller;

import com.springBootProject.content.calendar.model.Content;
import com.springBootProject.content.calendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {
private final ContentCollectionRepository repository;
//hon fi @Autowired bas l system automatically 3emela l2n fi bas 1 function
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }
    @GetMapping("")
public List<Content> findAll(){
        return repository.findAll();
}

@GetMapping("/{id}")
        public Content findById(@PathVariable Integer id){
            return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content){
        repository.save(content);
    }

}
