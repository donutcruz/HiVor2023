package hi.vinnsla;

public class Reiknivel {
    private int tala = 0;

    private int utkoma = 0;

    private final Reikna[] virkjar = {
            Integer::sum,
            (x, y) -> x - y,
            (x, y) -> x * y,
            (x, y) -> y == 0 ? 0 : x / y
    };

    private Reikna virki = virkjar[0];

    public void setTala(int x) {
        tala = tala * 10 + x;
    }

    public void setVirki(int tala) {
        utkoma = Reikna();
        this.tala = 0;
        virki = virkjar[tala];
    }

    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("NM_METHOD_NAMING_CONVENTION")
    public int Reikna() {
        return virki.reikna(utkoma, tala);
    }

    public void hreinsa() {
        tala = 0;
        utkoma = 0;
        virki = virkjar[0];
    }

    public int jafntOg() {
        tala = Reikna();
        utkoma = 0;
        virki = virkjar[0];
        return tala;
    }

}

