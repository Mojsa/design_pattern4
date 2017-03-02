/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.composite;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import mmojsino_zadaca_4.evictor.EvictionInterface;

/**
 *
 * @author Mariofil
 */
public class EquipmentComposite implements OpremaComposite, EvictionInterface {

    //sadrzavati ce sve sto opisuje equipment
    private String sifraOpreme;
    private String nazivOpreme;
    private int temp;
    private char trebaKapuljacu;
    private char trebaPododijelo;
    private char trebaNocniUron;
    private char trebaSnimanje;
    private int brojKomada;
    private LocalDateTime returnDate;

    public EquipmentComposite(String sifraOpreme, String nazivOpreme, int temp, char trebaKapuljacu, char trebaPododijelo, char trebaNocniUron, char trebaSnimanje, int brojKomada) {
        this.sifraOpreme = sifraOpreme;
        this.nazivOpreme = nazivOpreme;
        this.temp = temp;
        this.trebaKapuljacu = trebaKapuljacu;
        this.trebaPododijelo = trebaPododijelo;
        this.trebaNocniUron = trebaNocniUron;
        this.trebaSnimanje = trebaSnimanje;
        this.brojKomada = brojKomada;
    }

    public String getSifraOpreme() {
        return sifraOpreme;
    }

    public String getNazivOpreme() {
        return nazivOpreme;
    }

    public int getTemp() {
        return temp;
    }

    public char getTrebaKapuljacu() {
        return trebaKapuljacu;
    }

    public char getTrebaPododijelo() {
        return trebaPododijelo;
    }

    public char getTrebaNocniUron() {
        return trebaNocniUron;
    }

    public char getTrebaSnimanje() {
        return trebaSnimanje;
    }

    public int getBrojKomada() {
        return brojKomada;
    }

    @Override
    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    @Override
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addLeaf(OpremaComposite c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeLeaf(OpremaComposite c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpremaComposite> getLeafs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void smanjiBrojRaspolozivih() {
       this.brojKomada = this.brojKomada -1;
    }

    @Override
    public boolean isEvictable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object info() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeEviction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void povecajBrojRaspolozivih() {
        this.brojKomada = this.brojKomada +1;
    }

}
