package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Benvinguts al creador de llistes d'alumnes. Es començara per la creació de l'escola i la seva unica aula.");

        System.out.print("Introdueix el nom de la nova escola que es vol crear: ");
        String nomEscola = teclat.next();
        System.out.print("Introdueix el nom de l'aula: ");
        String nomAula = teclat.next();
        System.out.print("Introdueix la capacitat de l'aula: ");
        int capacitat = teclat.nextInt();

        Escola novaEscola = new Escola(nomEscola, nomAula, capacitat);

        int opcioMenu = 0;

        while (opcioMenu != 7) {
            System.out.println("");
            System.out.println("");
            System.out.println("Introdueix el número de l'acció que vols realitzar: ");
            System.out.println("1. Donar d'alta un alumne");
            System.out.println("2. Donar de baixa un alumne");
            System.out.println("3. Fer progressar un alumne");
            System.out.println("4. Modificar les dades d'un alumne");
            System.out.println("5. Mostrar totes les dades d'un alumne");
            System.out.println("6. Mostrar totes les dades de l'escola");
            System.out.println("7. Exit");
            System.out.println(" ");
            opcioMenu = teclat.nextInt();

            switch (opcioMenu) {
                case 1:
                    novaEscola.getAulaUnica().crearAlumne();
                    break;

                case 2:
                    System.out.println("Introdueix la matrícula de l'alumne a esborrar: ");
                    int matriculaEsborrarAlumne = teclat.nextInt();
                    novaEscola.getAulaUnica().borrarAlumneMatricula(matriculaEsborrarAlumne);
                    break;

                case 3:
                    System.out.println("Introdueix la matrícula de l'alumne a progressar: ");
                    novaEscola.getAulaUnica().progresNotaAlumne(teclat.nextInt() );
                    break;

                case 4:
                    System.out.println("Introdueix la matricula de l'alumne que es vol modificar les dades: ");
                    novaEscola.getAulaUnica().modificarDadesAlumne(teclat.nextInt() );
                    break;

                case 5:
                    System.out.println("Introdeux la matricula de l'alumne que es vol consultar les dades: ");
                    novaEscola.getAulaUnica().mostrarInfoAlumne(teclat.nextInt() );
                    break;

                case 6:
                    System.out.println("Escola: "+ novaEscola.getEscolaNom() );
                    System.out.println("Aula: "+ novaEscola.getAulaUnica().getNom() +" -- Capacitat: "+novaEscola.getAulaUnica().getCapacitat() );
                    novaEscola.getAulaUnica().mostrarLlistaAlumnes();
                    break;

            }

        }
    }
}

