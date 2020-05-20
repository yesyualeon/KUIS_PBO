package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProfileModel {
    Statement statement;

    public String[][] readProfile(String user_id) {
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakDataProfile(user_id)][2];

            String query = "SELECT * FROM `user` JOIN `anggota` ON `anggota`.`id_anggota` = `user`.`id_anggota` WHERE `user_id` = '"+user_id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            //int i = 1;
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = resultSet.getString("id_anggota");
                jmlData++;
                //i++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakDataProfile(String user_id) {
        int jmlData = 0;
        try{
            statement = KoneksiDatabase.getKoneksi().createStatement();
            String query = "SELECT * FROM `user` JOIN `anggota` ON `anggota`.`id_anggota` = `user`.`id_anggota` WHERE `user_id` = '"+user_id+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

}
