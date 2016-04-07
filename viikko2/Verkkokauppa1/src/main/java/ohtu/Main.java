package ohtu;

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import ohtu.verkkokauppa.Ostoskori;
import ohtu.verkkokauppa.Pankki;
import ohtu.verkkokauppa.Varasto;
import ohtu.verkkokauppa.Viitegeneraattori;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");
        Kirjanpito kirjanpito = ctx.getBean(Kirjanpito.class);
        Kauppa kauppa = ctx.getBean(Kauppa.class);

        testaaKauppaa(kauppa, kirjanpito);
    }

    private static void testaaKauppaa(Kauppa kauppa, Kirjanpito kirjanpito) {
        testiAsiakas(kauppa);
        uusiAsiakas(kauppa);

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }

    private static void testiAsiakas(Kauppa kauppa) {
        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi(new Ostoskori());
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");
    }

    private static void uusiAsiakas(Kauppa kauppa) {
        // seuraava asiakas
        kauppa.aloitaAsiointi(new Ostoskori());
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");
    }
}
