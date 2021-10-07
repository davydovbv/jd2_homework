package web;

import eu.bitwalker.useragentutils.UserAgent;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BrowserIdentification", urlPatterns = "/identification")
public class BrowserIdentificationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
        String browser = userAgent.getBrowser().getName();
        PrintWriter writer = resp.getWriter();
        String startOfPage = "<html><head><title>User information</title></head>";
        String endOfPage = "</body></html>";
        writer.println(startOfPage);
        writer.println("<body><h1 align='center'> Hello, user from " + browser);
        writer.println(endOfPage);
    }
}
