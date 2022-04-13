package com.example.FStore_Practice.model;


import com.example.FStore_Practice.entity.tbProducts;
import com.example.FStore_Practice.util.ConfigSql;
import com.example.FStore_Practice.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {


    public List<tbProducts> findAll() {
        List<tbProducts> listObj = new ArrayList<>();
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlSelect = ConfigSql.DATABASE_PRODUCT_SELECT;
            PreparedStatement statement = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                double amount = resultSet.getDouble("amount");
                String details = resultSet.getString("details");
                tbProducts obj = new tbProducts(id, name, price, amount, details);
                listObj.add(obj);
            }
        } catch (Exception e) {

        }
        return listObj;
    }
}