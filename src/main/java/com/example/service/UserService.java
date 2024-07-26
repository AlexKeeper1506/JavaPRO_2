package com.example.service;

import com.example.dto.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        try {
            userRepository.insert(user);
            System.out.println("Запись была успешно добавлена в таблицу!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        return userRepository.selectAll();
    }

    public User getUser(Long userId) throws SQLException {
        return userRepository.selectOne(userId);
    }

    public void updateUser(User user) {
        try {
            userRepository.update(user);
            System.out.println("Запись была успешно изменена!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void deleteUser(Long userId) {
        try {
            userRepository.delete(userId);
            System.out.println("Запись была успешно удалена!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
