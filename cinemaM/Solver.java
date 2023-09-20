package cinemaM;

import java.util.*;
class Client {
    private String id;
    private String fone;
    public Client(String id, String fone) {
        this.id = id;
        this.fone = fone;
    }
    public String getFone() {
        return this.fone;
    }
    public String getId() {
        return this.id;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String toString() {
        return id + ":" + fone;
    }
}

class Sala {
    private List<Client> cadeiras;

    private int procurar(String nome) {

    }
    private boolean verificarIndice(int indice) {

    }

    public Sala(int capacidade) {

    }
    public boolean reservar(String id, String fone, int ind) {

    }
    public Array<Client> getCadeiras() {
        return cadeiras;
    }
    public String toString() {

    }

}



public class Solver {
    
}
