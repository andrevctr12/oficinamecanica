package Model;

public  class DDD {
    int DDD;

    @Override
    public String toString() {
        return "DDD{" +
                "DDD=" + DDD +
                '}';
    }

    public DDD() {
    }

    public DDD(int DDD) {

        this.DDD = DDD;
    }

    public int getDDD() {

        return DDD;
    }

    public void setDDD(int DDD) {
        this.DDD = DDD;
    }
}
