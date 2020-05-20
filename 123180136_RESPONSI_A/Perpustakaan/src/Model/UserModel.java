package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserModel {
    Statement statement;

    public String[][] login(String sUsername, String sPassword){
        try{
            int jmlData = 0;

            String data[][] = new String[1][3];

            String query = "SELECT * FROM user WHERE (`username` = '"+ sUsername +"') AND `password` = '"+ sPassword +"'";
            statement = KoneksiDatabase.getKoneksi().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[0][0] = resultSet.getString("user_id");
                data[0][1] = resultSet.getString("username");
                data[0][2] = resultSet.getString("password");
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void  insertUser(String username, String password) {
        try{
            String query = "INSERT INTO `user` (`username`,  `password`) VALUES ('"+username+"','"+password+"')";
            statement = KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("User Successfully Added");
            JOptionPane.showMessageDialog(null, "User Successfully Added");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void deleteUser (String username) {
        try{
            String query = "DELETE FROM `user` WHERE `username` = '"+username+"'";
            statement = KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public void simpan(String a) {
        try{
            String query = "UPDATE anggota_aktif SET `id`='"+a+"'";
            statement = KoneksiDatabase.getKoneksi().createStatement();
            statement.execute(query);
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
