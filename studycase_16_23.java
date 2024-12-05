
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
        boolean isRun = true;

        while (isRun) {
            header();
            int pilihMenu = input.nextInt();

            switch (pilihMenu) {
                case 1:
                    tambahDataKRS();
                    break;
                case 2:
                    tampilDataKRS(input);
                    break;
                case 3:
                    analisisDataKRS();
                    break;
                case 4:
                    System.out.println("Program Selesai");
                    System.out.println("Terima Kasih!");
                    isRun = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        }
    }

    public static void header() {
        System.out.println("\n=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data KRS");
        System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
        System.out.println("3. Analisis Data KRS ");
        System.out.println("4. Keluar");
        System.out.print("Pilih Menu : ");
    }

    public static void tambahDataKRS() {
        Scanner input = new Scanner(System.in);

        //cek apakah data mahasiswa mencapai limit
        if (jumlahMhs >= max_mhs) {
            System.out.println("Kapasistas mahasiswa penuh");
            return;
        }

        System.out.println("\n--- Tambah Data KRS ---");

        System.out.print("Nama Mahasiswa : ");
        String nama = input.nextLine();
        System.out.print("NIM : ");
        String nim = input.nextLine();

        namaMhs[jumlahMhs] = nama; //simpan nama yang diinput ke array namaMHS
        nimMhs[jumlahMhs] = nim; //simpan nim yang diinput ke array nimMHS

        int jumlahMatkul = 0;
        while (true) {
            
            //cek apakah matkul mencapai limit
            if (jumlahMatkul > max_matkul) {
                System.out.println("Kapasitas matkul penuh");
                break;
            }
            //cek apakah total sks seorang mhs mencapai limit
            if (totalSks[jumlahMhs] >= 24) {
                System.out.println("SKS sudah mencapai limit (maks 24 SKS)!");
                break;
            }

            System.out.print("Kode Mata Kuliah : ");
            String kodeMatkul = input.nextLine();

            System.out.print("Nama Mata Kuliah : ");
            String namaMatkul = input.nextLine();

            int sks;
            while (true) {
                System.out.print("Jumlah SKS (1-3) : ");
                sks = input.nextInt();
                input.nextLine();
                if (sks >= 1 && sks <= 3) {
                    System.out.println("Data mata kuliah berhasil ditambahkan.");
                    break;
                }
                else {
                    System.out.println("Jumlah SKS tidak valid! Coba lagi");
                }
            }

            kodeMatkulMhs[jumlahMhs][jumlahMatkul] = kodeMatkul; //simpan kode matkul yg diinput ke array kodeMatkulMHS
            namaMatkulMhs[jumlahMhs][jumlahMatkul] = namaMatkul; //simpan nama matkul yg diinput ke array namaMatkulMHS
            sksMatkulMhs[jumlahMhs][jumlahMatkul] = sks; //simpan sks yg diinput ke array sksMatkulMHS
            totalSks[jumlahMhs] += sks; //tambah sks ke array totalSKS untuk mhs indeks ke jumlahMHS 
            jumlahMatkul++;
        
            System.out.print("Tambah mata kuliah lain? (y/n) : ");
            String pilihTambah = input.nextLine();
            if (pilihTambah.equalsIgnoreCase("n")) {
                break;
            }

        }
        System.out.println("Total SKS yang diambil oleh " + namaMhs[jumlahMhs] + " : " + totalSks[jumlahMhs]); //tampilkan jumlah sks yg diambil

        jumlahMhs++;
    }

    public static void tampilDataKRS(Scanner input) {
        System.out.println("--- Tampilkan Daftar KRS Mahasiswa ---");
        System.out.print("Masukkan NIM Mahasiswa : ");
        input.nextLine();
        String nim = input.nextLine();

        int posisi = -1;

        for (int i = 0; i < jumlahMhs; i++) {
            if (nimMhs[i].equals(nim)) {
                posisi = i + 1;  // Menyimpan posisi yang ditemukan (1-based index)
                break;
            }
        }

        // Menampilkan hasil pencarian
        if (posisi != -1) {
            System.out.println("\nDaftar KRS:");
            System.out.println("NIM        Nama            Kode MK     Nama Mata Kuliah           SKS");
            System.out.println("----------------------------------------------------------------------");

            for (int i = 0; i < max_matkul; i++) {
                if (kodeMatkulMhs[posisi][i] != null) {
                    System.out.print(nimMhs[posisi] + "        ");
                    System.out.print(namaMhs[posisi] + "        ");
                    System.out.print(kodeMatkulMhs[posisi][i] + "        ");
                    System.out.print(namaMatkulMhs[posisi][i] + "        ");
                    System.out.println(sksMatkulMhs[posisi][i] + "        ");
                }
            }
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }

    public static void analisisDataKRS() {

    }

}
