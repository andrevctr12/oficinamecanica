package Model;

public class Rua {
    private int ID;
    private String nomeRua;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    @Override
    public String toString() {
        return "Rua{" +
                "ID=" + ID +
                ", nomeRua='" + nomeRua + '\'' +
                '}';
    }
}
