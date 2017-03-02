/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.state;

import java.util.List;
import mmojsino_zadaca_4.Oprema;
import mmojsino_zadaca_4.Ronioc;
import mmojsino_zadaca_4.Uron;
import mmojsino_zadaca_4.UronPodaci;
import mmojsino_zadaca_4.composite.OpremaComposite;

/**
 *
 * @author Mariofil
 */
public interface State {
    public void setOprema(Ronioc r, List<OpremaComposite> oprema, Uron up);
}
