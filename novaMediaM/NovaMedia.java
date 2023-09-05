package novaMediaM;

/* 
O que fez?
Se fez tudo, passando em todos os testes, ou se fez parcial (qual parte fez).
Com quem fez?
Se fez sozinho ou se fez com alguém(quem) e como foi a divisão do trabalho.
O que aprendeu?
Se aprendeu não aprendeu o que a tarefa propõe ou tem partes que você não é capaz de refazer.
Quanto tempo levou?
Juntando estudo e codificação. */

//ATIVIDADE FEITA TODA EM SALA PELO PROFESSOR
// 1.Fiz os atributos e os métodos, mas aida com dificuldade no assunto
// 2.Com o professor
// 3.Aprendi mais sobre a classe main 
// 4.O horário da aula (2h).

import java.util.Scanner;
class Aluno{
    String nome;
    float notas[];
    
    void ler(){
        Scanner scan = new Scanner(System.in);
        this.nome = scan.next();
        this.notas = new float[3];
        for (int i = 0; i<3; i++){
            this.notas[i] = scan.nextFloat();
        }
        scan.close();
    }
    float media(){
        float soma = 0; 
        //for(int i = 0; i<3; i++){
        //  float nota = notas[i];
        //}
        for(float nota : notas){
            soma += nota; 
        }
        return soma/3;
    }
}

class NovaMedia {
    public static void main(String[] args) {
        Aluno a1 = new Aluno();
        a1.ler();
        float med = a1.media();
        System.out.printf("%.2f", med);
    
    }
}