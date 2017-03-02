/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import mmojsino_zadaca_4.composite.OpremaComposite;
import mmojsino_zadaca_4.strategy.RoniocStats;

/**
 *
 * @author Mario
 */
public class RonilackiKlubSingleton {

    private List<Ronioc> listRonioca = new ArrayList<>();
    private List<Uron> listUroni = new ArrayList<>();
    private List<UronPodaci> podaciUrona = new ArrayList<>();
    private List<Oprema> listaOprema = new ArrayList<>();
    private List<OpremaComposite> listaEquipment = new ArrayList<>();
    private HashMap<Ronioc, RoniocStats> roniocStats = new HashMap<>();
    private Random generator;

    private RonilackiKlubSingleton() {

    }

    public HashMap<Ronioc, RoniocStats> getRoniocStats() {
        return roniocStats;
    }

    public void putStats(Ronioc r, RoniocStats stats){
        if(!roniocStats.containsKey(r)){
            roniocStats.put(r, stats);
        }
    }
    public void setRoniocStats(HashMap<Ronioc, RoniocStats> roniocStats) {
        this.roniocStats = roniocStats;
    }
    
    public List<Oprema> getListaOprema() {
        return listaOprema;
    }

    public void setListaOprema(List<Oprema> listaOprema) {
        this.listaOprema = listaOprema;
    }

    public void setGenerator(int seed) {
        generator = new Random(seed);
    }

    public Random getGenerator() {
        return generator;
    }

    public List<Ronioc> getListRonioca() {
        return listRonioca;
    }

    public List<Uron> getListUroni() {
        return listUroni;
    }

    public void dodajRonioca(Ronioc r) {
        listRonioca.add(r);
    }

    public void dodajUron(Uron u) {
        listUroni.add(u);
    }

    public void dodajPodatkeUrona(UronPodaci up) {
        podaciUrona.add(up);
    }

    public List<UronPodaci> getPodaciUrona() {
        return podaciUrona;
    }

    public void setListUroni(List<Uron> listUroni) {
        this.listUroni = listUroni;
    }

    private static class SingletonHelper {

        private static final RonilackiKlubSingleton instance = new RonilackiKlubSingleton();

    }

    public static RonilackiKlubSingleton getInstance() {
        return SingletonHelper.instance;
    }

    public List<OpremaComposite> getListaEquipment() {
        return listaEquipment;
    }

    public void addToListaEquipment(OpremaComposite e) {
        this.listaEquipment.add(e);
    }

}
