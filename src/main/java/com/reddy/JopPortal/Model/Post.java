package com.reddy.JopPortal.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "JopPost")
@Data
public class Post {
    private String id;
    private String desc;
    private String exp;
    private String profile;
    private String[] techs;
}
