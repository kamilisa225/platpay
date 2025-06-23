package id.ac.binainsani.platpay.models;

public class Admin extends User {
    private String tipeAdmin;

    public Admin(String nik, String nama, String password, String tipeAdmin) {
        super(nik, nama, password);
        this.tipeAdmin = tipeAdmin;
    }

    public String getTipeAdmin() { return tipeAdmin; }
}
