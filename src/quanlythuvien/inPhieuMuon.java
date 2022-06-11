package quanlythuvien;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import static quanlythuvien.xuatPhieuMuon.listPM;

public class inPhieuMuon{
    public static int i=1;
    public static String tenPhieu;
    public void inPhieuMuon() throws FileNotFoundException, IOException{
        File phieuMuon = new File("Phieu_Muon_"+i+".doc");
        while(phieuMuon.exists()){
            i++;
            phieuMuon = new File("Phieu_Muon_"+i+".doc");
        }
        phieuMuon.createNewFile();
        tenPhieu=phieuMuon.getName();
        FileOutputStream fos = new FileOutputStream(phieuMuon,false);
        
        PrintWriter pw = new PrintWriter(fos);
        pw.print("                                   PHIẾU MƯỢN \n \n");
        pw.println("\nMã phiếu mượn: "+xuatPhieuMuon.jcb1);
        pw.println("\nĐộc giả      : "+xuatPhieuMuon.jt1);
        pw.println("\nMã độc giả   : "+xuatPhieuMuon.jt2);
        pw.println("\nĐịa chỉ      : "+xuatPhieuMuon.jt3);
        pw.println("\nSố điện thoại: "+xuatPhieuMuon.jt4);
        pw.println("\nNgày mượn    : "+xuatPhieuMuon.jt5);
        pw.println("\nNgày hẹn trả : "+xuatPhieuMuon.jt6);
        pw.println("\nTiền cọc     : "+xuatPhieuMuon.jt7);
        pw.print("\nDanh mục sách mượn: \n \n");
        for (phieuMuon pm : xuatPhieuMuon.listPM) {
            pw.println("Tên sách: "+pm.getTenSach()+
                    "\nSố lượng: "+pm.getSoLuong()+"\n");
        }
        pw.close();
        fos.flush();
        fos.close();
    }
}
