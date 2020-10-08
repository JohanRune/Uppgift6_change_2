import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Johan Rune
 * Date: 2020-10-07
 * Time: 14:15
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */
public class VäxelTest {

    Växel v = new Växel();

    @Test
    public final void växelTest() {
        int betalat = 2000;
        int pris = 500;
        assertTrue(v.växelTillbaka(betalat, pris) == 1500);
    }

    @Test
    public final void numberOfValörTest() {
        int beloppKvar = 1500;
        int valör = 1000;
        assertTrue(v.numberOfValör(beloppKvar, valör) == 1);
    }

    @Test
    public final void reduceAmountTest() {
        int betalat = 2000;
        int pris = 500;
        int valör = 1000;
        int amountLeft = 1500;
        int amountToWithdraw = 500;
        assertTrue(v.reduceAmount(amountLeft, amountToWithdraw) == 1000);
    }

    @Test
    public final void kronorLapparTest() {
        assertTrue(v.kronaEller[0].equals("lappar"));
        assertTrue(v.kronorEllerLappar(1).equals("kronor"));
        assertTrue(v.kronorEllerLappar(20).equals("lappar"));
        assertTrue(v.kronorEllerLappar(10).equals("kronor"));
        assertTrue(v.kronorEllerLappar(1000).equals("lappar"));
    }

    @Test
    public final void getStringFörEnRadTest() {
        assertTrue(v.getStringFörEnValör(1000, 3).startsWith("Antal 1000-lappar: 3")); //testar hennes "startWith".
        assertTrue(v.getStringFörEnValör(5, 1).startsWith("Antal 5-kronor: 1")); //testar hennes "startWith".
    }


    @Test
    public final void meddelandenTest() {
        assertTrue(v.meddelanden(1000, 1000) == "Det blev ingen växel");
        assertTrue(v.meddelanden(1000, 1500) == "Du betalade för lite");
    }

    @Test
    public final void readInputDataTest(){
        v.test=true;
        String ok = "23";
        assertTrue(v.readInputData("Hej", ok) == 23);
    }

}