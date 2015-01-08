package servlets;

import controls.authenticate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controls.*;

public class login extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String n=request.getParameter("username");
        String p=request.getParameter("password");

        authenticate user = new authenticate();

        if(user.validate(n,p)){
            RequestDispatcher rd=request.getRequestDispatcher("/welcome.jsp");
            rd.forward(request,response);
        }
        else{
            System.out.print("Sorry username or password error");
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
            response.sendRedirect("/error.jsp");
        }

    }
}
