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
 * @author HP
 */
public class SanPham {
    public database cn = new database();
    public ResultSet ShowLoaiSP() throws SQLException{
        String sql = "SELECT * FROM LoaiSP";
        return cn.ExcuteQueryGetTable(sql);
    }
    
    public ResultSet ShowLoaiSP(String ml) throws SQLException{
        String sql = "SELECT * FROM LoaiSP WHERE Maloai = '"+ml+"'";
        return cn.ExcuteQueryGetTable(sql);
    }
    
    public ResultSet ShowSPTheoLoai(String ml){
        String sql = "SELECT MaSP, TenSP, gia, Tenloai FROM SanPham S, LoaiSP L WHERE L.Maloai = S.Maloai and L.Maloai = '" + ml + "'";
        return cn.ExcuteQueryGetTable(sql);
    }
    
    public ResultSet ShowSanPham() throws SQLException{
        String sql = "SELECT MaSP, TenSP, gia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai";
        return cn.ExcuteQueryGetTable(sql);
    }
    
    public ResultSet ShowSanPhamTheoMa(String ma) throws SQLException{
        String sql = "SELECT MaSP, TenSP, gia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND MaSP = '" + ma +"'"; ;
        return cn.ExcuteQueryGetTable(sql);
    }
    
    public ResultSet ShowSanPhamTheoTen(String ten) throws SQLException{
        String sql = "SELECT MaSP, TenSP, gia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND TenSP LIKE '%" + ten +"%'";
        return cn.ExcuteQueryGetTable(sql);
    }
    
    public void InsertSP(String ten, int dg, String ml) throws SQLException{
        String sql = "INSERT INTO Sanpham VALUES(N'" + ten + "'," + dg + ",'" + ml + "')";
        cn.ExcuteQueryUpdateDB(sql);
    }
    
    public void EditSanPham(String ma, String ten, int dg, String ml){
        String truyvan = "UPDATE SanPham SET TenSP = N'"+ten+"', gia="+dg+", Maloai = '"+ml+"' WHERE MaSP = '"+ma+"'";
        cn.ExcuteQueryUpdateDB(truyvan);
    }
    public void EditLoaiSP(String MaLoai, String tenLoai){
        String sql = "UPDATE LoaiSP SET TenLoai = N'"+tenLoai+"' WHERE MaLoai = '"+MaLoai+"'";
        cn.ExcuteQueryUpdateDB(sql);
    }
    
    public void DeleteSP(String ma) throws SQLException{
        String sql = "DELETE FROM SanPham WHERE MaSP = '"+ma+"'";
        cn.ExcuteQueryUpdateDB(sql);
    }
    
    public ResultSet ShowSPTheoGia(int giaTu, int giaDen) throws SQLException{
        String sql = "SELECT MaSP, TenSP, gia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND gia >= " +giaTu +" AND gia <= " +giaDen;
        return cn.ExcuteQueryGetTable(sql);
    }
    public ResultSet SanPhamTheoTen(String ten) throws SQLException{
        String sql = "SELECT MaSP, TenSP, gia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND TenSP ='" + ten +"'";
        return cn.ExcuteQueryGetTable(sql);
    }
    public void ThemHD(String NgayLap){
        String sql = "insert into HoaDon values ('"+ NgayLap +"')";
        cn.ExcuteQueryUpdateDB(sql);	        
    }
    public ResultSet ShowSanPhamTheoTenVaLoai(String ten,String loai) throws SQLException{
        if(loai.equals("Tất cả")){
            loai="";
        }
        String sql = "SELECT MaSP, TenSP, gia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND TenSP LIKE '%" + ten +"%' AND L.TenLoai LIKE '%" + loai +"%'";
        return cn.ExcuteQueryGetTable(sql);
    }
    public int GetLastMHD() throws SQLException{
        String sql = "select top(1) * from HoaDon ORDER BY HoaDon.MaHD DESC";
        int i =-1;
        ResultSet res = cn.ExcuteQueryGetTable(sql);
        if(res.next()){
            i = Integer.parseInt(res.getString("MaHD"));
        }
        return i;
    }

    public void ThemChiTietHD(String MaHD,String MaSP,int SL,long Gia){
        String sql = "insert into ChiTietHoaDon values ('"+MaHD+"','"+MaSP+"',"+SL+","+Gia+")";
        cn.ExcuteQueryUpdateDB(sql);	                
    }
    
}
