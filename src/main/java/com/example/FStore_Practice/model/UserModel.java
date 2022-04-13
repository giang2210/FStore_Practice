package com.example.FStore_Practice.model;

import com.example.FStore_Practice.entity.tbUser;
import com.example.FStore_Practice.util.ConfigSql;
import com.example.FStore_Practice.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class UserModel {
        public tbUser findAccountByUsername(String username) {
            tbUser obj = null;
            try {
                Connection connection = ConnectionHelper.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(
                                ConfigSql.SELECT_ACCOUNT_BY_USERNAME);
                preparedStatement.setString(1, username);
                // PrepareStatement
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    String usernameDatabase = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    obj = new tbUser(usernameDatabase, password);
                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }
}
