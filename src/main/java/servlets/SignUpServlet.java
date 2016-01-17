package servlets;

import dbService.DBException;
import dbService.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by Zets on 16.01.2016.
 */
public class SignUpServlet extends HttpServlet {

    DBService dbService;

    public SignUpServlet(DBService dbService) {
        this.dbService = dbService;
    }

    //sign up
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        try {
            long userId = dbService.addUser(login, pass);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

}
