package com.reddy.JopPortal.Service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.reddy.JopPortal.Model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{

}
