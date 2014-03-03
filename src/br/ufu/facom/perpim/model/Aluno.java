/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufu.facom.perpim.model;

/**
 *
 * @author Hugo
 */
public class Aluno {
    
    private Integer id;
    private String nome;
    private String matricula;
    private float nota;
    private Disciplina disciplina;

    public Aluno(String nome, String matricula, float nota, Disciplina disciplina) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
        this.disciplina = disciplina;
    }

    public Aluno() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    
    
}
