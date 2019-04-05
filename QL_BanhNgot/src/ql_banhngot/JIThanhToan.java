/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ql_banhngot;

import Model.SanPham;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static ql_banhngot.JINguyenLieu.model;
import static ql_banhngot.frmTrangChu.db;

/**
 *
 * @author ASUS
 */
public class JIThanhToan extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIThanhToan
     */
    static SanPham sp = new SanPham();
    static DefaultTableModel model;
    
    public void InitPhanLoai() throws SQLException{
        cbbLoai.addItem("Tất cả");
        ResultSet res = sp.ShowLoaiSP();
        try {
            while(res.next()){
                cbbLoai.addItem(res.getString("TenLoai"));
            }
        } catch (Exception e) {
        }

    }
    
    public long TinhTong(){
        long sum =0;
        for (int i=0;i<tbThanhToan.getRowCount();i++)
        {
            sum = sum + (Integer.parseInt((String)tbThanhToan.getValueAt(i, 1))*Integer.parseInt((String)tbThanhToan.getValueAt(i, 2)));
        }
        return sum;
    }
    
    Object[][] obj ;

    public int GetMaSPTheoTen(String Ten){
        for(int j=0;j<100;j++){
            if(obj[j][1].equals(Ten)){
                for(int row = 0 ; row < tbThanhToan.getRowCount(); row++)
                {
                    if(tbThanhToan.getValueAt(row, 0).equals(obj[j][1])){
                        return Integer.parseInt((String)obj[j][0]);
                    }
                }
            }
        }
        return -1;
    }
    
    public void InitSanPham() throws SQLException{
        panalSanPham.setLayout(new GridLayout(10,10));
        ResultSet res = sp.ShowSanPham();
        int len = 100;
        obj = new Object[len][];
        try {
            int i=0;
            while (res.next()) {
                obj[i] = new String[]{res.getString("MaSP"),res.getString("TenSP"),res.getString("gia")};
                JButton btn = new JButton(res.getString("TenSP"));
                btn.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model = (DefaultTableModel)(tbThanhToan.getModel());
                        String nameButton = e.getActionCommand();
                        for(int j=0;j<len;j++){
                            if(obj[j][1].equals(nameButton)){
                                int flag = 0;
                                for(int row = 0 ; row < tbThanhToan.getRowCount(); row++)
                                {
                                    if(tbThanhToan.getValueAt(row, 0).equals(obj[j][1])){
                                        int temp =  Integer.parseInt((String)tbThanhToan.getValueAt(row, 1))+1;
                                        tbThanhToan.setValueAt(""+temp, row, 1);
                                        flag = 1;
                                        txtTong.setText(""+TinhTong());
                                        break;
                                    }
                                }
                                if(flag==0){
                                    model.addRow(new Object[]{obj[j][1],"1",obj[j][2]});
                                    break;
                                    
                                }
                            }
                        }
                        txtTong.setText(""+TinhTong());
                    }
                
                });
                panalSanPham.add(btn);
                i++;
            }            
        } catch (Exception e) {
        }                 
    }
    public void InitSanPham01(String ten,String loai) throws SQLException{
        panalSanPham.setLayout(new GridLayout(10,10));
        ResultSet res = sp.ShowSanPhamTheoTenVaLoai(ten, loai);
        int len = 100;
        obj = new Object[len][];
        try {
            int i=0;
            while (res.next()) {
                obj[i] = new String[]{res.getString("MaSP"),res.getString("TenSP"),res.getString("gia")};
                JButton btn = new JButton(res.getString("TenSP"));
                btn.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model = (DefaultTableModel)(tbThanhToan.getModel());
                        String nameButton = e.getActionCommand();
                        for(int j=0;j<len;j++){
                            if(obj[j][1].equals(nameButton)){
                                int flag = 0;
                                for(int row = 0 ; row < tbThanhToan.getRowCount(); row++)
                                {
                                    if(tbThanhToan.getValueAt(row, 0).equals(obj[j][1])){
                                        int temp =  Integer.parseInt((String)tbThanhToan.getValueAt(row, 1))+1;
                                        tbThanhToan.setValueAt(""+temp, row, 1);
                                        flag = 1;
                                        txtTong.setText(""+TinhTong());
                                        break;
                                    }
                                }
                                if(flag==0){
                                    model.addRow(new Object[]{obj[j][1],"1",obj[j][2]});
                                    break;
                                    
                                }
                            }
                        }
                        txtTong.setText(""+TinhTong());
                    }
                
                });
                panalSanPham.add(btn);
                i++;
            }            
        } catch (Exception e) {
        }                 
    }
    
    
    public JIThanhToan() throws SQLException {
        initComponents();
        InitPhanLoai();
        ClearPanelSP();
        InitSanPham();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panalSanPham = new javax.swing.JPanel();
        txtTong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnThanhToa = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbThanhToan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbbLoai = new javax.swing.JComboBox();
        txtTimkiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panalSanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panalSanPhamLayout = new javax.swing.GroupLayout(panalSanPham);
        panalSanPham.setLayout(panalSanPhamLayout);
        panalSanPhamLayout.setHorizontalGroup(
            panalSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panalSanPhamLayout.setVerticalGroup(
            panalSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txtTong.setBackground(new java.awt.Color(255, 255, 102));
        txtTong.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTong.setEnabled(false);

        jLabel1.setText("Tổng:");

        btnThanhToa.setText("Thanh toán");
        btnThanhToa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToaMouseClicked(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHuyMouseClicked(evt);
            }
        });

        tbThanhToan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên", "Số lượng", "Giá"
            }
        ));
        tbThanhToan.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tbThanhToanInputMethodTextChanged(evt);
            }
        });
        jScrollPane2.setViewportView(tbThanhToan);

        jLabel4.setText("Loại:");

        cbbLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLoaiItemStateChanged(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnTimKiem))
                    .addComponent(panalSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHuy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTong))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThanhToa)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThanhToa)
                            .addComponent(btnXoa)
                            .addComponent(btnHuy)))
                    .addComponent(panalSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("THANH TOÁN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ClearPanelSP(){
        Component[] componentList = panalSanPham.getComponents();

        //Loop through the components
        for(Component c : componentList){

            //Find the components you want to remove
            if(c instanceof JButton){

                //Remove it
                panalSanPham.remove(c);
            }
        }

        //IMPORTANT
        panalSanPham.revalidate();
        panalSanPham.repaint();        
    }
    
    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        ClearPanelSP();
        try {
            InitSanPham01(txtTimkiem.getText(), (String)cbbLoai.getSelectedItem());
        } catch (SQLException ex) {
            Logger.getLogger(JIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void tbThanhToanInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbThanhToanInputMethodTextChanged
        // TODO add your handling code here:
        System.err.println("hellofrt");
    }//GEN-LAST:event_tbThanhToanInputMethodTextChanged

    private void btnHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseClicked
        // TODO add your handling code here:
        for(int i=tbThanhToan.getRowCount()-1;i>=0;i--){
            model.removeRow(i);
        }
        txtTong.setText(""+TinhTong());
    }//GEN-LAST:event_btnHuyMouseClicked

    private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseClicked
        // TODO add your handling code here:
        if(tbThanhToan.getSelectedRow()==-1){
            showMessageDialog(null, "Vui lòng chọn dòng muốn xóa!", "Thông báo", ERROR_MESSAGE);
        }else{
//            JPanel panel = new JPanel(new GridLayout(0, 1));
//            panel.add(new JLabel("Bạn có muốn xóa không ?"));
//            int result = JOptionPane.showConfirmDialog(null, panel, "Thông báo",
//                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//            if (result == JOptionPane.OK_OPTION) {
//                int[] ob = tbThanhToan.getSelectedRows();
//                for(int i=ob.length-1;i>=0;i--){
//                    model.removeRow(ob[i]);
//                }
//            } else {
//                System.out.println("Cancelled");
//            }
            int[] ob = tbThanhToan.getSelectedRows();
            for(int i=ob.length-1;i>=0;i--){
                model.removeRow(ob[i]);
            }
            txtTong.setText(""+TinhTong());
            
        }


    }//GEN-LAST:event_btnXoaMouseClicked

    private void btnThanhToaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToaMouseClicked
        // TODO add your handling code here:
        if(tbThanhToan.getRowCount()<=0){
            JOptionPane.showMessageDialog(null, "Không có gì để thanh toán !","Thông báo",OK_OPTION);
        }else{
            LocalDateTime n = java.time.LocalDateTime.now();
            sp.ThemHD(n.toString().substring(0,10));
            try {
                int MaHD = sp.GetLastMHD();
                for(int i=0;i<tbThanhToan.getRowCount();i++){
                    sp.ThemChiTietHD(""+MaHD,""+GetMaSPTheoTen((String)tbThanhToan.getValueAt(i, 0)), Integer.parseInt((String)tbThanhToan.getValueAt(i, 1)), Integer.parseInt((String)tbThanhToan.getValueAt(i, 2)));
                }
            } catch (SQLException ex) {
                Logger.getLogger(JIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Bạn có muốn in hóa đơn không ?"));
            int result = JOptionPane.showConfirmDialog(null, panel, "Thông báo",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                // code in hoa don
            }
            
            btnHuyMouseClicked(evt);
        }
    }//GEN-LAST:event_btnThanhToaMouseClicked
    private void cbbLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLoaiItemStateChanged
        // TODO add your handling code here:
        ClearPanelSP();
        try {
            InitSanPham01(txtTimkiem.getText(), (String)cbbLoai.getSelectedItem());
        } catch (SQLException ex) {
            Logger.getLogger(JIThanhToan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cbbLoaiItemStateChanged
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThanhToa;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox cbbLoai;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panalSanPham;
    private javax.swing.JTable tbThanhToan;
    private javax.swing.JTextField txtTimkiem;
    private javax.swing.JTextField txtTong;
    // End of variables declaration//GEN-END:variables
}
