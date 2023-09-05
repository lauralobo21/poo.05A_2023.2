package qtsDentroM;

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
// 1.Fiz de acordo com o que o professor fez
// 2.Fiz com o professor
// 3.Não compreendi a questão.
// 4.Levei 2h. O horário da aula.

import java.util.Scanner;
import java.lang.Math;

class Ponto {
    float x;
    float y;
    
    void ler() {
        x = QuantosDentro.scan.nextFloat();
        y = QuantosDentro.scan.nextFloat();
    }
    
    float distancia( Ponto p ) {
        float cH = this.x - p.x;
        float cV = this.y - p.y;
        float dist = (float) Math.sqrt( cH*cH + cV*cV );
        return dist;
    }
    
    boolean dentro( Circulo c ) {
        if ( this.distancia( c.centro ) <= c.raio ) {
            return true;
        } else {
            return false;
        }
    }
}

class Circulo {
    Ponto centro;
    float raio;
    
    void ler() {
        this.centro = new Ponto();
        this.centro.x = QuantosDentro.scan.nextFloat();
        this.centro.y = QuantosDentro.scan.nextFloat();
        this.raio = QuantosDentro.scan.nextFloat();
    }

    boolean contem( Ponto p ) {
        if ( p.distancia( this.centro ) <= this.raio ) {
            return true;
        } else {
            return false;
        }
    }
    
    int quantosDentro( Ponto vetor[] ) {
        int cont = 0;
        for ( Ponto p : vetor ) {
            if ( this.contem( p ) ) {
            // if ( p.dentro( this ) ) {
                cont++;
            }
        }
        return cont;
    }
}

class QuantosDentro {
    public static void main( String args[] ) {
        int n = scan.nextInt();
        
        Ponto vetor[] = new Ponto[n];
        for (int i=0; i<n; i++) {
            vetor[i] = new Ponto();
            vetor[i].ler();
        }
        
        Circulo c = new Circulo();
        c.ler();
        
        System.out.println( c.quantosDentro( vetor ) );
    }
    
    static Scanner scan = new Scanner(System.in);
}
    
    
    
    
    
    
    