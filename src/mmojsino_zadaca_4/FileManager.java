/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import mmojsino_zadaca_4.Oprema;
import mmojsino_zadaca_4.composite.CategoryComposite;
import mmojsino_zadaca_4.composite.EquipmentComposite;
import mmojsino_zadaca_4.composite.OpremaComposite;

/**
 *
 * @author Mario
 */
public class FileManager {

    File writeFile = null;
    private static RonilackiKlubSingleton instance = RonilackiKlubSingleton.getInstance();

    public void openFile(String path) throws IOException {
        Path filePath = Paths.get(path);
        Scanner scanner = new Scanner(filePath);
        String[] parts;
        if (path.contains("ronioci")) {
            while (scanner.hasNext()) {
                if (scanner.hasNext()) {
                    parts = scanner.next().split(";");
                    if (parts.length == 4) {
                        instance.dodajRonioca(new Ronioc.RoniocBuilder(parts[0], Integer.parseInt(parts[3]))
                                .setAgencija(parts[1])
                                .setAgencijaNorm(RankingNorm.getAgencije()[0])
                                .setRang(parts[2])
                                .setRangNorm()
                                .setCertifikat()
                                .build());
                    } else {
                        System.out.println("Neispravan zapis, preskacem liniju.");
                    }

                } else {
                    scanner.next();
                }
            }
        } else if (path.contains("uroni")) {
            while (scanner.hasNext()) {
                if (scanner.hasNext()) {
                    parts = scanner.next().split(";");
                    if (parts.length == 7) {
                        instance.dodajUron(new Uron.UronBuilder(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),
                                Integer.parseInt(parts[5]), Integer.parseInt(parts[6])).build());
                    } else {
                        System.out.println("Neispravan zapis, preskacem liniju.");
                    }

                } else {
                    scanner.next();
                }
            }
        }
        scanner.close();
    }

    /**
     *
     * @param path
     * @return
     * @throws IOException
     */
    public ListMultimap procitajSpecijalnosti(String path) throws IOException {
        ListMultimap<String, String> specijalnosti = ArrayListMultimap.create();
        Path filePath = Paths.get(path);
        Scanner scanner = new Scanner(filePath);
        String[] parts;
        if (path.contains("specijalno")) {
            while (scanner.hasNext()) {
                if (scanner.hasNext()) {
                    parts = scanner.nextLine().split(";");
                    specijalnosti.put(parts[0], parts[1]);
                } else {
                    scanner.nextLine();
                }
            }
        }
        return specijalnosti;
    }

    public void procitajOpremu(String path) throws IOException {
        Path filePath = Paths.get(path);
        Scanner scanner = new Scanner(filePath);
        String[] parts;
        int tempTemp;
        String kategorija = "";
        CategoryComposite cc = null;
        if (path.contains("oprema")) {
            while (scanner.hasNext()) {
                if (scanner.hasNext()) {
                    parts = scanner.nextLine().split(";");
                    if (parts.length == 2) {
                        kategorija = parts[1];
                        if (cc != null && cc.getSize() > 0) {
                            instance.addToListaEquipment(cc);
                        }
                        cc = new CategoryComposite(kategorija);
                    }
                    if (parts.length == 8) {
                        tempTemp = 0;
                        if (parts[2].equals("#")) {
                            tempTemp = -5;
                        } else {
                            tempTemp = Integer.parseInt(parts[2]);
                        }
                        cc.addLeaf(new EquipmentComposite(parts[0], parts[1], tempTemp, parts[3].charAt(0), parts[4].charAt(0), parts[5].charAt(0), parts[6].charAt(0), Integer.parseInt(parts[7])));
                    }
                } else {
                    scanner.nextLine();
                }
            }
            if (cc != null && cc.getSize() > 0) {
                instance.addToListaEquipment(cc);
            }
        }
    }
}
