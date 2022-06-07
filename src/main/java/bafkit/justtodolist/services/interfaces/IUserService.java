package bafkit.justtodolist.services.interfaces;

import bafkit.justtodolist.domain.User;

public interface IUserService {

    int createUser(User user);
    User getUser(long id);
    int updateUser(User user, long id);
    int deleteUser(long id);

}
