import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main extends Hosok {
    public static void main(String[] args) {
        int arany = 0;
        int vasarlasiKoltseg = 5;
        Scanner sc = new Scanner(System.in);


        System.out.println("Valaszd ki a nehezsegi szintet! konnyu/kozepes/nehez: ");
        String nehezseg = sc.nextLine();
        boolean correct = false;
        while (correct == false){
            if (nehezseg.equals("konnyu")){
                correct=true;
                continue;
            }
            if (nehezseg.equals("nehez")){
                correct=true;
                continue;
            }
            if (nehezseg.equals("kozepes")){
                correct=true;
                continue;
            }
            System.err.println("Nem adtad meg helyesen a nehezsegi szintet! konnyu/kozepes/nehez\n");
            nehezseg = sc.nextLine();
        }

        if (nehezseg.equals("konnyu")) {

            arany = 1300;
            System.out.println("Nehezsegi szint: " + nehezseg + ", \nAranyak szama: " + arany);

        } else if (nehezseg.equals("kozepes")) {

            arany = 1000;
            System.out.println("Nehezsegi szint: " + nehezseg + ", \nAranyak szama: " + arany);


        } else if (nehezseg.equals("nehez")) {

            arany = 700;
            System.out.println("Nehezseg szint: " + nehezseg + ", \nAranyak szama: " + arany);

        }


        Hosok hosok = new Hosok();
        hosok.setSzerencse(1);
        hosok.setVedekezes(1);
        hosok.setMoral(1);
        hosok.setVarazsero(1);
        hosok.setTudas(1);
        hosok.setManna(10);
        hosok.setTamadas(1);
        System.out.println("\nJelenleg ennyi tamadasi pontod van: " + hosok.getTamadas());
        System.out.println("Jelenleg ennyi vedekezesi pontod van: " + hosok.getVedekezes());
        System.out.println("Jelenleg ennyi varazsero pontod van: " + hosok.getVarazsero());
        System.out.println("Jelenleg ennyi tudas pontod van: " + hosok.getTudas());
        System.out.println("Jelenleg ennyi moral pontod van: " + hosok.getMoral());
        System.out.println("Jelenleg ennyi szerencse pontod van: " + hosok.getSzerencse() + "\n");


        System.out.println("Tamadas: az egysegek sebzeset noveli meg, tulajdonsagpontonkent 10%-kal.");
        System.out.println("Vedekezes: az egysegeket ert sebzest csokkenti, tulajdonsagpontonkent 5%-kal.");
        System.out.println("Varazsero: a hos altal idezett varazslatok erosseget noveli.");
        System.out.println("Tudas: a hos maximalis mannapontjait noveli, tulajdonsagpontonkent 10-zel");
        System.out.println("Moral: az egysegek kezdemenyezeset noveli, tulajdonsagpontonkent 1-gyel");
        System.out.println("Szerencse: az egysegek kritikus tamadasanak eselyet noveli, tulajdonsagpontonkent 5%- kal.");

        /*TULAJDONSAG FEJLESZTES - KEZDES*/

        while (arany > 0) {
            System.out.println("\nTulajdonsag fejlesztese kovetkezik\n");
            System.out.println("Az elso fejlesztes 5 aranyba kerul, minden tovabbi 10%-kal dragabb.\n");
            System.out.println("Mit szeretnel fejleszteni? tamadas/vedekezes/varazsero/tudas/moral/szerencse/befejezem\n");
            String tulajdonsagFejlesztes = sc.nextLine();


            if (tulajdonsagFejlesztes.equals("tamadas")) {
                hosok.setTamadas(hosok.getTamadas() + 1);
                System.out.println("Tamadas szint: " + hosok.getTamadas());
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);

                if (hosok.getTamadas() == 10) {
                    System.err.println("Elerted a maximum szintet a tamadas egysegbol!");
                    continue;
                }

                if (arany < 0) {
                    System.err.println("Elfogyott az aranyad!");
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("vedekezes")) {
                hosok.setVedekezes(hosok.getVedekezes() + 1);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Vedekezes szint: " + hosok.getVedekezes());
                if (hosok.getVedekezes() == 10) {
                    System.err.println("Elerted a maximum szintet a vedekezes egysegbol!");
                    continue;
                }

                if (arany < 0) {
                    System.err.println("Elfogyott az aranyad!");
                    break;
                }
                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("varazsero")) {
                hosok.setVarazsero(hosok.getVarazsero() + 1);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Varazsero szint: " + hosok.getVarazsero());
                if (hosok.getVarazsero() == 10) {
                    System.err.println("Elerted a maximum szintet a varazsero egysegbol!");
                    continue;
                }

                if (arany < 0) {
                    System.err.println("Elfogyott az aranyad!");
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);


            } else if (tulajdonsagFejlesztes.equals("tudas")) {
                hosok.setTudas(hosok.getTudas() + 1);
                hosok.setManna(hosok.getManna() + 10);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Tudas szint: " + hosok.getTudas());
                System.out.println("Manna szint: " + hosok.getManna());
                if (hosok.getManna() == 100 || hosok.getTudas() == 10) {
                    System.err.println("Elerted a maximalis manna szintet!");
                    System.err.println("Elerted a maximum szintet a tudas egysegbol!");
                    continue;
                }

                if (arany < 0) {
                    System.err.println("Elfogyott az aranyad!");
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("moral")) {
                hosok.setMoral(hosok.getMoral() + 1);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Moral szint: " + hosok.getMoral());

                if (hosok.getMoral() == 10) {
                    System.err.println("Elerted a maximum szintet a moral egysegbol!");
                    continue;
                }

                if (arany < 0) {
                    System.err.println("Elfogyott az aranyad!");
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("szerencse")) {
                hosok.setSzerencse(hosok.getSzerencse() + 1);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Szerencse szint: " + hosok.getSzerencse());

                if (hosok.getSzerencse() == 10) {
                    System.err.println("Elerted a maximum szintet a szerencse egysegbol!");
                    continue;
                }

                if (arany < 0) {
                    System.err.println("Elfogyott az aranyad!");
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("befejezem")) {
                break;
            }
            else {
                System.err.println("Nem adtad meg jol a tulajdonsag nevet!");
            }
        }

        /*TULAJDONSAG FEJLESZTES - VEGE*/

        /*VARAZSERO FEJLESZTES - KEZDES*/

        System.out.println("Varazslatok kivalasztasa kovetkezik!\n");
        System.out.println("Az alabbi varazslatok kozul valaszthatsz: villamcsapas, tuzlabda, feltamasztas, vihar, szelfujas\n");
        System.out.println("Villamcsapas tulajdonsagai: \n Ara: 60 arany\n Manna: 5 \n Leirasa: Egy kivalasztott egysegre (varazsero*30) sebzes okozasa.\n");
        System.out.println("Tuzlabda tulajdonsagai: \n Ara: 120 arany\n Manna: 9 \n Leirasa: Egy kivalasztott mezo koruli 3x3-as teruleten levo osszes(sajat, illetve ellenseges) egysegre (varazsero*20) sebzes okozasa .\n");
        System.out.println("Feltamasztas tulajdonsagai: \n Ara: 120 arany\n Manna: 6 \n Leirasa: Egy kivalasztott sajat egyseg feltamasztasa. Maximalis gyogyitas merteke: (varazsero*50), (de az eredeti egysegszamnal tobb nem lehet)\n");
        System.out.println("Vihar tulajdonsagai: \n Ara: 100 arany\n Manna: 4\n Leirasa: Egy kivalasztott mezo koruli osszes egysegre (varazsero*15) sebzes okozasa.\n");
        System.out.println("Szelfujas tulajdonsagai: \n Ara: 80 arany\n Manna: 3\n Leirasa: Egy kivalasztott egysegre (varazsero*10) sebzes okozasa.\n");

        int villamcsapas = 0, tuzlabda = 0, feltamasztas = 0, vihar = 0, szelfujas = 0;


        while (arany > 0) {
            System.out.println("FIGYELEM! Minimum egy varazslatot kotelezo valasztani!\n");
            System.out.println("Milyen varazslatot szeretnel valasztani? villamcsapas, tuzlabda, feltamasztas, vihar, szelfujas, befejezem\n");
            String varazsV = sc.nextLine();

            if (varazsV.equals("villamcsapas")) {
                if (arany < 60) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                }  else {
                    villamcsapas++;
                    arany -= 60;
                    System.out.println("Jelenlegi villamcsapas varazslatok szama: " + villamcsapas + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                    System.out.println("Ennyi mannad maradt: " + hosok.getManna() + "\n");
                }
            } else if (varazsV.equals("tuzlabda")) {
                if (arany < 120) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    tuzlabda++;
                    arany -= 120;
                    System.out.println("Jelenlegi tuzlabda varazslatok szama: " + tuzlabda + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }
            } else if (varazsV.equals("feltamasztas")) {
                if (arany < 120) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    feltamasztas++;
                    arany -= 120;
                    System.out.println("Jelenlegi feltamasztas varazslatok szama: " + feltamasztas + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }
            } else if (varazsV.equals("vihar")) {
                if (arany < 100) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    vihar++;
                    arany -= 100;
                    System.out.println("Jelenlegi vihar varazslatok szama: " + vihar + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }
            } else if (varazsV.equals("szelfujas")) {
                if (arany < 80) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    szelfujas++;
                    arany -= 80;
                    System.out.println("Jelenlegi szelfujas varazslatok szama: " + szelfujas + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }
            } else if (varazsV.equals("befejezem")) {
                if (villamcsapas == 0 && tuzlabda == 0 && feltamasztas == 0 && vihar == 0 && szelfujas == 0) {
                    System.err.println("Nem valasztottal ki egyetlen varazserot sem!");
                    continue;
                } else {
                    break;
                }
            } else {
                System.err.println("Nem adtad meg jol a varazslat nevet!");
            }
        }

        /*VARAZSERO FEJLESZTES - VEGE*/

        /*SEREG OSSZEALLITASA - KEZDES*/
        int[] idg = new int[5];
        String[] tarolo = new String[5];
        int seholmashol = 0;

        System.out.println("A sereg osszeallitasa kovetkezik!\n");

        System.out.println("Az alábbi egysegek kozul valaszthatsz: foldmuves, sarkany, killer, ijasz, griff\n");
        System.out.println("A foldmuves tulajdonsagai: \n Ar: 2 arany \n Sebzes: 1-1 \n Eletero: 3 \n Sebesseg: 4 \n Kezdemenyezes: 8 \n Specialis kepesseg: nincs\n");
        System.out.println("A sarkany tulajdonsagai: \n Ar: 4 arany \n Sebzes: 2-3 \n Eletero: 5 \n Sebesseg: 6 \n Kezdemenyezes: 7 \n Specialis kepesseg: tuzet okad\n");
        System.out.println("A killer tulajdonsagai: \n Ar: 5 arany \n Sebzes: 3-4 \n Eletero: 9 \n Sebesseg: 6 \n Kezdemenyezes: 6 \n Specialis kepesseg: kesel\n");
        System.out.println("A ijasz tulajdonsagai: \n Ar: 6 arany \n Sebzes: 2-4 \n Eletero: 7 \n Sebesseg: 4 \n Kezdemenyezes: 9 \n Specialis kepesseg: loves\n");
        System.out.println("A griff tulajdonsagai: \n Ar: 15 arany \n Sebzes: 5-10 \n Eletero: 30 \n Sebesseg: 7 \n Kezdemenyezes: 15 \n Specialis kepesseg: vegtelen visszatamadas\n");

        int fsebzes = 0, feletero = 0, fsebesseg = 0, fkezedemenyezes = 0;
        String fspecKep;

        int ssebzes = 0, seletero = 0, ssebesseg = 0, skezedemenyezes = 0;
        String sspecKep;

        int ksebzes = 0, keletero = 0, ksebesseg = 0, kkezedemenyezes = 0;
        String kspecKep;

        int isebzes = 0, ieletero = 0, isebesseg = 0, ikezedemenyezes = 0;
        String ispecKep;

        int gsebzes = 0, geletero = 0, gsebesseg = 0, gkezedemenyezes = 0;
        String gspecKep;

        Scanner darab = new Scanner(System.in);
        while (arany > 0) {
            if (seholmashol>=5){
                break;
            }
            System.out.println("FIGYELEM! Minimum 1 harcost ki kell valasztani!");

            System.out.println("Kit szeretnel a csapatba rakni? foldmuves, sarkany, killer, ijasz, griff, befejezem\n");
            String seregFejlesztes = sc.nextLine();

            if (seregFejlesztes.equals("foldmuves")) {
                boolean foldmuves = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo[i].equals("F")) {
                        foldmuves = false;
                    }
                }
                if (foldmuves == true) {
                    tarolo[seholmashol] = "F";
                    idg[seholmashol] = 8;
                    seholmashol++;
                }

                System.out.println("Hany darabot szeretnel belole megvenni? ");
                int darabSzam=darabSzam = darab.nextInt();


                if (arany < 2 * darabSzam) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    arany -= 2 * darabSzam;
                    fsebzes += 1 * darabSzam;
                    feletero += 3 * darabSzam;
                    fsebesseg = 4;
                    fkezedemenyezes = 8;
                    fspecKep = "nincs";
                    System.out.println("Foldmuves sebzes beallitva " + fsebzes + "-ra/-re\n");
                    System.out.println("Foldmuves eletero beallitva " + feletero + "-ra/-re\n");
                    System.out.println("Foldmuves sebesseg beallitva " + fsebesseg + "-ra/-re\n");
                    System.out.println("Foldmuves kezdemenyezes beallitva " + fkezedemenyezes + "-ra/-re\n");
                    System.out.println("Foldmuves specialis kepesseg beallitva " + fspecKep + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }


            } else if (seregFejlesztes.equals("sarkany")) {
                boolean sarkany = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo[i].equals("S")) {
                        sarkany = false;
                    }
                }
                if (sarkany == true) {
                    tarolo[seholmashol] = "S";
                    idg[seholmashol] = 7;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                int darabSzam = darab.nextInt();

                if (arany < 4 * darabSzam) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    arany -= 4 * darabSzam;
                    ssebzes += 2 * darabSzam;
                    seletero += 5 * darabSzam;
                    ssebesseg = 6;
                    skezedemenyezes = 7;
                    sspecKep = "tuzet okad";
                    System.out.println("Sarkany sebzese beallitva " + ssebzes + "-ra/-re\n");
                    System.out.println("Sarkany eletero beallitva " + seletero + "-ra/-re\n");
                    System.out.println("Sarkany sebesseg beallitva " + ssebesseg + "-ra/-re\n");
                    System.out.println("Sarkany kezdemenyezes beallitva " + skezedemenyezes + "-ra/-re\n");
                    System.out.println("Sarkany specialis kepesseg beallitva " + sspecKep + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }


            } else if (seregFejlesztes.equals("killer")) {
                boolean killer = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo[i].equals("K")) {
                        killer = false;
                    }
                }
                if (killer == true) {
                    tarolo[seholmashol] = "K";
                    idg[seholmashol] = 6;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                int darabSzam = darab.nextInt();

                if (arany < 5 * darabSzam) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    arany -= 5 * darabSzam;
                    ksebzes += 3 * darabSzam;
                    keletero += 9 * darabSzam;
                    ksebesseg = 6;
                    kkezedemenyezes = 6;
                    kspecKep = "kesel";
                    System.out.println("Killer sebzese beallitva " + ksebzes + "-ra/-re\n");
                    System.out.println("Killer eletero beallitva " + keletero + "-ra/-re\n");
                    System.out.println("Killer sebesseg beallitva " + ksebesseg + "-ra/-re\n");
                    System.out.println("Killer kezdemenyezes beallitva " + kkezedemenyezes + "-ra/-re\n");
                    System.out.println("Killer specialis kepesseg beallitva " + kspecKep + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }


            } else if (seregFejlesztes.equals("ijasz")) {
                boolean ijasz = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo[i].equals("I")) {
                        ijasz = false;
                    }
                }
                if (ijasz == true) {
                    tarolo[seholmashol] = "I";
                    idg[seholmashol] = 9;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                int darabSzam = darab.nextInt();

                if (arany < 6 * darabSzam) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    arany -= 6 * darabSzam;
                    isebzes += 2 * darabSzam;
                    ieletero += 7 * darabSzam;
                    isebesseg = 4;
                    ikezedemenyezes = 9;
                    ispecKep = "loves";
                    System.out.println("Ijasz sebzese beallitva " + isebzes + "-ra/-re\n");
                    System.out.println("Ijasz eletero beallitva " + ieletero + "-ra/-re\n");
                    System.out.println("Ijasz sebesseg beallitva " + isebesseg + "-ra/-re\n");
                    System.out.println("Ijasz kezdemenyezes beallitva " + ikezedemenyezes + "-ra/-re\n");
                    System.out.println("Ijasz specialis kepesseg beallitva " + ispecKep + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }


            } else if (seregFejlesztes.equals("griff")) {
                boolean griff = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo[i].equals("G")) {
                        griff = false;
                    }
                }
                if (griff == true) {
                    tarolo[seholmashol] = "G";
                    idg[seholmashol] = 15;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                int darabSzam = darab.nextInt();

                if (arany < 15 * darabSzam) {
                    System.err.println("Elfogyott az aranyad, ezert nem birod megvenni!");
                    break;
                } else {
                    arany -= 15 * darabSzam;
                    gsebzes += 5 * darabSzam;
                    geletero += 30 * darabSzam;
                    gsebesseg = 7;
                    gkezedemenyezes = 15;
                    gspecKep = "vegtelen visszatamadas";
                    System.out.println("Griff sebzese beallitva " + gsebzes + "-ra/-re\n");
                    System.out.println("Griff eletero beallitva " + geletero + "-ra/-re\n");
                    System.out.println("Griff sebesseg beallitva " + gsebesseg + "-ra/-re\n");
                    System.out.println("Griff kezdemenyezes beallitva " + gkezedemenyezes + "-ra/-re\n");
                    System.out.println("Griff specialis kepesseg beallitva " + gspecKep + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }

            } else if (seregFejlesztes.equals("befejezem")) {
                if (fsebzes == 0 && ssebzes == 0 && ksebzes == 0 && isebzes == 0 && gsebzes == 0) {
                    System.err.println("Nem valasztottal ki egyetlen egyseget sem!");
                    continue;
                } else {
                    break;
                }
            } else {
                System.err.println("Nem adtad meg jol az egyseg nevet!");
            }
        }
        /*SEREG OSSZEALLITAS - VEGE*/


        /*CSATATER KESZITES - KEZDES*/

        System.out.println("Csatater megjelenitese");


        String[][] csatater = new String[10][12];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        csatater[i][j] = " -";
                    } else if (j % 2 == 1) {
                        csatater[i][j] = " |";
                    }
                } else if (i % 2 == 1) {
                    if (j % 2 == 1) {
                        csatater[i][j] = " -";
                    } else if (j % 2 == 0) {
                        csatater[i][j] = " |";
                    }
                }
            }
            System.out.println("");
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                System.out.print(csatater[i][j]);
            }
            System.out.println("");
        }


        /*CSATATER KESZITES - VEGE*/

        /*HARCOS LEHELYEZES - KEZDES*/

        int elsoKoordinata = 0;
        int masodikKoordinata = 0;
        boolean helyesE = false;
        boolean helyesE2 = false;
        boolean helyesE3 = false;
        boolean helyesE4 = false;
        int m = 0;
        Scanner koordinata = new Scanner(System.in);

        System.out.println("Harcosok lehelyezese kovetkezik!");

        for (int s = 0; s < seholmashol; s++) {
            /////////////////////////////////
            if (tarolo[s].equals("G")) {
                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a griffet? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        elsoKoordinata = koordinata.nextInt();
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            System.err.println("Nem adatad meg jol a koordinatat! Csak az 1. es 10. koordinatara teheted be!");
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        masodikKoordinata = koordinata.nextInt();
                        if (masodikKoordinata < 1 || masodikKoordinata > 2) {
                            System.err.println("Nem adtad meg jol a koordinatat! Csak az 1. es 2. koordinatara teheted be!");
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " G";
                            break;
                        }else {
                            System.err.println("Nem adtad meg jol a koordinatat! Mar van rajta hosod!");
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }




                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }

            /////////////////////////////////
            /////////////////////////////////
            else if (tarolo[s].equals("S")) {

                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a sarkanyt? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        elsoKoordinata = koordinata.nextInt();
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            System.err.println("Nem adatad meg jol a koordinatat! Csak az 1. es 10. koordinatara teheted be!");
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        masodikKoordinata = koordinata.nextInt();
                        if (masodikKoordinata < 1 || masodikKoordinata > 2) {
                            System.err.println("Nem adtad meg jol a koordinatat! Csak az 1. es 2. koordinatara teheted be!");
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " S";
                            break;
                        }else {
                            System.err.println("Nem adtad meg jol a koordinatat! Mar van rajta hosod!");
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }
            /////////////////////////////////
            /////////////////////////////////
            else if (tarolo[s].equals("I")) {

                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a ijaszt? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        elsoKoordinata = koordinata.nextInt();
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            System.err.println("Nem adatad meg jol a koordinatat! Csak az 1. es 10. koordinatara teheted be!");
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        masodikKoordinata = koordinata.nextInt();
                        if (masodikKoordinata < 1 || masodikKoordinata > 2) {
                            System.err.println("Nem adtad meg jol a koordinatat! Csak az 1. es 2. koordinatara teheted be!");
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " I";
                            break;
                        }else {
                            System.err.println("Nem adtad meg jol a koordinatat! Mar van rajta hosod!");
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }
            /////////////////////////////////
            /////////////////////////////////
            else if (tarolo[s].equals("F")) {

                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a foldmuvest? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        elsoKoordinata = koordinata.nextInt();
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            System.err.println("Nem adatad meg jol a koordinatat! Csak az 1. es 10. koordinatara teheted be!");
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        masodikKoordinata = koordinata.nextInt();
                        if (masodikKoordinata < 1 || masodikKoordinata > 2) {
                            System.err.println("Nem adtad meg jol a koordinatat! Csak az 1. es 2. koordinatara teheted be!");
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " F";
                            break;
                        }else {
                            System.err.println("Nem adtad meg jol a koordinatat! Mar van rajta hosod!");
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }
            /////////////////////////////////
            /////////////////////////////////
            else if (tarolo[s].equals("K")) {

                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a killert? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        elsoKoordinata = koordinata.nextInt();
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            System.err.println("Nem adatad meg jol a koordinatat! Csak az 1. es 10. koordinatara teheted be!");
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        masodikKoordinata = koordinata.nextInt();
                        if (masodikKoordinata < 1 || masodikKoordinata > 2) {
                            System.err.println("Nem adtad meg jol a koordinatat! Csak az 1. es 2. koordinatara teheted be!");
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " K";
                            break;
                        }else {
                            System.err.println("Nem adtad meg jol a koordinatat! Mar van rajta hosod!");
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }
        }
        /////////////////////////////////
        /////////////////////////////////
        /*HARCOS LEHELYEZES - VEGE*/


        /*HARCOS MOZGATAS - KEZDES*/
        String[] harcosKezdemenyezes = {"G", "I", "K", "F", "S"};
        int[] harcoskez;
        Scanner hosMozgatas = new Scanner(System.in);
        String hosMozgat;
        boolean mozgat = false;

        System.out.println("Mostantol mozgathatod a harcosodat!");

        for(int i= seholmashol-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(idg[j] < idg[j+1])
                {
                    int tmp = idg[j];
                    idg[j] = idg[j+1];
                    idg[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i <seholmashol ; i++) {
            if (idg[i]==15){
                tarolo[i]="G";

            }
            if (idg[i]==8){
                tarolo[i]="F";

            }
            if (idg[i]==7){
                tarolo[i]="S";

            }
            if (idg[i]==6){
                tarolo[i]="K";

            }
            if (idg[i]==9){
                tarolo[i]="I";

            }
        }

        int osszeletero = feletero+seletero+ieletero+keletero+geletero;

        System.out.println("A magasabb kezdemenyezesu harcossal tudsz lepni!");
        for (int i = 0; i < seholmashol; i++) {
            System.out.println("Az alabbi hoseid vannak: " + tarolo[i]);
        }
        int korszam=0;
        int karakterszam=seholmashol;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        arany = 1000;

        Hosok gephosok = new Hosok();
        gephosok.setSzerencse(1);
        gephosok.setVedekezes(1);
        gephosok.setMoral(1);
        gephosok.setVarazsero(1);
        gephosok.setTudas(1);
        gephosok.setManna(10);
        gephosok.setTamadas(1);
        System.out.println("\nJelenleg ennyi tamadasi pontod van: " + gephosok.getTamadas());
        System.out.println("Jelenleg ennyi vedekezesi pontod van: " + gephosok.getVedekezes());
        System.out.println("Jelenleg ennyi varazsero pontod van: " + gephosok.getVarazsero());
        System.out.println("Jelenleg ennyi tudas pontod van: " + gephosok.getTudas());
        System.out.println("Jelenleg ennyi moral pontod van: " + gephosok.getMoral());
        System.out.println("Jelenleg ennyi szerencse pontod van: " + gephosok.getSzerencse() + "\n");


        System.out.println("Tamadas: az egysegek sebzeset noveli meg, tulajdonsagpontonkent 10%-kal.");
        System.out.println("Vedekezes: az egysegeket ert sebzest csokkenti, tulajdonsagpontonkent 5%-kal.");
        System.out.println("Varazsero: a hos altal idezett varazslatok erosseget noveli.");
        System.out.println("Tudas: a hos maximalis mannapontjait noveli, tulajdonsagpontonkent 10-zel");
        System.out.println("Moral: az egysegek kezdemenyezeset noveli, tulajdonsagpontonkent 1-gyel");
        System.out.println("Szerencse: az egysegek kritikus tamadasanak eselyet noveli, tulajdonsagpontonkent 5%- kal.");

        /*TULAJDONSAG FEJLESZTES - KEZDES*/
        String[] geptulajdonsagok = {"tamadas","vedekezes","varazsero","tudas","moral","szerencse"};
        int randomNum = 0;
        while (arany > 666) {
            randomNum=ThreadLocalRandom.current().nextInt(0, 5);
            String tulajdonsagFejlesztes = geptulajdonsagok[randomNum];


            if (tulajdonsagFejlesztes.equals("tamadas")) {
                gephosok.setTamadas(gephosok.getTamadas() + 1);
                System.out.println("Tamadas szint: " + gephosok.getTamadas());
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);

                if (gephosok.getTamadas() == 10) {
                    System.err.println("Elerted a maximum szintet a tamadas egysegbol!");
                    continue;
                }

                if (arany < 666) {
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("vedekezes")) {
                gephosok.setVedekezes(gephosok.getVedekezes() + 1);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Vedekezes szint: " + gephosok.getVedekezes());
                if (gephosok.getVedekezes() == 10) {
                    System.err.println("Elerted a maximum szintet a vedekezes egysegbol!");
                    continue;
                }

                if (arany < 666) {
                    break;
                }
                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("varazsero")) {
                gephosok.setVarazsero(gephosok.getVarazsero() + 1);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Varazsero szint: " + gephosok.getVarazsero());
                if (gephosok.getVarazsero() == 10) {
                    System.err.println("Elerted a maximum szintet a varazsero egysegbol!");
                    continue;
                }

                if (arany < 666) {
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);


            } else if (tulajdonsagFejlesztes.equals("tudas")) {
                gephosok.setTudas(gephosok.getTudas() + 1);
                gephosok.setManna(gephosok.getManna() + 10);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Tudas szint: " + gephosok.getTudas());
                System.out.println("Manna szint: " + gephosok.getManna());
                if (gephosok.getManna() == 100 || gephosok.getTudas() == 10) {
                    System.err.println("Elerted a maximalis manna szintet!");
                    System.err.println("Elerted a maximum szintet a tudas egysegbol!");
                    continue;
                }

                if (arany < 666) {
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("moral")) {
                gephosok.setMoral(gephosok.getMoral() + 1);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Moral szint: " + gephosok.getMoral());

                if (gephosok.getMoral() == 10) {
                    System.err.println("Elerted a maximum szintet a moral egysegbol!");
                    continue;
                }

                if (arany < 666) {
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("szerencse")) {
                gephosok.setSzerencse(gephosok.getSzerencse() + 1);
                arany -= vasarlasiKoltseg;
                vasarlasiKoltseg = (int) Math.ceil(vasarlasiKoltseg * 1.1);
                System.out.println("Szerencse szint: " + gephosok.getSzerencse());

                if (gephosok.getSzerencse() == 10) {
                    System.err.println("Elerted a maximum szintet a szerencse egysegbol!");
                    continue;
                }

                if (arany < 666) {
                    break;
                }

                System.out.println("Ennyi aranyad maradt: " + arany);

            } else if (tulajdonsagFejlesztes.equals("befejezem")) {
                break;
            }
        }

        /*TULAJDONSAG FEJLESZTES - VEGE*/

        /*VARAZSERO FEJLESZTES - KEZDES*/

        System.out.println("Varazslatok kivalasztasa kovetkezik!\n");
        System.out.println("Az alabbi varazslatok kozul valaszthatsz: villamcsapas, tuzlabda, feltamasztas, vihar, szelfujas\n");
        System.out.println("Villamcsapas tulajdonsagai: \n Ara: 60 arany\n Manna: 5 \n Leirasa: Egy kivalasztott egysegre (varazsero*30) sebzes okozasa.\n");
        System.out.println("Tuzlabda tulajdonsagai: \n Ara: 120 arany\n Manna: 9 \n Leirasa: Egy kivalasztott mezo koruli 3x3-as teruleten levo osszes(sajat, illetve ellenseges) egysegre (varazsero*20) sebzes okozasa .\n");
        System.out.println("Feltamasztas tulajdonsagai: \n Ara: 120 arany\n Manna: 6 \n Leirasa: Egy kivalasztott sajat egyseg feltamasztasa. Maximalis gyogyitas merteke: (varazsero*50), (de az eredeti egysegszamnal tobb nem lehet)\n");
        System.out.println("Vihar tulajdonsagai: \n Ara: 100 arany\n Manna: 4\n Leirasa: Egy kivalasztott mezo koruli osszes egysegre (varazsero*15) sebzes okozasa.\n");
        System.out.println("Szelfujas tulajdonsagai: \n Ara: 80 arany\n Manna: 3\n Leirasa: Egy kivalasztott egysegre (varazsero*10) sebzes okozasa.\n");

        villamcsapas = 0;
        tuzlabda = 0;
        feltamasztas = 0;
        vihar = 0;
        szelfujas = 0;
        randomNum=0;
        String[] gepVarazs = {"villamcsapas","tuzlabda","feltamasztas","vihar","szelfujas"};

        while (arany > 333) {
            System.out.println("FIGYELEM! Minimum egy varazslatot kotelezo valasztani!\n");
            System.out.println("Milyen varazslatot szeretnel valasztani? villamcsapas, tuzlabda, feltamasztas, vihar, szelfujas, befejezem\n");
            randomNum=ThreadLocalRandom.current().nextInt(1, 4);
            String varazsV = gepVarazs[randomNum];


            if (varazsV.equals("villamcsapas")) {
                if (arany < 60) {

                    break;
                } else if (gephosok.getManna() < 5) {

                    break;
                } else {
                    villamcsapas++;
                    arany -= 60;
                    gephosok.setManna(gephosok.getManna() - 5);
                    System.out.println("Jelenlegi villamcsapas varazslatok szama: " + villamcsapas + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                    System.out.println("Ennyi mannad maradt: " + gephosok.getManna() + "\n");
                }
            } else if (varazsV.equals("tuzlabda")) {
                if (arany < 120) {

                    break;
                } else if (gephosok.getManna() < 9) {

                    break;
                } else {
                    tuzlabda++;
                    arany -= 120;
                    gephosok.setManna(gephosok.getManna() - 9);
                    System.out.println("Jelenlegi tuzlabda varazslatok szama: " + tuzlabda + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                    System.out.println("Ennyi mannad maradt: " + gephosok.getManna() + "\n");
                }
            } else if (varazsV.equals("feltamasztas")) {
                if (arany < 120) {

                    break;
                } else if (gephosok.getManna() < 6) {

                    break;
                } else {
                    feltamasztas++;
                    arany -= 120;
                    gephosok.setManna(gephosok.getManna() - 6);
                    System.out.println("Jelenlegi feltamasztas varazslatok szama: " + feltamasztas + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                    System.out.println("Ennyi mannad maradt: " + gephosok.getManna() + "\n");
                }
            } else if (varazsV.equals("vihar")) {
                if (arany < 100) {

                    break;
                } else if (gephosok.getManna() < 4) {

                    break;
                } else {
                    vihar++;
                    arany -= 100;
                    gephosok.setManna(gephosok.getManna() - 4);
                    System.out.println("Jelenlegi vihar varazslatok szama: " + vihar + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                    System.out.println("Ennyi mannad maradt: " + gephosok.getManna() + "\n");
                }
            } else if (varazsV.equals("szelfujas")) {
                if (arany < 80) {

                    break;
                } else if (gephosok.getManna() < 3) {

                    break;
                } else {
                    szelfujas++;
                    arany -= 80;
                    gephosok.setManna(gephosok.getManna() - 3);
                    System.out.println("Jelenlegi szelfujas varazslatok szama: " + szelfujas + "\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                    System.out.println("Ennyi mannad maradt: " + gephosok.getManna() + "\n");
                }
            } else if (varazsV.equals("befejezem")) {
                if (villamcsapas == 0 && tuzlabda == 0 && feltamasztas == 0 && vihar == 0 && szelfujas == 0) {
                    System.err.println("Nem valasztottal ki egyetlen varazserot sem!");
                    continue;
                } else {
                    break;
                }
            } else {
                System.err.println("Nem adtad meg jol a varazslat nevet!");
            }
        }

        /*VARAZSERO FEJLESZTES - VEGE*/

        /*SEREG OSSZEALLITASA - KEZDES*/
        int[] idg2 = new int[5];
        String[] tarolo2 = new String[5];
        seholmashol = 0;

        System.out.println("A sereg osszeallitasa kovetkezik!\n");

        System.out.println("Az alábbi egysegek kozul valaszthatsz: foldmuves, sarkany, killer, ijasz, griff\n");
        System.out.println("A foldmuves tulajdonsagai: \n Ar: 2 arany \n Sebzes: 1-1 \n Eletero: 3 \n Sebesseg: 4 \n Kezdemenyezes: 8 \n Specialis kepesseg: nincs\n");
        System.out.println("A sarkany tulajdonsagai: \n Ar: 4 arany \n Sebzes: 2-3 \n Eletero: 5 \n Sebesseg: 6 \n Kezdemenyezes: 7 \n Specialis kepesseg: tuzet okad\n");
        System.out.println("A killer tulajdonsagai: \n Ar: 5 arany \n Sebzes: 3-4 \n Eletero: 9 \n Sebesseg: 6 \n Kezdemenyezes: 6 \n Specialis kepesseg: kesel\n");
        System.out.println("A ijasz tulajdonsagai: \n Ar: 6 arany \n Sebzes: 2-4 \n Eletero: 7 \n Sebesseg: 4 \n Kezdemenyezes: 9 \n Specialis kepesseg: loves\n");
        System.out.println("A griff tulajdonsagai: \n Ar: 15 arany \n Sebzes: 5-10 \n Eletero: 30 \n Sebesseg: 7 \n Kezdemenyezes: 15 \n Specialis kepesseg: vegtelen visszatamadas\n");

        int fsebzes2 = 0, feletero2 = 0, fsebesseg2 = 0, fkezedemenyezes2 = 0;
        String fspecKep2;

        int ssebzes2 = 0, seletero2 = 0, ssebesseg2 = 0, skezedemenyezes2 = 0;
        String sspecKep2;

        int ksebzes2 = 0, keletero2 = 0, ksebesseg2 = 0, kkezedemenyezes2 = 0;
        String kspecKep2;

        int isebzes2 = 0, ieletero2 = 0, isebesseg2 = 0, ikezedemenyezes2 = 0;
        String ispecKep2;

        int gsebzes2 = 0, geletero2 = 0, gsebesseg2 = 0, gkezedemenyezes2 = 0;
        String gspecKep2;

        String[] gepSereg = {"foldmuves","sarkany","killer","ijasz","griff"};
        randomNum=0;

        while (arany > 0) {
            if (seholmashol>=5){
                break;
            }
            System.out.println("FIGYELEM! Minimum 1 harcost ki kell valasztani!");

            System.out.println("Kit szeretnel a csapatba rakni? foldmuves, sarkany, killer, ijasz, griff\n");
            randomNum=ThreadLocalRandom.current().nextInt(0, 5);
            String seregFejlesztes = gepSereg[randomNum];

            if (seregFejlesztes.equals("foldmuves")) {
                boolean foldmuves = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo2[i].equals("EF")) {
                        foldmuves = false;
                    }
                }
                if (foldmuves == true) {
                    tarolo2[seholmashol] = "EF";
                    idg2[seholmashol] = 8;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                randomNum=ThreadLocalRandom.current().nextInt(4, 10);
                int darabSzam = randomNum;

                if (arany < 2 * darabSzam) {

                    break;
                } else {
                    arany -= 2 * darabSzam;
                    fsebzes2 += 1 * darabSzam;
                    feletero2 += 3 * darabSzam;
                    fsebesseg2 = 4;
                    fkezedemenyezes2 = 8;
                    fspecKep2 = "nincs";
                    System.out.println("Foldmuves sebzes beallitva " + fsebzes2 + "-ra/-re\n");
                    System.out.println("Foldmuves eletero beallitva " + feletero2 + "-ra/-re\n");
                    System.out.println("Foldmuves sebesseg beallitva " + fsebesseg2 + "-ra/-re\n");
                    System.out.println("Foldmuves kezdemenyezes beallitva " + fkezedemenyezes2 + "-ra/-re\n");
                    System.out.println("Foldmuves specialis kepesseg beallitva " + fspecKep2 + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }


            } else if (seregFejlesztes.equals("sarkany")) {
                boolean sarkany = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo2[i].equals("ES")) {
                        sarkany = false;
                    }
                }
                if (sarkany == true) {
                    tarolo2[seholmashol] = "ES";
                    idg2[seholmashol] = 7;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                randomNum=ThreadLocalRandom.current().nextInt(4, 10);
                int darabSzam = randomNum;

                if (arany < 4 * darabSzam) {

                    break;
                } else {
                    arany -= 4 * darabSzam;
                    ssebzes2 += 2 * darabSzam;
                    seletero2 += 5 * darabSzam;
                    ssebesseg2 = 6;
                    skezedemenyezes2 = 7;
                    sspecKep2 = "tuzet okad";
                    System.out.println("Sarkany sebzese beallitva " + ssebzes2 + "-ra/-re\n");
                    System.out.println("Sarkany eletero beallitva " + seletero2 + "-ra/-re\n");
                    System.out.println("Sarkany sebesseg beallitva " + ssebesseg2 + "-ra/-re\n");
                    System.out.println("Sarkany kezdemenyezes beallitva " + skezedemenyezes2 + "-ra/-re\n");
                    System.out.println("Sarkany specialis kepesseg beallitva " + sspecKep2 + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }


            } else if (seregFejlesztes.equals("killer")) {
                boolean killer = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo2[i].equals("EK")) {
                        killer = false;
                    }
                }
                if (killer == true) {
                    tarolo2[seholmashol] = "EK";
                    idg2[seholmashol] = 6;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                randomNum=ThreadLocalRandom.current().nextInt(4, 10);
                int darabSzam = randomNum;

                if (arany < 5 * darabSzam) {

                    break;
                } else {
                    arany -= 5 * darabSzam;
                    ksebzes2 += 3 * darabSzam;
                    keletero2 += 9 * darabSzam;
                    ksebesseg2 = 6;
                    kkezedemenyezes2 = 6;
                    kspecKep2 = "kesel";
                    System.out.println("Killer sebzese beallitva " + ksebzes2 + "-ra/-re\n");
                    System.out.println("Killer eletero beallitva " + keletero2 + "-ra/-re\n");
                    System.out.println("Killer sebesseg beallitva " + ksebesseg2 + "-ra/-re\n");
                    System.out.println("Killer kezdemenyezes beallitva " + kkezedemenyezes2 + "-ra/-re\n");
                    System.out.println("Killer specialis kepesseg beallitva " + kspecKep2 + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }


            } else if (seregFejlesztes.equals("ijasz")) {
                boolean ijasz = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo2[i].equals("EI")) {
                        ijasz = false;
                    }
                }
                if (ijasz == true) {
                    tarolo2[seholmashol] = "EI";
                    idg2[seholmashol] = 9;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                randomNum=ThreadLocalRandom.current().nextInt(4, 10);
                int darabSzam = randomNum;

                if (arany < 6 * darabSzam) {

                    break;
                } else {
                    arany -= 6 * darabSzam;
                    isebzes2 += 2 * darabSzam;
                    ieletero2 += 7 * darabSzam;
                    isebesseg2 = 4;
                    ikezedemenyezes2 = 9;
                    ispecKep2 = "loves";
                    System.out.println("Ijasz sebzese beallitva " + isebzes2 + "-ra/-re\n");
                    System.out.println("Ijasz eletero beallitva " + ieletero2 + "-ra/-re\n");
                    System.out.println("Ijasz sebesseg beallitva " + isebesseg2 + "-ra/-re\n");
                    System.out.println("Ijasz kezdemenyezes beallitva " + ikezedemenyezes2 + "-ra/-re\n");
                    System.out.println("Ijasz specialis kepesseg beallitva " + ispecKep2 + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }


            } else if (seregFejlesztes.equals("griff")) {
                boolean griff = true;
                for (int i = 0; i < seholmashol; i++) {
                    if (tarolo2[i].equals("EG")) {
                        griff = false;
                    }
                }
                if (griff == true) {
                    tarolo2[seholmashol] = "EG";
                    idg2[seholmashol] = 15;
                    seholmashol++;
                }
                System.out.println("Hany darabot szeretnel belole megvenni? ");
                randomNum=ThreadLocalRandom.current().nextInt(4, 10);
                int darabSzam = randomNum;

                if (arany < 15 * darabSzam) {

                    break;
                } else {
                    arany -= 15 * darabSzam;
                    gsebzes2 += 5 * darabSzam;
                    geletero2 += 30 * darabSzam;
                    gsebesseg2 = 7;
                    gkezedemenyezes2 = 15;
                    gspecKep2 = "vegtelen visszatamadas";
                    System.out.println("Griff sebzese beallitva " + gsebzes2 + "-ra/-re\n");
                    System.out.println("Griff eletero beallitva " + geletero2 + "-ra/-re\n");
                    System.out.println("Griff sebesseg beallitva " + gsebesseg2 + "-ra/-re\n");
                    System.out.println("Griff kezdemenyezes beallitva " + gkezedemenyezes2 + "-ra/-re\n");
                    System.out.println("Griff specialis kepesseg beallitva " + gspecKep2 + "-ra/-re\n");
                    System.out.println("Ennyi aranyad maradt: " + arany + "\n");
                }

            } else if (seregFejlesztes.equals("befejezem")) {
                if (fsebzes2 == 0 && ssebzes2 == 0 && ksebzes2 == 0 && isebzes2 == 0 && gsebzes2 == 0) {

                    continue;
                } else {
                    break;
                }
            } else {
                System.err.println("Nem adtad meg jol az egyseg nevet!");
            }
        }

        /*HARCOS LEHELYEZES - KEZDES*/

        elsoKoordinata = 0;
        masodikKoordinata = 0;
        helyesE = false;
        helyesE2 = false;
        helyesE3 = false;
        helyesE4 = false;
        m = 0;

        System.out.println("Harcosok lehelyezese kovetkezik!");

        for (int s = 0; s < seholmashol; s++) {
            /////////////////////////////////
            if (tarolo2[s].equals("EG")) {
                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a griffet? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        randomNum=ThreadLocalRandom.current().nextInt(1, 10);
                        elsoKoordinata = randomNum;

                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        randomNum=ThreadLocalRandom.current().nextInt(11, 13);
                        masodikKoordinata = randomNum;
                        if (masodikKoordinata < 11 || masodikKoordinata > 12) {
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " EG";
                            break;
                        }else {
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }




                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }

            /////////////////////////////////
            /////////////////////////////////
            else if (tarolo2[s].equals("ES")) {

                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a sarkanyt? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        randomNum=ThreadLocalRandom.current().nextInt(1, 10);
                        elsoKoordinata = randomNum;
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        randomNum=ThreadLocalRandom.current().nextInt(11, 13);
                        masodikKoordinata = randomNum;
                        if (masodikKoordinata < 11 || masodikKoordinata > 12) {
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " ES";
                            break;
                        }else {
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }
            /////////////////////////////////
            /////////////////////////////////
            else if (tarolo2[s].equals("EI")) {

                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a ijaszt? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        randomNum=ThreadLocalRandom.current().nextInt(1, 10);
                        elsoKoordinata = randomNum;
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        randomNum=ThreadLocalRandom.current().nextInt(11, 13);
                        masodikKoordinata = randomNum;
                        if (masodikKoordinata < 11 || masodikKoordinata > 12) {
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " EI";
                            break;
                        }else {
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }
            /////////////////////////////////
            /////////////////////////////////
            else if (tarolo2[s].equals("EF")) {

                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a foldmuvest? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        randomNum=ThreadLocalRandom.current().nextInt(1, 10);
                        elsoKoordinata = randomNum;
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        randomNum=ThreadLocalRandom.current().nextInt(11, 13);
                        masodikKoordinata = randomNum;
                        if (masodikKoordinata < 11 || masodikKoordinata > 12) {
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " EF";
                            break;
                        }else {
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }
            /////////////////////////////////
            /////////////////////////////////
            else if (tarolo2[s].equals("EK")) {

                elsoKoordinata = 0;
                masodikKoordinata = 0;
                helyesE = false;
                helyesE2 = false;
                helyesE3 = false;
                while (helyesE3 != true){
                    while (helyesE == false) {
                        System.out.println("Hova szeretned lerakni a killert? Add meg az elso koordinatat 1-10 kozott, majd nyomj egy ENTER-t es utana add meg a masodik koordinatat is!");
                        randomNum=ThreadLocalRandom.current().nextInt(1, 10);
                        elsoKoordinata = randomNum;
                        if (elsoKoordinata < 1 || elsoKoordinata > 10) {
                            continue;

                        } else {
                            helyesE = true;
                        }
                    }
                    while (helyesE2 == false) {
                        System.out.println("Add meg a masodik koordinatat 1-2 kozott!");
                        randomNum=ThreadLocalRandom.current().nextInt(11, 13);
                        masodikKoordinata = randomNum;
                        if (masodikKoordinata < 11 || masodikKoordinata > 12) {
                            continue;
                        } else {
                            helyesE2 = true;
                        }
                    }
                    if (helyesE==true&&helyesE2==true){
                        if (csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" |")||csatater[elsoKoordinata-1][masodikKoordinata-1].equals(" -")){
                            csatater[elsoKoordinata-1][masodikKoordinata-1] = " EK";
                            break;
                        }else {
                            helyesE=false;
                            helyesE2=false;
                        }
                    }
                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 12; j++) {
                        System.out.print(csatater[i][j]);
                    }
                    System.out.println("");
                }
            }
        }
        /////////////////////////////////
        /////////////////////////////////
        /*HARCOS LEHELYEZES - VEGE*/


        /*HARCOS MOZGATAS - KEZDES*/
        //String[] harcosKezdemenyezes = {"G", "I", "K", "F", "S"};
        //int[] harcoskez;
        //Scanner hosMozgatas = new Scanner(System.in);
        //String hosMozgat;
        //boolean mozgat = false;

        System.out.println("Mostantol mozgathatod a harcosodat!");

        for(int i= seholmashol-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(idg2[j] < idg2[j+1])
                {
                    int tmp = idg2[j];
                    idg2[j] = idg2[j+1];
                    idg2[j+1] = tmp;
                }
            }
        }
        for (int i = 0; i <seholmashol ; i++) {
            if (idg2[i]==15){
                tarolo2[i]="EG";

            }
            if (idg2[i]==8){
                tarolo2[i]="EF";

            }
            if (idg2[i]==7){
                tarolo2[i]="ES";

            }
            if (idg2[i]==6){
                tarolo2[i]="EK";

            }
            if (idg2[i]==9){
                tarolo2[i]="EI";

            }
        }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        int osszeletero2 = feletero2+seletero2+ieletero2+keletero2+geletero2;
        //karakterszam
        Scanner ujkordinata=new Scanner(System.in);
        int ujelso = 0;
        int ujmasodik = 0;
        int regielso = 0;
        int regimasodik = 0;
        String karakter;
        String yesno;
        double hossz=0;
        boolean sikerestamadas=false;
        boolean helyesEaLepes=false;
        boolean helyeseakordinata=false;
        String mitAkarsz;
        int kor=0;
        boolean villam=false;
        String kittamadjak;
        while(osszeletero>0 && osszeletero2>0) {
            System.out.println(geletero2);
            System.out.println(feletero2);
            System.out.println(seletero2);
            System.out.println(keletero2);
            System.out.println(ieletero2);
            System.out.println(osszeletero2);
            kor++;
            System.out.println(kor + ". kor kovetkezik!");

            for (int s = 0; s < karakterszam; s++) {
                mitAkarsz="";
                for (int j = 0; j < 10; j++) {
                    for (int k = 0; k < 12; k++) {
                        System.out.print(csatater[j][k]);
                    }
                    System.out.println("");
                }
                System.out.println(geletero2);
                System.out.println(feletero2);
                System.out.println(seletero2);
                System.out.println(keletero2);
                System.out.println(ieletero2);
                System.out.println(osszeletero2);
                System.out.println("Mit szeretnel csinalni a "+tarolo[s]+" karakterrel? lepni/varakozni/tamadni");


                mitAkarsz = ujkordinata.nextLine();

                if (mitAkarsz.equals("lepni")) {
                    System.out.println("Hova szeretnel lepni a " + tarolo[s] + " karakterrel?");
                    if (tarolo[s].equals("G")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" G")) {
                                    regielso = j;
                                    regimasodik = k;
                                }
                            }
                        }
                        while (helyesEaLepes == false) {
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-10 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Griff sebesseg: " + gsebesseg);
                            ujelso = ujkordinata.nextInt();
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-12 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Griff sebesseg: " + gsebesseg);
                            ujmasodik = ujkordinata.nextInt();
                            hossz = Math.sqrt(((ujelso - regielso + 1) * (ujelso - regielso + 1)) + ((ujmasodik - regimasodik + 1) * (ujmasodik - regimasodik + 1)));

                            if (hossz <= gsebesseg && ujelso <= 10 && ujmasodik <= 12 && ujelso > 0 && ujmasodik > 0) {
                                if (csatater[ujelso - 1][ujmasodik - 1].equals(" -") || csatater[ujelso - 1][ujmasodik - 1].equals(" |")) {
                                    helyesEaLepes = true;
                                }
                            } else {
                                System.err.println("Nem tud ennyit lepni a hosod vagy ervenytelen koordinatat adtal meg!");
                                continue;
                            }
                        }
                        csatater[ujelso - 1][ujmasodik - 1] = " G";
                        if ((regielso + regimasodik) % 2 == 0) {
                            csatater[regielso][regimasodik] = " -";
                        } else if ((regielso + regimasodik) % 2 == 1) {
                            csatater[regielso][regimasodik] = " |";
                        }

                    }
                    helyesEaLepes = false;
                    if (tarolo[s].equals("K")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" K")) {
                                    regielso = j;
                                    regimasodik = k;
                                }
                            }
                        }
                        while (helyesEaLepes == false) {
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-10 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Killer sebesseg: " + ksebesseg);
                            ujelso = ujkordinata.nextInt();
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-12 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Killer sebesseg: " + ksebesseg);
                            ujmasodik = ujkordinata.nextInt();
                            hossz = Math.sqrt(((ujelso - regielso + 1) * (ujelso - regielso + 1)) + ((ujmasodik - regimasodik + 1) * (ujmasodik - regimasodik + 1)));
                            if (hossz <= gsebesseg && ujelso <= 10 && ujmasodik <= 12 && ujelso > 0 && ujmasodik > 0) {
                                if (csatater[ujelso - 1][ujmasodik - 1].equals(" -") || csatater[ujelso - 1][ujmasodik - 1].equals(" |")) {
                                    helyesEaLepes = true;
                                }
                            } else {
                                System.err.println("Nem tud ennyit lepni a hosod vagy ervenytelen koordinatat adtal meg!");
                                continue;
                            }
                        }

                        csatater[ujelso - 1][ujmasodik - 1] = " K";
                        if ((regielso + regimasodik) % 2 == 0) {
                            csatater[regielso][regimasodik] = " -";
                        } else if ((regielso + regimasodik) % 2 == 1) {
                            csatater[regielso][regimasodik] = " |";
                        }

                    }
                    helyesEaLepes = false;
                    if (tarolo[s].equals("S")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" S")) {
                                    regielso = j;
                                    regimasodik = k;
                                }
                            }
                        }
                        while (helyesEaLepes == false) {
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-10 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Sarkany sebesseg: " + ssebesseg);
                            ujelso = ujkordinata.nextInt();
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-12 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Sarkany sebesseg: " + ssebesseg);
                            ujmasodik = ujkordinata.nextInt();
                            hossz = Math.sqrt(((ujelso - regielso + 1) * (ujelso - regielso + 1)) + ((ujmasodik - regimasodik + 1) * (ujmasodik - regimasodik + 1)));
                            if (hossz <= gsebesseg && ujelso <= 10 && ujmasodik <= 12 && ujelso > 0 && ujmasodik > 0) {
                                if (csatater[ujelso - 1][ujmasodik - 1].equals(" -") || csatater[ujelso - 1][ujmasodik - 1].equals(" |")) {
                                    helyesEaLepes = true;
                                }
                            } else {
                                System.err.println("Nem tud ennyit lepni a hosod vagy ervenytelen koordinatat adtal meg!");
                                continue;
                            }
                        }

                        csatater[ujelso - 1][ujmasodik - 1] = " S";
                        if ((regielso + regimasodik) % 2 == 0) {
                            csatater[regielso][regimasodik] = " -";
                        } else if ((regielso + regimasodik) % 2 == 1) {
                            csatater[regielso][regimasodik] = " |";
                        }
                    }
                    helyesEaLepes = false;
                    if (tarolo[s].equals("F")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" F")) {
                                    regielso = j;
                                    regimasodik = k;
                                }
                            }
                        }
                        while (helyesEaLepes == false) {
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-10 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Foldmuves sebesseg: " + fsebesseg);
                            ujelso = ujkordinata.nextInt();
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-12 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Foldmuves sebesseg: " + fsebesseg);
                            ujmasodik = ujkordinata.nextInt();
                            hossz = Math.sqrt(((ujelso - regielso + 1) * (ujelso - regielso + 1)) + ((ujmasodik - regimasodik + 1) * (ujmasodik - regimasodik + 1)));
                            if (hossz <= gsebesseg && ujelso <= 10 && ujmasodik <= 12 && ujelso > 0 && ujmasodik > 0) {
                                if (csatater[ujelso - 1][ujmasodik - 1].equals(" -") || csatater[ujelso - 1][ujmasodik - 1].equals(" |")) {
                                    helyesEaLepes = true;
                                }
                            } else {
                                System.err.println("Nem tud ennyit lepni a hosod vagy ervenytelen koordinatat adtal meg!");
                                continue;
                            }
                        }
                        csatater[ujelso - 1][ujmasodik - 1] = " F";
                        if ((regielso + regimasodik) % 2 == 0) {
                            csatater[regielso][regimasodik] = " -";
                        } else if ((regielso + regimasodik) % 2 == 1) {
                            csatater[regielso][regimasodik] = " |";
                        }
                    }
                    helyesEaLepes = false;
                    if (tarolo[s].equals("I")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" I")) {
                                    regielso = j;
                                    regimasodik = k;
                                }
                            }
                        }
                        while (helyesEaLepes == false) {
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-10 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Ijasz sebesseg: " + isebesseg);
                            ujelso = ujkordinata.nextInt();
                            System.out.println("Add meg az elso koordinatat, ahova lepni szeretnel 1-12 kozott! DE FIGYELJ! Csak annyit tudsz lepni, amekkora a sebessege! Ijasz sebesseg: " + isebesseg);
                            ujmasodik = ujkordinata.nextInt();
                            hossz = Math.sqrt(((ujelso - regielso + 1) * (ujelso - regielso + 1)) + ((ujmasodik - regimasodik + 1) * (ujmasodik - regimasodik + 1)));
                            if (hossz <= gsebesseg && ujelso <= 10 && ujmasodik <= 12 && ujelso > 0 && ujmasodik > 0) {
                                if (csatater[ujelso - 1][ujmasodik - 1].equals(" -") || csatater[ujelso - 1][ujmasodik - 1].equals(" |")) {
                                    helyesEaLepes = true;
                                }
                            } else {
                                System.err.println("Nem tud ennyit lepni a hosod vagy ervenytelen koordinatat adtal meg!");
                                continue;
                            }
                        }
                        csatater[ujelso - 1][ujmasodik - 1] = " I";
                        if ((regielso + regimasodik) % 2 == 0) {
                            csatater[regielso][regimasodik] = " -";
                        } else if ((regielso + regimasodik) % 2 == 1) {
                            csatater[regielso][regimasodik] = " |";
                        }
                    }
                    else {continue;}
                } else if (mitAkarsz.equals("varakozni")) {
                    continue;
                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                //////////////////////////////////////////////////////////////////////////////////////////////////////
                else if (mitAkarsz.equals("tamadni")) {
                    System.out.println("Kit szeretnel megtamadni a " + tarolo[s] + " karakterrel?");
                    kittamadjak = sc.nextLine();
                    if (kittamadjak.equals("EG")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" EG")) {
                                    if (tarolo[s].equals("G")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" G")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(5, 11);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 = randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("K")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" K")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(3, 5);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("S")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" S")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(2, 4);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("F")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" F")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        geletero2 -= 1;
                                                        osszeletero2 -= 1;
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("I")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" I")) {
                                                    System.out.println("SIKEEEEEEEEEER");
                                                    randomNum = ThreadLocalRandom.current().nextInt(2, 5);
                                                    geletero2 -= randomNum;
                                                    osszeletero2 -= randomNum;
                                                    System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                    yesno = sc.nextLine();
                                                    if (yesno.equals("igen")) {
                                                        villam = true;
                                                    }
                                                    if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                        geletero -= hosok.getVarazsero() * 30;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        System.err.println("Nem talalhato ilyen karakter a palyan!");
                                        continue;
                                    }
                                }
                            }
                        }
                    } else if (kittamadjak.equals("ES")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" ES")) {
                                    if (tarolo[s].equals("G")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" G")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(5, 11);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 = randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("K")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" K")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(3, 5);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("S")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" S")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(2, 4);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("F")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" F")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        geletero2 -= 1;
                                                        osszeletero2 -= 1;
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("I")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" I")) {
                                                    System.out.println("SIKEEEEEEEEEER");
                                                    randomNum = (ThreadLocalRandom.current().nextInt(2, 5) + (vihar * 15) + (villamcsapas * 30) + (tuzlabda * 20) + (szelfujas * 10));
                                                    geletero2 -= randomNum;
                                                    osszeletero2 -= randomNum;
                                                    System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                    yesno = sc.nextLine();
                                                    if (yesno.equals("igen")) {
                                                        villam = true;
                                                    }
                                                    if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                        geletero -= hosok.getVarazsero() * 30;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        System.err.println("Nem talalhato ilyen karakter a palyan!");
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    else if (kittamadjak.equals("EK")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" EK")) {
                                    if (tarolo[s].equals("G")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" G")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(5, 11);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 = randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("K")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" K")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(3, 5);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("S")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" S")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(2, 4);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("F")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" F")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        geletero2 -= 1;
                                                        osszeletero2 -= 1;
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("I")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" I")) {
                                                    System.out.println("SIKEEEEEEEEEER");
                                                    randomNum = ThreadLocalRandom.current().nextInt(2, 5);
                                                    geletero2 -= randomNum;
                                                    osszeletero2 -= randomNum;
                                                    System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                    yesno = sc.nextLine();
                                                    if (yesno.equals("igen")) {
                                                        villam = true;
                                                    }
                                                    if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                        geletero -= hosok.getVarazsero() * 30;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        System.err.println("Nem talalhato ilyen karakter a palyan!");
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    else if (kittamadjak.equals("EF")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" EF")) {
                                    if (tarolo[s].equals("G")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" G")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(5, 11);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 = randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("K")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" K")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(3, 5);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("S")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" S")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(2, 4);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("F")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" F")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        geletero2 -= 1;
                                                        osszeletero2 -= 1;
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("I")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" I")) {
                                                    System.out.println("SIKEEEEEEEEEER");
                                                    randomNum = ThreadLocalRandom.current().nextInt(2, 5);
                                                    geletero2 -= randomNum;
                                                    osszeletero2 -= randomNum;
                                                    System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                    yesno = sc.nextLine();
                                                    if (yesno.equals("igen")) {
                                                        villam = true;
                                                    }
                                                    if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                        geletero -= hosok.getVarazsero() * 30;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        System.err.println("Nem talalhato ilyen karakter a palyan!");
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                    else if (kittamadjak.equals("EI")) {
                        for (int j = 0; j < 10; j++) {
                            for (int k = 0; k < 12; k++) {
                                if (csatater[j][k].equals(" EI")) {
                                    if (tarolo[s].equals("G")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" G")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(5, 11);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 = randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("elfogyott a mana");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("K")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" K")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(3, 5);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("nem sikerült");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("S")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" S")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        randomNum = ThreadLocalRandom.current().nextInt(2, 4);
                                                        geletero2 -= randomNum;
                                                        osszeletero2 -= randomNum;
                                                        System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                        yesno = sc.nextLine();
                                                        if (yesno.equals("igen")) {
                                                            villam = true;
                                                        }
                                                        if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                            geletero -= hosok.getVarazsero() * 30;
                                                        }
                                                    } else {
                                                        System.err.println("nem sikerült");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("F")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" F")) {
                                                    hossz = Math.sqrt(((j - l) * (j - l)) + ((k - n) * (k - n)));
                                                    if (hossz < 2) {
                                                        System.out.println("SIKEEEEEEEEEER");
                                                        geletero2 -= 1;
                                                        osszeletero2 -= 1;
                                                    } else {
                                                        System.err.println("nem sikerült");
                                                        continue;
                                                    }

                                                }
                                            }
                                        }

                                    }
                                    if (tarolo[s].equals("I")) {
                                        for (int l = 0; l < 10; l++) {
                                            for (int n = 0; n < 12; n++) {
                                                if (csatater[l][n].equals(" I")) {
                                                    System.out.println("SIKEEEEEEEEEER");
                                                    randomNum = (ThreadLocalRandom.current().nextInt(2, 5) + (vihar * 15) + (villamcsapas * 30) + (tuzlabda * 20) + (szelfujas * 10));
                                                    geletero2 -= randomNum;
                                                    osszeletero2 -= randomNum;
                                                    System.out.println("Szeretnel villammal tamadni? igen/nem");
                                                    yesno = sc.nextLine();
                                                    if (yesno.equals("igen")) {
                                                        villam = true;
                                                    }
                                                    if (villamcsapas >= 1 && hosok.getManna() >= 5 && villam == true) {
                                                        geletero -= hosok.getVarazsero() * 30;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        System.err.println("Nem talalhato ilyen karakter a palyan!");
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
            }


            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 12; j++) {
                    System.out.print(csatater[i][j]);
                }
                System.out.println("");
            }


            /////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////
            /////////////////////////////////////////////////////////////////////////////////


        }
        if (osszeletero2<=0){
            System.out.println("Nyertél!!!!!");
        } else if (osszeletero<=0) {
            System.out.println("Vesztettél!!!!!");
        }
    }
}


