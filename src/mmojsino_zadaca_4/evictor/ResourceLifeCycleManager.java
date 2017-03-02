/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.evictor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import mmojsino_zadaca_4.RonilackiKlubSingleton;
import mmojsino_zadaca_4.composite.OpremaComposite;

/**
 *
 * @author Mariofil
 */
public class ResourceLifeCycleManager {

    static List<OpremaComposite> listaOprema;
    static List<OpremaComposite> listaOpremaKoristeno = new ArrayList<>();
    Evictor evictor = new Evictor();

    private ResourceLifeCycleManager() {
        //RonilackiKlubSingleton s = RonilackiKlubSingleton.getInstance();
        // listaOprema = new ArrayList<>(s.getListaEquipment());
    }

    public void acquire(OpremaComposite o) {
        //add to koristeno lista, dodaj return date za equipment composite
//        o.setReturnDate(LocalDateTime.now());
//        o.smanjiBrojRaspolozivih();
//        if (!listaOpremaKoristeno.contains(o)) {
//            listaOpremaKoristeno.add(o);
//        }
    }

    public void release(OpremaComposite o) {
        //releasing resource with evictor
//        if (listaOpremaKoristeno.contains(o)) {
//            o.povecajBrojRaspolozivih();
//            evictor.evict(o);
//        }
    }

    private static class ResourceLifeCycleManagerHelper {

        private static final ResourceLifeCycleManager instance = new ResourceLifeCycleManager();
    }

    public static ResourceLifeCycleManager getInstance() {
        return ResourceLifeCycleManagerHelper.instance;
    }

    public List<OpremaComposite> getListaOpremaKoristeno() {
        return listaOpremaKoristeno;
    }

}
