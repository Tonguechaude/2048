import java.awt.Color;

public class Carree {

    private int valeur;

    private Color couleur;

    public Carree() {
        valeur = 0;
    }

    public Carree(int val) {
        valeur = val;
    }

    public int getValeur() {
        return valeur;
    }

    public Color getCouleur() {
        this.setCouleur();
        return couleur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setCouleur() {
        if (valeur == 2) {
            couleur = new Color(238, 228, 218);
        } else if (valeur == 4) {
            couleur = new Color(237, 224, 200);
        } else if (valeur == 8) {
            couleur = new Color(242, 177, 121);
        } else if (valeur == 16) {
            couleur = new Color(245, 149, 99);
        } else if (valeur == 32) {
            couleur = new Color(246, 124, 95);
        } else if (valeur == 64) {
            couleur = new Color(246, 94, 59);
        } else if (valeur == 128) {
            couleur = new Color(237, 207, 114);
        } else if (valeur == 256) {
            couleur = new Color(237, 204, 97);
        } else if (valeur == 512) {
            couleur = new Color(237, 200, 80);
        } else if (valeur == 1024) {
            couleur = new Color(237, 197, 63);
        } else {
            couleur = new Color(237, 194, 46);
        }
    }

    @Override
    public String toString() {
        return "" + valeur;
    }
}
