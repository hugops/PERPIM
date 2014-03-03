/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.perpim.control;

import br.ufu.facom.frameworkpim.control.StickyNotesControl;
import br.ufu.facom.frameworkpim.model.StickyNote;
import br.ufu.facom.frameworkpim.view.StickyNotesIFrame;
import br.ufu.facom.perpim.dao.ConnectionSQLiteDAO;
import br.ufu.facom.perpim.dao.StickyNotesDAO;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class StickyNotesControlImpl implements StickyNotesControl {

    @Override

    public void save(StickyNote snote) {
        try {
            StickyNotesDAO dao = new StickyNotesDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.save(snote, conn);
            conn.closeDB();
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados" + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao salvar o sticky: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: " + e.getMessage());
        }
    }

    @Override
    public void delete(StickyNote snote) {
        try {
            StickyNotesDAO dao = new StickyNotesDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.delete(snote, conn);
            conn.closeDB();
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados" + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao deletar os sticky: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: " + e.getMessage());
        }
    }

    @Override
    public void updateStickyNotePositionInfo(StickyNote snote) {
        try {
            StickyNotesDAO dao = new StickyNotesDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.updatePostion(snote, conn);
            conn.closeDB();
        } catch (ClassNotFoundException ex) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados" + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Problema ao atualizar os stickys: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("Problema ao configurar banco de dados: " + ex.getMessage());
        }
    }

    @Override
    public List<StickyNotesIFrame> buildStickyNotesIFrames() {
        List<StickyNote> snotes = load();
        List<StickyNotesIFrame> stks = new ArrayList<>();

        for (Iterator<StickyNote> it = snotes.iterator(); it.hasNext();) {
            StickyNote snote = it.next();
            stks.add(new StickyNotesIFrame(snote, new StickyNotesControlImpl()));
        }

        return stks;
    }

    public static List<StickyNote> load() {
        try {
            StickyNotesDAO dao = new StickyNotesDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            List<StickyNote> ls = dao.load(conn);
            conn.closeDB();
            return ls;
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados" + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Problema ao carregar os sticky: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: " + e.getMessage());
        }
        return null;
    }
}
