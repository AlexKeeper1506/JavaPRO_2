package com.example.repository;

import com.example.dto.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public Product selectByProductId(Long productId) throws SQLException {
        String query = "SELECT account_number, balance, type, user_id " +
                "FROM products " +
                "WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, productId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String accountNumber = resultSet.getString("account_number");
            Double balance = resultSet.getDouble("balance");
            String type = resultSet.getString("type");
            Long userId = resultSet.getLong("user_id");

            Product product = new Product(
                    productId,
                    accountNumber,
                    balance,
                    type,
                    userId
            );

            return product;
        } else {
            return null;
        }
    }

    public List<Product> selectByUserId(Long userId) throws SQLException {
        List<Product> productList = new ArrayList<>();

        String query = "SELECT id, account_number, balance, type " +
                "FROM products " +
                "WHERE user_id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Long productId = resultSet.getLong("id");
            String accountNumber = resultSet.getString("account_number");
            Double balance = resultSet.getDouble("balance");
            String type = resultSet.getString("type");

            Product product = new Product(
                    productId,
                    accountNumber,
                    balance,
                    type,
                    userId
            );

            productList.add(product);
        }

        return productList;
    }
}
