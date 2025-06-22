package id.ac.binainsani.platpay.services;

import id.ac.binainsani.platpay.models.*;
import java.util.ArrayList;

public class AuthService {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        // Data Admin
        users.add(new Admin("ADM001", "Admin Utama", "admin123", "Super Admin"));
        
        // Data Pemilik
        users.add(new Pemilik("PML001", "Budi Santoso", "budi123", "Jl. Merdeka No.1"));
        users.add(new Pemilik("PML002", "Ani Wijaya", "ani123", "Jl. Sudirman No.2"));
        users.add(new Pemilik("PML003", "Rudi Hermawan", "rudi123", "Jl. Gatot Subroto No.3"));
    }

    public User login(String nik, String password) {
        for (User user : users) {
            if (user.getNik().equals(nik) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean register(Pemilik baru) {
        for (User user : users) {
            if (user.getNik().equals(baru.getNik())) {
                return false; 
            }
        }
        users.add(baru);
        return true;
    }
}