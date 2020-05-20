package View;

import javax.swing.*;
import java.awt.*;

public class DashboardView extends JFrame {
    JLabel title = new JLabel("Hello, ");

    public JButton btnprofile = new JButton("Profile");
    public JButton btnpinjam = new JButton("Pinjam");
    public JButton logout = new JButton("Log Out");
    public ImageIcon icon1 = new ImageIcon("src\\profile.png");
    public ImageIcon icon2 = new ImageIcon("src\\book.png");
    public JLabel profile = new JLabel(icon1);
    public JLabel pinjam = new JLabel(icon2);

    Color bgdashboard = new Color(23, 34, 59);
    Color box1 = new Color(62, 134, 160);
    Color box2 = new Color(152, 118, 170);
    Color font = new Color(255,255,255);
    Color ftitle = new Color(255, 198, 109);

    public DashboardView() {
        getContentPane().setBackground(bgdashboard);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Perpustakaan Rica Rici");
        setVisible(true);
        setLayout(null);
        setSize(400, 300);

        add(title);
        title.setBounds(150, 20, 120, 25);
        title.setFont(new Font("Serif",Font.ITALIC,20));
        title.setForeground(ftitle);

        add(logout);
        logout.setBounds(4,4,85,20);
        logout.setBackground(box2);
        logout.setForeground(font);

        add(profile);
        profile.setBounds(50,120,70,70);
        add(btnprofile);
        btnprofile.setBounds(40, 200,90,20);
        btnprofile.setBackground(box1);
        btnprofile.setForeground(font);

        add(pinjam);
        pinjam.setBounds(250,120,70,70);
        add(btnpinjam);
        btnpinjam.setBounds(240,200,90,20);
        btnpinjam.setBackground(box2);
        btnpinjam.setForeground(font);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }
}
