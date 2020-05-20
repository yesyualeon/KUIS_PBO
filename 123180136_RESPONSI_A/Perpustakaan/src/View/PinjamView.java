package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PinjamView extends JFrame {
    JLabel title;

    JLabel lId_Anggota = new JLabel("ID Anggota :");
    public JTextField tfid_anggota = new JTextField();
    JLabel lnama = new JLabel("Nama :");
    public JTextField tfnama = new JTextField("");
    JLabel luser = new JLabel("ID User :");
    public JComboBox luserid = new JComboBox();
    JLabel lId_Buku = new JLabel("ID Buku :");
    public JTextField tfid_buku = new JTextField();
    JLabel ljudul = new JLabel("Judul Buku :");
    public JTextField tfjudul = new JTextField("");

    JLabel lId_AnggotaUpdate = new JLabel("ID Anggota :");
    public JTextField tfid_anggotaUpdate = new JTextField();
    JLabel lnamaupdate = new JLabel("Nama :");
    public JTextField tfnamaupdate = new JTextField("");
    JLabel luserupdate = new JLabel("ID User :");
    public JComboBox luseridupdate = new JComboBox();
    JLabel lId_BukuUpdate = new JLabel("ID Buku :");
    public JComboBox cbid_bukuupdate = new JComboBox();
    JLabel ljudulupdate = new JLabel("Judul Buku :");
    public JTextField tfjudulupdate = new JTextField("");


    public JButton btnInsertPanel = new JButton("Insert");
    public JButton btnCancel1Panel = new JButton("Cancel");
    public JButton btnUpdatePanel = new JButton("Update");
    public JButton btnCancel2Panel = new JButton("Cancel");
    public JButton back = new JButton();

    public JTable tabel;

    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"ID Anggota","Nama","ID Buku","Buku"};

    Color background = new Color(255, 214, 231);
    Color button1 = new Color(255,89,131);
    Color button2 = new Color(171,245,182);
    Color box = new Color(192,252,244);
    Color box2 = new Color(228,193,249);
    Color tbl  = new Color(237,231,177);
    Color t = new Color(130, 128, 255);

    public  PinjamView() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        getContentPane().setBackground(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 450);
        tabel.setBackground(tbl);

        title = new JLabel("BORROW BOOKS");
        add(title);
        title.setBounds(200, 5, 150, 30);
        title.setFont(new Font("Calibri",Font.BOLD,20));
        title.setForeground(t);

        title = new JLabel("Insert");
        add(title);
        title.setBounds(100, 35, 100, 20);

        title = new JLabel("Update");
        add(title);
        title.setBounds(100, 200, 100, 20);

        title = new JLabel("Borrowing List");
        add(title);
        title.setBounds(380, 55, 100, 20);

        back.setIcon(new ImageIcon("src\\back.png"));
        add(back);
        back.setBounds(4,4,30,30);
        back.setBackground(tbl);

        add(scrollPane);
        scrollPane.setBounds(250,80,320,250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lId_Anggota);
        lId_Anggota.setBounds(20,65,90,20);
        add(tfid_anggota);
        tfid_anggota.setBounds(110, 65, 120,20);
        tfid_anggota.setBackground(box);
        add(lnama);
        lnama.setBounds(20, 90, 90, 20);
        add(tfnama);
        tfnama.setBounds(110, 90, 120, 20);
        tfnama.setBackground(box);
        add(lId_Buku);
        lId_Buku.setBounds(20, 115, 90, 20);
        add(tfid_buku);
        tfid_buku.setBounds(110, 115, 120, 20);
        tfid_buku.setBackground(box);
        add(ljudul);
        ljudul.setBounds(20, 140, 90, 20);
        add(tfjudul);
        tfjudul.setBounds(110, 140, 120, 20);
        tfjudul.setBackground(box);

        add(btnInsertPanel);
        btnInsertPanel.setBounds(20, 165, 90, 20);
        btnInsertPanel.setBackground(button2);
        add(btnCancel1Panel);
        btnCancel1Panel.setBounds(135, 165, 90, 20);
        btnCancel1Panel.setBackground(button1);


        add(lId_AnggotaUpdate);
        lId_AnggotaUpdate.setBounds(20,225,90,20);
        add(tfid_anggotaUpdate);
        tfid_anggotaUpdate.setBounds(110, 225, 120, 20);
        tfid_anggotaUpdate.setBackground(box2);
        add(lnamaupdate);
        lnamaupdate.setBounds(20, 250, 90, 20);
        add(tfnamaupdate);
        tfnamaupdate.setBounds(110, 250, 120, 20);
        tfnamaupdate.setBackground(box2);
        add(lId_BukuUpdate);
        lId_BukuUpdate.setBounds(20, 275, 90, 20);
        add(cbid_bukuupdate);
        cbid_bukuupdate.setBounds(110, 275, 120, 20);
        cbid_bukuupdate.setBackground(box2);
        add(ljudulupdate);
        ljudulupdate.setBounds(20, 300, 90, 20);
        add(tfjudulupdate);
        tfjudulupdate.setBounds(110, 300, 120, 20);
        tfjudulupdate.setBackground(box2);

        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(20, 325, 90, 20);
        btnUpdatePanel.setBackground(button2);
        add(btnCancel2Panel);
        btnCancel2Panel.setBounds(135, 325, 90, 20);
        btnCancel2Panel.setBackground(button1);
    }

    public String getLuserid() {
        return luserid.getSelectedItem().toString();
    }
    public String getIdAnggota() {
        return tfid_anggota.getText();
    }

    public String getNama() {
        return tfnama.getText();
    }

    public String getIdBuku() {
        return tfid_buku.getText();
    }

    public String getJudul() {
        return tfjudul.getText();
    }

    public String getIdAnggotaUpdate(){
        return tfid_anggotaUpdate.getText();
    }

    public String getNamaUpdate(){
        return tfnamaupdate.getText();
    }

    public String getLuseridUpdate() {
        return luserid.getSelectedItem().toString();
    }

    public String getIdBukuUpdate(){
        return cbid_bukuupdate.getSelectedItem().toString();
    }

    public String getJudulUpdate(){
        return tfjudulupdate.getText();
    }
}
