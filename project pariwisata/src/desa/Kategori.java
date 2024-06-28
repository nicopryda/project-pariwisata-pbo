/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desa;
/**
 *
 * @author ASUS
 */
public class Kategori {
    private String id;
    private String nama; 
    private String meta_deskripsi;
    private String status_aktif;
    private String create;
    private String create_date;
    private String update ;
    private String update_date;
      
public Kategori(String id, String nama, String meta_deskripsi, String status_aktif, String create, String create_date, String update, String update_date) {
        this.id = id;
        this.nama = nama;
        this.meta_deskripsi = meta_deskripsi;
        this.status_aktif = status_aktif;
        this.create = create;
        this.create_date = create_date;
        this.update = update;
        this.update_date = update_date;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getmeta_deskripsi() {
        return meta_deskripsi;
    }
    
    public String getStatus_akrif() {
        return status_aktif;
    }
    
    public String getCreate() {
        return create;
    }
    public String getCreate_date() {
        return create_date;
    }
    public String getUpdate() {
        return update;
    }
    public String getUpdate_date() {
        return update_date;
    }
}
