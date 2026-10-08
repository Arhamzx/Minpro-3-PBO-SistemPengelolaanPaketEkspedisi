/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface PenyimpananPaket {
    void tambahPaket(Paket paket);
    
    // OVERLOADING
    Paket cariPaket(int id);
    
    
    Paket cariPaket(String resi);
    boolean hapusPaket(int id);
    List<Paket> getDaftarPaket();
}
