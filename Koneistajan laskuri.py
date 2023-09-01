import math
import sys

def susikappale():
    file = open("susikappaleet.txt", "a");
    nimike = input("Kappaleen nimike: ");
    reikä = input("Kappaleessa oleva reikä: ");
    määrä = input("Määrä: ");

    file.write(nimike + ", Halkaisija: " + reikä + ", Määrä: " + määrä +"\n");
    file.close();
    menu();

def kierrosnopeus(pora):
    nopeus = 15000/(pora*math.pi);
    print("Kierrosnopeus", pora, "mm poralla:", "%.0f" % nopeus, "rpm.");
    menu();

def inputTarkistus(teksti):
    tulos = "";
    p = 0;
    for c in teksti:
        if c == "," or c == ".":
            if p == 0:
                p = 1;
                tulos += ".";
        else:
            tulos += c;
    return tulos;

def kierros_laskuri():
    teksti = inputTarkistus(input("Poran koko: "));
    pora = float(teksti);
    if pora > 80:
        print("Pora ei voi olla isompi kuin 80mm.");
        kierros_laskuri();
    else:
        kierrosnopeus(pora);

def h_laskuri():
    teksti = inputTarkistus(input("Reijän koko: "));
    reikä = float(teksti);
    teksti = inputTarkistus(input("Kiilauran koko: "));
    kiilaura = float(teksti);
    if reikä < kiilaura:
        print("Kiilaura ei voi olla isompi kuin reikä.");
        h_laskuri();
    else:
        h = reikä/2-math.sqrt((reikä/2)**2-(kiilaura/2)**2);
        print("Kappaleen h-mitta on:","%.2f" % h, "mm");
        menu();

def lampolaajeneminen():
    aste = float(input("Kappaleen lämpötila: "));
    if aste < 0:
        print("Kappaleen lämpötila ei voi olla miinusmerkkinen.");
        lampolaajeneminen();
    else:
        pituus = float(input("Kappaleen pituus: "));
        materiaali = int(input("""
Valitse materiaali:
1. Teräs
2. Alumiini
3. Hopea
4. Kupari
"""));
        huonelampotila = 24;
        metallit = [12, 23, 19, 17]
        ero = pituus * (aste-huonelampotila) * metallit[materiaali-1] * (10**(-6));
        print("Kappale on laajentunut:","%.2f" % ero , "mm.");
        menu();
    
def menu():
    print("=======================================");
    print("1. Kierrosnopeuden laskuri.");
    print("2. Reijän ja kiilauran h-mitan laskuri.");
    print("3. Lämpölaajeneminen.");
    print("4. Susikappaleen lisäys.");
    print("5. Sulje ohjelma.");
    valinta = int(input("Valitse ohjelma: "));
    print("=======================================");
    if valinta == 1:
        kierros_laskuri();
    elif valinta == 2:
        h_laskuri();
    elif valinta == 3:
        lampolaajeneminen();
    elif valinta == 4:
        susikappale();
    elif valinta == 5:
        sys.exit();
print("""
 _   _______ _   _  _____ _____ _____ _____ ___     ___  ___   _   _ 
| | / /  _  | \ | ||  ___|_   _/  ___|_   _/ _ \   |_  |/ _ \ | \ | |
| |/ /| | | |  \| || |__   | | \ `--.  | |/ /_\ \    | / /_\ \|  \| |
|    \| | | | . ` ||  __|  | |  `--. \ | ||  _  |    | |  _  || . ` |
| |\  \ \_/ / |\  || |___ _| |_/\__/ / | || | | |/\__/ / | | || |\  |
\_| \_/\___/\_| \_/\____/ \___/\____/  \_/\_| |_/\____/\_| |_/\_| \_/

""");
print("""
  _                _____ _  ___    _ _____  _____ 
 | |        /\    / ____| |/ / |  | |  __ \|_   _|
 | |       /  \  | (___ | ' /| |  | | |__) | | |  
 | |      / /\ \  \___ \|  < | |  | |  _  /  | |  
 | |____ / ____ \ ____) | . \| |__| | | \ \ _| |_ 
 |______/_/    \_\_____/|_|\_\\\____/|_|  \_\_____|
""");
menu();
