package Model;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PinjamModel {
    Statement statement;

    public void insertPinjam(String id_anggota, String id_buku) {
        try {
            String query = "INSERT INTO `pinjam` (`id_pinjam`,`id_buku`,`id_anggota`) VALUES (NULL,'" + id_buku + "','" + id_anggota + "')";
            statement = KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully Borrowed");
            JOptionPane.showMessageDialog(null, "Successfully Borrowed");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void insertAnggota(String id_anggota, String nama, String id_buku) {
        try {
            String query = "INSERT INTO `anggota` (`id_anggota`,`nama`,`id_buku`) VALUES ('" + id_anggota + "', '" + nama + "', '"+id_buku+"')";
            statement = KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully Borrowed");
            JOptionPane.showMessageDialog(null, "Successfully Borrowed");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void insertBuku(String id_buku, String judul) {
        try {
            String query = "INSERT INTO `buku` (`id_buku`,`judul`) VALUES ('" + id_buku + "', '" + judul + "')";
            statement = KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully Borrowed");
            JOptionPane.showMessageDialog(null, "Successfully Borrowed");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }


    public String[][] readPinjam() {
        try {
            int jmlData = 0;
            //int i = 1;
            String data[][] = new String[getBanyakDataPinjam()][4];
            statement = KoneksiDatabase.getKoneksi().createStatement();
            String query = "Select * from `anggota` a JOIN `buku` b ON b.`id_buku` = a.`id_anggota`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                //data[jmlData][0] = String.valueOf(i);
                data[jmlData][0] = resultSet.getString("id_anggota");
                data[jmlData][1] = resultSet.getString("nama");
                data[jmlData][2] = resultSet.getString("id_buku");
                data[jmlData][3] = resultSet.getString("judul");
                jmlData++;
                //i++;
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }


    public int getBanyakDataPinjam() {
        int jmlData = 0;
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            String query = "Select * from `anggota`";
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


    public void deletePinjam(String id_pinjam) {
        try {
            String query = "DELETE FROM `pinjam` WHERE `id_pinjam` = '" + id_pinjam + "'";
            statement = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println();
            JOptionPane.showMessageDialog(null, "Successfully Deleted");
        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }


    public void updatePinjam(String id_pinjam, String id_buku, String id_anggota) {
        try {
            String query = "UPDATE `pinjam` set `id_pinjam`='" + id_pinjam + "', `id_buku`='" + id_buku + "', `id_anggota`='" + id_anggota + "' WHERE `id_pinjam` = '" + id_pinjam + "'";
            statement = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Schedule Successfully Updated");
            JOptionPane.showMessageDialog(null, "Schedule Successfully Updated");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateAnggota(String id_anggota, String nama) {
        try {
            String query = "UPDATE `anggota` set `id_anggota`='" + id_anggota + "', `nama`='" + nama + "' WHERE `id_anggota` = '" + id_anggota + "'";
            statement = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully Updated");
            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateBuku(String id_buku, String judul) {
        try {
            String query = "UPDATE `buku` set `id_buku`='" + id_buku + "', `judul`='" + judul + "' WHERE `id_buku` = '" + id_buku + "'";
            statement = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            statement.executeUpdate(query);
            System.out.println("Successfully Updated");
            JOptionPane.showMessageDialog(null, "Successfully Updated");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }


    public String[] selectIdBuku() {
        try {
            int hitung = 0;
            String[] data = new String[getBanyakDataBuku()];
            String query = "SELECT * FROM `buku`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[hitung] = rs.getString(1);
                hitung++;
            }
            return data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public String[] selectIdUser() {
        try {
            int hitung = 0;
            String[] data = new String[getBanyakDataBuku()];
            String query = "SELECT * FROM `anggota`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data[hitung] = rs.getString(1);
                hitung++;
            }
            return data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public int getBanyakDataBuku() {
        int jmlData = 0;
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            String query = "Select * from `buku`";
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

    public int getBanyakDataUser() {
        int jmlData = 0;
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            String query = "Select * from `anggota`";
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

    public String ambilua() {
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            String data = null;
            String query = "SELECT * FROM `buku`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getString(1);
            }
            System.out.println(data);
            return data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

            return null;
        }
    }

    public int ambilid(String a) {
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            int data = 0;
            String query = "SELECT * FROM `user` WHERE username='" + a + "' ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt(1);
            }
            System.out.println(data);
            return data;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public String ambilanggota() {
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            String data = null;
            String query = "SELECT * FROM `anggota`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getString(1);
            }
            System.out.println(data);
            return data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

            return null;
        }
    }

    public int ambilidanggota(String a) {
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            int data = 0;
            String query = "SELECT * FROM `anggota` WHERE id_anggota='" + a + "' ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt(1);
            }
            System.out.println(data);
            return data;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public String ambiluser() {
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            String data = null;
            String query = "SELECT * FROM `anggota`";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getString(1);
            }
            System.out.println(data);
            return data;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

            return null;
        }
    }

    public int ambiliduser(int a) {
        try {
            statement = KoneksiDatabase.getKoneksi().createStatement();
            int data = 0;
            String query = "SELECT user_id FROM `anggota` WHERE `id_anggota`='" + a + "' ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                data = rs.getInt(1);
            }
            System.out.println(data);
            return data;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }

    public int cek(String a) {
        try {
            int jumlah = 0;
            String q = "SELECT id_buku FROM buku where id_buku='" + a + "'";
            ResultSet rs = statement.executeQuery(q);
            while (rs.next()) {
                jumlah++;
            }
            return jumlah;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return 0;
        }
    }
}
