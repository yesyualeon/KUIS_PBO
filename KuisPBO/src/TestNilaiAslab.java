
public class TestNilaiAslab extends Nilai implements Kelulusan{
    int nim;

    public void kelolosan(float nilai1, float nilai2, float nilai3, float nilai4) {
        if (getRataRata(nilai1, nilai2, nilai3, nilai4) > 85) {
            //System.out.print("LOLOS");
            System.out.println(lolos);
            System.out.println("Selamat kepada " + getNim() + " telah diterima sebagai Aslab");
        }
        else {
            //System.out.println("TIDAK LOLOS");
            System.out.println(gagal);
            System.out.println("Mohon maaf kepada " + getNim() + " telah ditolak sebagai Aslab");
        }
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public int getNim() {
        return nim;
    }
}
