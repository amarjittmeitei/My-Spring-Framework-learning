package com.yawolart.servlet;

import com.yawolart.model.User;
import com.yawolart.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    UserService users = new UserService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {// throws ServletException, IOException {

        // fetching the query parameters
        Long id = Long.parseLong(req.getParameter("id"));
        String name= req.getParameter("name");

        //mapping it to model POJO class
        User user = new User();
        user.setId(id);
        user.setName(name);

        //calling service method
        user = users.createService(user);

        //response
        if(user == null)
        {
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getWriter().write("{\n" +
                    "    \"message\" : \"no found\"\n" +
                    "}");
            return;
        }

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write("{\n" +
                "    \"id\" : " +
                user.getId() +
                ",\n" +
                "    \"name\" : " +
                user.getName() +
                "\n" +
                "}");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // fetching the query parameters
        long id = Long.parseLong(req.getParameter("id"));

        //mapping it to model POJO class
        User user = new User();

        //calling service method
        user = users.getUserService(id);

        //response
        if(user == null)
        {
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getWriter().write("{\n" +
                    "    \"message\" : \"no found\"\n" +
                    "}");
            return;
        }

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write("{\n" +
                "    \"id\" : " +
                user.getId() +
                ",\n" +
                "    \"name\" : " +
                user.getName() +
                "\n" +
                "}");

    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException{

        long id = Long.parseLong(req.getParameter("id"));
        boolean response = users.deleteUserService(id);
        if(!response)
        {
            resp.setStatus(404);
            return;
        }
        else
        {
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getWriter().write("{\n" +
                    "    \"message\" : \"deleted succesfully\"\n" +
                    "}");
        }

    }


}
