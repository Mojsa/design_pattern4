/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.strategy;

import java.time.LocalDateTime;

/**
 *
 * @author Mariofil
 */
public class RoniocStats {
    private int brojUrona;
    private LocalDateTime uronDatum;
    private String najlosijaKategorija;

    public int getBrojUrona() {
        return brojUrona;
    }

    public void setBrojUrona(int brojUrona) {
        this.brojUrona = brojUrona;
    }

    public LocalDateTime getUronDatum() {
        return uronDatum;
    }

    public void setUronDatum(LocalDateTime uronDatum) {
        this.uronDatum = uronDatum;
    }

    public String getNajlosijaKategorija() {
        return najlosijaKategorija;
    }

    public void setNajlosijaKategorija(String najlosijaKategorija) {
        this.najlosijaKategorija = najlosijaKategorija;
    }
    
}
