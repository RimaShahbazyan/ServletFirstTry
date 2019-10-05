package com.synisys.servlet;

import com.synisys.com.synisys.entityManagers.UserManager;
import com.synisys.data.bulkData.BulkUserData;
import com.synisys.entities.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Welcome extends HttpServlet {
    private UserManager usMan;
    private User user;
    private PrintWriter out;
    @Override
    public void init(){
        String names[] ={ "Meri", "Anna", "Valod", "Vazgen"};
        String surnames[] = {"Khachatryan", "Poghosyan", "Minasyan","Mkrtchyan"};
        String emails[] = {"mk@gmail.com", "annpogh@gmail.com","valodik2005@yahoo.com",
                "Vazgen.Mkrtchyan@gmail.com"};
        String passwords[] = {"123456", "anushik-pupushik", "!@#123","veryStrongPassword"};
        usMan = new UserManager(new BulkUserData(names,surnames,emails,passwords));
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        out = resp.getWriter();
        out.println("<h1>" +
                "Welcome " + user.getName()+" " +
                user.getSurname()+
                "</h1>");
    }
    @Override
    public  void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        out = resp.getWriter();
        user = usMan.getUserByEmail(email);
        if (user.getPassword().equals(password)) {
            doGet(req,resp);
        }

    }
}
