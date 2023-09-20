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
import java.util.ArrayList;

class Lead {
    private float thickness; //calibre
    private String hardness; //dureza
    private int size; //tamanho em mm

    public Lead(float thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
        // this.setSize( size );
    }

    public float getThickness() {
        return this.thickness;
    }

    public String getHardness() {
        return this.hardness;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

    public String toString() {
        DecimalFormat form = new DecimalFormat("0.0");
        return form.format(thickness) + ":" + hardness + ":" + size;
    }
}


class Pencil {
    private float thickness;
    private Lead tip;

    public Pencil(float thickness) {
        this.thickness = thickness;
        this.tip = null;
    }

    public float getThickness() {
        return this.thickness;
    }

    public void setThickness(float value) {
        this.thickness = value;
    }

    public boolean hasGrafite() {
        // return (this.tip != null);
        if ( this.tip == null ) {
            return false;
        } else {
            return true;
        }
    }

    public boolean insert(Lead grafite) {
        if ( this.hasGrafite() ) {
            System.out.println("fail: ja existe grafite");
            return false;
        } else if ( this.thickness != grafite.getThickness() ) {
            System.out.println("fail: calibre incompativel");
            return false;
        } else {
            this.tip = grafite;
            return true;
        }
    }

    public Lead remove() {
        if ( !this.hasGrafite() ) {
            System.out.println("fail: nao existe grafite a ser removida");
            return null;
        } else {
            Lead grafite = this.tip;
            this.tip = null;
            return grafite;
        }
    }

    public void writePage() {
        if ( !this.hasGrafite() ) {
            System.out.println("fail: nao existe grafite");
            return;
        }
        if ( this.tip.getSize() <= 10 ) {
            System.out.println("fail: tamanho insuficiente");
            return;
        }
        if ( this.tip.getSize() - 10 < this.tip.usagePerSheet() ) {
            System.out.println("fail: folha incompleta");
            this.tip.setSize(10);
            return;
        }

        // this.tip.size -= this.tip.usagePerSheet();
        this.tip.setSize( this.tip.getSize() - this.tip.usagePerSheet() );        
    }
    
    public String toString() {
        String saida = "calibre: " + thickness + ", grafite: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "null";
        return saida;
    }
}

public class Solver {
    public static void main(String[] args) {
        Pencil pencil = new Pencil(0.5f);

        while (true) {
            String line = input();
            String[] argsL = line.split(" ");
            write('$' + line);

            if      ("end".equals(argsL[0])   ) { break;                                                                    }
            else if ("init".equals(argsL[0])  ) { pencil = new Pencil(number(argsL[1]));                                       }
            else if ("insert".equals(argsL[0])) { pencil.insert(new Lead(number(argsL[1]), argsL[2], (int) number(argsL[3]))); }
            else if ("remove".equals(argsL[0])) { pencil.remove();                                                             }
            else if ("write".equals(argsL[0]) ) { pencil.writePage();                                                          }
            else if ("show".equals(argsL[0])  ) { write(pencil.toString());                                                               }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input()           { return scanner.nextLine();    }
    public static void write(String value) { System.out.println(value);    }
    public static float number(String str) { return Float.parseFloat(str); }
}

