//package servlet;
//
//
//import dao.ArtistDao;
//import dto.ArtistDto;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet(name = "Artist", urlPatterns = "/artist")
//public class ArtistServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
//        try {
//            ArtistDao artistDao = new ArtistDao();
//            ArtistDto artistDto = artistDao.getArtistById(Integer.parseInt(req.getParameter("id")));
//            req.setAttribute("artist", artistDto);
//            req.getRequestDispatcher("/WEB-INF/jsp/read-artist.jsp").forward(req, resp);
//        } catch (ClassNotFoundException | SQLException | ServletException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("artistName");
//        String language = req.getParameter("language");
//        if (name.equals("") || language.equals("")) {
//            getServletContext().getRequestDispatcher("/WEB-INF/jsp/create-artist.jsp").forward(req, resp);
//        } else {
//           getServletContext().getRequestDispatcher("/artist/save").forward(req, resp);
//        }
//    }
//}
