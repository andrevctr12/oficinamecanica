package Model;

public class UF {
    private String UFsigla;
    private String nome;

    public String getUFsigla() {
        return UFsigla;
    }

    public void setUFsigla(String UFsigla) {
        this.UFsigla = UFsigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "UF{" +
                "UFsigla='" + UFsigla + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
