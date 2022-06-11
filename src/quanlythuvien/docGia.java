/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import java.sql.Date;
import java.io.Serializable;
/**
 *
 * @author Administrator
 */
public class docGia {
    private String MaDocGia, TenDocGia, GioiTinh, SoCMT, DiaChi, SDT;
    String NgaySinh;

    public docGia(String MaDocGia, String TenDocGia, String GioiTinh, String SoCMT, String DiaChi, String SDT, String NgaySinh) {
        this.MaDocGia = MaDocGia;
        this.TenDocGia = TenDocGia;
        this.GioiTinh = GioiTinh;
        this.SoCMT = SoCMT;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
    }

    docGia(){
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public String getTenDocGia() {
        return TenDocGia;
    }

    public void setTenDocGia(String TenDocGia) {
        this.TenDocGia = TenDocGia;
    }

    public String getSoCMT() {
        return SoCMT;
    }

    public void setSoCMT(String SoCMT) {
        this.SoCMT = SoCMT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    void setString(int i, String maDocGia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}