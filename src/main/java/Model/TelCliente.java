package Model;

public class TelCliente {
    int ID;
    String telefone;
    int DDD;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "TelCliente{" +
                "ID=" + ID +
                ", telefone='" + telefone + '\'' +
                ", DDD=" + DDD +
                '}';
    }

    public int getDDD() {
        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }
}
