package animalM;
/* 
O que fez?
Se fez tudo, passando em todos os testes, ou se fez parcial (qual parte fez).
Com quem fez?
Se fez sozinho ou se fez com alguém(quem) e como foi a divisão do trabalho.
O que aprendeu?
Se aprendeu não aprendeu o que a tarefa propõe ou tem partes que você não é capaz de refazer.
Quanto tempo levou?
Juntando estudo e codificação. */

// 1.Fiz tudo, mas a main fiz com o auxílio do vídeo;
// 2.Fiz sozinha
// 3.Aprendi como constrói e funciona a main
// 4.Levei 1h;
import java.util.Scanner;

//import javax.sound.midi.Soundbank;

class Animal {
    public String especie;
    public String barulho;
    public int idade;


    public Animal(String especie, String barulho) {
        this.especie = especie;
        this.barulho = barulho;
        this.idade = 0;
    }

    public String fazerBarulho() {
        if (idade == 0) {
            return "---";
        }
        if (idade == 4) {
            return "RIP";
        }
        return this.barulho;
    }

    public void envelhecer(int nivel) {
        idade += nivel;
        if (idade >= 4) {
            System.out.printf("warning: %s morreu%n, especie");
            idade = 4;
        }
    }

    public String toString() {
        return String.format("%s:%d:%s", especie, idade, barulho);
    }
}

public class Solverr {
    public static void main(String[] _args) {
        Animal animal = new Animal("", "");

        while(true) {
            String line = input(); //le a linha inteira
            String[] args = line.split(" "); //split quebra a linha em palavras
            write("$" + line); //escreve a linha

            if (args[0].equals("init")) {
                animal = new Animal(args[1], args[2]);
            } else if (args[0].equals("grow")) {
                animal.envelhecer((int) number(args[1]));
            } else if (args[0].equals("noise")) {
                write(animal.fazerBarulho());
            } else if (args[0].equals("show")) {
                write(animal.toString());
            } else if (args[0].equals("end")) {
                break;      //faz um pro end  e outro pro fail
            } else {
                write("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static String input()            {return scanner.nextLine();}
    public static void write(String value)  {System.out.println(value);}
    public static double number(String str) {return Double.parseDouble(str);} //sempre converte pra double
}
