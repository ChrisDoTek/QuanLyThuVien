/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import java.sql.Date;

public class thuThu {
    private String MaThuThu, TenThuThu, GioiTinh, SoCMT, DiaChi, SDT;
    private String NgaySinh;

    thuThu(){}
    
    public thuThu(String MaThuThu, String TenThuThu, String GioiTinh, String SoCMT, String DiaChi, String SDT, String NgaySinh) {
        this.MaThuThu = MaThuThu;
        this.TenThuThu = TenThuThu;
        this.GioiTinh = GioiTinh;
        this.SoCMT = SoCMT;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.NgaySinh = NgaySinh;
    }

    public String getMaThuThu() {
        return MaThuThu;
    }

    public void setMaThuThu(String MaThuThu) {
        this.MaThuThu = MaThuThu;
    }

    public String getTenThuThu() {
        return TenThuThu;
    }

    public void setTenThuThu(String TenThuThu) {
        this.TenThuThu = TenThuThu;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
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
    
    
}
