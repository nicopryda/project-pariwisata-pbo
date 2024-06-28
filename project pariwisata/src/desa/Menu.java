/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desa;

public  class Menu {
    private String id;
    private String upline;
    private int    urut;
    private String nama;
    private String tipe;
    private int level;
    private String link;
    private String icon;
    private int aktif;

    // Constructor

    public Menu (String id, String upline, int urut, String nama, String tipe, int level, String link, String icon, int aktif) {
        this.id = id;
        this.upline = upline;
        this.urut = urut;
        this.nama = nama;
        this.tipe = tipe;
        this.level = level;
        this.link = link;
        this.icon = icon;
        this.aktif = aktif;
    }


    // Getter dan Setter
    public String getId() {
        return id;
    }
    public String getUpline() {
        return upline;
    }
    public int getUrut() {
        return urut;
    }
    
    public String getNama() {
        return nama;
    }
    
    public String getTipe() {
        return tipe;
    }
    public int getLevel() {
        return level;
    }
    public String getLink() {
        return link;
    }
    
    public String getIcon() {
        return icon;
    }
    
    public int getAktif() {
        return aktif;
    }
/**
 *
 * @author ASUS
 */
}