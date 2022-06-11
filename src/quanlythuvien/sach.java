/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class sach{
    private String MaSach, TenSach, TacGia, NhaXuatBan, TheLoai;
    private int DonGia, SoLuongCon, SoLuongMuon, NamXuatBan;

    
    sach(){
    }

    public sach(String MaSach, String TenSach, String TacGia, String NhaXuatBan, int NamXuatBan, String TheLoai, int DonGia, int SoLuong) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TacGia = TacGia;
        this.NhaXuatBan = NhaXuatBan;
        this.TheLoai = TheLoai;
        this.DonGia = DonGia;
        this.SoLuongCon = SoLuong;
        this.NamXuatBan = NamXuatBan;
    }

    

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String NhaXuatBan) {
        this.NhaXuatBan = NhaXuatBan;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public int getSoLuongCon() {
        return SoLuongCon;
    }

    public void setSoLuongCon(int SoLuong) {
        this.SoLuongCon = SoLuong;
    }

    public int getSoLuongMuon() {
        return SoLuongMuon;
    }

    public void setSoLuongMuon(int SoLuongMuon) {
        this.SoLuongMuon = SoLuongMuon;
    }
    
    public int getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(int NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }
    
    public Object[] toArray(){
        return new Object[]{MaSach, TenSach, TacGia, NhaXuatBan, NamXuatBan, TheLoai, DonGia, SoLuongCon
        };
    }
}
