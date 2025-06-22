package id.ac.binainsani.platpay.models;

public abstract class User {
    protected String nik;
    protected String nama;
    protected String password;

    public User(String nik, String nama, String password) {
        this.nik = nik;
        this.nama = nama;
        this.password = password;
    }

    public String getNik() { return nik; }
    public String getNama() { return nama; }
    public String getPassword() { return password; }
}