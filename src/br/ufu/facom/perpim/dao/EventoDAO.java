package br.ufu.facom.perpim.dao;

import br.ufu.facom.frameworkpim.model.Evento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    
    public void save (Evento evento, ConnectionSQLiteDAO conn) throws SQLException{
        String query = "INSERT INTO evento "
                + "(event_datahora, event_duracao, event_descricao)"
                + "VALUES(?, ?, ?);";
        
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setTimestamp(1, evento.getDataHora());
        ps.setTimestamp(2, evento.getDuracao());
        ps.setString(3, evento.getDescricao());
        ps.execute();        
    }
    
    public List<Evento> load (ConnectionSQLiteDAO conn) throws SQLException {
        String query = "SELECT * FROM evento;";
        
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        
        return build(rs);
    }
    
    private List<Evento> build (ResultSet rs) throws SQLException{
        List<Evento> eventos = new ArrayList<>();
        while(rs.next()){
            eventos.add(new Evento(rs.getTimestamp("event_datahora"),
                    rs.getTimestamp("event_duracao"),
                    rs.getString("event_descricao")
            ));
        }
        return eventos;
    }
}
