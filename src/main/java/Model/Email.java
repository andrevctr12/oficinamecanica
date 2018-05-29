package Model;

public class Email {
    public int ID;
    public String email;
    public int idCliente;

    @Override
    public String toString() {
        return "EmailCliente{" +
                "ID=" + ID +
                ", email='" + email + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
