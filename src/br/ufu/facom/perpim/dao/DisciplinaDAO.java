package br.ufu.facom.perpim.dao;

import br.ufu.facom.perpim.model.Disciplina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {

    public void save(Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException {
        String query = "INSERT INTO disciplina VALUES (?, ?, ?, ?);";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, disc.getID());
        ps.setString(2, disc.getNome());
        ps.setString(3, disc.getSala());
        ps.setString(4, disc.getSemestre());
        ps.execute();
    }
    
    public void update(String SiglaOld, Disciplina disc, ConnectionSQLiteDAO conn) throws SQLException {
        String query = "UPDATE disciplina set _id = ? ,nome = ? ,sala = ? ,semestre = ? WHERE _id = ?";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, disc.getID());
        ps.setString(2, disc.getNome());
        ps.setString(3, disc.getSala());
        ps.setString(4, disc.getSemestre());
        ps.setString(5, SiglaOld);
        ps.executeUpdate();
    }
    
    public List<Disciplina> load(ConnectionSQLiteDAO conn) throws SQLException {
        String query = "SELECT * FROM disciplina ";

        return findWithQuery(query,conn);
    }

    public List<Disciplina> findBySemestre(String semestre, ConnectionSQLiteDAO conn) throws SQLException{
        String query = "SELECT * FROM disciplina WHERE semestre = '"+ semestre+"'";

        return findWithQuery(query,conn);
    }
    public Disciplina findById(String id,ConnectionSQLiteDAO conn) throws SQLException{
        String query = "SELECT * FROM disciplina WHERE _id = '"+ id+"'";

        return findWithQuery(query,conn).get(0);
    }

    public List<Disciplina> findWithQuery(String query, ConnectionSQLiteDAO conn)throws SQLException {
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Disciplina> ds = new ArrayList<>();
        while (rs.next()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setID(rs.getString("_id"));
            disciplina.setNome(rs.getString("nome"));
            disciplina.setSala(rs.getString("sala"));
            disciplina.setSemestre(rs.getString("semestre"));
            ds.add(disciplina);
        }

        return ds;
    }
}
