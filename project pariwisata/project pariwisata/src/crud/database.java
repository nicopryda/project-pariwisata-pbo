/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; //perintah sql simpan, ubah, hapus

/**
 *
 * @author ASUS
 */
public class database {
  private String databaseName = "2210010395";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;
    
    public database(){
        try {
            String location = "jdbc:mysql://localhost/" + databaseName;
            Class.forName("com.mysql.jdbc.Driver");
            koneksiDB = DriverManager.getConnection(location, username, password);
            System.out.println("database terkoneksi");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void simpanUji(String nik,String nama,String telp,String alamat){
        try {
            String sql = "insert into uji (nik, nama, telp, alamat) value(?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nik);
            perintah.setString(2, nama);
            perintah.setString(3, telp);
            perintah.setString(4, alamat);
            perintah.executeUpdate();
            
            System.out.println("data berhasil tersimpan"); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void ubahUji(String nik,String nama,String telp,String alamat){
        try {
            String sql = "update uji set nama = ?, telp = ?, alamat = ? where nik = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nama);
            perintah.setString(2, telp);
            perintah.setString(3, alamat);
            perintah.setString(4, nik);
            perintah.executeUpdate();
            
            System.out.println("data berhasil terubah");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     
    public void hapusUji(String nik){
        try {
            String sql = "delete from uji where nik = ?";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, nik);
            
            perintah.executeUpdate();
            System.out.println("data berhasil dihapus");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
      
}
