/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.database;
import java.sql.ResultSet;
/**
 *
 * @author ASUS
 */
public class TruyVan {
    database db;
    public TruyVan()
    {
        db =  new database();
    }
    public ResultSet taikhoan(String tk)
    {
        String sql = "select * from DangNhap where TK=N'"+tk+"'";
        return db.ExcuteQueryGetTable(sql);
    }
    public ResultSet NhanVien(){
        String sql = "select * from NhanVien";
        return db.ExcuteQueryGetTable(sql);
    }
    public ResultSet ListTaiKhoan(){
        String sql = "select TK, MK, a.MaPQ, TenPQ from DangNhap a, PhanQuyen b where a.MaPQ = b.MaPQ";
        return db.ExcuteQueryGetTable(sql);
    }
    public ResultSet ListTaiKhoan(String tk){
        String sql = "select TK, MK, a.MaPQ, TenPQ from DangNhap a, PhanQuyen b where a.MaPQ = b.MaPQ and TK like N'"+tk+"%'";
        return db.ExcuteQueryGetTable(sql);
    }
    public ResultSet Quyen(){
        String sql = "select * from PhanQuyen";
        return db.ExcuteQueryGetTable(sql);
    }
    public void ThemTK( String TK,String MK,int quyen) {         
        String sql = "insert into DangNhap(TK,MK,MaPQ) values ('"+TK+"','"+MK+"',"+quyen+")";
        db.ExcuteQueryUpdateDB(sql);	
    }
    public void SuaTK( String TK, String MK,int quyen) {         
        String sql = "update DangNhap set MK= '"+MK+"',MaPQ= "+quyen+" where TK='"+TK+"'";
        db.ExcuteQueryUpdateDB(sql);	
    }
    public void XoaTK(String TK) {	
        String sql = "delete from DangNhap where TK='"+TK+"'";
        db.ExcuteQueryUpdateDB(sql);	
    }
}
