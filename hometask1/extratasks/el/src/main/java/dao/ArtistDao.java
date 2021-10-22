package dao;


import dto.ArtistDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtistDao {
    private DataSource dataSource;


    public ArtistDao() throws ClassNotFoundException {
        dataSource = new DataSource();
    }

    public ArtistDto getArtistById(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM artists WHERE id=?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        ArtistDto artistDto = null;
        if (rs.next()) {
            artistDto = new ArtistDto(rs.getInt("id"), rs.getString("name"),
                    rs.getString("language"));
        }
        connection.close();
        ps.close();
        rs.close();
        return artistDto;
    }

    public List<ArtistDto> getAllArtists() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM artists");
        List<ArtistDto> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new ArtistDto(rs.getInt("id"), rs.getString("name"),
                    rs.getString("language")));
        }
        st.close();
        connection.close();
        rs.close();

        return list;
    }

    public void saveArtist(String name, String language) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement st = connection.prepareStatement("INSERT INTO artists (name, language ) VALUES (?,?)");
        st.setString(1,name);
        st.setString(2,language);
        st.executeUpdate();
        connection.close();
        st.close();
    }
}
