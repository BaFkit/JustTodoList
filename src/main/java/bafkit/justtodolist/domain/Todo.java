package bafkit.justtodolist.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "TODO")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "IMPORTANT")
    private Boolean important;

    @Column(name = "PRIORITY")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToMany
    @JoinTable(name = "TODO_TAG", joinColumns = @JoinColumn(name = "TODO_ID"), inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    private Set<Tag> tagList = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        setUser(user, false);
    }

    public void setUser(User user, boolean otherSideHasBeenSet) {
        this.user = user;
        if(otherSideHasBeenSet) return;
        user.addTodo(this, true);
    }

    public void removeUser(User user) {
        removeUser(user, false);
    }

    public void removeUser(User user, boolean otherSideHasBeenSet) {
        this.user = null;
        if(otherSideHasBeenSet) return;
        user.removeTodo(this, true);
    }

    public Set<Tag> getTagList() {
        return tagList;
    }

    public void  addTag(Tag tag) {
        addTag(tag, false);
    }

    public void addTag(Tag tag, boolean otherSideHasBeenSet) {
        getTagList().add(tag);
        if(otherSideHasBeenSet) return;
        tag.addTodo(this, true);
    }

    public void  removeTag(Tag tag) {
        removeTag(tag, false);
    }

    public void removeTag(Tag tag, boolean otherSideHasBeenSet) {
        getTagList().remove(tag);
        if(otherSideHasBeenSet) return;
        tag.removeTodo(this, true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Todo todo = (Todo) o;
        return id != null && Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
