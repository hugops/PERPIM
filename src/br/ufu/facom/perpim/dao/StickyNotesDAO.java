package br.ufu.facom.perpim.dao;

import br.ufu.facom.frameworkpim.model.StickyNote;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StickyNotesDAO {
    
    public void save (StickyNote snote, ConnectionSQLiteDAO conn) throws SQLException{
        String query = "INSERT INTO sticky_notes (stk_text, stk_xpos, stk_ypos) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, snote.getText());
        ps.setInt(2, snote.getXpos());
        ps.setInt(3, snote.getYpos());
        ps.execute();
    }
    
    public List<StickyNote> load (ConnectionSQLiteDAO conn) throws SQLException {
        String query = "SELECT * FROM sticky_notes;";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return build(rs); 
    }
    
    public void delete (StickyNote snote, ConnectionSQLiteDAO conn) throws SQLException{
        String query = "DELETE FROM sticky_notes WHERE stk_text LIKE ?;";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, snote.getText());
        ps.execute();
    }
    
    public void updatePostion (StickyNote snote, ConnectionSQLiteDAO conn) throws SQLException{
        String query = "UPDATE sticky_notes SET stk_xpos=?, stk_ypos=? WHERE stk_text LIKE ?;";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setInt(1, snote.getXpos());
        ps.setInt(2, snote.getYpos());
        ps.setString(3, snote.getText());
        ps.execute();
    }
    
    private List<StickyNote> build (ResultSet rs) throws SQLException {
        
        List<StickyNote> snotes = new ArrayList<>();
        
        while(rs.next()){
            snotes.add(new StickyNote(rs.getString("stk_text"), 
                    rs.getInt("stk_xpos"), rs.getInt("stk_ypos")));
        }
        
        return snotes;
    }
}
