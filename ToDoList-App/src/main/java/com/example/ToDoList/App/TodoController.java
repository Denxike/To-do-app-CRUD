package com.example.ToDoList.App;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoService todoService;
     public TodoController(TodoService todoService) {
         this.todoService = todoService;
     }

     @GetMapping
    public List<TodoEntity> getAllList(){
         return todoService.getAllList();
     }
     @GetMapping("/{id}")
    public TodoEntity getListById(@PathVariable Long id){
         return todoService.getListById(id);
     }
     @PostMapping("/add-list")
    public TodoEntity createList(@RequestBody String list) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setThingToBeSaved(list);
         return todoService.saveList(todoEntity);
     }
     @DeleteMapping("/delete/{id}")
    public String deleteString(@PathVariable Long id) {
         todoService.deleteListById(id);
         return "Id deleted id " +id ;
     }
     @PutMapping("/update/{id}")
    public String updateDtring(@PathVariable Long id,@RequestBody String newList) {
         TodoEntity updatedEntity = todoService.updateList(id, newList);
         return "Updated Successfull";
     }
}
