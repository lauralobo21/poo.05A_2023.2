package calculadoraM;
/* O que fez?
Se fez tudo, passando em todos os testes, ou se fez parcial (qual parte fez).
Com quem fez?
Se fez sozinho ou se fez com alguém(quem) e como foi a divisão do trabalho.
O que aprendeu?
Se aprendeu não aprendeu o que a tarefa propõe ou tem partes que você não é capaz de refazer.
Quanto tempo levou?
Juntando estudo e codificação. */


// 1.Feita em sala pelo professor
// 2.Fiz tudo com o professor e a main com ajuda do monitor.
// 3.Aprendi a fazer os métodos do jeito que a questão pedia.
// 4.Levei 2h da aula + 1h com o monitor



import java.util.*;
import java.text.DecimalFormat;

class Calculator {
    public int battery;
    public int batteryMax;
    public float display;

    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0.0f;
    }
    public void chargeBattery(int value) {
        if(value < 0) {
            return;
        }
        this.battery += value;
        if(this.battery > this.batteryMax) {
            this.battery = this.batteryMax;
        }
    }
    
    public boolean useBattery() {
        if(this.battery == 0) {
            System.out.println("fail: bateria insuficiente");
            return false;
        }
        this.battery = this.battery - 1;
            return true;
    }

    public void sum(int a, int b) {
        if(useBattery())
            this.display = (a + b);
        
    }

    public void division(int num, int den) {
        if(!useBattery()) {
            return;
        }
        if(den == 0) {
            System.out.println("fail: divisao por zero");
        } else {
            this.display = (float) num / den;
        }
    }


    public String toString() {
        DecimalFormat form = new DecimalFormat("0.00");
        return "display = " + form.format(this.display).replace(",",".") + ", battery = " + this.battery;
    }
}


class Solver {
    public static void main(String[] a) {
    Calculator calc = new Calculator(0);
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                }
            else if (args[0].equals("init"))  { calc = new Calculator(number(args[1]));}
            else if (args[0].equals("show"))  { System.out.println(calc);              }
            else if (args[0].equals("charge")) { calc.chargeBattery(number(args[1]));    } 
            else if (args[0].equals("sum")) { calc.sum(number(args[1]), number(args[2]));}
            else if (args[0].equals("div")) { calc.division(number(args[1]), number(args[2]));}
            else                              { write("fail: comando invalido");}
        }
        scanner.close();
    }

    static Scanner scanner = new Scanner(System.in);
    static String  input()              { return scanner.nextLine(); }
    static int number(String value) { return Integer.parseInt(value); }
    static void    write(String value)  { System.out.println(value); }
}

