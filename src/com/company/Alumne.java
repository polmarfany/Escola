package com.company;

public class Alumne {
    private String nom;
    private int matricula;
    private int nota;

    public Alumne(String inputAlumneNom, int inputAlumneMatriclua) {
        this.matricula = inputAlumneMatriclua;
        this.nom = inputAlumneNom;
        this.nota = 1; //default value
    }

    public String getNom() {
        return this.nom;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public int getNota() {
        return this.nota;
    }

    public void setNom(String nouNom) {
        this.nom = nouNom;
    }

    public void setMatricula (int nouMatricula) {
        this.matricula = nouMatricula;
    }

    public void addToNota (int sumaNota) {
        this.nota = this.nota + sumaNota;
    }

    public void setNota (int nouNota) {
        this.nota = nouNota;
    }
}

