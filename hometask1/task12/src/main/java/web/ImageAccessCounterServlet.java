package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "ImageAccessCounter", urlPatterns = "/image-counter")
public class ImageAccessCounterServlet extends HttpServlet {
    static String fileName;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        ServletOutputStream out = resp.getOutputStream();
        fileName = getServletContext().getInitParameter("logFilePath");
        BufferedImage image = new BufferedImage(500, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.ITALIC, 100));
        graphics.setColor(Color.GREEN);
        int count;
        if (readCount() == null) {
            count = 0;
        } else {
            count = readCount();
        }
        count++;
        graphics.drawString(String.valueOf(count), 200, 130);
        writeCount(count);
        ImageIO.write(image, "jpeg", out);
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
