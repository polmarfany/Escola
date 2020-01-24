package com.company;

public class Escola {
    private String escolaNom;
    private Aula aulaUnica;

    public Escola( String escolaNom, String aulaNom, int capacitat)
    {
        this.aulaUnica = new Aula(aulaNom, capacitat);
        this.escolaNom = escolaNom;
    }

    public String getEscolaNom(){
        return escolaNom;
    }

    public Aula getAulaUnica() {
        return aulaUnica;
    }
}
