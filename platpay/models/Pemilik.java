package id.ac.binainsani.platpay.models;

public class Pemilik extends User {
    private String alamat;

    public Pemilik(String nik, String nama, String password, String alamat) {
        super(nik, nama, password);
        this.alamat = alamat;
    }

    public String getAlamat() { return alamat; }
}