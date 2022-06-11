/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

/**
 *
 * @author Administrator
 */
public class phieuMuon {
    String maSach, tenSach;
    int soLuong;
    
    phieuMuon(){
    }
    
    public phieuMuon(String maSach, String tenSach, int soLuong){
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.soLuong = soLuong;
    }
    
    public void setMaSach(String maSach){
        this.maSach = maSach;
    }
    
    public String getMaSach(){
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
   
}
