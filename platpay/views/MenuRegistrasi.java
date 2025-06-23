package id.ac.binainsani.platpay.views;

import id.ac.binainsani.platpay.models.Pemilik;
import id.ac.binainsani.platpay.services.AuthService;
import java.util.Scanner;

public class MenuRegistrasi {
    public static void tampilkanMenu(Scanner scanner) {
        AuthService authService = new AuthService();
        
        System.out.println("\n=== REGISTRASI PEMILIK ===");
        System.out.print("NIK: ");
        String nik = scanner.nextLine();
        
        System.out.print("Nama Lengkap: ");
        String nama = scanner.nextLine();
        
        System.out.print("Alamat: ");
        String alamat = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        System.out.print("Konfirmasi Password: ");
        String confirmPass = scanner.nextLine();
        
        if (!password.equals(confirmPass)) {
            System.out.println("Password tidak cocok!");
            return;
        }
        
        Pemilik baru = new Pemilik(nik, nama, password, alamat);
        if (authService.register(baru)) {
            System.out.println("Registrasi berhasil! Silakan login.");
        } else {
            System.out.println("NIK sudah terdaftar!");
        }
    }
}
