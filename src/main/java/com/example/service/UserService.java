package com.example.service;

import com.example.dto.User;
import com.example.repository.UserRepositoryOld;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private final UserRepositoryOld userRepositoryOld;

    public UserService(UserRepositoryOld userRepositoryOld) {
        this.userRepositoryOld = userRepositoryOld;
    }

    public void createUser(User user) {
        try {
            userRepositoryOld.insert(user);
            System.out.println("Запись была успешно добавлена в таблицу!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return userRepositoryOld.selectAll();
    }

    public User getUser(Long userId) throws SQLException {
        return userRepositoryOld.selectOne(userId);
    }

    public void updateUser(User user) {
        try {
            userRepositoryOld.update(user);
            System.out.println("Запись была успешно изменена!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteUser(Long userId) {
        try {
            userRepositoryOld.delete(userId);
            System.out.println("Запись была успешно удалена!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
