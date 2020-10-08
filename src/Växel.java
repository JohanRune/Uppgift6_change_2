import java.util.Scanner;

/**
 * Created by Johan Rune
 * Date: 2020-10-07
 * Time: 14:14
 * Project: IntelliJ IDEA
 * Copyright: MIT
 */
public class Växel {
    int betalat;
    int pris;
    int[] valörer = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
    int[] sedlar = new int[10]; //skulle heta "antal".
    String[] kronaEller = {"lappar", "lappar","lappar","lappar","lappar","lappar","kronor","kronor","kronor","kronor"};

    public int växelTillbaka(int betalat, int pris){
        return (betalat - pris);
    }

    public int numberOfValör(int beloppkvar, int valör) {
        return (int) (beloppkvar / valör);

    }

    public int reduceAmount(int amountLeft, int amountToWithdraw) {
        return (amountLeft - amountToWithdraw);
    }

    public String kronorEllerLappar (int belopp){
        for (int i = 0; i < valörer.length; i++) {
            if (belopp == valörer[i])
                return kronaEller[i];
        }
        return null;
    }

    public String meddelanden (int betalat, int pris){
        if (betalat == pris)
            return ("Det blev ingen växel");
        else if (pris > betalat)
            return "Du betalade för lite";
        return null;
    }


    //i facit gör hon en metod som heter "printa en rad", exakt "getStringForOneValör". Den är lätt att testa.
    public void printa () {
        if (betalat <= pris)
            System.out.println(meddelanden(betalat, pris));
        else
            for (int i = 0; i < sedlar.length; i++) {
                if (sedlar[i] != 0)
                    System.out.println(getStringFörEnValör(valörer[i], sedlar[i]));
        }
    }


    public static Boolean test = false;
    private Scanner scanner;

    public int readInputData (String promt, String optionalTestParameter) { //string, är det bra?
        if (test) {
            scanner = new Scanner(optionalTestParameter);
        }
        else{
            scanner = new Scanner(System.in);
        }
        System.out.println(promt);
        return scanner.nextInt();
    }

    //ska denna finnas någon annan stans? Behövs den?
    public void räknare() {
        int beloppKvar = växelTillbaka(betalat, pris);
        for (int i = 0; i < valörer.length; i++) {
            int antal = numberOfValör(beloppKvar, valörer[i]);
            sedlar[i] = antal;
            beloppKvar = reduceAmount(beloppKvar, antal * valörer[i]);
        }
    }

    public void mainProgram (){
        pris = readInputData("Vad kostar varan?", null);
        betalat = readInputData("Vad betalar du med för belopp?", null);
        räknare();
        printa();
    }

    public String getStringFörEnValör(int valör, int antal) {
        //String s = "Antal " + valör + "-" + kronorEllerLappar(valör) + ": " + antal;
        //return s;
        StringBuilder sb = new StringBuilder();
        sb.append("Antal " + valör + "-" + kronorEllerLappar(valör) + ": " + antal);
        return sb.toString();
    }
}
