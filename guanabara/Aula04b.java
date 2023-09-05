package guanabara;

class Caneta2 {
    public String modelo;
    public float ponta;
    public boolean tampada;
    public String cor;


    //Método Construtor:
    public Caneta2(String m, String c, float p) {
        this.modelo = m;
        this.cor = c;
        this.ponta = p;
        this.tampar();
    
    }

    //get não precisa de parametro e tem um return
    //get é pra retornar uma informacão do atributo
    public String getModelo() { 
        return this.modelo;
    }
    //set precisa de parametro e não tem return
    //set é pra colocar um dado
    public void setModelo(String m) { 
        this.modelo = m;
    }

    public float getPonta() {
        return this.ponta;
    }
    public void setPonta(float p) {
        this.ponta = p;
    }

    public void status() {
        System.out.println("SOBRE A CANETA:");
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ponta: " + this.ponta);
        System.out.println("Cor: " + this.cor);
        System.out.println("Tampada?: " + this.tampada);
    }

    public void tampar() {
        this.tampada = true;
    }

    public void destampar() {
        this.tampada = false;
    }
}


public class Aula04b {
    public static void main(String[] args) {
        Caneta2 c1 = new Caneta2("NIC", "Amarela", 0.7f);
        c1.status();

        Caneta2 c2 = new Caneta2("UFC", "Laranja", 0.9f);
        c2.status();
    }
}
