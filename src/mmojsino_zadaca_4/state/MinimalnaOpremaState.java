/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mmojsino_zadaca_4.state;

import java.util.List;
import mmojsino_zadaca_4.Ronioc;
import mmojsino_zadaca_4.Uron;
import mmojsino_zadaca_4.composite.OpremaComposite;
import mmojsino_zadaca_4.evictor.ResourceLifeCycleManager;

/**
 *
 * @author Mariofil
 */
public class MinimalnaOpremaState implements State {

    @Override
    public void setOprema(Ronioc r, List<OpremaComposite> oprema, Uron up) {
        ResourceLifeCycleManager rlcm = ResourceLifeCycleManager.getInstance();
        r.setStanje(this);
        if (!r.getOprema().isEmpty()) {
            r.getOprema().clear();
        }
        if (up.getTemp() <= 10) {
            if (r.getSpecijalnost().contains("Suho odijelo")) {
                OpremaComposite opKat = oprema.stream().filter((x -> x.getName().contains("Suho odijelo"))).findAny().orElse(null);
                if (opKat != null) {
                    OpremaComposite opOprema = opKat.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                            .max((p1, p2) -> Integer.compare(p1.getTemp(), p2.getTemp())).orElse(null);
                    if (opOprema != null) {
                        rlcm.acquire(opOprema);
                        r.dodajOpremu(opOprema);
                    } else {
                        OpremaComposite opOprema2 = opKat.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                                .min((p1, p2) -> Integer.compare(p1.getTemp(), p2.getTemp())).orElse(null);
                        if (opOprema2 != null) {
                            rlcm.acquire(opOprema2);
                            r.dodajOpremu(opOprema2);
                        }
                        if (opOprema2 != null && opOprema2.getTrebaPododijelo() == '+') {
                            OpremaComposite opOpremaPod = oprema.stream().filter(x -> x.getName().contains("Pododijelo za suho odijelo")).findAny().orElse(null);
                            if (opOpremaPod != null) {
                                OpremaComposite pododijelo = opOpremaPod.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                                        .min((p1, p2) -> Integer.compare(p1.getTemp(), p2.getTemp())).orElse(null);
                                if (pododijelo != null) {
                                    rlcm.acquire(pododijelo);
                                    r.dodajOpremu(pododijelo);
                                }
                            }
                        }
                    }
                } else {
                    OpremaComposite odijeloKat = oprema.stream().filter(x -> x.getName().matches(".*(Mokro odijelo).*")).findAny().orElse(null);
                    if (odijeloKat != null) {
                        OpremaComposite odijeloMokro = odijeloKat.getLeafs().stream().filter((x) -> x.getBrojKomada() > 0)
                                .max((p1, p2) -> Integer.compare(p1.getTemp(), p2.getTemp())).orElse(null);
                        if (odijeloMokro != null) {
                            rlcm.acquire(odijeloMokro);
                            r.dodajOpremu(odijeloMokro);
                        }
                        if (odijeloMokro.getTrebaKapuljacu() == '+') {
                            OpremaComposite kapuljaKat = oprema.stream().filter((x) -> x.getName().contains("Kapulj")).findAny().orElse(null);
                            OpremaComposite kapulja = kapuljaKat.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                                    .max((p1, p2) -> Integer.compare(p1.getTemp(), p2.getTemp())).orElse(null);
                            if (kapulja != null) {
                                rlcm.acquire(kapulja);
                                r.dodajOpremu(kapulja);
                            }
                        }
                    }
                }
            }

        }
        if (up.getNoc() > 0) {
            if (r.getSpecijalnost().contains("Noćno ronjenje")) {
                OpremaComposite katRacunalo = oprema.stream().filter(x -> x.getName().contains("Sustav ronilačkih instrumenata")).findAny().orElse(null);
                OpremaComposite racunaloOprema = katRacunalo.getLeafs().stream().filter(x -> x.getBrojKomada() > 0 && x.getNazivOpreme().contains("računalo"))
                        .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
                if (racunaloOprema != null) {
                    rlcm.acquire(racunaloOprema);
                    r.dodajOpremu(racunaloOprema);
                }
                OpremaComposite katSvjetiljka = oprema.stream().filter(x -> x.getName().contains("Sustav dodatne opreme")).findAny().orElse(null);
                OpremaComposite svjetiljkaOprema = katSvjetiljka.getLeafs().stream().filter(x -> x.getBrojKomada() > 0 && x.getNazivOpreme().contains("svjetiljka"))
                        .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
                if (svjetiljkaOprema != null) {
                    rlcm.acquire(svjetiljkaOprema);
                    r.dodajOpremu(svjetiljkaOprema);
                }
            }

        }
        if (up.getSnimanja() > 0) {
            if (r.getSpecijalnost().contains("Podvodni fotograf")) {
                OpremaComposite katFotoaparat = oprema.stream().filter(x -> x.getName().matches(".*(Foto-video aparat).*")).findAny().orElse(null);

                OpremaComposite fotoaparat = katFotoaparat.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                        .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
                if (fotoaparat != null) {
                    rlcm.acquire(fotoaparat);
                    r.dodajOpremu(fotoaparat);
                }
                OpremaComposite rasvjeta = oprema.stream().filter(x -> x.getName().matches(".*(Podvodni rasvjeta).*")).findAny().orElse(null);
                OpremaComposite ras = rasvjeta.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                        .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
                if (ras != null) {
                    rlcm.acquire(ras);
                    r.dodajOpremu(ras);
                }
            }
        }

        OpremaComposite sustavOpreme = oprema.stream().filter(x -> x.getName().contains("Sustav opreme za ronjenje na dah")).findAny().orElse(null);
        OpremaComposite maskaOprema = sustavOpreme.getLeafs().stream().filter(x -> x.getBrojKomada() > 0 && x.getNazivOpreme().contains("Maska"))
                .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
        if (maskaOprema != null) {
            rlcm.acquire(maskaOprema);
            r.dodajOpremu(maskaOprema);
        }

        OpremaComposite disalicaOprema = sustavOpreme.getLeafs().stream().filter(x -> x.getBrojKomada() > 0 && x.getNazivOpreme().contains("Disalica"))
                .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
        if (disalicaOprema != null) {
            rlcm.acquire(disalicaOprema);
            r.dodajOpremu(disalicaOprema);
        }

        OpremaComposite perajaOprema = sustavOpreme.getLeafs().stream().filter(x -> x.getBrojKomada() > 0 && x.getNazivOpreme().contains("Peraje"))
                .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
        if (perajaOprema != null) {
            rlcm.acquire(perajaOprema);
            r.dodajOpremu(perajaOprema);
        }

        OpremaComposite rukaviceKat = oprema.stream().filter(x -> x.getName().contains("Rukavice")).findAny().orElse(null);
        OpremaComposite rukaviceOprema = rukaviceKat.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
        if (rukaviceOprema != null) {
            rlcm.acquire(rukaviceOprema);
            r.dodajOpremu(rukaviceOprema);
        }
        OpremaComposite cizmeKat = oprema.stream().filter(x -> x.getName().contains("izme")).findAny().orElse(null);
        OpremaComposite cizmeOprema = cizmeKat.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
        if (cizmeOprema != null) {
            rlcm.acquire(cizmeOprema);
            r.dodajOpremu(cizmeOprema);
        }
        OpremaComposite bocaKat = oprema.stream().filter(x -> x.getName().contains("Boca za ronjenje")).findAny().orElse(null);
        OpremaComposite bocaOprema = bocaKat.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
        if (bocaOprema != null) {
            rlcm.acquire(bocaOprema);
            r.dodajOpremu(bocaOprema);
        }
        OpremaComposite regulatorKat = oprema.stream().filter(x -> x.getName().contains("Regulator")).findAny().orElse(null);
        OpremaComposite regulatorOprema = regulatorKat.getLeafs().stream().filter(x -> x.getBrojKomada() > 0)
                .max((p1, p2) -> Integer.compare(p1.getBrojKomada(), p2.getBrojKomada())).orElse(null);
        if (regulatorOprema != null) {
            rlcm.acquire(regulatorOprema);
            r.dodajOpremu(regulatorOprema);
        }

    }
}
