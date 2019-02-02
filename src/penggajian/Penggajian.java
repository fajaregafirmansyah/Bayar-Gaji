package penggajian;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class Penggajian {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String nama, gol, status;
        int anak = 0, gpokok = 0, tunjistri = 0, tunjanak = 0, gkotor = 0, pajak = 0, gbersih = 0;

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        System.out.println("========== Penggajian sederhana ==========");

        System.out.print("Masukan Nama                  : ");
        nama = input.nextLine();

        System.out.print("Masukan Golongan (2A/2B/3A/3B): ");
        gol = input.nextLine();

        System.out.print("Masukan Status (Nikah/Lajang) : ");
        status = input.nextLine();

        if (status.equals("Nikah")) {
            System.out.print("Masukan Jumlah Anak           : ");
            anak = input.nextInt();
        }

        System.out.println("");
        System.out.println("===========================================");
        System.out.println("-----------Gaji " + nama + "----------------");
        System.out.println("===========================================");
        System.out.println("");

        System.out.println("Nama            = " + nama);

        if (null != gol) {
            switch (gol) {
                case "2A":
                    gpokok = 1000000;
                    kursIndonesia.format(gpokok);
                    break;
                case "2B":
                    gpokok = 1500000;
                    kursIndonesia.format(gpokok);
                    break;
                case "3A":
                    gpokok = 2000000;
                    kursIndonesia.format(gpokok);
                    break;
                case "3B":
                    gpokok = 2500000;
                    kursIndonesia.format(gpokok);
                    break;
                default:
                    break;
            }
        }
        System.out.println("Golongan        = " + gol);
        System.out.println("Status          = " + status);
        System.out.println("Jumlah Anak     = " + anak);
        System.out.println("Gaji Pokok      = " + kursIndonesia.format(gpokok));

        tunjistri = 10 * gpokok / 100;
        System.out.println("Tunj Suami/Istri = " + kursIndonesia.format(tunjistri));

        if (anak == 1) {
            tunjanak = 5 * gpokok / 100;
        } else if (anak == 2) {
            tunjanak = 2 * (5 * gpokok / 100);
        } else if (anak > 2) {
            tunjanak = 2 * (5 * gpokok / 100);
        }

        System.out.println("Tunjangan Anak  = " + kursIndonesia.format(tunjanak));

        gkotor = gpokok + (tunjistri + tunjanak);
        System.out.println("Gaji Kotor      = " + kursIndonesia.format(gkotor));

        pajak = 10 * gkotor / 100;
        System.out.println("Pajak 10%       = " + kursIndonesia.format(pajak));

        gbersih = gkotor - pajak;
        System.out.println("Gaji Bersih     = " + kursIndonesia.format(gbersih));
    }

}
