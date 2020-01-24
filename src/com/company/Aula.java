package com.company;

import java.util.Scanner;

public class Aula {

    Scanner teclat = new Scanner(System.in);

    private String aulaNom;
    private int capacitat;
    private Alumne[] llistatAlumnes;
    private int firstFree = 0;

    public Aula(String aulaNom, int capacitat) {
        this.aulaNom = aulaNom;
        this.capacitat = capacitat;
        llistatAlumnes = new Alumne[capacitat];
    }

    public String getNom() {
        return aulaNom;
    }
    public int getCapacitat() { return capacitat;}

    //atributs i funcions propies del llistat d'alumnes


    public void updateFirstFree() {
        boolean trobat = false;
        int index = 0;
        while (index < capacitat && !trobat) {
            if (llistatAlumnes[index] != null) {
                index++;
            }
            else if (llistatAlumnes[index] == null) {
                trobat = true;
                firstFree = index;
            }
        }
        if (!trobat) {
            firstFree = capacitat; // amb això aconseguim delimitar la capacitat
        }
    }

    public int trobarMatricula(int matriculaBuscada) {
        boolean trobat = false;
        int index = 0;
        int posicioMatriculaBuscada = -1;

        while (index < capacitat && !trobat) {

            if (llistatAlumnes[index] != null && llistatAlumnes[index].getMatricula() == matriculaBuscada) {
                trobat = true;
                posicioMatriculaBuscada = index;
            }
            else {
                index++;
            }
        }
        if (posicioMatriculaBuscada == -1) {
            System.out.print("No s'ha trobat cap coincidencia de matrícula en el llistat. ");
        }
        return posicioMatriculaBuscada;
    }

    public void crearAlumne() {
        if (firstFree == capacitat) {
            System.out.println("S'ha arribat al màxim d'alumnes segons la capacitat.");
        }

        else {
            System.out.println("introdueix el nom del nou alumne: ");
            String nomNouAlumne = teclat.next();
            System.out.println("Introdueix el número de matricula del nou alumne: ");
            int matriculaNouAlumne = teclat.nextInt();

            if (trobarMatricula(matriculaNouAlumne)!= -1 ) {
                System.out.println("la matricula esmentada ja existeix");
            }

            else {
                Alumne nouAlumne = new Alumne(nomNouAlumne,matriculaNouAlumne);
                llistatAlumnes[firstFree] = nouAlumne;
                updateFirstFree();
                System.out.println("S'ha creat l'alumne.");
            }

        }

    }

    public void borrarAlumneMatricula(int matriculaAlumneEsborrar) {
        int posicioAlumneEsborrar = trobarMatricula(matriculaAlumneEsborrar);

        if ( posicioAlumneEsborrar == -1 ) {
           System.out.println("No s'ha pogut esborrar l'alumne.");
        }

        else {
            llistatAlumnes[posicioAlumneEsborrar] = null;
            updateFirstFree();
            System.out.println("S'ha esborrat l'alumne.");
        }
    }

    public void mostrarInfoAlumne(int matriculaAlumneConsulta) {
        int posicioAlumne = trobarMatricula(matriculaAlumneConsulta);
        if (posicioAlumne == -1) {
            System.out.println("No s'ha pogut mostrar la consulta de informació.");
        }

        else {
            System.out.println("Nom: "+llistatAlumnes[posicioAlumne].getNom() );
            System.out.println("Matricula: "+llistatAlumnes[posicioAlumne].getMatricula() );
            System.out.println("Nota: "+llistatAlumnes[posicioAlumne].getNota() );
        }
    }

    public void modificarDadesAlumne(int matriculaAlumneModificar) {

        int posicioAlumne = trobarMatricula(matriculaAlumneModificar);
        if (posicioAlumne == -1 ) {
            System.out.println("No s'ha pogut fer cap modificació.");
        }

        else {
            System.out.println("Introdueix quina vols que sigui la nova matricula: ");
            int novaMatricula = teclat.nextInt();
            if ( trobarMatricula(novaMatricula) == -1) {
                llistatAlumnes[posicioAlumne].setMatricula(novaMatricula);
            }
            else if (matriculaAlumneModificar == novaMatricula) {
                System.out.println("La matricula introduida és la mateixa que hi havia previament.");
            }
            else {
                System.out.println("La matricula introduida ja existeix en el sistema.");
            }

            System.out.println("Introdueix quin vols que sigui el nou nom: ");
            llistatAlumnes[posicioAlumne].setNom(teclat.next() );
        }
    }
    public void progresNotaAlumne (int matriculaAlumneProgres) {
        int posicioAlumne = trobarMatricula(matriculaAlumneProgres);
        if (posicioAlumne == -1 ) {
            System.out.println("Aquest alumne no existeix.");
        }

        else {
            System.out.println("Selecciona el que desitges fer amb la nota actual: "+llistatAlumnes[posicioAlumne].getNota() );
            System.out.println("1. Introduir una nova nota, independentment de l'actual.");
            System.out.println("2. Afegir punts a la nota actual.");
            int opcioMenuProgres = teclat.nextInt();
            switch (opcioMenuProgres) {
                case 1:
                    System.out.println("Introdueix la nova nota: ");
                    llistatAlumnes[posicioAlumne].setNota(teclat.nextInt() );
                    break;
                case 2:
                    System.out.println("Introdueix la nota que vols afegir: ");
                    llistatAlumnes[posicioAlumne].addToNota(teclat.nextInt() );
                    break;
            }

            if (llistatAlumnes[posicioAlumne].getNota() >= 10 ) {
                System.out.println("Degut a que l'alumne ha superat un 10 amb la Nota, s'informa que automàticament s'eliminarà del sistema aquest alumne.");
                llistatAlumnes[posicioAlumne] = null;
                updateFirstFree();
            }
        }
    }

    public void mostrarLlistaAlumnes() {

        for (int index = 0; index < capacitat; index++) {
            if (llistatAlumnes[index] != null) {
                System.out.println("Nom: " + llistatAlumnes[index].getNom()
                        + " -- Matricula: " + llistatAlumnes[index].getMatricula()
                        + " -- Nota: " + llistatAlumnes[index].getNota());
            }
        }
    }
}
