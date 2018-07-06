package pl.jdomanski.controller;

import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.jdomanski.model.TodoData;
import pl.jdomanski.model.TodoItem;
import pl.jdomanski.service.TodoItemService;
import pl.jdomanski.util.AttributeNames;
import pl.jdomanski.util.Mappings;
import pl.jdomanski.util.ViewNames;

@Slf4j
@Controller
public class TodoItemController {
    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }
    
    // == handler methods ==
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.ADD_ITEM)
    public String addEditItems(@RequestParam(required = false, defaultValue = "-1") int id,
                                Model model){
        
        log.info("editing id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        
        if (todoItem == null){
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        return ViewNames.ADD_ITEM;
    }
    
    @PostMapping(Mappings.ADD_ITEM)
    public String processItems(
        @ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem) {
        
        log.info("todoItem from form is: {}", todoItem);
    	if (todoItem.getId() == 0){
    	   todoItemService.addItem(todoItem);
	    } else {
	        todoItemService.updateItem(todoItem);
	    }

    	return "redirect:/" + Mappings.ITEMS;
    }
    
    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam int id){
        log.info("Deleting item with id = {}", id);
        
        todoItemService.removeItem(id);
        
        return "redirect:/" + Mappings.ITEMS;
    }
    
    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        
        log.info("Viewing todoItem with id = {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        log.info("todoItem with id = {} is {}", id, todoItem);
        
        return ViewNames.VIEW_ITEM;
    }
}
