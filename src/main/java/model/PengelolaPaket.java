/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author LENOVO
 */
public class PengelolaPaket extends Person implements PenyimpananPaket {

    private final ArrayList<Paket> daftarPaket;

    public PengelolaPaket(int id, String nama, String nomorHp) {
        super(id, nama, nomorHp);
        this.daftarPaket = new ArrayList<>();
    }

    public void tambahPaket(Paket paket) {
        daftarPaket.add(paket);
    }

    public ArrayList<Paket> getDaftarPaket() {
        return daftarPaket;
    }

    public Paket cariPaket(int id) {
        for (Paket p : daftarPaket) {
            if (p.getIdPaket() == id) {
                return p;
            }
        }
        return null;
    }

    public Paket cariPaket(String resi) {
        for (Paket p : daftarPaket) {
            if (p.getNoResi().equalsIgnoreCase(resi)) {
                return p;
            }
        }
        return null;
    }

    public boolean hapusPaket(int id) {
        Paket target = cariPaket(id);

        if (target != null) {
            daftarPaket.remove(target);
            return true;
        }

        return false;
    }
    
    @Override
    public String getPeran() { return "Pengelola Paket"; }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Total paket: " + daftarPaket.size();
    }
}
