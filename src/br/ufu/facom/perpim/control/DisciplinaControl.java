package br.ufu.facom.perpim.control;

import br.ufu.facom.perpim.dao.ConnectionSQLiteDAO;
import br.ufu.facom.perpim.dao.DisciplinaDAO;
import br.ufu.facom.perpim.model.Disciplina;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Singleton
public class DisciplinaControl {
    
    public static DisciplinaControl instance;
    private List<Disciplina> disciplinas;
    
    private DisciplinaControl (List<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }
    
    public static DisciplinaControl getInstance() {
        if (instance == null){
            instance = new DisciplinaControl(load());
        }
        return instance;
    }
    
    public static List<Disciplina> getDisciplinas() {
        return getInstance().disciplinas;
    }
    
    public static void save (Disciplina disc){
        try {
            DisciplinaDAO dao = new DisciplinaDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.save(disc, conn);
            conn.closeDB();
            DisciplinaControl.getDisciplinas().add(disc);
        } catch (SQLException e) {
            System.err.println("Problema ao salvar disciplina: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    public static void update (String siglaOld,Disciplina disc){
        try {
            DisciplinaDAO dao = new DisciplinaDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            dao.update(siglaOld,disc, conn);
            conn.closeDB();
            DisciplinaControl.getDisciplinas().add(disc);
        } catch (SQLException e) {
            System.err.println("Problema ao salvar disciplina: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
    }
    
    public static List<Disciplina> load (){
        try {
            DisciplinaDAO dao = new DisciplinaDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            List<Disciplina> disciplina = dao.load(conn);
            conn.closeDB();
            return disciplina;
        } catch (SQLException e) {
            System.err.println("Problema ao recuperar info. de disciplina: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        return new ArrayList<>();
    }
    
    public static Disciplina findById (String id){
        try {
            DisciplinaDAO dao = new DisciplinaDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            Disciplina disciplina = dao.findById(id,conn);
            conn.closeDB();
            return disciplina;
        } catch (SQLException e) {
            System.err.println("Problema ao recuperar info. de disciplina: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        return null;
    }
    
   public static ArrayList<String> getListaSemestre(){
       List<Disciplina> listaDisciplina = load();
       ArrayList<String> listaSemestre = new ArrayList<>();
       for(Disciplina d : listaDisciplina){
           if(!listaSemestre.contains(d.getSemestre())){
               listaSemestre.add(d.getSemestre());
           }
       }
       return listaSemestre;
   }
   
    public static List<Disciplina> findBySemestre(String semestre){
       try {
            DisciplinaDAO dao = new DisciplinaDAO();
            ConnectionSQLiteDAO conn = new ConnectionSQLiteDAO();
            List<Disciplina> disciplina = dao.findBySemestre(semestre,conn);
            conn.closeDB();
            return disciplina;
        } catch (SQLException e) {
            System.err.println("Problema ao recuperar info. de disciplina: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Nao foi possivel encontrar plugin do banco de dados"+e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Problema ao configurar banco de dados: "+e.getMessage());
        }
        return new ArrayList<>();
   }
}
