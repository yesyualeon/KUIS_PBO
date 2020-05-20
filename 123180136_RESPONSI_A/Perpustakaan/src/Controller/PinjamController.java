package Controller;

import MVC.DashboardMVC;
import Model.PinjamModel;
import View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PinjamController implements ActionListener {
    PinjamModel model;
    PinjamView view;
    String id_pinjam;
    String data[][];
    String id_anggota;
    String id_buku;

    public PinjamController(PinjamModel model, PinjamView view, String id_pinjam, String id_buku, String id_anggota, String[][] data) {
        HomeView hv = null;
        this.model = model;
        this.view = view;
        this.id_pinjam = id_pinjam;
        this.id_buku = id_buku;
        this.id_anggota = id_anggota;
        this.data = data;

        String buku = model.ambilua();
        int id = model.ambilid(buku);
        String[] isibuku = new String[model.getBanyakDataPinjam()];
        isibuku = model.selectIdBuku();
        System.out.println(buku);
        for(int i = 0 ; i < model.getBanyakDataBuku() ; i++) {
            view.cbid_bukuupdate.addItem(isibuku[i]);
        }

        String anggota = model.ambilanggota();
        int id_ang = model.ambilidanggota(anggota);
        String dataJadwal[][] = model.readPinjam();
        view.tabel.setModel((new JTable(dataJadwal, view.namaKolom)).getModel());


        view.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                DashboardMVC dashboardMVC = new DashboardMVC(data);
            }
        });

        view.btnInsertPanel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                //model.insertPinjam(id, view.getIdAnggota(), view.getNama(), view.getIdBuku(), view.getJudul());
                model.insertAnggota(view.getIdAnggota(), view.getNama(), view.getIdBuku());
                if(model.cek(view.getIdBuku()) == 0){
                    model.insertBuku(view.getIdBuku(), view.getJudul());
                } else {
                    System.out.println("Trouble");
                }
                //model.insertPinjam(view.getIdBuku(), view.getIdAnggota());
                String dataJadwal[][] = model.readPinjam();
                view.tabel.setModel((new JTable(dataJadwal, view.namaKolom)).getModel());
            }
        });

        view.btnUpdatePanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_anggota = view.getIdAnggotaUpdate();
                String nama = view.getNamaUpdate();
                String id_buku = view.getIdBukuUpdate();
                String judul = view.getJudulUpdate();
                model.updateAnggota(id_anggota,nama);
                model.updateBuku(id_buku,judul);
                model.updatePinjam(id_pinjam,id_buku,id_anggota);
                String dataJadwal[][] = model.readPinjam();
                view.tabel.setModel((new JTable(dataJadwal, view.namaKolom)).getModel());
            }
        });

        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = view.tabel.getSelectedRow();
                String dataterpilih = view.tabel.getValueAt(baris,0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null, "Do yo want to delete " + dataterpilih + "?", "Delete", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    model.deletePinjam(dataterpilih);
                    //String dataPinjam[][] = model.deletePinjam(id_pinjam);
                    //view.tabel.setModel(new JTable(dataPinjam, view.namaKolom).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
