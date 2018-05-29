package Model;

public class Bairro {
    private String nome;
    private int ID;

    public Bairro() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "nome='" + nome + '\'' +
                ", ID=" + ID +
                '}';
    }

    public Bairro(String nome) {
        this.nome = nome;
    }


}