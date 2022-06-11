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
public class muonTra {
    String MaMuonTra, MaDocGia, MaThuThu, NgayMuon, NgayHenTra;
    int TienCoc;
    
    muonTra(){
    };

    public muonTra(String MaMuonTra, String MaDocGia, String MaThuThu, String NgayMuon, String NgayHenTra, int TienCoc) {
        this.MaMuonTra = MaMuonTra;
        this.MaDocGia = MaDocGia;
        this.MaThuThu = MaThuThu;
        this.NgayMuon = NgayMuon;
        this.NgayHenTra = NgayHenTra;
        this.TienCoc = TienCoc;
    }

    public String getMaMuonTra() {
        return MaMuonTra;
    }

    public void setMaMuonTra(String MaMuonTra) {
        this.MaMuonTra = MaMuonTra;
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public String getMaThuThu() {
        return MaThuThu;
    }

    public void setMaThuThu(String MaThuThu) {
        this.MaThuThu = MaThuThu;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public String getNgayHenTra() {
        return NgayHenTra;
    }

    public void setNgayHenTra(String NgayHenTra) {
        this.NgayHenTra = NgayHenTra;
    }

    public int getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(int TienCoc) {
        this.TienCoc = TienCoc;
    }
    
    
}
