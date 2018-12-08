/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Komennot;

import Komennot.Komento;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import laskin.Sovelluslogiikka;

/**
 *
 * @author mmohamud
 */
public class Summa implements Komento {

    private Sovelluslogiikka sovellus;
    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    private int edellinenTulos;
    

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
        this.nollaa = nollaa;
        this.undo = undo;
    }


    @Override
    public void suorita() {
        edellinenTulos = sovellus.tulos();
        int syote = Integer.parseInt(this.syotekentta.getText());
        sovellus.plus(syote);        
        this.tuloskentta.setText("" + sovellus.tulos());
    }    

    @Override
    public void undo() {
        sovellus.setTulos(edellinenTulos);
        this.tuloskentta.setText("" + sovellus.tulos());
    }
}
