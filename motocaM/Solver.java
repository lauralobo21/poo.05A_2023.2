package motocaM;
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
// 1.Fiz quase toda, menos a main toda;
// 2.Fiz com ajuda do monitor
// 3.Aprendi a lógica de alguns métodos e mais um pouco da main;
// 4.Levei 2h30min

import java.util.*;

class Person {
    private int age;
    private String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + ":" + this.age;
    }
}

class Motorcycle {
    private Person person;
    private int power;
    private int time;

    // Construtor -----------------------------
    public Motorcycle(int power) {
        this.power = power;
        this.time = 0;
        this.person = null;
    }

    public boolean insertPerson(Person person) {
        if(this.person != null) {
            System.out.println("fail: busy motorcycle");
            return false;
        } else {
            this.person = person; 
            return true;
        }
    }
    
    public Person remove() {
        if (this.person == null) {
            System.out.println("fail: empty motorcycle");
            return null;
        }
        else {
            Person removedPerson = this.person;
            this.person = null;
            return removedPerson;
        }
    }

    public void buyTime(int time) {
        this.time += time;
    }

    public void drive(int time) {
        if(this.time == 0) {
            System.out.println("fail: buy time first");
            return;
        }
        if (this.person == null) {
            System.out.println("fail: empty motorcycle"); return;
        }
        
        if(this.person.getAge() <= 10) {
            if(time > this.time) {
                System.out.println("fail: time finished after " + this.time + " minutes");
                this.time = 0;
            } else {
                this.time -= time;
            }
        } else {
            System.out.println("fail: too old to drive");
        }
    }

    public void honk() {
        String saida = "P";
        for(int i = 0; i<this.power; i++) {
            saida += "e";
        } saida += "m";
        System.out.println(saida);
    }

    public Person getPerson() {
        return person;
    }

    public int getPower() {
        return power;
    }

    public int getTime() {
        return time;
    }

    public String toString() {
        return "power:" + this.power + ", time:" + this.time + ", person:(" + ((this.person == null) ? "empty" : person) + ")" ;
        
    }

}


class Solver {
    static Motorcycle motoca = new Motorcycle(1);

    public static void main(String[] args) {
        while(true) {
            String line = input();
            args = line.split(" ");
            write('$' + line);

            if      (args[0].equals("show"))    {System.out.println(motoca);}
            else if (args[0].equals("init"))    {motoca = new Motorcycle(number(args[1]));}
            else if (args[0].equals("buy"))     {motoca.buyTime(number(args[1]));}
            else if (args[0].equals("honk"))    {motoca.honk();}
            else if (args[0].equals("drive"))   {motoca.drive(number(args[1]));}
            else if (args[0].equals("enter"))   {motoca.insertPerson(new Person(args[1], number(args[2])));}
            else if (args[0].equals("end"))     {break;}
            else if (args[0].equals("leave"))   {
                Person person = motoca.remove();
                if(person != null) {
                    System.out.println(person.toString());
                }
            }
            else { System.out.println("fail: comando invalido"); }
        }
        scanner.close();
    }
    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void write(String value) {
        System.out.println(value);
    }

    public static int number(String str) {
        return Integer.parseInt(str);
    }
}
