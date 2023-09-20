package lapiseiraM;

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
    private ArrayList<Lead> barrel;

    public Pencil(float thickness) {
        this.thickness = thickness;
        this.tip = null;
        this.barrel = new ArrayList<Lead>();
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
        if ( this.thickness != grafite.getThickness() ) {
            System.out.println("fail: calibre incompatível");
            return false;
        } else {
            this.barrel.add(grafite);
            return true;
        }
    }

    public boolean pull() {
        if(this.hasGrafite()) {
            System.out.println("fail: ja existe grafite no bico");
            return false;
        } else if(this.barrel.isEmpty()) {
            System.out.println("fail: não existe grafite no tambor");
            return false;
        } else {
            //this.tip = this.barrel.get(0);
            //this.barrel.remove(0);

            this.tip = this.barrel.remove(0);
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
            System.out.println("fail: nao existe grafite no bico");
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
        String saida = "calibre: " + thickness + ", bico: ";
        if (tip != null)
            saida += "[" + tip + "]";
        else
            saida += "[]";
            saida += ", tambor: {";
            for(Lead elem : this.barrel) {
                saida += "[" + elem + "]";
            }
            saida += "}";
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

            if      ("end".equals(argsL[0])   ) { break;                                                                       }
            else if ("init".equals(argsL[0])  ) { pencil = new Pencil(number(argsL[1]));                                       }
            else if ("insert".equals(argsL[0])) { pencil.insert(new Lead(number(argsL[1]), argsL[2], (int) number(argsL[3]))); }
            else if ("pull".equals(argsL[0])) { pencil.pull();                                                                 }
            else if ("remove".equals(argsL[0])) { pencil.remove();                                                             }
            else if ("write".equals(argsL[0]) ) { pencil.writePage();                                                          }
            else if ("show".equals(argsL[0])  ) { write(pencil.toString());                                                    }
            else  {write("comando inválido");}                                                          
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input()           { return scanner.nextLine();    }
    public static void write(String value) { System.out.println(value);    }
    public static float number(String str) { return Float.parseFloat(str); }
}





