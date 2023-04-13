package vinnsla;

/**
 * @Author Donna Cruz
 * @Email: Deb5@hi.is
 */

/**
 * A class representing a customer.
 */
public class Vidskiptavinur {
    private static String nafn;
    private static String heimilisfang;

    /**
     * Býr til a new Vidskiptavinur
     */
    public Vidskiptavinur(){
        System.out.println("Það kallast ekki á neitt");
    }

    /**Býr til nýjan Vidskiptavinur hlut með tilgreindu nafni og heimilisfangi.
     * @param nafn nafn viðskiptavinar
     * @param heimilisfang heimilisfang viðskiptavinar
     **/
    public Vidskiptavinur(String nafn, String heimilisfang){
        this.nafn = nafn;
        this.heimilisfang = heimilisfang;
    }

    /**
     * Returns nafn Viðskiptavinar
     * @return nafn Viðskiptavinar
     */
    public String getNafn() {
        return this.nafn;
    }

    /**
     * Returns heimilisfang viðskiptavinar
     * @return heimilisfang viðskiptavinar
     */
    public String getHeimilisfang() {
        return heimilisfang;
    }

    /**
     * Seter fyrir nafn á  viðskiptavin
     * @param nafn fyrir nafn á  viðskiptavin
     */
    public void setNafn(String nafn) {
        this.nafn = nafn;
    }

    /**
     * Sets heimilisfang viðskiptavinar
     * @param heimilisfang heimilisfang viðskiptavinar
     */
    public void setHeimilisfang(String heimilisfang) {
        this.heimilisfang = heimilisfang;
    }

}
