package Model;


public class Endereco {
    private int id;
    private Bairro Bairro;
    private Rua Rua;
    private Cidade Cidade;
    private int CEP;


    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", Bairro=" + Bairro +
                ", Rua=" + Rua +
                ", Cidade=" + Cidade +
                ", CEP=" + CEP +

                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Model.Bairro getBairro() {
        return Bairro;
    }

    public void setBairro(Model.Bairro bairro) {
        Bairro = bairro;
    }

    public Model.Rua getRua() {
        return Rua;
    }

    public void setRua(Model.Rua rua) {
        Rua = rua;
    }

    public Model.Cidade getCidade() {
        return Cidade;
    }

    public void setCidade(Model.Cidade cidade) {
        Cidade = cidade;
    }

    public int getCEP() {
        return CEP;
    }

    public void setCEP(int CEP) {
        this.CEP = CEP;
    }



}