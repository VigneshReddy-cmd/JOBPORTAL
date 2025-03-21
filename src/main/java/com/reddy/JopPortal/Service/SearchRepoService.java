package com.reddy.JopPortal.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.reddy.JopPortal.Model.Post;

@Service
public class SearchRepoService implements SearchReporitory {

  // for aquiring the client
  @Autowired
  MongoClient mongoClient;

  // for converting the Document to post
  @Autowired
  MongoConverter mongoConverter;

  @Override
  public List<Post> getByText(String text) {
    final List<Post> posts = new ArrayList<>();

    // we have to implement the methods for frtching
    // use the pipeline generated in mongodb
    MongoDatabase database = mongoClient.getDatabase("reddy");
    MongoCollection<Document> collection = database.getCollection("JopPost");
    AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
        // for value
        new Document("$search",
        new Document("index", "keyWordSearch")
        .append("text", new Document("query", text)
        .append("path", Arrays.asList("profile", "techs", "profile" , "desc" )))),

        // for sorting
        new Document("$sort", new Document("exp", 1L)),

        // for limit
        new Document("$limit", 6L)));

        // mongo converter converts doc to mentioned typr
        result.forEach(
          doc -> posts.add( mongoConverter.read(Post.class, doc)  )
        );

    return posts;
  }

}
