/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection; //mendapatkan koneksi
import java.sql.DriverManager; //menghubungkan database
import java.sql.PreparedStatement; //perintah sql simpan, ubah, hapus
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    
    public void simpanDesa(String id, String id_kecamatan, String nama, String keterangan, String aktiv){
          try {
              String sql = "insert into desa (id, id_kecamatan, nama, keterangan, aktiv) value(?, ?, ?, ?, ?)"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, id_kecamatan);
              perintah.setString(3, nama);
              perintah.setString(4, keterangan);
              perintah.setString(5, aktiv);
              perintah.executeUpdate();
                           
              System.out.println("Desa telah ditambahkan.");
            } catch (SQLException e) {
              System.out.println(e.getMessage());
          }
      }
      
     public void ubahDesa(String id, String id_kecamatan, String nama, String keterangan, String aktiv){
          try {
              String sql = "UPDATE desa set id_kecamatan = ?, nama = ?, keterangan = ?, aktiv = ? WHERE id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id_kecamatan);
              perintah.setString(2, nama);
              perintah.setString(3, keterangan);
              perintah.setString(4, aktiv);
              perintah.setString(5, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil diubah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
      
       public void hapusDesa(String id){
          try {
              String sql = "delete from desa where id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil dihapus");
          } catch (SQLException e) {
              System.out.println(e.getMessage());
          }        
      }
        public void simpanKategori(String paramid, String paramnama, String parammeta_deskripsi, String paramstatus_aktif, String paramcreate, String paramcreate_date, String paramupdate, String paramupdate_date) {
    try {
            String sql = "INSERT INTO Kategori (id, nama, meta_deskripsi, status_aktif, `create`, create_date, `update`, update_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, paramid);
            perintah.setString(2, paramnama);
            perintah.setString(3, parammeta_deskripsi);
            perintah.setString(4, paramstatus_aktif);
            perintah.setString(5, paramcreate);
            perintah.setString(6, paramcreate_date);
            perintah.setString(7, paramupdate);
            perintah.setString(8, paramupdate_date);
              perintah.executeUpdate();
                           
              System.out.println("Kategori telah diSimpan.");
            } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void ubahKategori(String paramid, String paramnama, String parammeta_deskripsi, String paramstatus_aktif, String paramcreate, String paramcreate_date, String paramupdate, String paramupdate_date) {
    try {
        String sql = "UPDATE kategori SET nama = ?, meta_deskripsi = ?, status_aktif = ?, `create` = ?, create_date = ?, `update` = ?, update_date = ? WHERE id = ?";
        PreparedStatement perintah = koneksiDB.prepareStatement(sql);
            perintah.setString(1, paramnama);
            perintah.setString(2, parammeta_deskripsi);
            perintah.setString(3, paramstatus_aktif);
            perintah.setString(4, paramcreate);
            perintah.setString(5, paramcreate_date);
            perintah.setString(6, paramupdate);
            perintah.setString(7, paramupdate_date);
            perintah.setString(8, paramid);
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
       public void simpanKecamatan(String id, String id_kabupaten, String nama, String keterangan, String aktif){
          try {
              String sql = "insert into Kecamatan (id, id_kabupaten, nama, keterangan, aktif) value(?, ?, ?, ?, ?)"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id);
              perintah.setString(2, id_kabupaten);
              perintah.setString(3, nama);
              perintah.setString(4, keterangan);
              perintah.setString(5, aktif);
              perintah.executeUpdate();
                           
              System.out.println("Kecamatan telah ditambahkan.");
            } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void ubahKecamatan(String id , String id_kabupaten, String nama, String keterangan, String aktif){
          try {
              String sql = "UPDATE kecamatan SET id_kabupaten = ?, nama = ?, keterangan = ?, aktif = ? WHERE id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, id_kabupaten);
              perintah.setString(2, nama);
              perintah.setString(3, keterangan);
              perintah.setString(4, aktif);
              perintah.setString(5, id);
              perintah.executeUpdate();
              
              System.out.println("data berhasil diubah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
      
       public void hapusKecamatan(String id){
          try {
              String sql = "DELETE from kecamatan WHERE id = ?"; 
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
      public void simpanMenu(String paramid, String paramupline, int paramurut, String paramnama, String paramtipe, int paramlevel, String paramlink, String paramicon, int paramaktif){
          try {
              String sql = "insert into menu (id, upline, urut, nama, tipe, level, link,  icon,  aktif) value(?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, paramid);
              perintah.setString(2, paramupline);
              perintah.setInt(3, paramurut);
              perintah.setString(4, paramnama);
              perintah.setString(5, paramtipe);
              perintah.setInt(6, paramlevel);
              perintah.setString(7, paramlink);
              perintah.setString(8, paramicon);
              perintah.setInt(9, paramaktif);
              perintah.executeUpdate();
                           
              System.out.println("Menu telah ditambahkan.");
            } catch (Exception e) {
              System.out.println(e.getMessage());
          }
      }
      
      public void ubahMenu(String paramid, String paramupline, int paramurut, String paramnama, String paramtipe, int paramlevel, String paramlink, String paramicon, int paramaktif){
          try {
              String sql = "UPDATE menu set upline = ?, urut = ?, nama = ?, tipe = ?, level = ?, link = ?, icon = ?, aktif = ? WHERE id = ?"; 
              PreparedStatement perintah = koneksiDB.prepareStatement(sql);
              perintah.setString(1, paramupline);
              perintah.setInt(2, paramurut);
              perintah.setString(3, paramnama);
              perintah.setString(4, paramtipe);
              perintah.setInt(5, paramlevel);
              perintah.setString(6, paramlink);
              perintah.setString(7, paramicon);
              perintah.setInt(8, paramaktif);
              perintah.setString(9, paramid);
              perintah.executeUpdate();
              
              System.out.println("data berhasil diubah");
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }        
      }
      
       public void hapusMenu(String id){
          try {
              String sql = "DELETE from menu WHERE id = ?"; 
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
}

