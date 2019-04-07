/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Ngan Tuyet
 */
public class NhanVien {
    public database cn = new database();

    public ResultSet ShowNhanVien() throws SQLException{
        String sql = "SELECT * FROM NhanVien";
        return cn.ExcuteQueryGetTable(sql);
    }
    public ResultSet ShowNhanVienTheoMa(String nv) throws SQLException{
        String sql = "SELECT * FROM NhanVien WHERE MaNV = '"+nv+"'";
        return cn.ExcuteQueryGetTable(sql);
    }
    public void XoaNhanVien(String nv) throws SQLException{
        String sql = "DELETE FROM NhanVien WHERE MaNV = '"+nv+"'";
        cn.ExcuteQueryUpdateDB(sql);
    }
    public void ThemNhanVien(String ten, String sdt, String ns) throws SQLException{
        String sql = "INSERT INTO NhanVien VALUES(N'" + ten + "'," + sdt + ",'" + ns + "')";
        cn.ExcuteQueryUpdateDB(sql);
    }    
    public void SuaNhanVien(String ma, String ten, String sdt, String ns){
        String sql = "UPDATE NhanVien SET TenNV = N'"+ten+"', SDT="+sdt+", Namsinh = '"+ns+"' WHERE MaNV = '"+ma+"'";
        cn.ExcuteQueryUpdateDB(sql);
    }
    public ResultSet ShowNhanVienTheoTen(String tennv) throws SQLException{
        String sql = "SELECT * FROM NhanVien WHERE TenNV = N'"+tennv+"'";
        return cn.ExcuteQueryGetTable(sql);
    }
}
