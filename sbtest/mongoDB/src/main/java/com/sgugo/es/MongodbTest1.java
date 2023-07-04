package com.sgugo.es;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MongodbTest1 {
    @Autowired
    private MongoTemplate mongoTemplate;
    private int a = 10;

    @Test
    public void findAll(){
        List<Student> all = mongoTemplate.findAll(Student.class);
        System.out.println(all);
    }
}
