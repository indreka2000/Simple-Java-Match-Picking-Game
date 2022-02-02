import java.util.Random;
import java.util.Scanner;

public class ArumetsÜlesanne3 {

// Deklareerin muutujad.
    public static int tikkudeArvLaual;
    public static int maxVõetavateArv;
    public static int alles;
    public static int allesPärastArvutiKäiku;

// Loon kontolli, et sisestatav tikkude arv laual oleks suurem kui 0 ning täisarv.
    static boolean isValid(int n) {
        if (n >= 1) return true;
        else return false;
    }

// Loon funktsiooni nimega tikkeKokku.
    public static int tikkeKokku (int laualKokku) {

// Deklareerin muutuja ning omistan sellele väärtuse, lugedes käsurealt sisse sisendi.
        Scanner tikkeLaual = new Scanner(System.in);

// Funktsioon jätkab oma tööd seni kuni on sisestatud täisarv, mis on suurem nullist.
        while(true) {

// Funktsioon küsib kasutaja käest sisendit.
            System.out.println("Sisestage lauale asetatavate tikkude arv: ");

// Kui muutuja omab täisarvulist väärtust, omistan selle väärtuse muutujale tikkudeArvLaual.
            if (tikkeLaual.hasNextInt()) {
                tikkudeArvLaual = tikkeLaual.nextInt();

// Kontroll, kui muutuja tikkudeArvLaual omab väärtust, mis on vähemalt 1, väljastan tulemuse ning
// tagastan muutuja väärtuse.
                if (isValid(tikkudeArvLaual)) {
                    System.out.println("Tikke on laual: " + tikkudeArvLaual);
                    return tikkudeArvLaual;
                }
            }

// Kui muutuja väärtuseks on midagi muud, näiteks sõne, väljastan veateate ning küsin sisendit
// nii kaua kuni sisestatakse väärtus, mis on kooskõlas nõutud tingimustega.
            else {
                tikkeLaual.next();
                System.out.println("Viga! Tegu peab olema täisarvuga!");
            }
        }
    }

// Loon kontrolli, et maksimaalselt laualt võetavate tikkude arv oleks suurem kui null ning väiksem
// kui on laual tikke.
    static boolean isValid2(int m) {
        if (0 < m && m < tikkudeArvLaual) return true;
        else return false;
    }

// Loon funktsiooni nimega võetavad.
    public static int võetavad (int laualtVõetavad) {

// Deklareerin muutuja ning omistan sellele väärtuse, lugedes käsurealt sisse sisendi.
        Scanner eemalda = new Scanner(System.in);

// Funktsioon jätkab oma tööd seni kuni maksimaalselt võetavate tikkude arv jääb nõutud vahemikku.
        while (true) {

// Küsin kasutajalt sisendit.
            System.out.println("Sisestage maksimaalselt võetavate tikkude arv, mis ei ületa laual olevate arvu: ");

// Kui sisend omab täisarvulist väärtust, omistatakse see muutujale maxVõetavateArv.
            if (eemalda.hasNextInt()) {
                maxVõetavateArv = eemalda.nextInt();

// Kui muutuja maxVõetavateArv on suurem kui 0 ning väiksem kui laual olevate tikkude arv, väljastan tulemuse
// ning tagastan väärtuse.
                if (isValid2(maxVõetavateArv)) {
                    System.out.println("Maksimaalselt tohib eemaldada: " + maxVõetavateArv + " tikku");
                    return maxVõetavateArv;
                }
            }

// Kui käsurealt loetakse sisse mittetäisarvuline väärtus, näiteks sõne, väljastab funktsioon veateate
// ning küsib sisendit uuesti.
            else {
                eemalda.next();
                System.out.println("Viga! Tegu peab olema täisarvuga!");

            }
        }

    }

// Loon kontrolli, eemaldavate tikkude arvu kohta.
    static boolean isValid3(int võetav) {
        if (0 < võetav && maxVõetavateArv >= võetav && allesPärastArvutiKäiku >= võetav) return true;
        else return false;
    }

// Loon funktsiooni makeHumanMove.
    public static int makeHumanMove (int eemaldan) {

// Deklareerin muutuja ning omistan sellele väärtuse, lugedes käsurealt sisse sisendi.
        Scanner inimeneEemaldab = new Scanner(System.in);

// Funktsioon jätkab oma tööd seni kuni inimese poolt eemaldatavate tikkude arv on nõutud vahemikus.
        while (true) {

// Küsin kasutajalt sisendi.
            System.out.println("Sisestage laualt võetavate tikkude arv, vahemikus 1 kuni " + maxVõetavateArv + " või suurus, mis on võimalik: ");

// Kui sisend omab täisarvulist väärtust, omistan selle muutujale eemaldan.
            if (inimeneEemaldab.hasNextInt()) {
                eemaldan = inimeneEemaldab.nextInt();

// Kui muutuja eemaldan asub nõutud vahemikus, lahutan muutujale allesPärastArvutiKäiku omistatud väärtusest maha
// kasutaja poolt sisestatud väärtuse ning väljastan tulemuse ja tagastan muutuja alles väärtuse.
                if (isValid3(eemaldan)) {
                    alles = allesPärastArvutiKäiku - eemaldan;

                    System.out.println("Laual on tikke alles: " + alles);
                    return alles;
                }

            }

// Kui kasutaja sisestab midagi muud, näiteks sõne, väljastatakse vastav veateade ning küsitakse sisendit uuesti.
            else {
                inimeneEemaldab.next();
                System.out.println("Viga! Tegu peab olema täisarvuga!");
            }
        }
    }

// Loon funktsiooni nimega makeComputerMove.
    public static int makeComputerMove (int arvutiEemaldab) {

// Loon tingimuse, et juhul kui pärast kasutaja pakutud väärtuse maha lahutamist on laual alles sama palju
// tikke nagu on maksimaalne tikkude eemaldamise arv või kui laual on tikkude väärtus, mis jääb vahemikku
// 1 kuni maksimaalne eemaldatavate tikkude arv, lahutatakse lauale alles jäänud väärtus iseendast, et
// arvutil oleks võimalus võita ühe käiguga, kui tekib selleks sobiv olukord.
        if (alles == maxVõetavateArv || alles > 0 && alles < maxVõetavateArv) {

            allesPärastArvutiKäiku = alles - alles;

// Väljastan tulemuse.
            System.out.println("Laual on tikke alles pärast arvutikäiku: " + allesPärastArvutiKäiku);


        }
// Kui laual on alles rohkem tikke, kui on võimalik maksimaalselt eemaldada, kasutan juhusliku arvu
// genereerimise töövõtet ning genereerin juhusliku arvu vahemikus 1 kuni maksimaalne võimalik ära võetav
// arv tikke ja lahutan selle alles olevatest tikkude arvust.
        else if (alles > 0){
            Random arvutiKäik = new Random();
            arvutiEemaldab = 1 + arvutiKäik.nextInt(maxVõetavateArv);
            allesPärastArvutiKäiku = alles - arvutiEemaldab;

// Väljastan tulemuse.
            System.out.println("Laual on tikke alles pärast arvutikäiku: " + allesPärastArvutiKäiku);
        }

// Kui pärast arvuti käiku laual tikke ei ole, väljastan tulemuse.
        else {
            allesPärastArvutiKäiku = 0;
            System.out.println("Laual on tikke alles pärast arvutikäiku: " + allesPärastArvutiKäiku);
        }

// Tagastan tikkude arvu väärtuse pärast arvuti käiku.
        return allesPärastArvutiKäiku;
    }

// Loon funktsiooni nimega main.
    static void main() {

// Kutsun välja funktsioonid tikkeKokku ning võetavad koos väärtustega.
        tikkeKokku(tikkudeArvLaual);
        võetavad(maxVõetavateArv);

// Omistan muutujatele väärtused.
        allesPärastArvutiKäiku = tikkudeArvLaual;
        alles = allesPärastArvutiKäiku;

// Funktsioon main() töötab seni kaua kuni on laual tikke.
        while(allesPärastArvutiKäiku > 0 && alles > 0) {

// Kutsun välja funktsioonid makeHumanMove ning makeComputerMove koos väärtustega.
            makeHumanMove(alles);
            makeComputerMove(allesPärastArvutiKäiku);
        }

// Kui tikud saavad laualt otsa väljastan teate mängu lõppemisest ning küsin kas kasutaja soovib
// edasi mängida või lõpetada.
        System.out.println("Mängu lõpp!");
        System.out.println("Kas soovid uuesti jätkata? Sisesta: y");
        System.out.println("Soovid lõpetada? Sisesta: n");

    }

// Loon kontrolli sisendi kontrollimiseks.
    static boolean isValidValik(String u) {
        if (u.equals("y")) return true;
        else return false;
    }

// Loon funktsiooni nimega newGame.
    static void newGame() {

// Deklareerin muutuja ning omistan sellele väärtuse, lugedes selle käsurealt sisendina.
        Scanner uusMäng = new Scanner(System.in);

// Deklareerin muutuja ning omistan sellele väärtuse, mille lugesin sisse käsurealt.
        String vastus = uusMäng.next();

// Mäng hakkab uuesti tööle, kui pärast kasutajalt küsimist mängu jätkamise kohta sisestatakse y.
        while (true) {
            if (isValidValik(vastus)) {

// Kutsun välja funktsiooni main().
                main();
            }

// Kui kasutaja ei soovi mängu uuesti mängida, annab ta sisendiks n ning kasutajat tänatakse ja
// programm lõpetab oma töö.
            else {
                System.out.println("Aitäh, et mängisid!");
                break;
            }
        }
    }

// Programmi alguses kutsun välja funktsioonid main() ning newGame().
    public static void main(String[] args) {
        main();
        newGame();
    }







}
