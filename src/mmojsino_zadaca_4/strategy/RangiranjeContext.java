/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import mmojsino_zadaca_4.RonilackiKlubSingleton;
import mmojsino_zadaca_4.Ronioc;
import mmojsino_zadaca_4.Uron;

/**
 *
 * @author Mariofil
 */
public class RangiranjeContext {
    private HashMap<Ronioc, RoniocStats> stats;
    private Comparator<Ronioc> comparator;

    public RangiranjeContext(RonilackiKlubSingleton klub) {
        this.stats = klub.getRoniocStats();
        this.comparator = (Ronioc r1, Ronioc r2) -> {
            RoniocStats rs1 = stats.get(r1);
            RoniocStats rs2 = stats.get(r2);
            //1. broj uron
            RangiranjeStrategy poUronima = new BrojUrona();
            int value = poUronima.usporediRonioce(rs1, rs2);
            if(value == 0){
                //2. po datumu
                RangiranjeStrategy poDatumu = new NajstarijiUron();
                value = poDatumu.usporediRonioce(rs1, rs2);
            }if(value == 0){
                RangiranjeStrategy poKategoriji = new NajnizaKategorija();
                value = poKategoriji.usporediRonioce(rs1, rs2);
            }
            return value;
        };
    }
    
    public void sortirajKandidate(Uron u){
        Collections.sort(u.getOdabraniRonioci(), this.comparator);
    }
    
}
