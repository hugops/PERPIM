/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufu.facom.perpim.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Hugo
 */
public class AlunoTableModel extends AbstractTableModel {

    private List<Aluno> listaAluno;
    
    public AlunoTableModel(){
        listaAluno = new ArrayList<>();
    }
    
    public AlunoTableModel(List<Aluno> listaAluno){
        this();
        this.listaAluno.addAll(listaAluno);
    }

    public List<Aluno> getListaAluno() {
        return listaAluno;
    }

    public void setListaAluno(List<Aluno> listaAluno) {
        this.listaAluno = listaAluno;
    }
    
    @Override
    public int getRowCount() {
        return listaAluno.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return listaAluno.get(rowIndex).getMatricula();
            case 1:
                return listaAluno.get(rowIndex).getNome();
            case 2:
                return listaAluno.get(rowIndex).getNota();
        }
        return null;
    }
    
    @Override  
    public String getColumnName(int coluna) {  
        // vamos retornar o nome de cada coluna  
        switch (coluna) {  
        case 0:  
            return "Matricula"; // o nome da primeira coluna  
        case 1:  
            return "Nome"; // o nome da segunda  
        case 2:  
            return "Nota"; // e o da terceira  
        default:  
            return ""; // isso nunca deve ocorrer, pois temos só 3 colunas  
        }  
    }  
    
}
