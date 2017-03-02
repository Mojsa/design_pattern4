/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.strategy;

import java.util.Arrays;

/**
 *
 * @author Mariofil
 */
public class NajnizaKategorija implements RangiranjeStrategy {

    public static final String[] razine = {"R0", "R1", "R2", "R3", "R4", "R5", "I0", "I1", "I2", "I3", "I4", "I5", "I6", "I7"};

    @Override
    public int usporediRonioce(RoniocStats rs1, RoniocStats rs2) {
        if(Arrays.asList(razine).indexOf(rs1.getNajlosijaKategorija()) < Arrays.asList(razine).indexOf(rs2.getNajlosijaKategorija()) ){
            return -1;
        }else if(Arrays.asList(razine).indexOf(rs1.getNajlosijaKategorija()) > Arrays.asList(razine).indexOf(rs2.getNajlosijaKategorija())){
            return 1;
        }else {
            return 0;
        }
    }

}
