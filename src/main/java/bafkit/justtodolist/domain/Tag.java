package bafkit.justtodolist.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "TAG")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(mappedBy = "tagList")
    private Set<Todo> todoList = new HashSet<>();

    public Set<Todo> getTodoList() {
        return todoList;
    }

    public void  addTodo(Todo todo) {
        addTodo(todo, false);
    }

    public void addTodo(Todo todo, boolean otherSideHasBeenSet) {
        getTodoList().add(todo);
        if(otherSideHasBeenSet) return;
        todo.addTag(this, true);
    }

    public void  removeTodo(Todo todo) {
        removeTodo(todo, false);
    }

    public void removeTodo(Todo todo, boolean otherSideHasBeenSet) {
        getTodoList().remove(todo);
        if(otherSideHasBeenSet) return;
        todo.removeTag(this, true);
    }

}
