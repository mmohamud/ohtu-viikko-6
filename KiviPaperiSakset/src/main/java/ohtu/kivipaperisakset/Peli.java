/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;
/**
 *
 * @author mmohamud
 */
public class Peli {

    private Pelaaja eka;
    private Pelaaja toka;
    private Tuomari tuomari;

    private String ekanJulkaisu;
    private String tokanJulkaisu;

    public Peli(Pelaaja eka, Pelaaja toka, String ekanJulkaisu, String tokanJulkaisu) {
        tuomari = new Tuomari();
        this.eka = eka;
        this.toka = toka;
        this.ekanJulkaisu = ekanJulkaisu;
        this.tokanJulkaisu = tokanJulkaisu;
    }

    public void pelaa() {
        System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");

        String ekanSiirto;
        String tokanSiirto;

        do {
            ekanSiirto = vuoro(eka, ekanJulkaisu);
            tokanSiirto = vuoro(toka, tokanJulkaisu);

            toka.asetaSiirto(ekanSiirto);
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

        } while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto));

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    private String vuoro(Pelaaja p, String julkaisu) {
        System.out.println(julkaisu);
        String siirto = p.annaSiirto();
        System.out.println(julkaisePelaajanSiirto(p, siirto));
        return siirto;
    }

    private String julkaisePelaajanSiirto(Pelaaja p, String siirto) {
        if (p.getClass() != Ihminen.class) {
            return siirto;
        } else {
            return "";
        }
    }
}
