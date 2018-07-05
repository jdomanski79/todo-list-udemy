package pl.jdomanski.service;

import org.springframework.stereotype.Service;
import pl.jdomanski.model.TodoData;
import pl.jdomanski.model.TodoItem;

import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // == fields ==
    private final TodoData data = new TodoData();

    // == public methods ==
    @Override
    public List<TodoItem> getItems() {
        return data.getItems();
    }

    @Override
    public void addItem(TodoItem toAdd) {
        data.addItem(toAdd);
    }

    @Override
    public void removeItem(int id) {
        data.removeItem(id);
    }

    @Override
    public TodoItem getItem(int id) {
        return data.getItem(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        data.updateItem(toUpdate);
    }

    @Override
    public TodoData getData() {
        return data;
    }
}
