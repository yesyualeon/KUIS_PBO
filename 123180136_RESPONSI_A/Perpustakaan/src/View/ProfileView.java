package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProfileView extends JFrame {
    JLabel title;

    JLabel lid_anggota = new JLabel("Your ID :");
    JLabel id_anggota = new JLabel();
    JLabel lnama = new JLabel("Your Name :");
    JLabel nama = new JLabel();


    public JButton back = new JButton();

    Color background = new Color(255, 214, 231);
    Color button1 = new Color(255,89,131);
    Color button2 = new Color(171,245,182);
    Color box = new Color(192,252,244);
    Color box2 = new Color(228,193,249);
    Color tbl  = new Color(237,231,177);

    public ProfileView(){
        getContentPane().setBackground(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Rica Rici");
        setVisible(true);
        setLayout(null);
        setSize(300, 300);


        title = new JLabel("PROFILE");
        add(title);
        title.setBounds(100, 5, 150, 80);
        title.setForeground(button1);

        back.setIcon(new ImageIcon("src\\back.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(tbl);

        add(lid_anggota);
        lid_anggota.setBounds(100,90,90,20);
        add(id_anggota);
        id_anggota.setBounds(120, 115, 120,20);
        id_anggota.setBackground(box);
        add(lnama);
        lnama.setBounds(100, 130, 90, 20);
        add(nama);
        nama.setBounds(120, 155, 120, 20);
        nama.setBackground(box);
    }

    public void setlId_anggota(String lId_anggota) {
        this.id_anggota.setText(lId_anggota);
    }

    public void setlNama(String lNama) {
        this.nama.setText(lNama);
    }
}
