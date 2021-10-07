package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet(name = "AccessCounterServlet", urlPatterns = "/counter")
public class AccessCounterServlet extends HttpServlet {

    static String fileName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        fileName = getServletContext().getInitParameter("logFilePath");
        int count;
        if (readCount() == null) {
            count = 0;
        } else {
            count = readCount();
        }
        count++;
        writeCount(count);
        pw.println("<h1 align='center'>Count " + count + "</h1>");

    }

    private static Integer readCount() {
        Integer count = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            count = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static void writeCount(int count) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(count + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

