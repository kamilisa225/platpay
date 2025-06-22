package id.ac.binainsani.platpay.views;

import id.ac.binainsani.platpay.models.Kendaraan;
import id.ac.binainsani.platpay.services.DataService;
import java.util.Scanner;

public class MenuCekPajak {
    public static void tampilkanMenu(Scanner scanner) {
        DataService dataService = new DataService();
        
        System.out.println("\n=== CEK PAJAK KENDARAAN ===");
        System.out.print("Masukkan Nomor Polisi (contoh: B 1234 AB): ");
        String nopol = scanner.nextLine();
        
        Kendaraan k = dataService.getKendaraanByNopol(nopol);
        if (k != null) {
            System.out.println("\n--- HASIL CEK PAJAK ---");
            System.out.println("Nomor Polisi : " + k.getNopol());
            System.out.println("Merk/Tipe    : " + k.getMerkTipe());
            System.out.println("Tahun        : " + k.getTahunKeluar());
            System.out.println("Kapasitas CC : " + k.getKapasitasCC());
            System.out.println("Warna        : " + k.getWarna());
            System.out.println("Pemilik (NIK): " + k.getNikPemilik());
            System.out.println("Status Pajak : " + k.getStatusPajak());
        } else {
            System.out.println("Kendaraan tidak ditemukan!");
        }
        
        System.out.print("\nTekan Enter untuk kembali...");
        scanner.nextLine();
    }
}