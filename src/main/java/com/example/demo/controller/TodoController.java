package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by sshashidhar on 15/07/18.
 */
@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(method = RequestMethod.GET, value="/todos")
    public Map<String, Object> getAllTodos(){
        List<Todo> todoList =  todoRepository.findAll();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("totalTodos", todoList.size());
        response.put("todo", todoList);
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/todo")
    public Map<String, Object> createTodo(@RequestBody Map<String, Object> todoMap){
        Todo todo = new Todo(todoMap.get("todo").toString(),
                Boolean.parseBoolean(todoMap.get("isComplete").toString()));

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Todo created successfully");
        response.put("todo", todoRepository.save(todo));
        return response;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/todo/{id}")
    public Map<String, Object> updateTodo(@PathVariable("id") String id, @RequestBody Map<String, Object> todoMap){
        Todo todo = new Todo(todoMap.get("todo").toString(),
                Boolean.parseBoolean(todoMap.get("isComplete").toString()));

        todo.setId(id);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Todo updated successfully");
        response.put("todo", todoRepository.save(todo));
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value="/todo/{id}")
    public Map<String, Object> getOneTodo(@PathVariable("id") String id){
        Optional<Todo> todo = todoRepository.findById(id);
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("todo", todo);
        return response;
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/todo/{id}")
    public Map<String, Object> deleteTodo(@PathVariable("id") String id){
        Todo todo = new Todo();
        todo.setId(id);
        todoRepository.delete(todo);

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", "Todo deleted successfully");
        return response;
    }



}
