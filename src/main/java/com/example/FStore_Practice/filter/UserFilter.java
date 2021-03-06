package com.example.FStore_Practice.filter;


import com.example.FStore_Practice.entity.tbUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

    public class UserFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("start user filter");
            Filter.super.init(filterConfig);
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("User Filtering.....");
            HttpServletRequest request = (HttpServletRequest)servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            HttpSession session = request.getSession();
            tbUser account = (tbUser) session.getAttribute("currentAccount");
            if (account == null){
                response.sendRedirect("/accounts/login");
            }else {
                System.out.println("Current account: " + account.getUsername());
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }

        @Override
        public void destroy() {
            System.out.println("end user filter");
            Filter.super.destroy();
        }
}
