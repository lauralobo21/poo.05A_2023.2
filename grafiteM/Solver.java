/* 
O que fez?
Se fez tudo, passando em todos os testes, ou se fez parcial (qual parte fez).
Com quem fez?
Se fez sozinho ou se fez com alguém(quem) e como foi a divisão do trabalho.
O que aprendeu?
Se aprendeu não aprendeu o que a tarefa propõe ou tem partes que você não é capaz de refazer.
Quanto tempo levou?
Juntando estudo e codificação. */

// 1. Fiz a construção inical do programa
// 2. Fiz junto com o professor na sala.
// 3. 
// 4.

package grafiteM;

import java.text.DecimalFormat;
import java.util.Scanner;

class Lead {
    private float thickness;
    private String hardness;
    private int size;

//Construtor ------------------------------
    public Lead(float thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

//Metodo ----------------------------------
    public int usagePerSheet() {
        if(hardness.equals("HB"))
            return 1;
        else if(hardness.equals("2B"))
            return 2;
        else if(hardness.equals("4B"))
            return 4;
        else 
            return 6; 
    }

//gets--------------------------------  
    public String getHardness() {
        return hardness;
    }
    public int getSize() {
        return size;
    }
    public float getThickness() {
        return thickness;
    }

//set -------------------------------
    public int setSize() {
        return this.size;
    }
    
//toString ----------------------------
    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
    }
}

//---------------- PENCIL -------------------
class Pencil {
    private float thickness;
    private Lead tip;

//Construtor ----------------------------
    public Pencil(float thickness) {
        this.thickness = thickness;
        this.tip = null;
    }
//Metodos --------------------------------
    public boolean hasGrafite() {

    }
    public boolean insert(Lead lead) {

    }
    public Lead remove() {
        if(!this.hasGrafite()) {
            System.out.println("fail: nao existe grafite");
            return null;
        } else {
            Lead grafite = this.tip;
            this.tip = null;
            return grafite;
        }
    }
    public void writePage() {
        if(!this.hasGrafite()) {
            System.out.println("fail: nao exite grafite");
            return;
        }
        if(this.tip.getSize() <= 10) {
            System.out.println("fail: tamanho insuficente");
            return;
        }
    }

    public String toString() {
        String saida = "calibre: " + this.thickness + ", grafite: ";
        if(tip != null) {
            saida += "[" + tip + "]";
        } else {
            saida += "null";
        }
        return saida;
    }
}

public class Solver {
    
}
