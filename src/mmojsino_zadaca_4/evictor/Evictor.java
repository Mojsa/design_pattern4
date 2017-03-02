/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.evictor;

import java.time.LocalDateTime;
import java.util.Date;
import mmojsino_zadaca_4.composite.OpremaComposite;
import static mmojsino_zadaca_4.evictor.ResourceLifeCycleManager.listaOpremaKoristeno;

/**
 *
 * @author Mariofil
 */
public class Evictor implements Runnable {


    public Evictor() {
        //new Thread(this).start();
    }

    @Override
    public void run() {
        // For simplicity, we run forever
        while (true) {
            try {
                long pollTime = 0;
                // Sleep for configured amount of time
                Thread.sleep(pollTime);
            } catch (InterruptedException e) {
                break;
        
            }

        }

    }
    
    public void evict(OpremaComposite o){
        //delete from resourcelifecyclemanager
        
        listaOpremaKoristeno.remove(o);
    }
    
    public void evictAllUnreturned(){
       LocalDateTime currentTime = LocalDateTime.now();
       for(OpremaComposite o: listaOpremaKoristeno){
           if(currentTime.isAfter(o.getReturnDate())){
               //evict, proslo vrijeme
               listaOpremaKoristeno.remove(o);
           }
       }
    }

}
