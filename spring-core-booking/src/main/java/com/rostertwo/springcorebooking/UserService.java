package com.rostertwo.springcorebooking;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    @Autowired
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(long userId) {
        return userDao.get(userId);
    }

    public User getUserByEmail(String email) {
        return userDao
                .getAll()
                .stream()
                .filter((s) -> email.equals(s.getEmail()))
                .findAny()
                .get();
    }

    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao
                .getAll()
                .stream()
                .filter((s) -> s.getName().contains(name))
                .collect(Collectors.toList());
    }

    public User createUser(User user) {
        userDao.save(user);
        return user;
    }

    public User updateUser(User user, String name, String email) {
        userDao.update(user, name, email);
        return user;
    }

    public boolean deleteUser(long userId) {
        userDao.delete(userId);
        return true;
    }

}
