package id.ac.binainsani.platpay.services;

import id.ac.binainsani.platpay.models.Kendaraan;
import java.util.ArrayList;

public class DataService {
    private static ArrayList<Kendaraan> kendaraans = new ArrayList<>();
    private static ArrayList<String> blockedKendaraans = new ArrayList<>();

    static {
        kendaraans.add(new Kendaraan("B 1234 AB", 2020, "Toyota Avanza", 1300, "Hitam", "PML001", "BELUM BAYAR", 1500000, "2023-12-31"));
        kendaraans.add(new Kendaraan("D 5678 CD", 2021, "Honda Civic", 1500, "Merah", "PML002", "LUNAS", 1750000, "2023-12-31"));
        kendaraans.add(new Kendaraan("L 9012 EF", 2019, "Suzuki Ertiga", 1200, "Putih", "PML001", "BELUM BAYAR", 1250000, "2023-12-31"));
        kendaraans.add(new Kendaraan("B 3456 GH", 2022, "Mitsubishi Xpander", 1500, "Silver", "PML003", "LUNAS", 1800000, "2023-12-31"));
    }

    public ArrayList<Kendaraan> getAllKendaraan() {
        return new ArrayList<>(kendaraans);
    }

    public Kendaraan getKendaraanByNopol(String nopol) {
        for (Kendaraan k : kendaraans) {
            if (k.getNopol().equals(nopol)) {
                return k;
            }
        }
        return null;
    }

    public boolean addKendaraan(Kendaraan kendaraan) {
        if (getKendaraanByNopol(kendaraan.getNopol()) != null) {
            return false; 
        }
        kendaraans.add(kendaraan);
        return true;
    }

    public boolean updateStatusPajak(String nopol, String status) {
        if (isBlocked(nopol)) {
            return false;
        }
        Kendaraan k = getKendaraanByNopol(nopol);
        if (k != null) {
            k.setStatusPajak(status);
            return true;
        }
        return false;
    }

    public boolean blockKendaraan(String nopol) {
        if (getKendaraanByNopol(nopol) != null && !blockedKendaraans.contains(nopol)) {
            blockedKendaraans.add(nopol);
            return true;
        }
        return false;
    }

    public boolean unblockKendaraan(String nopol) {
        return blockedKendaraans.remove(nopol);
    }

    public boolean isBlocked(String nopol) {
        return blockedKendaraans.contains(nopol);
    }

    public ArrayList<Kendaraan> getBlockedKendaraans() {
        ArrayList<Kendaraan> result = new ArrayList<>();
        for (Kendaraan k : kendaraans) {
            if (blockedKendaraans.contains(k.getNopol())) {
                result.add(k);
            }
        }
        return result;
    }
}
