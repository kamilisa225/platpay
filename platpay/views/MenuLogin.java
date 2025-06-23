package id.ac.binainsani.platpay.views;

import id.ac.binainsani.platpay.models.Admin;
import id.ac.binainsani.platpay.models.Pemilik;
import id.ac.binainsani.platpay.models.User;
import id.ac.binainsani.platpay.services.AuthService;
import java.util.Scanner;

public class MenuLogin {
    public static void tampilkanMenu(Scanner scanner) {
        AuthService authService = new AuthService();
        
        System.out.println("\n=== LOGIN ===");
        System.out.print("NIK: ");
        String nik = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        User user = authService.login(nik, password);
        
        if (user == null) {
            System.out.println("Login gagal! NIK atau password salah.");
            return;
        }
        
        if (user instanceof Admin) {
            MenuAdmin.tampilkanMenu(scanner, (Admin)user);
        } else if (user instanceof Pemilik) {
            MenuPemilik.tampilkanMenu(scanner, (Pemilik)user);
        }
    }
}
