package bafkit.justtodolist.utils;

import bafkit.justtodolist.domain.Tag;
import bafkit.justtodolist.domain.Todo;
import bafkit.justtodolist.domain.User;
import bafkit.justtodolist.domain.plainObjects.TagPojo;
import bafkit.justtodolist.domain.plainObjects.TodoPojo;
import bafkit.justtodolist.domain.plainObjects.UserPojo;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class Converter {

    public UserPojo userToPojo(User source) {
        UserPojo result = new UserPojo();

        result.setId(source.getId());
        result.setEmail(source.getEmail());
        result.setPassword(source.getPassword());
        result.setTodoList(source.getTodoList().stream().map(this::todoToPojo).collect(Collectors.toSet()));

        return result;
    }

    public TodoPojo todoToPojo(Todo source) {
        TodoPojo result = new TodoPojo();

        result.setId(source.getId());
        result.setName(source.getName());
        result.setComment(source.getComment());
        result.setStartDate(source.getStartDate());
        result.setEndDate(source.getEndDate());
        result.setImportant(source.getImportant());
        result.setPriority(source.getPriority());
        result.setUserId(source.getUser().getId());
        result.setTagList(source.getTagList().stream().map(this::tagToPojo).collect(Collectors.toSet()));

        return result;
    }

    public TagPojo tagToPojo(Tag source) {
        TagPojo result = new TagPojo();

        result.setId(source.getId());
        result.setName(source.getName());
        result.setTodoListIds(source.getTodoList().stream().map(Todo::getId).collect(Collectors.toSet()));

        return result;
    }

}
