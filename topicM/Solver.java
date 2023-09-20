package topicM;

import java.lang.reflect.Array;
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
        this.prioritySeats = new LinkedList<Pass>();
        this.normalSeats = new LinkedList<Pass>();
    }

    private static int findFirstFreePos(List<Pass> list) {
        return 0;
    }
    
    private static int findByName(String name, List<Pass> list) {
        return 0;
    }
    
    private static boolean insertOnList(Pass pass, List<Pass> list) {
        return false;
    }

    private static boolean removeFromList(String name, List<Pass> list) {
        return false;
    }


    public boolean insert(Pass pass) {
        return false;
    }

    public boolean remove(String name) {
        return false;
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
        System.out.println("side_by_side=100");
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
