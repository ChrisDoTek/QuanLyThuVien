/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import quanlythuvien.sach;
import java.io.Serializable;

/**
 *
 * @author Administrator
 */
public class chiTietMuonTra {
    String MaMuonTra, MaSach, NgayTra;
    int TienPhat, SoLuong, SoNgayCham;

    chiTietMuonTra() {
    }

    public chiTietMuonTra(String MaMuonTra, String MaSach, int SoLuong, String NgayTra, int TienPhat, int SoNgayCham) {
        this.MaMuonTra = MaMuonTra;
        this.MaSach = MaSach;
        this.SoLuong = SoLuong;
        this.NgayTra = NgayTra;
        this.TienPhat = TienPhat;
        this.SoNgayCham = SoNgayCham;
    }

    public String getMaMuonTra() {
        return MaMuonTra;
    }

    public void setMaMuonTra(String MaMuonTra) {
        this.MaMuonTra = MaMuonTra;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }

    public int getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(int TienPhat) {
        this.TienPhat = TienPhat;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getSoNgayCham() {
        return SoNgayCham;
    }

    public void setSoNgayCham(int SoNgayCham) {
        this.SoNgayCham = SoNgayCham;
    }
    
}
