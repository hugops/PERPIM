/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufu.facom.perpim.control;

import br.ufu.facom.perpim.dao.AlunoDAO;
import br.ufu.facom.perpim.dao.ConnectionSQLiteDAO;
import br.ufu.facom.perpim.model.Aluno;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hugo
 */
public class AlunoControl {
    
    public static AlunoControl instance;
    private List<Aluno> alunoList;
    
    private AlunoControl (List<Aluno> aluno){
        this.alunoList = aluno;
    }
    
    public static AlunoControl getInstance() {
        if (instance == null){
            instance = new AlunoControl(load());
        }
        return instance;
    }
    
    public static List<Aluno> getAlunoList() {
        return getInstance().alunoList;
    }
    
    public static void save (Aluno aluno){
        try {
            AlunoDAO dao = new AlunoDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.save(aluno, conn);
            conn.closeDB();
            AlunoControl.getAlunoList().add(aluno);
        } catch (SQLException e) {
            System.err.println("Problema ao salvar aluno: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    public static void update (Aluno aluno){
        try {
            AlunoDAO dao = new AlunoDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.update(aluno, conn);
            conn.closeDB();
            AlunoControl.getAlunoList().add(aluno);
        } catch (SQLException e) {
            System.err.println("Problema ao salvar aluno: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    public static List<Aluno> load (){
        try {
            AlunoDAO dao = new AlunoDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            List<Aluno> alunoList = dao.load(conn);
            conn.closeDB();
            return alunoList;
        } catch (SQLException e) {
            System.err.println("Problema ao recuperar info. de aluno: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        return new ArrayList<>();
    }
    
    public static List<Aluno> findByDisciplina (String disciplina){
        try {
            AlunoDAO dao = new AlunoDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            List<Aluno> alunoList = dao.findByDisciplina(disciplina,conn);
            conn.closeDB();
            return alunoList;
        } catch (SQLException e) {
            System.err.println("Problema ao recuperar info. de aluno: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        return new ArrayList<>();
    }
}
