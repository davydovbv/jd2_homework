package servlet;

import dao.ArtistDao;
import dto.ArtistDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Artists", urlPatterns = "/artists")
public class ArtistsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            ArtistDao artistDao = new ArtistDao();
            List<ArtistDto> list = artistDao.getAllArtists();
            req.setAttribute("artists", list);
            req.getRequestDispatcher("/WEB-INF/jsp/artists-read-all.jsp").forward(req, resp);
        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
