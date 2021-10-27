package com.rostertwo.springcorebooking;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserDao {
    private Map<Long, User> users;
    private String storagePath;

    public void setUsers(Map<Long, User> users) {
        this.users = users;
    }

    public User get(long id) {
        return users.get(id);
    }

    public List<User> getAll() {
        return users
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public void save(User user) {
        if (user != null) {
            users.put(user.getId(), user);
        }
    }

    public void update(User user, String name, String email) {
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            users.put(user.getId(), user);
        }
    }

    public void delete(long userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
        }
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }

    public void initUsersBean() {
//        System.out.println("Init Bean for : UserDao");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            users = objectMapper.readValue(new URL("file:"+ storagePath), new TypeReference<Map<Long,User>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
