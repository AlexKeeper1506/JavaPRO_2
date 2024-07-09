package com.example.service;

import com.example.dto.User;
import com.example.repository.UserDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void createUser(User user) {
        try {
            userDAO.insert(user);
            System.out.println("Запись была успешно добавлена в таблицу!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return userDAO.selectAll();
    }

    public User getUser(Long userId) throws SQLException {
        return userDAO.selectOne(userId);
    }

    public void updateUser(User user) {
        try {
            userDAO.update(user);
            System.out.println("Запись была успешно изменена!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteUser(Long userId) {
        try {
            userDAO.delete(userId);
            System.out.println("Запись была успешно удалена!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
