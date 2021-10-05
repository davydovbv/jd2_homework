package by.academy.it.web;

import by.academy.it.controller.Printer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "parkingServlet", urlPatterns = "/parking")
public class ParkingServlet extends HttpServlet {

    private final Map<String, Date> map = new HashMap<>();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            PrintWriter writer = resp.getWriter();
            HttpSession session = req.getSession();
            Date currentDate = new Date();
            String number = req.getParameter("number");
            addParkingCookies(resp, number);
            if (map.containsKey(number)) {
                Date startDate = map.remove(number);
                long seconds = (currentDate.getTime() - startDate.getTime()) / 1000;
                writer.println("You stayed in our parking: ");
                writer.println(seconds + " seconds");
            } else {
                map.put(number,currentDate);
                writer.println("Welcome to our Parking!");
                writer.println(currentDate);
                writer.println("Car Number: " + number);
            }
            writer.println("Car Number: " + number);
            session.setAttribute("number", number);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void addParkingCookies(HttpServletResponse resp, String number) {
        Cookie cookie = new Cookie("PLATENUMBER", number);
        cookie.setMaxAge(300);
        resp.addCookie(cookie);
    }
}
