package topicM;
/* 
O que fez?
Se fez tudo, passando em todos os testes, ou se fez parcial (qual parte fez).
Com quem fez?
Se fez sozinho ou se fez com alguém(quem) e como foi a divisão do trabalho.
O que aprendeu?
Se aprendeu não aprendeu o que a tarefa propõe ou tem partes que você não é capaz de refazer.
Quanto tempo levou?
Juntando estudo e codificação. */

// 1.
// 2.
// 3.
// 4.

import java.util.*;
import java.util.stream.*;

class Pass {
    private String name;
    private int age;

    public Pass(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean isPriority() {
        return age >= 65;
    }

    public String getName() {
        return this.name;
    }
    public String toString(){
        return this.name + ":" + this.age;
    }

}

class Topic {
    private List<Pass> prioritySeats;
    private List<Pass> normalSeats;
    
    public Topic(int capacity, int qtdPriority) {
        this.prioritySeats = new ArrayList<>(qtdPriority);
        for(int i = 0; i<qtdPriority - capacity; i++) {
            prioritySeats.add(i, null);
        }
        this.normalSeats = new ArrayList<>(capacity - qtdPriority);
        for(int i = 0; i<qtdPriority - capacity; i++) {
            normalSeats.add(i, null);
        }
    }

    private static int findFirstFreePos(List<Pass> list) {
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i) == null) {
                return i;
            }
        }
        return -1;
    }
    
    private static int findByName(String name, List<Pass> list) {
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
    
    private static boolean insertOnList(Pass pass, List<Pass> list) {
        int i = findFirstFreePos(list);
        if(i == -1) { 
            return false;
        } else {
            list.set(i, pass);
        }
        return true;
    }

    private static boolean removeFromList(String name, List<Pass> list) {
        for(int i = 0; i<list.size(); i++) {
            if(list.get(i).getName().equals(name)) {
                list.set(i, null);
                return true;
            }
        }
        return false;
    }


    public boolean insert(Pass pass) {
        if() {
            
        }
        
    }

    public boolean remove(String name) {
    }
    public String toString() {
        return "[" + Stream.concat(
            this.prioritySeats.stream().map(p -> ("@" + ((p == null)?(""):("" + p)))), 
            this.normalSeats.stream().map(p -> ("=" + ((p == null)?(""):("" + p)))))
            .collect(Collectors.joining(" ")) + "]";
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Topic topic = new Topic(0, 0);
        while(true){
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(line.equals("end")) {
                break;
            } else if(ui[0].equals("init")) { //capacity qtdPriority
                topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
            } else if(ui[0].equals("show")) {
                System.out.println(topic);
            } else if(ui[0].equals("in")) {
                topic.insert(new Pass(ui[1], Integer.parseInt(ui[2])));
            } else if(ui[0].equals("out")) {//value value
                topic.remove(ui[1]);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}