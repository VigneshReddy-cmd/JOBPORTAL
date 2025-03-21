package com.reddy.JopPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reddy.JopPortal.Model.Post;
import com.reddy.JopPortal.Service.PostRepository;
import com.reddy.JopPortal.Service.SearchReporitory;

@RestController
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    PostRepository postRepository;

    // for custom search
    @Autowired
    SearchReporitory searchReporitory;

    @RequestMapping("/")
    public String getHome()
    {
        return "HOME COMMING~!";
    }

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts()
    {

        System.out.print("HIT FOR ALL POSTS\n");
        return postRepository.findAll(); 
    }

    @GetMapping("/post/{text}")
    @CrossOrigin
    public List<Post> getByText(@PathVariable String text)
    {
        return searchReporitory.getByText(text);
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
        postRepository.save(post);
        return post;
    }


}
