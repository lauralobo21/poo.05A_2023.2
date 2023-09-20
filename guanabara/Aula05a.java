package guanabara;

class ContaBanco {
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;

    //cc 50
    //cp 150

//Métodos Personalizados
    public void estadoAtual() {
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Status: " + this.getStatus());
        System.out.println("----------------------------------");
    }
    public void abrirConta(String t) {
        this.setTipo(t);
        this.setStatus(true); //this.status = true;
        if(t == "CC") {
            this.setSaldo(50); //this.saldo = 50;
        }
        else if(t == "CP") {
            this.setSaldo(150); //this.saldo = 150;
        }
    }

    public void fecharConta() {
        if(this.getSaldo() > 0) {
            System.out.println("A conta ainda tem dinheiro");
        } 
        else if(this.getSaldo() < 0) {
            System.out.println("A conta está em débito");
        }
        else {
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }
    }

    public void depositar(float v) {
        if(this.getStatus()) {
            this.setSaldo(this.getSaldo() + v); //this.saldo = this.saldo + v; 
            System.out.println("Deposito realizado na conta de: " + this.getDono());
        } else {
            System.out.println("Impossível depositar em uma conta fechada");
        }
    }
    
    public void sacar(float v) {
        if(this.getStatus()) {
            if(this.getSaldo() >= v) {
                this.setSaldo(this.getSaldo() + v); //saldo = saldo - v;
                System.out.println("Saque realizado na conta de: " + this.getDono());
            } else {
                System.out.println("Saldo insuficiente para saque");
            }
        } else {
            System.out.println("Impossível sacar de uma conta fechada");
        }
    }
    
    public void pagarMensal() {
        int x = 0;
        if(this.getTipo() == "CC") {
            x = 12;
        } else if(this.getTipo() == "CP") {
            x = 20;
        }
        if(this.getStatus()) {
            this.setSaldo(this.getSaldo() - x);
            System.out.println("Mensalidade paga com sucesso por: " + this.getDono());
        } else {
            System.out.println("Impossível pagar uma conta fechada");
        }
    }
    
    //Método Construtor
    public ContaBanco() {
            this.saldo = 0;
            this.status = false;
        }


    //Getters and Setters (jsados para atributos)
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int n) {
        this.numConta = n;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = (float)saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}

public class Aula05a {
    public static void main(String[] args){
        ContaBanco p1 = new ContaBanco();
        p1.setNumConta(111);
        p1.setDono("Jubileu");
        p1.abrirConta("CC");
        

        ContaBanco p2 = new ContaBanco();
        p2.setDono("Tarciana");
        p2.setNumConta(2232);
        p2.abrirConta("CP");
        
        p1.depositar(500);
        p2.depositar(540);
        p2.sacar(100);
        p1.estadoAtual();
        p2.estadoAtual();
    }
}
