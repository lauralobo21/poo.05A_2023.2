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
// 1.Fiz os métodos, mas não entendi nada da main.
// 2.Fiz de acordo com o professor.
// 3.Aprendi melhor sobre os gets e sets
// 4.Levei 2h, o horário da aula.
package relogioM;

import java.util.*;
class Time {
    private int hour ;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);

    }

    public void setHour(int hour) {
        if(hour < 0 || hour > 23) {
            System.out.println("fail: hora invalida");
        } else {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if(minute < 0 || minute > 59) {
            System.out.println("fail: minuto invalido");
        } else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if(second < 0 || second > 59) {
            System.out.println("fail: segundo invalido");
        } else {
            this.second = second;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void nextSecond(){
        second++;
        if(second > 59){
            second = 0;
            minute++;
            if(minute > 59){
                minute = 0;
                hour++;
                if(hour > 23){
                    hour = 0;
                }
            }
        }

    }
    public String toString(){
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}

 class Solver {
    public static void main(String[] a){
        Time time = new Time(0, 0, 0);

        while(true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if(args[0].equals("end")){
                break;
            }
            else if(args[0].equals("show")){
                System.out.println(time);
            }
            else if(args[0].equals("next")){
                time.nextSecond();
            }
            else if(args[0].equals("set")){
                time.setHour((int)number(args[1]));
                time.setMinute((int)number(args[2]));
                time.setSecond((int)number(args[3]));
            }
            else if(args[0].equals("init")){
                time = new Time((int)number(args[1]), (int)number(args[2]), (int)number(args[3]));
            }
            else {
                write("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String input(){
        return scanner.nextLine();
    }
    private static double number(String value){
        return Double.parseDouble(value);
    }
    private static void write(String value){
        System.out.println(value);
    }
}
