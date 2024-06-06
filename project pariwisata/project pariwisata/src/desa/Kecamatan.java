/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class Kecamatan {
    private String databaseName = "2210010395";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;

    
      public Kecamatan(){
          try {
              String location = "jdbc:mysql://localhost/" + databaseName;
              Class.forName("com.mysql.jdbc.Driver");
              koneksiDB = DriverManager.getConnection(location, username, password);
              System.out.println("database terkoneksi");
              
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }

      public void tambahKecamatan(String id, String kabupaten_id, String nama, String keterangan, Boolean aktif){
          try {
              String sql = "insert into Kecamatan (id, kabupaten_id, nama, keterangan, aktif) value(?, ?, ?, ?, ?)"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, kabupaten_id);
              perintah.setString(3, nama);
              perintah.setString(4, keterangan);
              perintah.setBoolean(5, aktif);
              perintah.executeUpdate();
                           
              System.out.println("Kecamatan telah ditambahkan.");
            } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void ubahKecamatan(String id, String kabupaten_id, String nama, String keterangan, Boolean aktif){
          try {
              String sql = "update kecamatan set id = ?, kabupaten_id = ?, nama = ?, keterangan = ? aktif = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
               perintah.setString(1, id);
              perintah.setString(2, kabupaten_id);
              perintah.setString(3, nama);
              perintah.setString(4, keterangan);
              perintah.setBoolean(5, aktif);
              perintah.executeUpdate();
              
              System.out.println("data berhasil diubah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
      
       public void hapusKecamatan(String id){
          try {
              String sql = "delete from desa where id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil dihapus");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
       
      public void cariKecamatan(String id){
          try {
              String sql = "select*from Kecamatan where id = ?";
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("ID : "+data.getString("id"));
                  System.out.println("ID KABUPATEN : "+data.getString("kabupaten_id"));
                  System.out.println("NAMA : "+data.getString("nama"));
                  System.out.println("KETERANGAN : "+data.getString("keterangan"));
                  System.out.println("AKTIF : "+data.getString("aktif"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      public void dataKecamatan(){
          try {
              Statement stmt = koneksiDB.createStatement();
              ResultSet baris = stmt.executeQuery("select * from Kecamatan order by id asc");
              while(baris.next()){
                  System.out.println(baris.getString("id")+" | "+
                          baris.getString("kabupaten_id")+" | "+
                          baris.getString("nama")+" | "+
                          baris.getString("keterangan")+" | "+
                          baris.getString("aktif"));
                          
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
}
//    private int id;
//    private int idKabupaten;
//    private String nama;
//    private String keterangan;
//    private boolean aktif;
//
//    // Constructor
//    public Kecamatan(int id, int idKabupaten, String nama, String keterangan, boolean aktif) {
//        this.id = id;
//        this.idKabupaten = idKabupaten;
//        this.nama = nama;
//        this.keterangan = keterangan;
//        this.aktif = aktif;
//    }
//
//    // Getter dan Setter
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getIdKabupaten() {
//        return idKabupaten;
//    }
//
//    public void setIdKabupaten(int idKabupaten) {
//        this.idKabupaten = idKabupaten;
//    }
//
//    public String getNama() {
//        return nama;
//    }
//
//    public void setNama(String nama) {
//        this.nama = nama;
//    }
//
//    public String getKeterangan() {
//        return keterangan;
//    }
//
//    public void setKeterangan(String keterangan) {
//        this.keterangan = keterangan;
//    }
//
//    public boolean isAktif() {
//        return aktif;
//    }
//
//    public void setAktif(boolean aktif) {
//        this.aktif = aktif;
//    }
//}

