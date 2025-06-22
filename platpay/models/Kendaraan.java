package id.ac.binainsani.platpay.models;

public class Kendaraan {
    private String nopol;
    private int tahunKeluar;
    private String merkTipe;
    private int kapasitasCC;
    private String warna;
    private String nikPemilik;
    private String statusPajak;

    public Kendaraan(String nopol, int tahunKeluar, String merkTipe, 
                    int kapasitasCC, String warna, String nikPemilik, 
                    String statusPajak) {
        this.nopol = nopol;
        this.tahunKeluar = tahunKeluar;
        this.merkTipe = merkTipe;
        this.kapasitasCC = kapasitasCC;
        this.warna = warna;
        this.nikPemilik = nikPemilik;
        this.statusPajak = statusPajak;
    }

    public String getNopol() { return nopol; }
    public int getTahunKeluar() { return tahunKeluar; }
    public String getMerkTipe() { return merkTipe; }
    public int getKapasitasCC() { return kapasitasCC; }
    public String getWarna() { return warna; }
    public String getNikPemilik() { return nikPemilik; }
    public String getStatusPajak() { return statusPajak; }
    public void setStatusPajak(String status) { this.statusPajak = status; }
}