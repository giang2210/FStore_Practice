package com.example.FStore_Practice.controller;

import com.example.FStore_Practice.entity.tbProducts;
import com.example.FStore_Practice.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel model = new ProductModel();
        List<tbProducts> listObj = model.findAll();
        req.setAttribute("listObj", listObj);
        req.getRequestDispatcher("/products/ListProduct.jsp").forward(req,resp);
    }
}
