package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;

@WebServlet(name = "AccessCounterServlet", urlPatterns = "/counter")
public class AccessCounterServlet extends HttpServlet {

    static String fileName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        fileName = getServletContext().getInitParameter("logFilePath");
        File file = new File(fileName.substring(0,fileName.lastIndexOf("\\")));
        if(file.exists()) {
            int count;
            if (readCount() == null) {
                count = 0;
            } else {
                count = readCount();
            }
            count++;
            writeCount(count);
            pw.println("<h1 align='center'>Count " + count + "</h1>");
        } else {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                pw.println("<h1 align='center'>" + "Wrong log file specified" + "</h1>");
                pw.println("<h1 align='center'>" + "Chek configuration and try again" + "</h1>");
            }
        }

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

