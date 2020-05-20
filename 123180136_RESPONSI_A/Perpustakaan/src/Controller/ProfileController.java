package Controller;

import MVC.DashboardMVC;
import Model.ProfileModel;
import View.ProfileView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileController {
    ProfileModel model;
    ProfileView view;
    String data[][];

    public ProfileController(ProfileModel model, ProfileView view, String[][] data) {
        this.model = model;
        this.view = view;
        this.data = data;

        String dataProfile[][] = model.readProfile(data[0][0]);
        /*if (model.getBanyakDataNilai(data[0][0]) != 0){
            if (dataNilai[model.getBanyakDataNilai(data[0][0])-1][5].equals("0")) {
                view.btnWithdraw.setEnabled(false);
            }
        } else{
            view.btnWithdraw.setEnabled(false);
        }*/

        if (model.getBanyakDataProfile(data[0][0]) != 0){
            dataProfile = model.readProfile(data[0][0]);
            view.setlId_anggota(dataProfile[model.getBanyakDataProfile(data[0][0])-1][1]);
            view.setlNama(dataProfile[model.getBanyakDataProfile(data[0][0])-1][0]);
        } else{
            view.setlId_anggota("0");
            view.setlNama("0");
            JOptionPane.showMessageDialog(null,"Data Tidak Ada");
        }

        view.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                DashboardMVC dashboardMVC = new DashboardMVC(data);
            }
        });
    }
}
