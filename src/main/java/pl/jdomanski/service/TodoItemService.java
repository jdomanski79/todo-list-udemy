package pl.jdomanski.service;

import pl.jdomanski.model.TodoData;
import pl.jdomanski.model.TodoItem;

import java.util.List;

public interface TodoItemService {

    void addItem(TodoItem toAdd);

    void removeItem(int id);

    TodoItem getItem(int id);

    void updateItem(TodoItem toUpdate);

    TodoData getData();
}

