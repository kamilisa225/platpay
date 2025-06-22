package id.ac.binainsani.platpay.views;

import id.ac.binainsani.platpay.models.Kendaraan;
import id.ac.binainsani.platpay.models.Pemilik;
import id.ac.binainsani.platpay.services.DataService;
import java.util.Scanner;

public class MenuPemilik {
    public static void tampilkanMenu(Scanner scanner, Pemilik pemilik) {
        DataService dataService = new DataService();
        
        while (true) {
            System.out.println("\n=== MENU PEMILIK (" + pemilik.getNama() + ") ===");
            System.out.println("1. Lihat Kendaraan Saya");
            System.out.println("2. Cek Status Pajak");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                
                switch (pilihan) {
                    case 1:
                        tampilkanKendaraanSaya(dataService, pemilik.getNik());
                        break;
                    case 2:
                        cekStatusPajak(scanner, dataService);
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    private static void tampilkanKendaraanSaya(DataService dataService, String nikPemilik) {
        System.out.println("\n--- KENDARAAN SAYA ---");
        boolean found = false;
        
        System.out.printf("%-12s %-15s %-10s %-8s %-10s %-12s\n",
                "NO POLISI", "MERK/TIPE", "TAHUN", "CC", "WARNA", "STATUS PAJAK");
        
        for (Kendaraan k : dataService.getAllKendaraan()) {
            if (k.getNikPemilik().equals(nikPemilik)) {
                System.out.printf("%-12s %-15s %-10d %-8d %-10s %-12s\n",
                        k.getNopol(),
                        k.getMerkTipe(),
                        k.getTahunKeluar(),
                        k.getKapasitasCC(),
                        k.getWarna(),
                        k.getStatusPajak());
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Anda belum memiliki kendaraan terdaftar!");
        }
    }

    private static void cekStatusPajak(Scanner scanner, DataService dataService) {
        System.out.println("\n--- CEK STATUS PAJAK ---");
        System.out.print("Masukkan Nomor Polisi: ");
        String nopol = scanner.nextLine();
        
        Kendaraan k = dataService.getKendaraanByNopol(nopol);
        if (k != null) {
            System.out.println("\n--- DETAIL KENDARAAN ---");
            System.out.println("Nomor Polisi : " + k.getNopol());
            System.out.println("Merk/Tipe    : " + k.getMerkTipe());
            System.out.println("Tahun        : " + k.getTahunKeluar());
            System.out.println("Kapasitas CC : " + k.getKapasitasCC());
            System.out.println("Warna        : " + k.getWarna());
            System.out.println("Status Pajak : " + k.getStatusPajak());
        } else {
            System.out.println("Kendaraan tidak ditemukan!");
        }
        
        System.out.print("\nTekan Enter untuk kembali...");
        scanner.nextLine();
    }
}