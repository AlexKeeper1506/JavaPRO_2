package com.example.service;

import com.example.dto.UserResponseDto;
import com.example.entity.User;
import com.example.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        try {
            User newUser = userRepository.save(user);
            System.out.println("Запись была успешно добавлена в таблицу!");
            return newUser;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return new User();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponseDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

        UserResponseDto userDto = new UserResponseDto(
                user.getId(),
                user.getUsername()
        );

        return userDto;
    }

    public User updateUser(User user) {
        try {
            User updatedUser = userRepository.save(user);
            System.out.println("Запись была успешно изменена!");
            return updatedUser;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return new User();
    }

    public String deleteUserById(Long userId) {
        try {
            userRepository.deleteById(userId);
            return "Запись была успешно удалена!";
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return "Что-то пошло не так!";
    }
}
