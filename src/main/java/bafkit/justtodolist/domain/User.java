package bafkit.justtodolist.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "_USER")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
        todo.setUser(this, true);
    }

    public void  removeTodo(Todo todo) {
        removeTodo(todo, false);
    }

    public void removeTodo(Todo todo, boolean otherSideHasBeenSet) {
        getTodoList().remove(todo);
        if(otherSideHasBeenSet) return;
        todo.removeUser(this, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id == user.id && email.equals(user.email) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password);
    }
}
