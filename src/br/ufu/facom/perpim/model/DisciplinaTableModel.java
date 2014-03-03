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
public class DisciplinaTableModel extends AbstractTableModel {  
    
    private List<Disciplina> listaDisciplina;

    public DisciplinaTableModel(){
         this.listaDisciplina = new ArrayList<>();
    }
    
    public DisciplinaTableModel(List<Disciplina> listaDisciplina) {
        this();
        this.listaDisciplina.addAll(listaDisciplina);
    }

    public List<Disciplina> getListaDisciplina() {
        return listaDisciplina;
    }

    public void setListaDisciplina(List<Disciplina> listaDisciplina) {
        this.listaDisciplina = listaDisciplina;
    }
    
    @Override
    public int getRowCount() {
        return listaDisciplina.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            case 0:
                return listaDisciplina.get(rowIndex).getID();
            case 1:
                return listaDisciplina.get(rowIndex).getNome();
            case 2:
                return listaDisciplina.get(rowIndex).getSemestre();
        }
        return null;
    }

    @Override  
    public String getColumnName(int coluna) {  
        // vamos retornar o nome de cada coluna  
        switch (coluna) {  
        case 0:  
            return "Id"; // o nome da primeira coluna  
        case 1:  
            return "Nome"; // o nome da segunda  
        case 2:  
            return "Semestre"; // e o da terceira  
        default:  
            return ""; // isso nunca deve ocorrer, pois temos só 3 colunas  
        }  
    }  
 
}
