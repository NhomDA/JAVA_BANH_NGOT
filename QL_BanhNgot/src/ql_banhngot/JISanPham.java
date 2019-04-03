/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_banhngot;

import Model.SanPham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class JISanPham extends javax.swing.JInternalFrame {

    /**
     * Creates new form JISanPham
     */
    private final SanPham sp = new SanPham();
    private boolean cothem = true;
    private final DefaultTableModel tableModel = new DefaultTableModel();
    
    public final void ShowDataCombobox(){
        ResultSet resultSet = null;
        try{
            resultSet = sp.ShowLoaiSP();
            while(resultSet.next()){
                cboxMaLoai.addItem(resultSet.getString("Maloai"));
            }
        }
        catch(SQLException e){
            
        }
    }
    
    
    public void ClearData(){
        int n = tableModel.getRowCount() - 1;
        for (int i = n; i >= 0; i--) {
            tableModel.removeRow(i);
        }
    }
    
    public final void ShowData() throws SQLException{
        ResultSet result = null;
        result = sp.ShowSanPham();
        try{
            ClearData();
            while(result.next()){
                String rows[] = new String[4];
                rows[0] = result.getString(1);
                rows[1] = result.getString(2);
                rows[2] = result.getString(3);
                rows[3] = result.getString(4);
                tableModel.addRow(rows);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, "Dữ liệu trống","Thông báo",JOptionPane.OK_OPTION);
        }
    }
    
    private void setNull(){
        this.txtMaSP.setText(null);
        this.txtTenSP.setText(null);
        this.txtGia.setText(null);
        this.txtTenLoai.setText(null);
        this.txtMaSP.requestFocus();
    }
    
    private void setKhoa(boolean a){
        this.txtMaSP.setEnabled(!a);
        this.txtTenSP.setEnabled(!a);
        this.txtGia.setEnabled(!a);
        this.txtTenLoai.setEnabled(!a);
        cboxMaLoai.setEnabled(!a);
    }
    
    private void setButton(boolean a){
        this.btnThem.setEnabled(a);
        this.btnXoa.setEnabled(a);
        this.btnSua.setEnabled(a);
        this.btnLuu.setEnabled(!a);
        this.btnHuy.setEnabled(!a);
    }
    
    public JISanPham() throws SQLException {
        initComponents();
        String []colsName = {"Mã SP", "Tên SP", "Giá", "Loại SP"};
        tableModel.setColumnIdentifiers(colsName);
        tableSP.setModel(tableModel);
        ShowData();
        ShowDataCombobox();
        setNull();
        setKhoa(true);
        setButton(true);
        this.btnTimKiem.setEnabled(false);
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
        txtMaSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboxMaLoai = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSP = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();

        setClosable(true);
        setTitle("SẢN PHẨM");

        jLabel1.setText("Mã sản phẩm");

        jLabel2.setText("Tên sản phẩm");

        jLabel3.setText("Giá");

        jLabel4.setText("Mã loại");

        cboxMaLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn loại--" }));
        cboxMaLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxMaLoaiItemStateChanged(evt);
            }
        });
        cboxMaLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboxMaLoaiMouseClicked(evt);
            }
        });

        tableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Mã loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSP.setFillsViewportHeight(true);
        tableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableSP);
        if (tableSP.getColumnModel().getColumnCount() > 0) {
            tableSP.getColumnModel().getColumn(0).setResizable(false);
            tableSP.getColumnModel().getColumn(1).setResizable(false);
            tableSP.getColumnModel().getColumn(2).setResizable(false);
            tableSP.getColumnModel().getColumn(3).setResizable(false);
        }

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");

        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên loại:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(22, 22, 22)
                                .addComponent(btnXoa)
                                .addGap(26, 26, 26)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTimKiem))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                    .addComponent(txtMaSP)
                                    .addComponent(txtGia))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTenLoai))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cboxMaLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnLuu)
                                    .addComponent(btnHuy))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu)
                    .addComponent(jLabel5)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboxMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        setNull();
        setKhoa(false);
        this.txtMaSP.setEnabled(false);
        txtMaSP.setText(null);
        setButton(false);
        this.txtTenLoai.setEnabled(false);
        cothem = true;
    }//GEN-LAST:event_btnThemActionPerformed

    private void tableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSPMouseClicked
        // TODO add your handling code here:
        try{
            int row = this.tableSP.getSelectedRow();
            String ma = this.tableSP.getModel().getValueAt(row,0).toString();
            ResultSet rs = sp.ShowSanPhamTheoMa(ma);
            if(rs.next()){
                this.txtMaSP.setText(rs.getString("MaSP"));
                this.txtTenSP.setText(rs.getString("TenSP"));
                this.txtGia.setText(rs.getString("gia"));
                this.cboxMaLoai.setSelectedItem(rs.getString("Maloai"));
                this.txtTenLoai.setText(rs.getString("Tenloai"));
            }
        }
        catch(SQLException e){

        }
    }//GEN-LAST:event_tableSPMouseClicked

    private void cboxMaLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboxMaLoaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxMaLoaiMouseClicked

    private void cboxMaLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxMaLoaiItemStateChanged
        // TODO add your handling code here:
        ResultSet resultSet = null;
        try{
            resultSet = sp.ShowLoaiSP();
            while(resultSet.next()){
                if(this.cboxMaLoai.getSelectedItem().toString().equals(resultSet.getString("Maloai")))
                txtTenLoai.setText(resultSet.getString("Tenloai"));
            }
        }
        catch(SQLException e){
            
        }
    }//GEN-LAST:event_cboxMaLoaiItemStateChanged

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        String ma = txtMaSP.getText();
        try{
            if(ma.length() == 0){
                JOptionPane.showMessageDialog(null,"Chọn một sp để xóa","Thông báo",1);
            }
            else{
                if(JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sản phầm "+ma+" này hay không?","Thông báo",2 ) == 0){
                    sp.DeleteSP(ma);
                    ClearData();
                    ShowData();
                    setNull();
                }
            }
        }
        catch(SQLException e){
            Logger.getLogger(JISanPham.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        String ma = txtMaSP.getText();
        if(ma.length() == 0){
            JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm cần sửa","Thông báo",1);
        }
        else{
            setKhoa(false);
            this.txtMaSP.setEnabled(false);
            setButton(false);
            cothem = false;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        String ma=txtMaSP.getText();
        String ten = txtTenSP.getText();
        int gia = Integer.parseInt(txtGia.getText());
        String TenLoai=txtTenLoai.getText();
        String loai = cboxMaLoai.getSelectedItem().toString();
        if(ten.length() == 0){
            JOptionPane.showMessageDialog(null,"Vui lòng nhập đầy đủ thông tin","Thông báo", 1);
        }
        else{
                try{
                    if(cothem){
                        sp.InsertSP(ten, gia, loai);
                    }
                    else{
                        sp.EditSP(ma, ten, gia, loai);
                        sp.EditLoaiSP(loai, TenLoai);
                    }
                    ClearData();
                    ShowData();
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Cập nhật thất bại","Thông báo",1);
                }
                setNull();
                setKhoa(true);
                setButton(true);
            }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        setNull();
        setKhoa(true);
        setButton(true);
    }//GEN-LAST:event_btnHuyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboxMaLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableSP;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
