/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufu.facom.perpim.dao;

import br.ufu.facom.perpim.control.DisciplinaControl;
import br.ufu.facom.perpim.model.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class AlunoDAO {

    public void save(Aluno aluno, ConnectionSQLiteDAO conn) throws SQLException {
        String query = "INSERT INTO alunos "
                + "(nome,matricula,fk_disc_id,nota)" + "VALUES(?, ?, ?, ?);";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getMatricula());
        ps.setString(3, aluno.getDisciplina().getID());
        ps.setFloat(4, aluno.getNota());
        ps.execute();
    }

    public void update(Aluno aluno, ConnectionSQLiteDAO conn) throws SQLException {
        String query = "UPDATE alunos set nota = ? ,nome = ? ,matricula = ? ,fk_disc_id = ? WHERE _id = ?";
        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ps.setFloat(1, aluno.getNota());
        ps.setString(2, aluno.getNome());
        ps.setString(3, aluno.getMatricula());
        ps.setString(4, aluno.getDisciplina().getID());
        ps.setFloat(5, aluno.getId());
        ps.execute();
    }

    public List<Aluno> load(ConnectionSQLiteDAO conn) throws SQLException {
        String query = "SELECT * FROM alunos ";

        return findWithQuery(query, conn);
    }

    public List<Aluno> findByDisciplina(String disciplina, ConnectionSQLiteDAO conn) throws SQLException {
        String query = "SELECT * FROM alunos WHERE fk_disc_id = '" + disciplina + "'";

        return findWithQuery(query, conn);
    }

    public List<Aluno> findWithQuery(String query, ConnectionSQLiteDAO conn) throws SQLException {

        PreparedStatement ps = conn.getDBConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        List<Aluno> ds = new ArrayList<>();
        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setId(rs.getInt("_id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setMatricula(rs.getString("matricula"));
            aluno.setNota(rs.getFloat("nota"));
            aluno.setDisciplina(DisciplinaControl.findById(rs.getString("fk_disc_id")));
            ds.add(aluno);
        }

        return ds;
    }

}
