/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4;

/**
 *
 * @author Mariofil
 */
public class UronPodaci {

    private String datum;
    private String vrijeme;
    private int brojRonioca;
    private int dubina;
    private int noc;
    private int snimanja;
    private int temp;

    public UronPodaci(String datum, String vrijeme, int brojRonioca, int dubina, int noc, int snimanja, int temp) {
        this.datum = datum;
        this.vrijeme = vrijeme;
        this.brojRonioca = brojRonioca;
        this.dubina = dubina;
        this.noc = noc;
        this.snimanja = snimanja;
        this.temp = temp;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
    }

    public int getBrojRonioca() {
        return brojRonioca;
    }

    public void setBrojRonioca(int brojRonioca) {
        this.brojRonioca = brojRonioca;
    }

    public int getDubina() {
        return dubina;
    }

    public void setDubina(int dubina) {
        this.dubina = dubina;
    }

    public int getNoc() {
        return noc;
    }

    public void setNoc(int noc) {
        this.noc = noc;
    }

    public int getSnimanja() {
        return snimanja;
    }

    public void setSnimanja(int snimanja) {
        this.snimanja = snimanja;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

}
