package impressaoM;

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
// 1.Não fiz quase nada. Ainda não tinha um bom conhecimento no assunto.
// 2.O professor fez.
// 3.Aprendi a printar.
// 4.O horário da aula(2h)


import java.util.Scanner;


class impressao {
    public static void main(String[] arg){
        Scanner in = new Scanner(System.in);
        
        String nome = in.nextLine();
        int matr = Integer.parseInt( in.nextLine() );
        String disc = in.nextLine();
        float nota = Float.parseFloat( in.nextLine() );
        
        
        System.out.println("Nome = " + nome);
        System.out.println("Matrícula = " + matr);
        System.out.println("Disciplina = " + disc);
        System.out.println("Nota = " + nota);
        
    }
}