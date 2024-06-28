/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desa;


/**
 *
 * @author ASUS
 */

    public  class Desa {
    private String id;
    private String id_Kecamatan;
    private String nama;
    private String keterangan;
    private String aktiv;

    // Constructor

    public Desa(String id, String id_kecamatan, String nama, String keterangan, String aktiv) {
        this.id = id;
        this.id_Kecamatan = id_kecamatan;
        this.nama = nama;
        this.keterangan = keterangan;
        this.aktiv = aktiv;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }
    public String getId_Kecamatan() {
        return id_Kecamatan;
    }
    public String getNama() {
        return nama;
    }
    
    public String getKeterangan() {
        return keterangan;
    }
    
    public String getAktif() {
        return aktiv;
    }
}

//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getIdKecamatan() {
//        return idKecamatan;
//    }
//
//    public void setIdKecamatan(int idKecamatan) {
//        this.idKecamatan = idKecamatan;
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

