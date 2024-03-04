/**
 * A hosok osztaly segitsegevel, beallíthatjuk a hosok egyes elemeit
 * @version : 1.0
 * Created by: Horvath Martin
 * */

public class Hosok {
    private int tamadas;
    private int vedekezes;
    private int varazsero;
    private int tudas;
    private int moral;
    private int szerencse;
    private int manna;

    public int getTamadas() {
        return tamadas;
    }

    public void setTamadas(int tamadas) {
        this.tamadas=tamadas;
        if (this.tamadas<1){
            this.tamadas=1;
        }else if(this.tamadas>10){
            this.tamadas = 10;
        }

    }
/**
 * A getVedekezes visszateresi erteke megadja a setVedekezesben beallitott erteket*/

    public int getVedekezes() {
        return vedekezes;
    }

    public void setVedekezes(int vedekezes) {
        this.vedekezes=vedekezes;
        if (this.vedekezes<1){
            this.vedekezes=1;
        }else if(this.vedekezes>10){
            this.vedekezes = 10;
        }
    }
    /**
     * A getVarazsero visszateresi erteke megadja a setVarazsero beallitott erteket*/
    public int getVarazsero() {
        return varazsero;
    }

    public void setVarazsero(int varazsero) {
        this.varazsero=varazsero;
        if (this.varazsero<1){
            this.varazsero=1;
        }else if(this.varazsero>10){
            this.varazsero = 10;
        }
    }
    /**
     * A getTudas visszateresi erteke megadja a setTudas beallitott erteket*/
    public int getTudas() {
        return tudas;
    }

    public void setTudas(int tudas) {
        this.tudas=tudas;
        if (this.tudas<1){
            this.tudas=1;
        }else if(this.tudas>10){
            this.tudas = 10;
        }
    }
    /**
     * A getMoral visszateresi erteke megadja a setMoral beallitott erteket*/
    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral=moral;
        if (this.moral<1){
            this.moral=1;
        }else if(this.moral>10){
            this.moral = 10;
        }
    }
    /**
     * A getSzerencse visszateresi erteke megadja a setSzerencse beallitott erteket*/
    public int getSzerencse() {
        return szerencse;
    }

    public void setSzerencse(int szerencse) {
        this.szerencse=szerencse;
        if (this.szerencse<1){
            this.szerencse=1;
        }else if(this.szerencse>10){
            this.szerencse = 10;
        }
    }
    /**
     * A getManna visszateresi erteke megadja a setManna beallitott erteket*/
    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
        if (this.manna<0){
            this.manna=10;
        }else if(this.manna>100){
            this.manna=100;
        }
    }
}
