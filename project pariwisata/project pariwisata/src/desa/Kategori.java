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
public class Kategori {
    private String databaseName = "2210010395";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;

    
      public Kategori(){
          try {
              String location = "jdbc:mysql://localhost/" + databaseName;
              Class.forName("com.mysql.jdbc.Driver");
              koneksiDB = DriverManager.getConnection(location, username, password);
              System.out.println("database terkoneksi");
              
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }

      public void tambahKategori(String id, String nama, String meta_deskripsi, String status_aktif, String create, String create_date, String update, String update_date){
          try {
              String sql = "insert into Kecamatan (String id, String nama, String meta_deskripsi, String status_aktif. String create, String create_date, String update, String update_date) value(?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, nama);
              perintah.setString(3, meta_deskripsi);
              perintah.setString(4, status_aktif);
              perintah.setString(5, create);
              perintah.setString(6, create_date);
              perintah.setString(7, update_date);
              perintah.setString(8, update_date);
              perintah.executeUpdate();
                           
              System.out.println("Kategori telah ditambahkan.");
            } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void ubahKategori(String id, String nama, String meta_deskripsi, String status_aktif, String create, String create_date, String update, String update_date){
          try {
              String sql = "update Kategoti  id = ?, nama = ?, meta_deskripsi = ?, status_aktif = ?, create = ?, create_date= ?, update = ? update_date = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, nama);
              perintah.setString(3, meta_deskripsi);
              perintah.setString(4, status_aktif);
              perintah.setString(5, create);
              perintah.setString(6, create_date);
              perintah.setString(7, update_date);
              perintah.setString(8, update_date);
              perintah.executeUpdate();
              
              System.out.println("data berhasil diubah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
      
       public void hapusKategori(String id){
          try {
              String sql = "delete from Kategori where id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil dihapus");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
       
      public void cariKategori(String id){
          try {
              String sql = "select*from Kategori where id = ?";
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("ID : "+data.getString("id"));
                  System.out.println("NAMA : "+data.getString("nama"));
                  System.out.println("NETA DESKRIPSI : "+data.getString("meta_deskripsi"));
                  System.out.println("STATUS AKTIF : "+data.getString("status_aktif"));
                  System.out.println("CREATE : "+data.getString("create"));
                  System.out.println("CREATE DATE : "+data.getString("create_date"));
                  System.out.println("UPDATE : "+data.getString("update"));
                  System.out.println("UPDATE DATE : "+data.getString("update_date"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      public void dataKategori(){
          try {
              Statement stmt = koneksiDB.createStatement();
              ResultSet baris = stmt.executeQuery("select * from Kategori order by id asc");
              while(baris.next()){
                  System.out.println(baris.getString("id")+" | "+
                          baris.getString("nama")+" | "+
                          baris.getString("meta_deskripsi")+" | "+
                          baris.getString("status_aktif")+" | "+
                          baris.getString("create")+" | "+
                          baris.getString("create_date")+" | "+
                          baris.getString("update")+" | "+
                          baris.getString("update_date"));
                          
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
}
