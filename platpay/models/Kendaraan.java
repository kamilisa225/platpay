package id.ac.binainsani.platpay.models;

public class Kendaraan {
    private String nopol;
    private int tahunKeluar;
    private String merkTipe;
    private int kapasitasCC;
    private String warna;
    private String nikPemilik;
    private String statusPajak;
    private double hargaPajak;
    private String tjtp;

    public Kendaraan(String nopol, int tahunKeluar, String merkTipe, 
                    int kapasitasCC, String warna, String nikPemilik, 
                    String statusPajak, double hargaPajak, String tjtp) {
        this.nopol = nopol;
        this.tahunKeluar = tahunKeluar;
        this.merkTipe = merkTipe;
        this.kapasitasCC = kapasitasCC;
        this.warna = warna;
        this.nikPemilik = nikPemilik;
        this.statusPajak = statusPajak;
        this.hargaPajak = hargaPajak;
        this.tjtp = tjtp;
    }

    public String getNopol() { return nopol; }
    public int getTahunKeluar() { return tahunKeluar; }
    public String getMerkTipe() { return merkTipe; }
    public int getKapasitasCC() { return kapasitasCC; }
    public String getWarna() { return warna; }
    public String getNikPemilik() { return nikPemilik; }
    public String getStatusPajak() { return statusPajak; }
    public double getHargaPajak() { return hargaPajak; }
    public String getTjtp() { return tjtp; }
    public void setStatusPajak(String status) { this.statusPajak = status; }
    public void setHargaPajak(double hargaPajak) { this.hargaPajak = hargaPajak; }
    public void setTjtp(String tjtp) { this.tjtp = tjtp; }
}
