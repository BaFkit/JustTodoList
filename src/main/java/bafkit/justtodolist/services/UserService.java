package bafkit.justtodolist.services;

import bafkit.justtodolist.domain.User;
import bafkit.justtodolist.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    public UserService() {
    }

    @Override
    public int createUser(User user) {
        return 0;
    }

    @Override
    public User getUser(long id) {
        return null;
    }

    @Override
    public int updateUser(User updatedUser, long id) {
        return 0;
    }

    @Override
    public int deleteUser(long id) {
        return 0;
    }
}