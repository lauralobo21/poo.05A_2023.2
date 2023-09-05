package carroM;

import java.util.Scanner;

class Car {
    public int pass;
    public int passMax;
    public int gas;
    public int gasMax;
    public int km;

    public Car() {
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;

    }

    public void enter() {
        this.pass++;
        if(this.pass > this.passMax) {
            System.out.println("Entrada não permitida");
        }
    }

    public void leave() {
        if(this.pass > 0) {
            this.pass--;
        }
        else {
            System.out.println("Não ha ngm no carro");
        }
    }

    public void drive(int value) { //qtd de km que quer andar
        if(gas > 0) {
            if(pass > 0) {
                if(gas >= value) {
                    gas = gas - value;
                    km = km + value;
                }
                else {
                    System.out.println("tanque vazio apos andar" + gas);
                    km += gas;
                    gas = 0;
                }
            }
            else {
                System.out.println("Não ha ngm no carro");
            }
        }
        else {
            System.out.println("nao há gasolina");
        }
    }

    public void fuel(int value) { //qtd de gasolina q quer colocar
        gas = gas + value;
        if(gas > gasMax){
            gas = gasMax;
        }

    }

    public String toString() {
        String texto = "pass: " + pass + ", gas: " + gas + ", km: " + km;
        return texto;
    }

    
}



public class Solver {
    public static void main (String[] a){
         Car car = new Car();
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                }
            else if (args[0].equals("show"))  { System.out.println(car);              }
            else if (args[0].equals("enter")) { car.enter();                          }
            else if (args[0].equals("leave")) { car.leave();                          }
            else if (args[0].equals("drive")) { car.drive((int) number(args[1]));     }
            else if (args[0].equals("fuel"))  { car.fuel((int) number(args[1]));      }
            else                              { write("fail: comando invalido");}
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
    }
