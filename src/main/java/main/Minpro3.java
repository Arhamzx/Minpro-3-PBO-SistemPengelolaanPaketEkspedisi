/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import controller.ManajemenPaketController;
import model.Ekspedisi;
import model.JNE;
import model.Kurir;
import model.Paket;
import model.Penerima;
import model.PengelolaPaket;
import view.ManajemenPaketView;

/**
 *
 * @author LENOVO
 */
public class Minpro3 {

    public static void main(String[] args) {

        // PENGELOLS PAKET
        PengelolaPaket pengelola =
            new PengelolaPaket(
                1,
                "Admin Ekspedisi",
                "08123456789"
            );

        // DATA DUMMY
        Ekspedisi ekspedisi =
            new JNE(
                1,
                "REG"
            );

        Penerima penerima =
            new Penerima(
                1,
                "Arham",
                "08123456789",
                "Sangatta",
                "75683"
            );

        Kurir kurir =
            new Kurir(
                1,
                "Budi",
                "08129876543",
                "Motor"
            );

        Paket paket =
            new Paket(
                1,
                "RESI001",
                "Ikrar",
                "23-09-2026",
                "Dalam Proses",
                ekspedisi,
                penerima,
                kurir
            );

        pengelola.tambahPaket(paket);

        // CONTROLLER
        ManajemenPaketController controller =
            new ManajemenPaketController(
                pengelola
            );

        // VIEW
        ManajemenPaketView view =
            new ManajemenPaketView(
                controller
            );
        
        view.jalankan();
    }
}
