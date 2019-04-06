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
    public ResultSet listThongKe()
    {
        String sql = "select a.MaHD, c.TenSP, b.SL, b.DonGia, a.NgayLap from HoaDon a, ChiTietHoaDon b, SanPham c where a.MaHD = b.MaHD AND b.MaSP = c.MaSP";
        return db.ExcuteQueryGetTable(sql);
    }
    public ResultSet Sanpham()
    {
        String sql = "select MaSP, TenSP from SanPham";
        return db.ExcuteQueryGetTable(sql);
    }
    public void XoaCTHD(String maHD, int maSP) {	
        String sql = "delete from ChiTietHoaDon where MaHD="+maHD+" AND MaSP="+maSP+"";
        db.ExcuteQueryUpdateDB(sql);	
    }
    public ResultSet listThongKe(String ngay)
    {
        String sql = "select a.MaHD, c.TenSP, b.SL, b.DonGia, a.NgayLap from HoaDon a, ChiTietHoaDon b, SanPham c where a.MaHD = b.MaHD AND b.MaSP = c.MaSP AND a.NgayLap like '%"+ngay+"%'";
        return db.ExcuteQueryGetTable(sql);
    }
    public void ThemNV( String tennv,String sdt,String nam) {         
        String sql = "set dateformat dmy insert into NhanVien(TenNV,SDT,NamSinh) values (N'"+tennv+"','"+sdt+"','"+nam+"')";
        db.ExcuteQueryUpdateDB(sql);	
    }
    public void SuaNV(int id , String tennv,String sdt,String nam) {         
        String sql = "set dateformat dmy update NhanVien set TenNV = N'"+tennv+"',SDT = '"+sdt+"', NamSinh = '"+nam+"' where MaNV ="+id+"";
        db.ExcuteQueryUpdateDB(sql);	
    }
    public void XoaNV(int id) {	
        String sql = "delete from NhanVien where  MaNV ="+id+"";
        db.ExcuteQueryUpdateDB(sql);	
    }
    public ResultSet listNV(String ten)
    {
        String sql = "select * from NhanVien where TenNV like N'%"+ten+"%'";
        return db.ExcuteQueryGetTable(sql);
    }
}
