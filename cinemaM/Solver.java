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

package cinemaM;
import java.util.*;

class Client {
    private String id;
    private String fone;
    public Client(String id, String fone) {
        this.id = id;
        this.fone = fone;
    }

    @Override
    public String toString() {
        return id + ":" + fone;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
}

// Animal gato = new Gato();
// animais.add( gato );
// Animal cachorro = new Cachorro();
// animais.add( cachorro );

// for ( Animal animal : animais ) {
//     animal.desenhar();
// }

class Sala{ //----------------------------------------------------------------------------------
    private ArrayList<Client> cadeiras;
    private int procurar(String nome) {
        for(int i=0; i<this.cadeiras.size(); i++) {
            if(this.cadeiras.get(i) != null) {
                if(this.cadeiras.get(i).getId().equals( nome )) {
                    return i;
                }
            }
        }
        return -1;
    }
    private boolean verificarIndice(int indice) {
        if(indice >= 0 && indice < this.cadeiras.size()) {
            return true;
        } else {
            return false;
        }
    }
    // Construtor
    public Sala(int capacidade) {
        // this.cadeiras = new ArrayList<Client>( capacidade );
        // System.out.println( cadeiras.size() );
        this.cadeiras = new ArrayList<Client>();
        for(int i=0; i<capacidade; i++) {
            this.cadeiras.add(null);
        }
    }

    public List<Client> getCadeiras() {
        return null;
    }
    
    public boolean reservar(String id, String fone, int ind) {
        if(!this.verificarIndice(ind)) {
            System.out.println("fail: cadeira nao existe");
            return false;
        }
        if(this.cadeiras.get(ind) != null) {
            System.out.println("fail: cadeira ja esta ocupada");
            return false;
        }
        
        if(this.procurar(id) != -1) { //se id for encontrado em alguma cadeira
            System.out.println("fail: cliente ja esta no cinema");
            return false;
        }
        
        // Cliente cliente = new Client(id,fone);
        // this.cadeiras.set(ind, cliente);
        this.cadeiras.set(ind, new Client(id,fone));
            return true;
    }

    public void cancelar(String id) {
        int ind = this.procurar(id);
        if(ind == -1) { // se não encontrar
            System.out.println("fail: cliente nao esta no cinema");
            return;
        }
        //this.cadeiras[ind] = null;
        this.cadeiras.set(ind, null);
    }

    @Override
    public String toString() {
        String saida = "[";
        int nC = -1; //numero do cliente
        for(Client cliente : cadeiras) {
            if(cliente == null)
                saida += "-";
            else
                saida += cliente + "";

            nC++;
            if (nC != cadeiras.size()-1) saida += " ";
        }
        return saida + "]";
    }
}

class Solver {
    static Shell sh = new Shell();
    static Sala sala = new Sala(0);

    public static void main(String args[]) {
        sh.chain.put("init", () -> {
            sala = new Sala(getInt(1));
        });
        sh.chain.put("show", () -> {
            System.out.println(sala);
        });
        sh.chain.put("reservar", () -> {
            sala.reservar(getStr(1), getStr(2), getInt(3));
        });
        sh.chain.put("cancelar", () -> {
            sala.cancelar(getStr(1));
        });

        sh.execute();
    }

    static int getInt(int pos) {
        return Integer.parseInt(sh.param.get(pos));
    }

    static String getStr(int pos) {
        return sh.param.get(pos);
    }
}

class Shell {
    public Scanner scanner = new Scanner(System.in);
    public HashMap<String, Runnable> chain = new HashMap<>();
    public ArrayList<String> param = new ArrayList<>();

    public Shell() {
        Locale.setDefault(new Locale("en", "US"));
    }

    public void execute() {
        while (true) {
            param.clear();
            String line = scanner.nextLine();
            Collections.addAll(param, line.split(" "));
            System.out.println("$" + line);
            if (param.get(0).equals("end")) {
                break;
            } else if (chain.containsKey(param.get(0))) {
                chain.get(param.get(0)).run();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}

