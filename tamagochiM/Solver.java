/* 
O que fez?
Se fez tudo, passando em todos os testes, ou se fez parcial (qual parte fez).
Com quem fez?
Se fez sozinho ou se fez com alguém(quem) e como foi a divisão do trabalho.
O que aprendeu?
Se aprendeu não aprendeu o que a tarefa propõe ou tem partes que você não é capaz de refazer.
Quanto tempo levou?
Juntando estudo e codificação. */

// 1.Fiz a construção de quase tudo, menos a main e a lógica de alguns sets;
// 2.Fiz com ajuda do vídeo da resolução;
// 3.Aprendi a lógica do método construtivo, gets, sets;
// 4.Levei 2h da aula + 2h de estudo;
package tamagochiM; 
import java.util.*;
    class Pet {
        //geralmente os atributos são privados
        private boolean alive;
        private int clean;
        private int cleanMax;
        private int energy;
        private int energyMax;
        private int hungry;
        private int hungryMax;
        private int age;
        private int diamonds;
        
        //MÉTODO CONSTRUTOR
        public Pet(int energy, int hungry, int clean){
            this.energyMax = energy;
            this.hungryMax = hungry;
            this.cleanMax = clean;

            this.energy = energy;
            this.hungry = hungry;
            this.clean = clean;

            this.diamonds = 0;
            this.age = 0;
            this.alive = true;
        }

        //Get and Set dos Atributos ---------------------------------------------------
       
        public void setAlive(boolean alive) {
            this.alive = alive;
        }
        
        public void setClean(int clean) {
            if(clean <= 0) {
                this.clean = 0;
                this.alive = false;
                System.out.println("fail: pet morreu de sujeira");
            } else if(clean > this.cleanMax) {
                this.clean = this.cleanMax;
            } else {
                this.clean = clean;
            }
        }
       
        public void setCleanMax(int cleanMax) {
            this.cleanMax = cleanMax;
        }
        
        public void setEnergy(int energy) {
            if(energy <= 0) {
                this.energy = 0;
                System.out.println("fail: pet morreu de fraqueza");
                this.alive = false;
                return;
            } else if(energy > this.energyMax) {
                this.energy = this.energyMax;
            } else {
                this.energy = energy;
            }
        }
        
       public void setEnergyMax(int energyMax) {
            this.energyMax = energyMax;
        }
        
        public void setHungry(int hungry) {
            if(hungry < 0) {
                this.hungry = 0;
                System.out.println("fail: pet morreu de fome");
                this.alive = false;
            } else if(hungry > this.hungryMax) {
                this.hungry = this.hungryMax;
            } else {
                this.hungry = hungry;
            }
        }
        
        public void setHungryMax(int hungryMax) {
            this.hungryMax = hungryMax;
        }
        
        public void setAge(int age) {
            this.age = age;
        }
        
         public void setDiamonds(int diamonds) {
            this.diamonds = diamonds;
        }
        
        public int getDiamonds() {
            return diamonds;
        }
        public int getAge() {
            return age;
        }
        public int getHungryMax() {
            return hungryMax;
        }
        public int getHungry() {
            return hungry;
        }
        public int getEnergyMax() {
            return energyMax;
        }
        public int getEnergy() {
            return energy;
        }
        public int getCleanMax() {
            return cleanMax;
        }
        public int getClean() {
            return clean;
        }
        public boolean getAlive() {
            return alive;
        }

        // MÉTODOS --------------------------------------------------------------------------
        public String toString(){
        String ss = "";
        ss +=  "E:" + energy + "/" + energyMax + ", "
            +  "S:" + hungry + "/" + hungryMax + ", "
            +  "L:" + clean + "/" + cleanMax + ", "
            +  "D:" + diamonds + ", " + "I:"  + age;
        return ss;
    }
        
        private boolean testAlive() {
            if(!this.alive) {
                System.out.println("fail: pet esta morto");
            return false; 
            } return true;
        }

        public void eat() {
            if(!testAlive())
                return;
            this.setEnergy(getEnergy() - 1);
            this.setHungry(getHungry() + 4);
            this.setClean(getClean() - 2);
            this.diamonds = this.diamonds + 0;
            this.age = this.age + 1;
        }

        public void play() {
            if(!testAlive())
                return;
            else {
            this.setEnergy(getEnergy() - 2);
            this.setHungry(getHungry() - 1);
            this.setClean(getClean() - 3);
            this.diamonds = this.diamonds + 1;
            this.age = this.age + 1;
            }
        }

        public void shower() {
            if(!testAlive())
                return;
            else {
            this.setEnergy(getEnergy() - 3);
            this.setHungry(getHungry() - 1);
            this.setClean(this.cleanMax);
            this.age = this.age + 2;
            }
        }

        public void sleep() {
             if(!testAlive())
                return;
            if(this.energyMax - this.energy < 5) {
                System.out.println("fail: nao esta com sono");
                return;
            }
            this.age += this.energyMax - this.energy;
            this.setEnergy(this.energyMax);
            this.setHungry(getHungry() - 1);
        }
    }

public class Solver {
    public static void main(String[] a) {
        Pet pet = new Pet(0, 0, 0);
        
        while (true) {
            var line = input();
            write("$" + line);
            var args = line.split(" ");

            if      (args[0].equals("end"))   { break;                                                                           }
            else if (args[0].equals("show"))  { write(pet.toString());                                                           }
            else if (args[0].equals("init"))  { pet = new Pet((int)number(args[1]), (int)number(args[2]), (int)number(args[3])); }
            else if (args[0].equals("play"))  { pet.play();                                                                      }
            else if (args[0].equals("eat"))   { pet.eat();                                                                       }
            else if (args[0].equals("sleep")) { pet.sleep();                                                                     }
            else if (args[0].equals("shower")){ pet.shower();                                                                    }
            else                              { write("fail: comando invalido");                                                 }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
    private static String  input()              { return scanner.nextLine(); }
    private static double  number(String value) { return Double.parseDouble(value); }
    private static void    write(String value)  { System.out.println(value); }
}
