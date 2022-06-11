/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import quanlythuvien.quanLySach;
import quanlythuvien.quanLyChiTietMuonTra;
import quanlythuvien.quanLyThuThu;
import quanlythuvien.quanLyDocGia;
import quanlythuvien.quanLyMuonTra;

/**
 *
 * @author Administrator
 */
public class connect {
    public static Connection con;
    String connectionUrl = "jdbc:sqlserver://ASUSD-PC:1433;" +  
		         "databaseName=quanlythuvien;integratedSecurity=True"; 
    
    public connect(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
        }
    }
    public boolean addBook(sach b){
        String sql ="INSERT INTO Sach(MaSach, TenSach, TacGia, NhaXuatBan, NamXuatBan, TheLoai, DonGia, SoLuong) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, b.getMaSach());
            p.setString(2, b.getTenSach());
            p.setString(3, b.getTacGia());
            p.setString(4, b.getNhaXuatBan());
            p.setInt(5, b.getNamXuatBan());
            p.setString(6, b.getTheLoai());
            p.setInt(7, b.getDonGia());
            p.setInt(8, b.getSoLuongCon());
            
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();            
        }
        
        return false;
    }
    
    public boolean updateBook(sach b){
        String sql ="UPDATE Sach SET TenSach=?, TacGia=?, NhaXuatBan=?, NamXuatBan=?, TheLoai=?, DonGia=?, SoLuong=? WHERE MaSach=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(8, b.getMaSach());
            p.setString(1, b.getTenSach());
            p.setString(2, b.getTacGia());
            p.setString(3, b.getNhaXuatBan());
            p.setInt(4, b.getNamXuatBan());
            p.setString(5, b.getTheLoai());
            p.setInt(6, b.getDonGia());
            p.setInt(7, b.getSoLuongCon());
            
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public boolean delBook(sach b){
        String sql ="DELETE FROM Sach WHERE MaSach=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, b.getMaSach());
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public ArrayList<sach> getListBook(){
        ArrayList<sach> list = new ArrayList<>();
        String sql= "SELECT * FROM Sach";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sach b = new sach();
                b.setMaSach(rs.getString("MaSach"));
                b.setTenSach(rs.getString("Tensach"));
                b.setTacGia(rs.getString("TacGia"));
                b.setNhaXuatBan(rs.getString("NhaXuatBan"));
                b.setNamXuatBan(rs.getInt("NamXuatBan"));
                b.setTheLoai(rs.getString("TheLoai"));
                b.setDonGia(rs.getInt("DonGia"));
                b.setSoLuongCon(rs.getInt("SoLuong"));
                
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    boolean addDocGia(docGia dg) {
        String sql ="INSERT INTO DocGia(MaDocGia, TenDocGia, GioiTinh, NgaySinh, SoCMT, DiaChi, SDT) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, dg.getMaDocGia());
            p.setString(2, dg.getTenDocGia());
            p.setString(3, dg.getGioiTinh());
            p.setString(4, dg.getNgaySinh());
            p.setString(5, dg.getSoCMT());
            p.setString(6, dg.getDiaChi());
            p.setString(7, dg.getSDT());
            
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    boolean updateDocGia(docGia dg) {
        String sql ="UPDATE DocGia SET TenDocGia=?, GioiTinh=?, NgaySinh=?, SoCMT=?, DiaChi=?, SDT=? WHERE MaDocGia=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(7, dg.getMaDocGia());
            p.setString(1, dg.getTenDocGia());
            p.setString(2, dg.getGioiTinh());
            p.setString(3, dg.getNgaySinh());
            p.setString(4, dg.getSoCMT());
            p.setString(5, dg.getDiaChi());
            p.setString(6, dg.getSDT());
            
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    boolean delDocGia(docGia dg) {
        String sql ="DELETE FROM DocGia WHERE MaDocGia=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, dg.getMaDocGia());
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    ArrayList<docGia> getListDocGia() {
        ArrayList<docGia> list = new ArrayList<>();
        String sql= "SELECT * FROM DocGia";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                docGia dg = new docGia();
                dg.setMaDocGia(rs.getString("MaDocGia"));
                dg.setTenDocGia(rs.getString("TenDocGia"));
                dg.setGioiTinh(rs.getString("GioiTinh"));
                dg.setNgaySinh(rs.getString("NgaySinh"));
                dg.setSoCMT(rs.getString("SoCMT"));
                dg.setDiaChi(rs.getString("DiaChi"));
                dg.setSDT(rs.getString("SDT"));
                
                list.add(dg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    boolean addThuThu(thuThu tt) {
        String sql ="INSERT INTO ThuThu(MaThuThu, TenThuThu, GioiTinh, NgaySinh, SoCMT, DiaChi, SDT) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, tt.getMaThuThu());
            p.setString(2, tt.getTenThuThu());
            p.setString(3, tt.getGioiTinh());
            p.setString(4, tt.getNgaySinh());
            p.setString(5, tt.getSoCMT());
            p.setString(6, tt.getDiaChi());
            p.setString(7, tt.getSDT());
            
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    boolean updateThuThu(thuThu tt) {
        String sql ="UPDATE ThuThu SET TenThuThu=?, GioiTinh=?, NgaySinh=?, SoCMT=?, DiaChi=?, SDT=? WHERE MaThuThu=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(7, tt.getMaThuThu());
            p.setString(1, tt.getTenThuThu());
            p.setString(2, tt.getGioiTinh());
            p.setString(3, tt.getNgaySinh());
            p.setString(4, tt.getSoCMT());
            p.setString(5, tt.getDiaChi());
            p.setString(6, tt.getSDT());
            
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    boolean delThuThu(thuThu tt) {
        String sql ="DELETE FROM ThuThu WHERE MaThuThu=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, tt.getMaThuThu());
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    ArrayList<thuThu> getListThuThu() {
        ArrayList<thuThu> list = new ArrayList<>();
        String sql= "SELECT * FROM ThuThu";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                thuThu tt = new thuThu();
                tt.setMaThuThu(rs.getString("MaThuThu"));
                tt.setTenThuThu(rs.getString("TenThuThu"));
                tt.setGioiTinh(rs.getString("GioiTinh"));
                tt.setNgaySinh(rs.getString("NgaySinh"));
                tt.setSoCMT(rs.getString("SoCMT"));
                tt.setDiaChi(rs.getString("DiaChi"));
                tt.setSDT(rs.getString("SDT"));
                
                list.add(tt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    boolean addMuonTra(muonTra mt) {
        String sql ="INSERT INTO QuanLyMuonTra(MaMuonTra, MaDocGia, MaThuThu, NgayMuon, NgayHenTra, TienCoc) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, mt.getMaMuonTra());
            p.setString(2, mt.getMaDocGia());
            p.setString(3, mt.getMaThuThu());
            p.setString(4, mt.getNgayMuon());
            p.setString(5, mt.getNgayHenTra());
            p.setInt(6, mt.getTienCoc());
            
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    boolean updateMuonTra(muonTra mt) {
        String sql ="UPDATE QuanLyMuonTra SET MaDocGia=?, MaThuThu=?, NgayMuon=?, NgayHenTra=?, TienCoc=? WHERE MaMuonTra=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(7, mt.getMaMuonTra());
            p.setString(1, mt.getMaDocGia());
            p.setString(2, mt.getMaThuThu());
            p.setString(3, mt.getNgayMuon());
            p.setString(4, mt.getNgayHenTra());
            p.setInt(5, mt.getTienCoc());
            
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    boolean delMuonTra(muonTra mt) {
        String sql ="DELETE FROM QuanLyMuonTra WHERE MaMuonTra=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, mt.getMaMuonTra());
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }

    ArrayList<muonTra> getListMuonTra() {
        ArrayList<muonTra> list = new ArrayList<>();
        String sql= "SELECT * FROM QuanLyMuonTra";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                muonTra mt = new muonTra();
                mt.setMaMuonTra(rs.getString("MaMuonTra"));
                mt.setMaDocGia(rs.getString("MaDocGia"));
                mt.setMaThuThu(rs.getString("MaThuThu"));
                mt.setNgayMuon(rs.getString("NgayMuon"));
                mt.setNgayHenTra(rs.getString("NgayHenTra"));
                mt.setTienCoc(rs.getInt("TienCoc"));
                
                list.add(mt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    boolean addChiTietMuonTra(chiTietMuonTra ctmt) {
        String sql;
        if(ctmt.getNgayTra().equals("")){
            sql ="INSERT INTO ChiTietMuonTra(MaMuonTra, MaSach, SoLuong, NgayTra, TienPhat) VALUES(?,?,?,NULL,?)";
                try {
                PreparedStatement p = con.prepareStatement(sql);
                p.setString(1, ctmt.getMaMuonTra());
                p.setString(2, ctmt.getMaSach());
                p.setInt(3, ctmt.getSoLuong());
                p.setInt(4, ctmt.getTienPhat());

                return p.executeUpdate()>0;

                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        else{
            sql ="INSERT INTO ChiTietMuonTra(MaMuonTra, MaSach, SoLuong, NgayTra, TienPhat) VALUES(?,?,?,?,?)";
            try {
                PreparedStatement p = con.prepareStatement(sql);
                p.setString(1, ctmt.getMaMuonTra());
                p.setString(2, ctmt.getMaSach());
                p.setInt(3, ctmt.getSoLuong());
                p.setString(4, ctmt.getNgayTra());
                p.setInt(5, ctmt.getTienPhat());

                return p.executeUpdate()>0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    boolean updateChiTietMuonTra(chiTietMuonTra ctmt) {
        String sql; 
        if(ctmt.getNgayTra().equals("")){        
            sql="UPDATE ChiTietMuonTra SET SoLuong=?, NgayTra=NULL, TienPhat=? WHERE MaMuonTra=? and MaSach=?";
            try {
                PreparedStatement p = con.prepareStatement(sql);
                p.setString(3, ctmt.getMaMuonTra());
                p.setString(4, ctmt.getMaSach());
                p.setInt(1, ctmt.getSoLuong());
                p.setInt(2, ctmt.getTienPhat());

                return p.executeUpdate()>0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{        
            sql="UPDATE ChiTietMuonTra SET SoLuong=?, NgayTra=?, TienPhat=? WHERE MaMuonTra=? and MaSach=?";
            try {
                PreparedStatement p = con.prepareStatement(sql);
                p.setString(4, ctmt.getMaMuonTra());
                p.setString(5, ctmt.getMaSach());
                p.setInt(1, ctmt.getSoLuong());
                p.setString(2, ctmt.getNgayTra());
                p.setInt(3, ctmt.getTienPhat());

                return p.executeUpdate()>0;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    boolean delChiTietMuonTra(chiTietMuonTra ctmt) {
        String sql ="DELETE FROM ChiTietMuonTra WHERE MaMuonTra=? and MaSach=?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, ctmt.getMaMuonTra());
            p.setString(2, ctmt.getMaSach());
            return p.executeUpdate()>0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    int tinhSoNgayCham () {
        String sql ="Select MaSach, SoNgayCham=DATEDIFF(day, QuanLyMuonTra.NgayHenTra, ChiTietMuonTra.NgayTra)\n" +
                    "from QuanLyMuonTra join ChiTietMuonTra on QuanLyMuonTra.MaMuonTra=ChiTietMuonTra.MaMuonTra\n" +
                    "where MaSach=? and ChiTietMuonTra.MaMuonTra=?";
            try {
                PreparedStatement p = con.prepareStatement(sql);
                p.setString(1, quanLyChiTietMuonTra.jt2);
                p.setString(2, quanLyChiTietMuonTra.jt1);
                ResultSet rs= p.executeQuery();
                while(rs.next()){
                    chiTietMuonTra ctmt = new chiTietMuonTra();
                    ctmt.setSoNgayCham(rs.getInt("SoNgayCham"));
                    return ctmt.getSoNgayCham();
                }
            } catch (Exception e) {
                e.printStackTrace();
        }
        return 0;
    }


    ArrayList<chiTietMuonTra> getListChiTietMuonTra() {
        ArrayList<chiTietMuonTra> list = new ArrayList<>();
        String sql= "SELECT * FROM ChiTietMuonTra";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                chiTietMuonTra ctmt = new chiTietMuonTra();
                ctmt.setMaMuonTra(rs.getString("MaMuonTra"));
                ctmt.setMaSach(rs.getString("MaSach"));
                ctmt.setSoLuong(rs.getInt("SoLuong"));
                ctmt.setNgayTra(rs.getString("NgayTra"));
                ctmt.setTienPhat(rs.getInt("TienPhat"));
                
                list.add(ctmt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<sach> getListTimKiemSach(){
        ArrayList<sach> list = new ArrayList<>();
        String sql ="Select * FROM Sach WHERE "+timKiemSach.jcb1+" like ? ";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, "%"+timKiemSach.jt1+"%");
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                    sach b = new sach();
                    b.setMaSach(rs.getString("MaSach"));
                    b.setTenSach(rs.getString("Tensach"));
                    b.setTacGia(rs.getString("TacGia"));
                    b.setNhaXuatBan(rs.getString("NhaXuatBan"));
                    b.setNamXuatBan(rs.getInt("NamXuatBan"));
                    b.setTheLoai(rs.getString("TheLoai"));
                    b.setDonGia(rs.getInt("DonGia"));
                    b.setSoLuongCon(rs.getInt("SoLuong"));

                    list.add(b);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<docGia> getListTimKiemDocGia(){
        ArrayList<docGia> list = new ArrayList<>();
        String sql ="Select * FROM DocGia WHERE "+timKiemDocGia.jcb1+" like ?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, "%"+ timKiemDocGia.jt1 +"%");
            ResultSet rs = p.executeQuery();
                while(rs.next()){
                    docGia dg = new docGia();
                    dg.setMaDocGia(rs.getString("MaDocGia"));
                    dg.setTenDocGia(rs.getString("TenDocGia"));
                    dg.setGioiTinh(rs.getString("GioiTinh"));
                    dg.setNgaySinh(rs.getString("NgaySinh"));
                    dg.setSoCMT(rs.getString("SoCMT"));
                    dg.setDiaChi(rs.getString("DiaChi"));
                    dg.setSDT(rs.getString("SDT"));

                    list.add(dg);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<thuThu> getListTimKiemThuThu(){
        ArrayList<thuThu> list = new ArrayList<>();
        String sql ="Select * FROM ThuThu WHERE "+timKiemThuThu.jcb1+" like ?";
        try {
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, "%"+timKiemThuThu.jt1+"%");
            ResultSet rs = p.executeQuery();
                while(rs.next()){
                    thuThu tt = new thuThu();
                    tt.setMaThuThu(rs.getString("MaThuThu"));
                    tt.setTenThuThu(rs.getString("TenThuThu"));
                    tt.setGioiTinh(rs.getString("GioiTinh"));
                    tt.setNgaySinh(rs.getString("NgaySinh"));
                    tt.setSoCMT(rs.getString("SoCMT"));
                    tt.setDiaChi(rs.getString("DiaChi"));
                    tt.setSDT(rs.getString("SDT"));

                    list.add(tt);
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    ArrayList<muonTra> getListTimKiemMuonTra() {
        ArrayList<muonTra> list = new ArrayList<>();
        String sql= "SELECT * FROM QuanLyMuonTra WHERE " + timKiemMuonTra.jcb1 + " like ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, "%"+ timKiemMuonTra.jt1 +"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                muonTra mt = new muonTra();
                mt.setMaMuonTra(rs.getString("MaMuonTra"));
                mt.setMaDocGia(rs.getString("MaDocGia"));
                mt.setMaThuThu(rs.getString("MaThuThu"));
                mt.setNgayMuon(rs.getString("NgayMuon"));
                mt.setNgayHenTra(rs.getString("NgayHenTra"));
                mt.setTienCoc(rs.getInt("TienCoc"));
                
                list.add(mt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    ArrayList<chiTietMuonTra> getListTimKiemChiTietMuonTra() {
        ArrayList<chiTietMuonTra> list = new ArrayList<>();
        String sql= "SELECT * FROM ChiTietMuonTra WHERE " + timKiemChiTietMuonTra.jcb1 + " like ?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, "%"+timKiemChiTietMuonTra.jt1+"%");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                chiTietMuonTra ctmt = new chiTietMuonTra();
                ctmt.setMaMuonTra(rs.getString("MaMuonTra"));
                ctmt.setMaSach(rs.getString("MaSach"));
                ctmt.setSoLuong(rs.getInt("SoLuong"));
                ctmt.setNgayTra(rs.getString("NgayTra"));
                ctmt.setTienPhat(rs.getInt("TienPhat"));
                
                list.add(ctmt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
}
