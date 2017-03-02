/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4;

import com.google.common.collect.ListMultimap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import mmojsino_zadaca_4.composite.OpremaComposite;
import mmojsino_zadaca_4.evictor.ResourceLifeCycleManager;
import mmojsino_zadaca_4.state.MinimalnaOpremaState;
import mmojsino_zadaca_4.strategy.RangiranjeContext;
import mmojsino_zadaca_4.strategy.RoniocStats;

/**
 *
 * @author Mariofil
 */
public class Mmojsino_zadaca_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 6) {
            return;
        }
        RonilackiKlubSingleton singleton = RonilackiKlubSingleton.getInstance();
        singleton.setGenerator(Integer.parseInt(args[0]));
        FileManager fm = new FileManager();
        String workingDirectory = Paths.get(".").toAbsolutePath().normalize().toString();
        fm.openFile(workingDirectory + "\\" + args[1]);
        fm.openFile(workingDirectory + "\\" + args[2]);
        ListMultimap tm = fm.procitajSpecijalnosti(workingDirectory + File.separator + args[3]);
        fm.procitajOpremu(workingDirectory + File.separator + args[4]);
        for (Ronioc r : singleton.getListRonioca()) {
            for (Object ime : tm.keySet()) {
                List<String> spec = (List<String>) tm.get(ime.toString());
                if (ime.toString().equals(r.getImeRonioca())) {
                    for (String s : spec) {
                        r.dodajSpecijalnost(s);
                    }
                }
            }
        }
        int maxPosudba = Integer.parseInt(args[5]);
        RangiranjeContext rc = new RangiranjeContext(singleton);
        singleton.getListUroni().forEach((u) -> {
            //provjera dubine
            List<Ronioc> temp = new ArrayList<>(singleton.getListRonioca());
            if (u.getMaxDubina() > 20) {
                temp.removeIf((r) -> r.getRang().equalsIgnoreCase("R1") || r.getRang().equalsIgnoreCase("R0"));
            }
            if (u.getTemp() <= 10) {
                temp.removeIf((r) -> !r.getSpecijalnost().stream().anyMatch((s) -> s.contains("Suho")));
            }
            if (u.getSnimanja() > 0) {
                temp.removeIf((r) -> !r.getSpecijalnost().stream().anyMatch((s) -> s.contains("fotograf")));
            }
            if (u.getNoc() > 0) {
                temp.removeIf((r) -> !r.getSpecijalnost().stream().anyMatch((s) -> s.contains("ronjenje")));
            }
            u.setUronGrupa(temp);
        });
        System.out.println("---------------------");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        TreeMap<String, LocalDateTime> dateTimes = new TreeMap<>();
        TreeMap<String, Integer> numberOfDives = new TreeMap<>();
        LocalDateTime dateTime = null;
        for (Uron u : singleton.getListUroni()) {
            dateTime = LocalDateTime.parse(u.getDatum() + " " + u.getVrijeme(), formatter);
            for (Ronioc r : u.getOdabraniRonioci()) {
                numberOfDives.put(r.getImeRonioca(), (int) numberOfDives.getOrDefault(r.getImeRonioca(), 0) + 1);
                if (dateTimes.containsKey(r.getImeRonioca())) {
                    if (dateTime.isBefore(dateTimes.get(r.getImeRonioca()))) {
                        dateTimes.put(r.getImeRonioca(), dateTime);
                    }
                } else {
                    dateTimes.put(r.getImeRonioca(), dateTime);
                }
            }
        }
        for (Ronioc r : singleton.getListRonioca()) {
            if (numberOfDives.containsKey(r.getImeRonioca())) {
                RoniocStats rs = new RoniocStats();
                rs.setBrojUrona(numberOfDives.get(r.getImeRonioca()));
                rs.setUronDatum(dateTimes.get(r.getImeRonioca()));
                rs.setNajlosijaKategorija(r.getRang());
                singleton.putStats(r, rs);
            }
        }

        singleton.getListUroni().forEach((u) -> {
            if (u.getOdabraniRonioci().size() > u.getBrojRonioca()) {
                rc.sortirajKandidate(u);
                u.setUronGrupa(u.getOdabraniRonioci().subList(0, (u.getOdabraniRonioci().size() - u.getBrojRonioca() - 1)));
            }
        });

        //ResourceLifeCycleManager rlcm = ResourceLifeCycleManager.getInstance();
        for (Uron u : singleton.getListUroni()) {
            for (Ronioc r : u.getOdabraniRonioci()) {
                r.getStanje().setOprema(r, singleton.getListaEquipment(), u);
            }
        }

        singleton.getListUroni().forEach(u -> {
            System.out.println("Datum - vrijeme " + u.getDatum() + " / " + u.getVrijeme());
            for (Ronioc r : u.getOdabraniRonioci()) {
                System.out.println("");
                System.out.print("Ronioc: " + r.getImeRonioca() + ", Oprema : ");
                for (OpremaComposite o : r.getOprema()) {
                    System.out.print(o.getNazivOpreme() + " , ");
                }
            }
            System.out.println("");
            System.out.println("");
        });
        //release u evictoru - ne radi bas kako treba
//        for (Uron u : singleton.getListUroni()) {
//            if (u.getBrojRonioca() > u.getOdabraniRonioci().size()) {
//                for (Ronioc r : u.getOdabraniRonioci()) {
//                    for (OpremaComposite o : r.getOprema()) {
//                        //rlcm.release(o);
//                    }
//                }
//            }
//        }

    }

    public static String getMinKey(TreeMap<String, Integer> map) {
        String[] minKey = new String[1];
        minKey[0] = map.firstKey();
        map.forEach((k, v) -> {
            if ((int) map.get(k) < (int) map.get(minKey[0])) {
                minKey[0] = k;
            }
        });
        return minKey[0];
    }

}
