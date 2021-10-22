package servlet;

import dao.ArtistDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SaveArtist", urlPatterns = "/artist/save")
public class SaveArtistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArtistDao artistDao = null;
        try {
            artistDao = new ArtistDao();
            artistDao.saveArtist(req.getParameter("artistName"), req.getParameter("language"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/jsp/create-artist-success.jsp").forward(req, resp);
    }
}
