package junkfoodM;
/* 
O que fez?
Se fez tudo, passando em todos os testes, ou se fez parcial (qual parte fez).
Com quem fez?
Se fez sozinho ou se fez com alguém(quem) e como foi a divisão do trabalho.
O que aprendeu?
Se aprendeu não aprendeu o que a tarefa propõe ou tem partes que você não é capaz de refazer.
Quanto tempo levou?
Juntando estudo e codificação. */

// 1. Fiz a construção e a lógica inicial
// 2. Fiz com ajuda do monitor
// 3. Aprendi mais sobre ArrayList
// 4. Fiz em 2h30

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;

class Slot {
    private String name;
    private float price;
    private int quantity;
    
    public Slot( String name, float price, int quantity ) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() { 
        return this.name; 
    }

    public float getPrice() {
        return this.price; 
    }

    public int getQuantity() {
        return this.quantity; 
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }
    
    public String toString() {
        return String.format("%8s",this.name) + " : " +
        this.quantity + " U : " +
        Solver.decForm.format(this.price) + " RS";
    }
}

class VendingMachine {
    private ArrayList<Slot> slots;
    private float profit;
    private float cash = 0;
    private int capacity;
    
    public VendingMachine(int capacity) {
        this.slots = new ArrayList<>(capacity);
        for(int i = 0; i < capacity; i++) {
            slots.add( new Slot("empty", 0f , 0));
        }
        this.capacity = capacity;
    }

    private boolean indiceInvalido( int ind) {
        if(ind < 0 || ind >= this.slots.size()) {
            return true;
        }
        return false;
    }

    public Slot getSlot(int ind) {
        if(this.indiceInvalido(ind)) {
            return null;
        }
        return this.slots.get(ind);
    }
    
    public float getProfit() {
        return this.profit;
    }
    
    public float getCash() {
        return this.cash;
    }
    
    public void setSlot(int ind, Slot slot) {
        if(indiceInvalido(ind)) { 
            System.out.println("fail: indice nao existe");
        } else {
            this.slots.set(ind, slot);
        }
    }
    
    public void clearSlot(int ind) {
        if(indiceInvalido(ind)) {
            System.out.println("fail: indice nao existe");
        } else {
            this.slots.set(ind, new Slot("empty", 0f, 0));
        }
    }
    
    public void insertCash(float cash) {
        this.cash = getCash() + cash;
    }

    public float withdrawCash() {
        Solver.println("voce recebeu " + Solver.decForm.format(this.cash) + " RS");
        this.cash = 0;
        return 1;
    }
    
    
    public void buyItem(int ind) {
        if(indiceInvalido(ind)) {
            System.out.println("fail: indice nao existe");   
            return;
        }
        if(this.cash < slots.get(ind).getPrice()) {
            System.out.println("fail: saldo insuficiente");
            return;
        }  
        else if(slots.get(ind).getQuantity() == 0) {
            System.out.println("fail: espiral sem produtos");
            return;
        } else {
            this.cash = getCash() - slots.get(ind).getPrice();
            this.profit += slots.get(ind).getPrice();
            this.slots.get(ind).setQuantity(-1);
            System.out.printf("voce comprou um %s\n", slots.get(ind).getName());
            return;  
        }
    }

    public String toString() {
        String s = "saldo: " + Solver.decForm.format(this.cash) + "\n";
        for (int i=0; i<this.slots.size(); i++) {
            Slot slot = this.getSlot(i);
            s += i + " [" + slot + "]\n";
        }
        return s;
    }
}
class Solver {
    public static void main (String[] args) {
        VendingMachine machine = new VendingMachine(0);
        while(true) {
            String linha = input();
            String[] palavras = linha.split(" ");
            println("$" + linha);

            if ( palavras[0].equals("end") ) { break; }
            else if ( palavras[0].equals("init")     ) { machine = new VendingMachine( Integer.parseInt(palavras[1]) ); }
            else if ( palavras[0].equals("show")     ) { print(machine); }
            else if ( palavras[0].equals("set")      ) { machine.setSlot( Integer.parseInt(palavras[1]), new Slot( palavras[2], Float.parseFloat(palavras[4]), Integer.parseInt(palavras[3]) ) ); }
            else if ( palavras[0].equals("limpar")   ) { machine.clearSlot( Integer.parseInt(palavras[1]) ); }
            else if ( palavras[0].equals("comprar")   ) { machine.buyItem( Integer.parseInt(palavras[1]) ); } 
            else if ( palavras[0].equals("troco")    ) { machine.withdrawCash( ); }
            else if ( palavras[0].equals("dinheiro") ) { machine.insertCash( Float.parseFloat(palavras[1]) ); }
            else if ( palavras[0].equals("apurado")  ) { println( "apurado total: " + decForm.format(machine.getProfit()) ); }
            else { println("comando inválido!"); }
        }
    }

    public static Scanner scan = new Scanner(System.in);
    public static String input() { return scan.nextLine(); }
    public static void println(Object str) { System.out.println(str); }
    public static void print(Object str) { System.out.print(str); }
    public static DecimalFormat decForm = new DecimalFormat("0.00");
}
