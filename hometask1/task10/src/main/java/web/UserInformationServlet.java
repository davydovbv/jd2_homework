package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserInformation", urlPatterns = "/information")
public class UserInformationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String emale = req.getParameter("e-male");
        String startOfPage = "<html><head><meta charset='UTF-8'><title>User information</title></head>";
        String endOfPage = "</body></html>";
        if (name.equals("") || (phone.equals("") && emale.equals(""))) {
            writer.println(startOfPage);
            writer.println("<body><h1 align='center'>Error: You should input your name and at least phone number or E-male");
            writer.println("<form method='get' action='/task10'>");
            writer.println("<input type='submit' name='print' value='try again'>");
            writer.println(endOfPage);
        } else {
            writer.println(startOfPage);
            writer.println("<body><h1 align='center'>User name: " + name + "</h1>");
            if (!phone.equals("")) {
                writer.println("<h1 align='center'>User phone number: " + phone + "</h1>");
            } if (!emale.equals("")) {
                writer.println("<h1 align='center'>User e-male: " + emale + "</h1>");
            }
            writer.println(endOfPage);
        }
    }
}
