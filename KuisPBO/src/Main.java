import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float nilaiTulis, nilaiCoding, nilaiWawancara, nilaiMicroteaching, nilaiJaringan;
        int menu, n;
        int nim;
        String nama;
        char y_n;

        Scanner input = new Scanner(System.in);
        Nilai nilai = new Nilai();
        TestNilaiAslab testNilaiAslab = new TestNilaiAslab();
        TestNilaiAdmin testNilaiAdmin = new TestNilaiAdmin();
        
        do {
            System.out.println("MENU FORM PENDAFTARAN");
            System.out.println("1. Asisten Laboratorium");
            System.out.println("2. Admin Laboratorium");
            System.out.println("Pilih Jenis Form : ");
            menu = input.nextInt();

            try {
                switch (menu) {
                    case 1:
                        System.out.println("FORM PENDAFTARAN ASISTEN LABORATORIUM");
                        System.out.println("Berapa banyak data yang akan diinputkan? : ");
                        n = input.nextInt();
                        for (int i = 0; i < n; i++) {
                            try {
                                System.out.println("Input NIM : ");
                                nim = input.nextInt();
                                System.out.println("Input Nama : ");
                                nama = input.nextLine();
                                input.nextLine();
                                System.out.println("Input Nilai Tes Tertulis : ");
                                nilaiTulis = input.nextInt();
                                System.out.println("Input Nilai Tes Coding : ");
                                nilaiCoding = input.nextInt();
                                System.out.println("Input Nilai Tes Wawancara : ");
                                nilaiWawancara = input.nextInt();
                                System.out.println("Input Nilai Tes Microteaching : ");
                                nilaiMicroteaching = input.nextInt();
                                nilai.RataRata(nilaiTulis,nilaiCoding,nilaiWawancara,nilaiMicroteaching);
                                System.out.println("Nilai Akhir : " + nilai.getRataRata(nilaiTulis,nilaiCoding,nilaiWawancara,nilaiMicroteaching));
                                testNilaiAslab.setNim(nim);
                                System.out.println("KETERANGAN : ");
                                testNilaiAslab.kelolosan(nilaiTulis, nilaiCoding, nilaiWawancara, nilaiMicroteaching);
                                //testNilai.getKelolosan();
                            } catch (Exception e) {
                                System.out.println(e);
                            }

                        }
                        break;
                    case 2:
                        System.out.println("FORM PENDAFTARAN ADMIN LABORATORIUM");
                        System.out.println("Berapa banyak data yang akan diinputkan? : ");
                        n = input.nextInt();
                        for (int i = 0; i < n; i++) {
                            try {
                                System.out.println("Input NIM : ");
                                nim = input.nextInt();
                                System.out.println("Input Nama : ");
                                nama = input.nextLine();
                                input.nextLine();
                                System.out.println("Input Nilai Tes Tertulis : ");
                                nilaiTulis = input.nextInt();
                                System.out.println("Input Nilai Tes Coding : ");
                                nilaiCoding = input.nextInt();
                                System.out.println("Input Nilai Tes Wawancara : ");
                                nilaiWawancara = input.nextInt();
                                System.out.println("Input Nilai Tes Jaringan : ");
                                nilaiJaringan = input.nextInt();
                                nilai.RataRata(nilaiTulis,nilaiCoding,nilaiWawancara,nilaiJaringan);
                                System.out.println("Nilai Akhir : " + nilai.getRataRata(nilaiTulis,nilaiCoding,nilaiWawancara,nilaiJaringan));
                                testNilaiAdmin.setNim(nim);
                                System.out.println("KETERANGAN : ");
                                testNilaiAdmin.kelolosan(nilaiTulis, nilaiCoding, nilaiWawancara, nilaiJaringan);
                                //testNilai.getKelolosan();
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        }
                        break;

                    default:
                        System.out.println("Menu tidak tersedia");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Input Harus Bilangan Bulat");
            }


            System.out.println("Kembali ke menu utama? (y/n) : ");
            y_n = input.next().charAt(0);
        } while (y_n == 'y' || y_n == 'Y');
    }
}
