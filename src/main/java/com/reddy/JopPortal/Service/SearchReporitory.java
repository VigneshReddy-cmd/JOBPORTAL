package com.reddy.JopPortal.Service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.reddy.JopPortal.Model.Post;

@Repository
public interface SearchReporitory {

    public List<Post> getByText(String text);

}
