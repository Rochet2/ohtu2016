
package ohtu.verkkokauppa;

import java.util.ArrayList;

public class Kirjanpito implements Bookkeeping {
    
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }
    
    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }      
    
    /*
    private void dummy(int t)
    {
        for(int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
            System.out.println("test");
            }
        }
        if (t < 1)
            if (t < -200)
                if (t < -600)
                    System.out.println("t is small");
        if (t > 9)
            System.out.println("t is positive");
        if (t < -1000)
            System.out.println("t is negative");
    }
    */
}
