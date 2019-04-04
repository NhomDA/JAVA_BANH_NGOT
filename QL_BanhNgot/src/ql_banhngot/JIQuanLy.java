/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_banhngot;

import Controller.TruyVan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class JIQuanLy extends javax.swing.JInternalFrame {

    ResultSet rs = null;
    TruyVan sql;
    private String t;
    /**
     * Creates new form JIQuanLy
     */
    public JIQuanLy() {
        initComponents();
        sql = new TruyVan();
        LoadTK();
        LoadCB();

    }
    
    public void LoadTK()
    {
        rs=sql.ListTaiKhoan();
        Vector item=null;
        String kt[]={"So","Tài khoản","Mật khẩu","Quyền"};
        DefaultTableModel tableModel = new DefaultTableModel(kt,0);
        tableModel.setRowCount(0);
        int d = 0;
        try
        {
            while(rs.next())
            {
                d++;
                item = new Vector();
                item.add(d);
                item.add(rs.getString("TK")); 
                item.add(rs.getString("MK"));
                item.add(rs.getString("TenPQ"));
      
              tableModel.addRow(item);                
            }
            tbTaiKhoan.setModel(tableModel);
        } catch (SQLException ex)
        {
            System.out.println(ex.toString());
        }
    }
    public void LoadTK(String TK)
    {
        rs=sql.ListTaiKhoan(TK);
        Vector item=null;
        String kt[]={"So","Tài khoản","Mật khẩu","Quyền"};
        DefaultTableModel tableModel = new DefaultTableModel(kt,0);
        tableModel.setRowCount(0);
        int d = 0;
        try
        {
            while(rs.next())
            {
                d++;
                item = new Vector();
                item.add(d);
                item.add(rs.getString("TK")); 
                item.add(rs.getString("MK"));
                item.add(rs.getString("TenPQ"));
      
              tableModel.addRow(item);                
            }
            tbTaiKhoan.setModel(tableModel);
        } catch (SQLException ex)
        {
            System.out.println(ex.toString());
        }
    }
    public void LoadCB()
    {
        rs=sql.Quyen();
        DefaultComboBoxModel mod = new DefaultComboBoxModel();
        mod.addElement("--- Chọn quyền ---");
        try
        {
            while(rs.next())
            {                   
              mod.addElement(rs.getString("TenPQ"));                
            }
            cbQuyen.setModel(mod);
        } catch (SQLException ex)
        {
            System.out.println(ex.toString());
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

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTaiKhoan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        tittle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        txtTaikhoan = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        lb_hoten = new javax.swing.JLabel();
        lb_sdt = new javax.swing.JLabel();
        lb_namsinh = new javax.swing.JLabel();
        lb_timkiem = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        cbQuyen = new javax.swing.JComboBox<>();
        btnLoad = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximizable(true);
        setTitle("QUẢN LÝ");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        tbTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbTaiKhoan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        tittle.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        tittle.setText("QUẢN LÝ TÀI KHOẢN");
        tittle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tittle, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tittle)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        lb_hoten.setText("Tài khoản:");

        lb_sdt.setText("Mật khẩu:");

        lb_namsinh.setText("Quyền:");

        lb_timkiem.setText("Tìm kiếm");

        cbQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn", "Item 2", "Item 3", "Item 4" }));

        btnLoad.setText("Load");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_sdt)
                    .addComponent(lb_hoten)
                    .addComponent(lb_namsinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(290, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbQuyen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lb_timkiem)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(btnTim))
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_hoten)
                    .addComponent(txtTaikhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_sdt)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_namsinh)
                    .addComponent(lb_timkiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnLoad)
                    .addComponent(btnTim))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int kt = kttk();
        if(kt == 0)
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (this, "Bạn có muốn thêm","Thông báo",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                sql.ThemTK(txtTaikhoan.getText(), String.copyValueOf(txtMatKhau.getPassword()), cbQuyen.getSelectedIndex());
                LoadTK();
            }
            setnull();
            
        }
        if(kt == 1)
        {
            JOptionPane.showConfirmDialog(this,"Tài khoản đã tồn tại !!!","Thông báo",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tbTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTaiKhoanMouseClicked
        // TODO add your handling code here:
        int row = tbTaiKhoan.getSelectedRow();
        txtTaikhoan.setText((String) tbTaiKhoan.getValueAt(row, 1).toString());
        t = (String) tbTaiKhoan.getValueAt(row, 1).toString();
        txtMatKhau.setText((String) tbTaiKhoan.getValueAt(row, 2).toString());
        cbQuyen.setSelectedItem(tbTaiKhoan.getValueAt(row, 3).toString());            
    }//GEN-LAST:event_tbTaiKhoanMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int kt = kttk();
        if(kt == 1)
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (this, "Bạn có muốn sửa","Thông báo",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                sql.SuaTK(txtTaikhoan.getText(), String.copyValueOf(txtMatKhau.getPassword()), cbQuyen.getSelectedIndex());
                LoadTK();
            }
            setnull();
        }
        if(kt == 0)
        {
            JOptionPane.showConfirmDialog(this,"Bạn không được phép sửa tên tài khoản hoặc tài khoản không tồn tại","Thông báo",JOptionPane.WARNING_MESSAGE);
            txtTaikhoan.setText(t);
        }
        
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void setnull()
    {
        txtMatKhau.setText("");
        txtTaikhoan.setText("");
        txtTimKiem.setText("");
    } 
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int kt = kttk();
        if(kt == 1)
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (this, "Bạn có muốn xóa","Thông báo",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                sql.XoaTK(txtTaikhoan.getText());
                LoadTK();
            }
            setnull();
            
        }
        if(kt == 0)
        {
            JOptionPane.showConfirmDialog(this,"Tài khoản không tồn tại","Thông báo",JOptionPane.WARNING_MESSAGE);
   
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        // TODO add your handling code here:
        LoadTK();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        LoadTK(txtTimKiem.getText());
        
    }//GEN-LAST:event_btnTimActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        // TODO add your handling code here:
        if(!txtTaikhoan.getText().equals("")||txtMatKhau.getPassword().length != 0)
        {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (this, "Bạn có chắc muốn thoát khi vẫn có dữ liệu đang được nhập","Thông báo",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION)
            {
                this.dispose();
            }
        }
        else
        {
            this.dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    public int kttk()
    {
        rs = sql.ListTaiKhoan();
        if(txtTaikhoan.getText().equals("")||txtMatKhau.getPassword().length == 0)
        {
            JOptionPane.showConfirmDialog(this,"Vui lòng không để trống ô tài khoản và mật khẩu","Thông báo",JOptionPane.WARNING_MESSAGE);
            return -1;
        }
        if(cbQuyen.getSelectedIndex() == 0 )
        {
            JOptionPane.showConfirmDialog(this,"Vui lòng chọn quyền cho tài khoản","Thông báo",JOptionPane.WARNING_MESSAGE);
            return -1;
        }
        else{
            int temp = 0;
                try{
                    while(rs.next())
                    {
                        if(txtTaikhoan.getText().equals(rs.getString("TK")))
                        {
                            temp = 1;           
                        }

                    }
                }catch(SQLException ex)
                {
                    System.out.println(ex.toString());
                }        
            return temp;
        }        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbQuyen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_hoten;
    private javax.swing.JLabel lb_namsinh;
    private javax.swing.JLabel lb_sdt;
    private javax.swing.JLabel lb_timkiem;
    private javax.swing.JTable tbTaiKhoan;
    private javax.swing.JLabel tittle;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTaikhoan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
