package br.ufu.facom.perpim.model;

public class Disciplina {

    private String ID;
    private String nome;
    private String sala;
    private String semestre;

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    
    public String getID() {
        return ID;
    }

    public Disciplina(String ID, String nome, String sala) {
        this.ID = ID;
        this.nome = nome;
        this.sala = sala;
    }

    public Disciplina() {

    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return  ID;
    }
    

}
