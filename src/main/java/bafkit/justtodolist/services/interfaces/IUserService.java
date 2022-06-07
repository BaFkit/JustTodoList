package bafkit.justtodolist.services.interfaces;

import bafkit.justtodolist.domain.User;
import bafkit.justtodolist.domain.plainObjects.UserPojo;

import java.util.List;

public interface IUserService {

    UserPojo createUser(User user);
    UserPojo getUser(long id);
    List<UserPojo> getAllUsers();
    UserPojo updateUser(User user, long id);
    UserPojo deleteUser(long id);

}
