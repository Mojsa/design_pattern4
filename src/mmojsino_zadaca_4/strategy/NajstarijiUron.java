/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.strategy;

/**
 *
 * @author Mariofil
 */
public class NajstarijiUron implements RangiranjeStrategy {

    @Override
    public int usporediRonioce(RoniocStats rs1, RoniocStats rs2) {
        if(rs1.getUronDatum().isBefore(rs2.getUronDatum())){
            return 1;
        }else if(rs1.getUronDatum().isAfter(rs2.getUronDatum())){
            return -1;
        }else {
            return 0;
        }
    }
    
}
