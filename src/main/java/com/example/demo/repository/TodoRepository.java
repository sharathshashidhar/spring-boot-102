package com.example.demo.repository;

import com.example.demo.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by sshashidhar on 15/07/18.
 */
public interface TodoRepository extends MongoRepository<Todo,String> {
}
