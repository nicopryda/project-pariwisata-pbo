/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desa;


/**
 *
 * @author ASUS
 */
  public  class Kecamatan {
    private String id;
    private String id_Kabupaten;
    private String nama;
    private String keterangan;
    private String aktif;

    // Constructor

    public Kecamatan (String id, String id_kabupaten, String nama, String keterangan, String aktif) {
        this.id = id;
        this.id_Kabupaten = id_kabupaten;
        this.nama = nama;
        this.keterangan = keterangan;
        this.aktif = aktif;
    }


    // Getter dan Setter
    public String getId() {
        return id;
    }
    public String getid_Kabupaten() {
        return id_Kabupaten;
    }
    public String getNama() {
        return nama;
    }
    
    public String getKeterangan() {
        return keterangan;
    }
    
    public String getAktif() {
        return aktif;
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

