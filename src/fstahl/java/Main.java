package fstahl.java;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        //1. Persitente Daten laden falls nicht vorhanden erstellen
        Rechtschreibtrainer r = new Rechtschreibtrainer();
        r.addPaare("Mercedes","https://flotte.at/NewsImages-870x580/pic4645_1-die-wertvollsten-automarken-der-welt.jpg");
        r.addPaare("Maserati","https://i.pinimg.com/originals/5e/5f/0f/5e5f0f05f9703fa3db0cc93b5d2c8578.png");
        r.addPaare("Ferrari","https://upload.wikimedia.org/wikipedia/de/thumb/c/c0/Scuderia_Ferrari_Logo.svg/1200px-Scuderia_Ferrari_Logo.svg.png");

        String text;
        String input;
        while(true){
            r.starteTraining();
            ImageIcon bildIcon = new ImageIcon(new URL(r.getCurrentPaar().getBildURL()));
            Image image = bildIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(250, 250,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            ImageIcon bild = new ImageIcon(newimg);  // transform it back

            input = JOptionPane.showInputDialog(
                    null,
                    bild,
                    "Rechtschreibtrainer",
                    JOptionPane.PLAIN_MESSAGE
            );
            if(input.equals("")){
                break;
            }
            r.rateWort(input);
            text = "Gesamt: " + r.getStats().getGesamtVersuche() + "\nRichtig: " + r.getStats().getRichtigeVersuche() + "\nFalsch: " + r.getStats().getFalscheVersuche();
            JOptionPane.showMessageDialog(null,text);
        }
    }
}