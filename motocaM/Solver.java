package motocaM;

class Person {
    private int age;
    private String name;


    public Person(String name, int age) {

    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    public String toString() {

    }
}

class Motorcycle {
    private Person person;
    private int power;
    private int time;

//Construtor -----------------------------
    public Motorcycle(int power) {
        this.power = 1;
        this.time = 0;
        this.person = (0, 0);
    }

    public boolean insertPerson(Person person) {
        if(this.person < 1) {
            System.out.println("empty");
        }
        else if(this.person > 1)
            System.out.println("fail: busy motorcycle");
        } else {
            this.person = person;
        }
    }
    public Person remove() {
        if(this.person == null) {
            System.out.println();
            return null;
        }
        Person removedPerson = this.person;
        this.person = null;
        return removedPerson;
    }

    public void buyTime(int time) {

    }
    public void drive(int time) {

    }
    public void honk() {

    }
    
//gets ----------------------------------
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
        return "power" + this.power + ", time:" + this.time + 
    }


public class Solver {
    public static void main(String[] args) {

    }
}
