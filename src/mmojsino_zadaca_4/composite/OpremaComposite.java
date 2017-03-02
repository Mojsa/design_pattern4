/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.composite;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Mariofil
 */
public interface OpremaComposite {

    public void addLeaf(OpremaComposite c);

    public void removeLeaf(OpremaComposite c);

    public int getSize();

    public List<OpremaComposite> getLeafs();

    public String getName();

    public String getNazivOpreme();

    public int getTemp();

    public char getTrebaKapuljacu();

    public char getTrebaPododijelo();

    public char getTrebaNocniUron();

    public char getTrebaSnimanje();

    public int getBrojKomada();
    
    public void smanjiBrojRaspolozivih();
    
    public LocalDateTime getReturnDate();
    
    public void setReturnDate(LocalDateTime d);
    
    public void povecajBrojRaspolozivih();
}
