package id.ac.binainsani.platpay.views;

import id.ac.binainsani.platpay.models.Admin;
import id.ac.binainsani.platpay.models.Kendaraan;
import id.ac.binainsani.platpay.services.DataService;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
    public static void tampilkanMenu(Scanner scanner, Admin admin) {
        DataService dataService = new DataService();
        
        while (true) {
            System.out.println("\n=== MENU ADMIN (" + admin.getNama() + ") ===");
            System.out.println("1. Lihat Semua Kendaraan");
            System.out.println("2. Tambah Kendaraan");
            System.out.println("3. Ubah Status Pajak");
            System.out.println("4. Blokir Kendaraan");
            System.out.println("5. Lihat Kendaraan Diblokir");
            System.out.println("6. Buka Blokir Kendaraan");
            System.out.println("7. Logout");
            System.out.print("Pilih menu: ");
            
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                
                switch (pilihan) {
                    case 1:
                        tampilkanSemuaKendaraan(dataService);
                        break;
                    case 2:
                        tambahKendaraanBaru(scanner, dataService);
                        break;
                    case 3:
                        ubahStatusPajak(scanner, dataService);
                        break;
                    case 4:
                        blokirKendaraan(scanner, dataService);
                        break;
                    case 5:
                        tampilkanKendaraanDiblokir(dataService);
                        break;
                    case 6:
                        unblockKendaraan(scanner, dataService);
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    private static void tampilkanSemuaKendaraan(DataService dataService) {
        System.out.println("\n--- DAFTAR KENDARAAN ---");
        System.out.printf("%-12s %-15s %-10s %-8s %-10s %-15s %-12s %-10s\n",
                "NO POLISI", "MERK/TIPE", "TAHUN", "CC", "WARNA", "PEMILIK (NIK)", "STATUS PAJAK", "BLOKIR");
        
        for (Kendaraan k : dataService.getAllKendaraan()) {
            System.out.printf("%-12s %-15s %-10d %-8d %-10s %-15s %-12s %-10s\n",
                    k.getNopol(),
                    k.getMerkTipe(),
                    k.getTahunKeluar(),
                    k.getKapasitasCC(),
                    k.getWarna(),
                    k.getNikPemilik(),
                    k.getStatusPajak(),
                    dataService.isBlocked(k.getNopol()) ? "YA" : "TIDAK");
        }
    }

    private static void tambahKendaraanBaru(Scanner scanner, DataService dataService) {
        System.out.println("\n--- TAMBAH KENDARAAN BARU ---");
        
        System.out.print("Nomor Polisi: ");
        String nopol = scanner.nextLine();
        
        System.out.print("Tahun Keluar: ");
        int tahun = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Merk/Tipe: ");
        String merk = scanner.nextLine();
        
        System.out.print("Kapasitas CC: ");
        int cc = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Warna: ");
        String warna = scanner.nextLine();
        
        System.out.print("NIK Pemilik: ");
        String nikPemilik = scanner.nextLine();
        
        Kendaraan baru = new Kendaraan(nopol, tahun, merk, cc, warna, nikPemilik, "BELUM BAYAR");
        if (dataService.addKendaraan(baru)) {
            System.out.println("Kendaraan berhasil ditambahkan!");
        } else {
            System.out.println("Gagal menambahkan kendaraan (mungkin nopol sudah ada)");
        }
    }

    private static void ubahStatusPajak(Scanner scanner, DataService dataService) {
        System.out.println("\n--- UBAH STATUS PAJAK ---");
        System.out.print("Nomor Polisi: ");
        String nopol = scanner.nextLine();
        
        if (dataService.isBlocked(nopol)) {
            System.out.println("Kendaraan ini diblokir, tidak bisa diubah status pajaknya!");
            return;
        }
        
        System.out.print("Status Baru (LUNAS/BELUM BAYAR): ");
        String status = scanner.nextLine().toUpperCase();
        
        if (!status.equals("LUNAS") && !status.equals("BELUM BAYAR")) {
            System.out.println("Status harus LUNAS atau BELUM BAYAR");
            return;
        }
        
        if (dataService.updateStatusPajak(nopol, status)) {
            System.out.println("Status pajak berhasil diubah!");
        } else {
            System.out.println("Gagal mengubah status pajak (nopol tidak ditemukan)");
        }
    }

    private static void blokirKendaraan(Scanner scanner, DataService dataService) {
        System.out.println("\n--- BLOKIR KENDARAAN ---");
        System.out.print("Nomor Polisi: ");
        String nopol = scanner.nextLine();
        
        if (dataService.blockKendaraan(nopol)) {
            System.out.println("Kendaraan berhasil diblokir!");
        } else {
            System.out.println("Gagal memblokir kendaraan (sudah diblokir/tidak ditemukan)");
        }
    }

    private static void tampilkanKendaraanDiblokir(DataService dataService) {
        System.out.println("\n--- KENDARAAN DIBLOKIR ---");
        ArrayList<Kendaraan> blocked = dataService.getBlockedKendaraans();
        
        if (blocked.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang diblokir");
            return;
        }
        
        System.out.printf("%-12s %-15s %-10s %-8s %-10s %-15s %-12s\n",
                "NO POLISI", "MERK/TIPE", "TAHUN", "CC", "WARNA", "PEMILIK (NIK)", "STATUS PAJAK");
        
        for (Kendaraan k : blocked) {
            System.out.printf("%-12s %-15s %-10d %-8d %-10s %-15s %-12s\n",
                    k.getNopol(),
                    k.getMerkTipe(),
                    k.getTahunKeluar(),
                    k.getKapasitasCC(),
                    k.getWarna(),
                    k.getNikPemilik(),
                    k.getStatusPajak());
        }
    }

    private static void unblockKendaraan(Scanner scanner, DataService dataService) {
        System.out.println("\n--- BUKA BLOKIR KENDARAAN ---");
        System.out.print("Nomor Polisi: ");
        String nopol = scanner.nextLine();
        
        if (dataService.unblockKendaraan(nopol)) {
            System.out.println("Kendaraan berhasil dibuka blokirnya!");
        } else {
            System.out.println("Gagal membuka blokir (kendaraan tidak ditemukan/tidak diblokir)");
        }
    }
}