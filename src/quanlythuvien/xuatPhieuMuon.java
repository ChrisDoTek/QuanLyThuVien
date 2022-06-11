/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlythuvien;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import static quanlythuvien.connect.con;

/**
 *
 * @author Administrator
 */
public class xuatPhieuMuon extends javax.swing.JFrame {
    
    public static String jt1, jt2, jt3, jt4, jt5, jt6, jt7;
    public static ArrayList<phieuMuon> listPM;
    DefaultTableModel tModel;
    public static Connection con;
    String connectionUrl = "jdbc:sqlserver://localhost:1433;" +  
		         "databaseName=quanlythuvien;integratedSecurity=True";
    
    
    private DefaultComboBoxModel cModel;
    /**
     * Creates new form xuatHoaDon
     */
    public xuatPhieuMuon() {
        initComponents();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
        }
        this.setLocationRelativeTo(null);
        tModel = (DefaultTableModel) jTable1.getModel();
        tModel.getDataVector().removeAllElements();
        tModel.fireTableDataChanged();
        TableRowSorter sorter = new TableRowSorter(tModel); 
        jTable1.setRowSorter(sorter); 
        nhapDuLieuCBB();
        nhapDuLieuJTf();
    }
    
    private void nhapDuLieuCBB(){
        String sqlcbb ="Select MaMuonTra from QuanLyMuonTra";
        try {
            PreparedStatement p = con.prepareStatement(sqlcbb);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                this.jComboBox1.addItem(rs.getString("MaMuonTra"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void nhapDuLieuJTf(){
        String sqljt ="select ChiTietMuonTra.MaMuonTra, DocGia.TenDocGia, DocGia.MaDocGia, DocGia.DiaChi, DocGia.SDT, QuanLyMuonTra.NgayMuon, QuanLyMuonTra.NgayHenTra, QuanLyMuonTra.TienCoc\n" +
            "from chiTietMuonTra, QuanLyMuonTra, Sach, DocGia\n" +
            "where ChiTietMuonTra.MaMuonTra=QuanLyMuonTra.MaMuonTra\n" +
            "and ChiTietMuonTra.MaSach=Sach.MaSach\n" +
            "and QuanLyMuonTra.MaDocGia=DocGia.MaDocGia\n" +
            "and ChiTietMuonTra.MaMuonTra=?";
        try {
            PreparedStatement p = con.prepareStatement(sqljt);
            p.setString(1, (String) jComboBox1.getSelectedItem());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                jTextField1.setText(rs.getString("TenDocGia").trim());
                jTextField2.setText(rs.getString("MaDocGia").trim());
                jTextField3.setText(rs.getString("DiaChi").trim());
                jTextField4.setText(rs.getString("SDT").trim());
                jTextField5.setText(rs.getString("NgayMuon").trim());
                jTextField6.setText(rs.getString("NgayHenTra").trim());
                jTextField7.setText(rs.getString("TienCoc").trim());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String jcb1;
    
    ArrayList<phieuMuon> getListPhieuMuon() {
        jcb1=(String) jComboBox1.getSelectedItem();
        ArrayList<phieuMuon> listPM = new ArrayList<>();
        String sql= "select distinct Sach.MaSach, Sach.TenSach, SoLuongMuon=Sum(ChiTietMuonTra.SoLuong)\n" +
            "from ChiTietMuonTra join Sach on ChiTietMuonTra.MaSach=Sach.MaSach\n" +
            "where MaMuonTra='"+jcb1+"'\n" +
            "group by Sach.MaSach, Sach.TenSach";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                phieuMuon pm = new phieuMuon();
                pm.setMaSach(rs.getString("MaSach").trim());
                pm.setTenSach(rs.getString("TenSach").trim());
                pm.setSoLuong(rs.getInt("SoLuongMuon"));
                
                listPM.add(pm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPM;
    }
    
    int i=1;
    
    public void showTable() { //xuất bảng
        listPM = getListPhieuMuon();
        for (phieuMuon pm : listPM) {
            tModel.addRow(new Object[]{
                i++, pm.getMaSach(), pm.getTenSach(), pm.getSoLuong()
            });
        }
    }
    
    public void clearTable() { //xóa bảng
            while(i!=1){
                i--;
                tModel.removeRow(i-1);
            }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đỗ Đoàn Kết - 2017104052");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("XUẤT PHIẾU MƯỢN");

        jLabel2.setText("Mã mượn trả");

        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên độc giả");

        jLabel4.setText("Mã độc giả");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("Số điện thoại");

        jLabel8.setText("Ngày mượn");

        jLabel9.setText("Ngày hẹn trả");

        jLabel10.setText("Tiền cọc");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Số lượng mượn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(3).setMinWidth(105);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(105);
        }

        jButton1.setText("Xuất phiếu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hủy");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(42, 42, 42)
                                .addComponent(jTextField7))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 155, Short.MAX_VALUE)
                                    .addComponent(jTextField2)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jTextField5)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel10))
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int click = JOptionPane.showOptionDialog(null, "Xuất phiếu mượn?", "Xác nhận!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null, null, null);
        if(click==JOptionPane.YES_NO_OPTION){
            inPhieuMuon in = new inPhieuMuon();
            try {
                in.inPhieuMuon();
                String ten = inPhieuMuon.tenPhieu;
                JOptionPane.showMessageDialog(null, "Đã xuất phiếu "+ten, "Thông báo", JOptionPane.WARNING_MESSAGE);
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(evt.getSource()==jComboBox1){
            nhapDuLieuJTf();
            clearTable();
            showTable();
            jt1=jTextField1.getText();
            jt2=jTextField2.getText();
            jt3=jTextField3.getText();
            jt4=jTextField4.getText();
            jt5=jTextField5.getText();
            jt6=jTextField6.getText();
            jt7=jTextField7.getText();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
            
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(evt.getSource()==jButton2){
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(xuatPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(xuatPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(xuatPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(xuatPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new xuatPhieuMuon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
