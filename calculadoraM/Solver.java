package calculadoraM;

import java.util.*;
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
            System.out.println("fail: divisao pro zero");
        } else {
            this.display = (float) num / den;
        }
    }


    public String toString() {
        System.out.println("display: " + this.display + "bateria: " + this.battery);
    }



public class Solver {
    public static void main(String[] a) {
    Calculator calc = new Calculator(0);
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                }
            else if (args[0].equals("show"))  { System.out.println(calc);              }
            else if (args[0].equals("init")) { calc.();                          }
            else if (args[0].equals("leave")) { calc.leave();                          }
            else if (args[0].equals("drive")) { calc.drive((int) number(args[1]));     }
            else if (args[0].equals("charge V"))  { calc.fuel((int) number(args[1]));      }
            else                              { write("fail: comando invalido");}
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
    }

