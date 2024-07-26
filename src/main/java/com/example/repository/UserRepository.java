package com.example.repository;

import com.example.dto.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public void insert(User user) throws SQLException {
        String query = "INSERT INTO users(id, username) VALUES ( ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getUsername());

        preparedStatement.executeUpdate();
    }

    public List<User> selectAll() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT id, username FROM users";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while(resultSet.next()) {
                Long id = resultSet.getLong("id");
                String username = resultSet.getString("username");

                User user = new User(id, username);
                userList.add(user);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return userList;
    }

    public User selectOne(Long userId) throws SQLException {
        String query = "SELECT id, username FROM users WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setLong(1, userId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String username = resultSet.getString("username");

            User user = new User(id, username);
            return user;
        } else {
            return null;
        }
    }

    public void update(User user) throws SQLException {
        String query = "UPDATE users SET username = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setLong(2, user.getId());

        preparedStatement.executeUpdate();
    }

    public void delete(Long userId) throws SQLException {
        String query = "DELETE FROM users WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setLong(1, userId);

        preparedStatement.executeUpdate();
    }
}
