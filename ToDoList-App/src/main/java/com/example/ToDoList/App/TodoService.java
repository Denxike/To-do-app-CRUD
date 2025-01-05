package com.example.ToDoList.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    public List<TodoEntity> getAllList(){
        return todoRepository.findAll();
    }
    public  TodoEntity saveList(TodoEntity todoEntity) {
        return todoRepository.save(todoEntity);
    }
    public void deleteListById(Long id) {
        if(!todoRepository.existsById(id)) {
            throw new RuntimeException("List not found with Id: "+id);
        }
        todoRepository.deleteById(id);
    }
    public TodoEntity getListById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("List with Id not found "));
    }
    public TodoEntity updateList(Long id, String newList) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Entity with ID"));
        todoEntity.setThingToBeSaved(newList);
        return todoRepository.save(todoEntity);
    }
}
