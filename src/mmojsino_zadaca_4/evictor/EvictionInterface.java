/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.evictor;

/**
 *
 * @author Mariofil
 */
public interface EvictionInterface {

    public boolean isEvictable();

    public Object info();

    public void beforeEviction();
}
