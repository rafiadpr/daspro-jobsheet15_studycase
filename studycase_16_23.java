
import java.util.Scanner;

public class studycase_16_23 {

    //variable global
    static int max_mhs = 100;
    static int max_matkul = 20;
    static String[] namaMhs = new String[max_mhs];
    static String[] nimMhs = new String[max_mhs];
    static int[][] sksMatkulMhs = new int[max_mhs][max_matkul];
    static String[][] kodeMatkulMhs = new String[max_mhs][max_matkul];
    static String[][] namaMatkulMhs = new String[max_mhs][max_matkul];
    static int jumlahMhs = 0;
    static int[] totalSks = new int[max_mhs];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            header();
            int pilihMenu = input.nextInt();

            switch (pilihMenu) {
                case 1:
                    tambahDataKRS();
                    break;
                case 2:
                    tampilDataKRS();
                    break;
                case 3:
                    analisisDataKRS();
                    break;
                case 4:
                    System.out.println("Program Selesai");
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    break;
            }
        }
    }

    public static void header() {
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data KRS");
        System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
        System.out.println("3. Analisis Data KRS ");
        System.out.println("4. Keluar");
        System.out.print("Pilih Menu : ");
    }

    public static void tambahDataKRS() {

    }

    public static void tampilDataKRS() {

    }

    public static void analisisDataKRS() {

    }

    // public static void 
}
