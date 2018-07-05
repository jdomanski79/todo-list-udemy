package pl.jdomanski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import pl.jdomanski.model.TodoData;
import pl.jdomanski.util.Mappings;
import pl.jdomanski.util.ViewNames;

@Controller
public class TodoItemController {
    
    // == model attributes ==
    @ModelAttribute
    public TodoData todaData(){
        return new TodoData();
    }
    
    // == handler methods ==
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }
}
