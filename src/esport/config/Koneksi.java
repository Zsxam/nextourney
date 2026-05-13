/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esport.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Koneksi {
    // Variabel statis untuk menyimpan status koneksi
    private static Connection koneksiDatabase;

    // Method untuk memanggil koneksi
    public static Connection getKoneksi() {
        if (koneksiDatabase == null) {
            try {
                // Konfigurasi Database XAMPP
                String url = "jdbc:mysql://localhost:3306/db_turnamen_esport"; 
                String user = "root"; // Default user XAMPP
                String password = ""; // Default password XAMPP kosong

                // Membuat koneksi ke database
                koneksiDatabase = DriverManager.getConnection(url, user, password);
                
                System.out.println("Koneksi ke MySQL Berhasil!");
                
            } catch (SQLException e) {
                // Jika gagal, tampilkan pesan error
                System.out.println("Koneksi Gagal: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Gagal terhubung ke Database!\n" + e.getMessage(), "Error Koneksi", JOptionPane.ERROR_MESSAGE);
            }
        }
        return koneksiDatabase;
    }
    
    // Method Main (Hanya untuk testing koneksi saat file ini di-run)
    public static void main(String[] args) {
        getKoneksi();
    }
}
