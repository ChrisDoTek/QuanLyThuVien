package quanlythuvien;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import static quanlythuvien.xuatPhieuMuon.con;
import static quanlythuvien.xuatPhieuMuon.jcb1;
import static quanlythuvien.xuatPhieuMuon.listPM;

public class thongKeSach extends javax.swing.JFrame {
    private ArrayList<sach> listSach;
    DefaultTableModel model;
    public static Connection con;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
		         "databaseName=quanlythuvien;integratedSecurity=True";
    
    public thongKeSach() {
        initComponents();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
        }
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) jTable1.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        TableRowSorter sorter = new TableRowSorter(model); 
        jTable1.setRowSorter(sorter); 
        showTable();
    }

    ArrayList<sach> getListtkSach() {
        ArrayList<sach> listSach = new ArrayList<>();
        String sql= "select distinct Sach.MaSach, Sach.TenSach, Sach.TheLoai, SoLuongMuon=Sum(ChiTietMuonTra.SoLuong), SoLuongCon=Sach.SoLuong\n" +
                    "from ChiTietMuonTra join Sach on ChiTietMuonTra.MaSach=Sach.MaSach\n" +
                    "group by Sach.MaSach, Sach.TheLoai, Sach.TenSach, Sach.SoLuong, Sach.TheLoai";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                sach s = new sach();
                s.setMaSach(rs.getString("MaSach").trim());
                s.setTenSach(rs.getString("TenSach").trim());
                s.setTheLoai(rs.getString("TheLoai").trim());
                s.setSoLuongCon(rs.getInt("SoLuongCon"));
                s.setSoLuongMuon(rs.getInt("SoLuongMuon"));
                
                listSach.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSach;
    }
    
    private int i=1;
    
    int n=1;
    private String ten;
    
    private void xuatRaExcel() {
        WritableWorkbook workbook;
        
        // create workbook
        try {
            File f = new File("Bang_Thong_Ke"+n+".xls");
            while(f.exists()){
                n++;
                f = new File("Bang_Thong_Ke"+n+".xls");
            }
            workbook = Workbook.createWorkbook(f);
            ten = f.getName();
 
            // create sheet
            WritableSheet sheet1 = workbook.createSheet("Sách", 0);
 
            // create Label and add to sheet
            sheet1.addCell(new Label(0, 0, "DANH MỤC SÁCH CỦA THƯ VIỆN"));
 
            // row begin write data
            int rowBegin = 2;
            int h=1;
            
            Object[] ojb1 = new Object[] {"STT", "Mã sách", "Tên sách", "Thể loại", "Số lượng trong kho", "Đã cho mượn"};
            for(int j=0; j<6; j++)
                sheet1.addCell(new Label(j, rowBegin, ojb1[j].toString()));
            rowBegin++;
            
            for (sach s : listSach) {
                Object[] ojb = new Object[] {h++, s.getMaSach(), s.getTenSach(), s.getTheLoai(), s.getSoLuongCon(), s.getSoLuongMuon()};
                
                for(int j=0; j<6; j++)
                    sheet1.addCell(new Label(j, rowBegin, ojb[j].toString()));
                rowBegin++;
            }
            // write file
            workbook.write();
 
            // close
            workbook.close();
        } catch (IOException e) {
            System.out.println("Error create file\n" + e.toString());
        } catch (RowsExceededException e) {
            System.out.println("Error write file\n" + e.toString());
        } catch (WriteException e) {
            System.out.println("Error write file\n" + e.toString());
        }
        JOptionPane.showMessageDialog(null, "Đã xuất "+ten, "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
    
    public void showTable() { //xuất bảng
        listSach = getListtkSach();
        for (sach s : listSach) {
            model.addRow(new Object[]{
                i++, s.getMaSach(), s.getTenSach(), s.getTheLoai(), s.getSoLuongCon(), s.getSoLuongMuon()
            });
        }
    }
    
    public void clearTable() { //xóa bảng
            while(i!=1){
                i--;
                model.removeRow(i-1);
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đỗ Đoàn Kết - 2017104051");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("THỐNG KÊ SÁCH");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Thể loại", "Số lượng trong kho", "Số lượng cho mượn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setText("Close");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Xuất phiếu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(283, 283, 283)
                .addComponent(jLabel1)
                .addContainerGap(300, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(evt.getSource()==jButton8){
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int click = JOptionPane.showOptionDialog(null, "Xuất bản thống kê?", "Xác nhận!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, null, null);
        if(click==JOptionPane.YES_NO_OPTION){
            xuatRaExcel();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(thongKeSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongKeSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongKeSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongKeSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thongKeSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
