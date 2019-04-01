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
}
