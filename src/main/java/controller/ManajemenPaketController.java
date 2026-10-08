/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.Paket;
import model.PengelolaPaket;
import model.PenyimpananPaket;  
/**
 *
 * @author LENOVO
 */
public class ManajemenPaketController {

    private PenyimpananPaket pengelola;

    public ManajemenPaketController(PenyimpananPaket pengelola) {
        this.pengelola = pengelola;
    }

    public PenyimpananPaket getPengelola() { 
        return pengelola;
    }
    
    public void tambahPaket(Paket paket) {
        pengelola.tambahPaket(paket);
    }
    
    // OVERLOADING DARI PENGELOLA
    public Paket cariPaket(int id) {
        return pengelola.cariPaket(id);
    }

    // OVERLOADING DARI PENGELOLA
    public Paket cariPaket(String resi) {
        return pengelola.cariPaket(resi);
    }

    public boolean hapusPaket(int id) {
        return pengelola.hapusPaket(id);
    }

}
