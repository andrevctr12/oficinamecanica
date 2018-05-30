package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente {
    private int ID;
    private String nome;
    private String cpf;
    private String Senha;
    private int end_num;
    private String complemento;
    private Endereco endereco;
    private TelCliente telCliente;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public int getEnd_num() {
        return end_num;
    }

    public void setEnd_num(int end_num) {
        this.end_num = end_num;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public TelCliente getTelCliente() {
        return telCliente;
    }

    public void setTelCliente(TelCliente telCliente) {
        this.telCliente = telCliente;


    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", Senha='" + Senha + '\'' +
                ", end_num=" + end_num +
                ", complemento='" + complemento + '\'' +
                ", endereco=" + endereco +
                ", telCliente=" + telCliente +
                '}';
    }
}