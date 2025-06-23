package id.ac.binainsani.platpay.views;

import java.util.Scanner;

public class MenuUtama {
    public static void tampilkanMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== PLATPAY ===");
            System.out.println("1. Cek Pajak Kendaraan");
            System.out.println("2. Login");
            System.out.println("3. Registrasi");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            
            try {
                int pilihan = Integer.parseInt(scanner.nextLine());
                
                switch (pilihan) {
                    case 1:
                        MenuCekPajak.tampilkanMenu(scanner);
                        break;
                    case 2:
                        MenuLogin.tampilkanMenu(scanner);
                        break;
                    case 3:
                        MenuRegistrasi.tampilkanMenu(scanner);
                        break;
                    case 4:
                        System.out.println("Terima kasih telah menggunakan PlatPay!");
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }
}
