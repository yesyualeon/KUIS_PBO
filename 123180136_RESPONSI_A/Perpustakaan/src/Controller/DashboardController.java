package Controller;

import MVC.HomeMVC;
import MVC.PinjamMVC;
import MVC.ProfileMVC;
import Model.UserModel;
import View.DashboardView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashboardController {
    UserModel model;
    DashboardView view;
    String data[][];
    String id_anggota;
    String id_buku;
    String id_pinjam;

    public DashboardController(UserModel model, DashboardView view, String[][] data) {
        this.model = model;
        this.view = view;
        this.data = data;
        view.setTitle("Hello, " + data[0][2]);

        view.logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                HomeMVC homeMVC = new HomeMVC();
            }
        });

        view.btnprofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                ProfileMVC profileMVC = new ProfileMVC(data);
            }
        });

        view.btnpinjam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                PinjamMVC pinjamMVC = new PinjamMVC(id_pinjam, id_buku, id_anggota, data);
            }
        });
    }
}
