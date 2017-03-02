/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.iterator;

import java.util.List;
import mmojsino_zadaca_4.RonilackiKlubSingleton;
import mmojsino_zadaca_4.composite.OpremaComposite;

/**
 *
 * @author Mariofil
 */
public class EquipmentRepository implements Container{
    public List<OpremaComposite> listaOprema = RonilackiKlubSingleton.getInstance().getListaEquipment();

    @Override
    public EquipmentIterator getIterator() {
        return new OpremaIterator();
    }
    
    private class OpremaIterator implements EquipmentIterator{
        
        int index;

        @Override
        public boolean hasNext() {
            if(index < listaOprema.size()-1){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return listaOprema.get(index++);
            }
            return null;
        }
        
    }
    
}
