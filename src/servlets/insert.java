package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controls.entry;

public class insert extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String s1 = request.getParameter("Name");
        String s2 = request.getParameter("Username");
        String s3 = request.getParameter("Password");
        String s4 = request.getParameter("Confirm_Password");

        entry obj = new entry();

        String res = obj.enter_into_db(s1,s2,s3,s4);
        if(res == "Blank_Field"){
            RequestDispatcher rd=request.getRequestDispatcher("/Blank_Field.html");
            rd.forward(request,response);
            return;

        }else if (res == "Passwords_Do_Not_Match"){

            RequestDispatcher rd=request.getRequestDispatcher("/Passwords_do_not_match.html");
            rd.forward(request,response);

        }else if(res == "Username_already_exists"){

            RequestDispatcher rd=request.getRequestDispatcher("Username_already_exists.html");
            rd.forward(request,response);

        }else {
            RequestDispatcher rd=request.getRequestDispatcher("/Successful_data_insertion.html");
            rd.forward(request,response);

        }


    }
}
