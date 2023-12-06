package ru.rishaleva.springtask.dao;

import ru.rishaleva.springtask.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void removeUser(long id);

    void updateUser(User user);

    List<User> getAllUsers();

    User getUser(long id);
}

