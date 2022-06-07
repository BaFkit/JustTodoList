package bafkit.justtodolist.domain.plainObjects;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class UserPojo {

    private long id;
    private String email;
    private String password;
    private Set<TodoPojo> todoList = new HashSet<>();
}
