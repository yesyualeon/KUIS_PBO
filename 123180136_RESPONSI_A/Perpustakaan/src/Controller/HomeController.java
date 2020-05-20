package Controller;

import MVC.DashboardMVC;
import Model.UserModel;
import View.HomeView;
import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeController {

    HomeView view;
    UserModel model;

    public HomeController(UserModel model, HomeView view) {
        this.view = view;
        this.model = model;


        view.btnlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getUser().equals("")){
                    JOptionPane.showMessageDialog(null,"Username Tidak Boleh Kosong");
                }else if (view.getPass().equals("")){
                    JOptionPane.showMessageDialog(null,"Password Tidak Boleh Kosong");
                }else{
                    try{
                        String sUsername = view.getUser();
                        String sPassword = view.getPass();
                        String data[][] = model.login(sUsername,sPassword);
                        if (sUsername.equals(data[0][1]) && sPassword.equals(data[0][2])){
                            System.out.println("Login Success");
                            JOptionPane.showMessageDialog(null, "Login Success!");
                            view.setVisible(false);
                            model.simpan(sUsername);
                            DashboardMVC dashboardMVC = new DashboardMVC(data);
                        } else{
                            System.out.println("Login Gagal");
                            JOptionPane.showMessageDialog(null, "Username/Password Salah");
                        }
                    }catch(Exception ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            }
        });

    }
}
