/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Mario
 */
public class Uron {

    //required
    private String datum;
    private String vrijeme;
    private int maxDubina;
    private int brojRonioca;
    private int noc;
    private int snimanja;
    private int temp;
    private List<Ronioc> odabraniRonioci = new ArrayList<>();

    private Uron(UronBuilder b) {
        this.datum = b.datum;
        this.vrijeme = b.vrijeme;
        this.maxDubina = b.maxDubina;
        this.brojRonioca = b.brojRonioca;
        this.noc = b.noc;
        this.snimanja = b.snimanja;
        this.temp = b.temp;
    }

    public void setUronGrupa(List<Ronioc> uronGrupa) {
        this.odabraniRonioci = uronGrupa;
    }

    public String getDatum() {
        return datum;
    }

    public String getVrijeme() {
        return vrijeme;
    }

    public int getMaxDubina() {
        return maxDubina;
    }

    public int getBrojRonioca() {
        return brojRonioca;
    }

    public int getNoc() {
        return noc;
    }

    public int getSnimanja() {
        return snimanja;
    }

    public int getTemp() {
        return temp;
    }

    public List<Ronioc> getOdabraniRonioci() {
        return odabraniRonioci;
    }
    
    

    public static class UronBuilder {

        //required
        private String datum;
        private String vrijeme;
        private int maxDubina;
        private int brojRonioca;
        private int noc;
        private int snimanja;
        private int temp;

        //optional

        public UronBuilder(String datum, String vrijeme, int maxDubina, int brojRonioca, int temp,  int noc, int snimanja) {
            this.datum = datum;
            this.vrijeme = vrijeme;
            this.maxDubina = maxDubina;
            this.brojRonioca = brojRonioca;
            this.noc = noc;
            this.snimanja = snimanja;
            this.temp = temp;
        }

        public Uron build() {
            return new Uron(this);
        }
    }
}
