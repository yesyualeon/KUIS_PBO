package MVC;

import Controller.PinjamController;
import Model.PinjamModel;
import View.PinjamView;

public class PinjamMVC {
    String id_pinjam;
    String id_anggota;
    String id_buku;
    String data[][];

    public PinjamMVC(String id_pinjam, String id_buku, String id_anggota, String[][] data) {
        this.id_anggota = id_anggota;
        this.id_pinjam = id_pinjam;
        this.id_buku = id_buku;
        this.data = data;
        PinjamModel model = new PinjamModel();
        PinjamView view = new PinjamView();
        PinjamController controller = new PinjamController(model,view,id_pinjam,id_buku,id_anggota,data);
    }
}
