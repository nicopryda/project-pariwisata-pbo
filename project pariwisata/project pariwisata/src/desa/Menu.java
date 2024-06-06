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
public class Menu {
    private String databaseName = "2210010395";
    private String username = "root";
    private String password = "";
    public static Connection koneksiDB;

    
      public Menu(){
          try {
              String location = "jdbc:mysql://localhost/" + databaseName;
              Class.forName("com.mysql.jdbc.Driver");
              koneksiDB = DriverManager.getConnection(location, username, password);
              System.out.println("database terkoneksi");
              
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }

      public void tambahMenu(String id, String upline, String urut, String nama, String tipe, String level, String link, String icon, boolean aktif){
          try {
              String sql = "insert into menu (String id, String upline, String urut, String nama. String tipe, String level, String link, String icon, boleean aktif) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, upline);
              perintah.setString(3, urut);
              perintah.setString(4, nama);
              perintah.setString(5, tipe);
              perintah.setString(6, level);
              perintah.setString(7, link);
              perintah.setString(8, icon);
              perintah.setBoolean(9, aktif);
              perintah.executeUpdate();
                           
              System.out.println("Menu telah ditambahkan.");
            } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void ubahMenu(String id, String upline, String urut, String nama, String tipe, String level, String link, String icon, boolean aktif){
          try {
              String sql = "update menu  id = ?, upline = ?, urut = ?, nama = ?, tipe = ?, level = ?, link = ?, icon = ? aktif = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, upline);
              perintah.setString(3, urut);
              perintah.setString(4, nama);
              perintah.setString(5, tipe);
              perintah.setString(6, level);
              perintah.setString(7, link);
              perintah.setString(8, icon);
              perintah.setBoolean(9, aktif);
              perintah.executeUpdate();
              
              System.out.println("data berhasil diubah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
      
       public void hapusMenu(String id){
          try {
              String sql = "delete from menu where id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil dihapus");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
       
      public void cariMenu(String id){
          try {
              String sql = "select*from menu where id = ?";
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              ResultSet data = perintah.executeQuery();
              while(data.next()){
                  System.out.println("ID : "+data.getString("id"));
                  System.out.println("UPLINE : "+data.getString("upline"));
                  System.out.println("URUT : "+data.getString("urut"));
                  System.out.println("NAMA : "+data.getString("nama"));
                  System.out.println("TIPE : "+data.getString("tipe"));
                  System.out.println("LEVEL : "+data.getString("level"));
                  System.out.println("LINK : "+data.getString("link"));
                  System.out.println("ICON : "+data.getString("icon"));
                  System.out.println("AKTIF : "+data.getString("aktif"));
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
      
      public void dataKategori(){
          try {
              Statement stmt = koneksiDB.createStatement();
              ResultSet baris = stmt.executeQuery("select * from menu order by id asc");
              while(baris.next()){
                  System.out.println(baris.getString("id")+" | "+
                          baris.getString("upline")+" | "+
                          baris.getString("urut")+" | "+
                          baris.getString("nama")+" | "+
                          baris.getString("tipe")+" | "+
                          baris.getString("level")+" | "+
                          baris.getString("link")+" | "+
                          baris.getString("icon")+" | "+
                          baris.getString("aktif"));
                          
              }
          } catch (Exception e) {
              System.err.println(e.getMessage());
          }
      }
}