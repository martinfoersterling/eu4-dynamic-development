package checker;

import com.google.common.base.Strings;

import static util.Util.*;


public class DevChecker {

    public static int year;

    public static void main(String[] args) {

        paris("Paris");
        paris_lopsided_pro_mp("Paris, bonus mp only");
        paris_badly_Managed("Paris medium");
        paris_with_unrest("Paris with unrest", 0);
        paris_with_unrest("Paris with unrest", 0.01);
        paris_with_unrest("Paris with unrest", 0.1);
        paris_with_unrest("Paris with unrest", 1);
        paris_with_unrest("Paris with unrest", 2);
        paris_with_unrest("Paris with unrest", 4);
        paris_with_unrest("Paris with unrest", 6);
        paris_with_unrest("Paris with unrest", 8);
        paris_with_unrest("Paris with unrest", 10);
        arctic_well_managed("Arctic well");
        desert_well_managed("Desert well");
        desert_badly_managed("Desert bad");
        decent_island("Island, decent");

        //Current output:
//        Paris                         35/35/35 : 105
//        Paris medium                  17/17/16 : 50
//        Paris with unrest 0.0         35/35/35 : 105
//        Paris with unrest 0.01        32/33/33 : 98
//        Paris with unrest 0.1         32/32/32 : 96
//        Paris with unrest 1.0         30/30/30 : 90
//        Paris with unrest 2.0         27/27/27 : 81
//        Paris with unrest 4.0         21/21/21 : 63
//        Paris with unrest 6.0         16/16/16 : 48
//        Paris with unrest 8.0         10/10/10 : 30
//        Paris with unrest 10.0        4/5/5 : 14
//        Arctic well                   6/6/6 : 18
//        Desert well                   12/12/13 : 37
//        Desert bad                    3/3/3 : 9
//        Island, decent                15/15/16 : 46
    }

    private static void desert_badly_managed(String scenario) {

        int tax = 1;
        int prod = 1;
        int mp = 1;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            //flat malus
            ttax *= flat_malus();
            tprod *= flat_malus();
            tmp *= flat_malus();

            //times dev efficiency
            ttax *= dev_efficiency();
            tprod *= dev_efficiency();
            tmp *= dev_efficiency();

            //times desert * arid
            ttax *= desert() * arid();
            tprod *= desert() * arid();
            tmp *= desert() * arid();

            //times renaissance
            ttax *= renaissance();
            tprod *= renaissance();
            tmp *= renaissance();

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;
        }

        //185 progress if 1 every second year

        tax += ptax / 100;
        prod += pprod / 100;
        mp += pmp / 100;

        output(scenario, tax, prod, mp);
    }

    private static void desert_well_managed(String scenario) {

        int tax = 1;
        int prod = 1;
        int mp = 1;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            //flat malus
            ttax *= flat_malus();
            tprod *= flat_malus();
            tmp *= flat_malus();

            //times dev efficiency
            ttax *= dev_efficiency();
            tprod *= dev_efficiency();
            tmp *= dev_efficiency();

            //times desert * arid
            ttax *= desert() * arid();
            tprod *= desert() * arid();
            tmp *= desert() * arid();

            //times full economic ideas * renaissance
            ttax *= full_economic_ideas() * renaissance();
            tprod *= full_economic_ideas() * renaissance();
            tmp *= full_economic_ideas() * renaissance();

            //times buildings * manufactory (only production) * forts (only military)
            //probably can't build all these anyway due to lack of building slots
            ttax *= full_tax_buildings();
            tprod *= full_production_buildings();
            tmp *= full_military_buildings();

            //times university
            ttax *= university();
            tprod *= university();
            tmp *= university();

            //times full growth boost
            ttax *= full_growth_bonus();
            tprod *= full_growth_bonus();
            tmp *= full_growth_bonus();

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;
        }

        tax += ptax / 100;
        prod += pprod / 100;
        mp += pmp / 100;

        output(scenario, tax, prod, mp);
    }

    private static void arctic_well_managed(String scenario) {

        int tax = 1;
        int prod = 1;
        int mp = 1;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            //flat malus
            ttax *= flat_malus();
            tprod *= flat_malus();
            tmp *= flat_malus();

            //times dev efficiency
            ttax *= dev_efficiency();
            tprod *= dev_efficiency();
            tmp *= dev_efficiency();

            //times glacial * arctic
            ttax *= glacial() * arctic();
            tprod *= glacial() * arctic();
            tmp *= glacial() * arctic();

            //times full economic ideas * renaissance
            ttax *= full_economic_ideas() * renaissance();
            tprod *= full_economic_ideas() * renaissance();
            tmp *= full_economic_ideas() * renaissance();

            //times buildings * manufactory (only production) * forts (only military)
            //probably can't build all these anyway due to lack of building slots
            ttax *= full_tax_buildings();
            tprod *= full_production_buildings();
            tmp *= full_military_buildings();

            //times university
            ttax *= university();
            tprod *= university();
            tmp *= university();

            //times full growth boost
            ttax *= full_growth_bonus();
            tprod *= full_growth_bonus();
            tmp *= full_growth_bonus();

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;
        }

        tax += ptax / 100;
        prod += pprod / 100;
        mp += pmp / 100;

        output(scenario, tax, prod, mp);
    }

    private static void paris(String scenario) {

        int tax = 11;
        int prod = 11;
        int mp = 10;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            //flat malus
            ttax *= flat_malus();
            tprod *= flat_malus();
            tmp *= flat_malus();

            //times dev efficiency
            ttax *= dev_efficiency();
            tprod *= dev_efficiency();
            tmp *= dev_efficiency();

            //times farmlands * cloth
            ttax *= farmlands() * cloth();
            tprod *= farmlands() * cloth();
            tmp *= farmlands() * cloth();

            //times full economic ideas * renaissance
            ttax *= full_economic_ideas() * renaissance();
            tprod *= full_economic_ideas() * renaissance();
            tmp *= full_economic_ideas() * renaissance();

            //times buildings * manufactory (only production) * forts (only military)
            ttax *= full_tax_buildings();
            tprod *= full_production_buildings();
            tmp *= full_military_buildings();

            //times university
            ttax *= university();
            tprod *= university();
            tmp *= university();

            //times full growth boost
            ttax *= full_growth_bonus();
            tprod *= full_growth_bonus();
            tmp *= full_growth_bonus();

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;

            //thats how I gotta calculate it in Paradox language...
            if (ptax >=100) {
                tax +=1;
                ptax -=100;
            }
            if (pprod >=100) {
                prod +=1;
                pprod -=100;
            }
            if (pmp >=100) {
                mp +=1;
                pmp -=100;
            }
        }

        output(scenario, tax, prod, mp);
    }

    private static void paris_lopsided_pro_mp(String scenario) {

        int tax = 11;
        int prod = 11;
        int mp = 10;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            //flat malus
            ttax *= flat_malus();
            tprod *= flat_malus();
            tmp *= flat_malus();

            //times dev efficiency
            ttax *= dev_efficiency();
            tprod *= dev_efficiency();
            tmp *= dev_efficiency();

            //times farmlands * cloth
            ttax *= farmlands() * cloth();
            tprod *= farmlands() * cloth();
            tmp *= farmlands() * cloth();

            //times full economic ideas * renaissance
            ttax *= full_economic_ideas() * renaissance();
            tprod *= full_economic_ideas() * renaissance();
            tmp *= full_economic_ideas() * renaissance();

            //times buildings * manufactory (only production) * forts (only military)
            ttax *= full_tax_buildings();
            tprod *= full_production_buildings();
            tmp *= full_military_buildings();

            //times university
            ttax *= university();
            tprod *= university();
            tmp *= university();

            //times full growth boost ONLY FOR MANPOWER
            tmp *= full_growth_bonus();

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;

            //thats how I gotta calculate it in Paradox language...
            if (ptax >=100) {
                tax +=1;
                ptax -=100;
            }
            if (pprod >=100) {
                prod +=1;
                pprod -=100;
            }
            if (pmp >=100) {
                mp +=1;
                pmp -=100;
            }
        }

        output(scenario, tax, prod, mp);
    }

    private static void output(String scenario, int tax, int prod, int mp) {
        System.err.println(Strings.padEnd(scenario, 30, ' ') + tax + "/" + prod + "/" + mp + " : " + (tax + prod + mp));
    }

    private static void paris_with_unrest(String scenario, double unrest) {

        int tax = 11;
        int prod = 11;
        int mp = 10;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            //flat malus
            ttax *= flat_malus();
            tprod *= flat_malus();
            tmp *= flat_malus();

            //times dev efficiency
            ttax *= dev_efficiency();
            tprod *= dev_efficiency();
            tmp *= dev_efficiency();

            //times farmlands * cloth
            ttax *= farmlands() * cloth();
            tprod *= farmlands() * cloth();
            tmp *= farmlands() * cloth();

            //times full economic ideas * renaissance
            ttax *= full_economic_ideas() * renaissance();
            tprod *= full_economic_ideas() * renaissance();
            tmp *= full_economic_ideas() * renaissance();

            //times buildings * manufactory (only production) * forts (only military)
            ttax *= full_tax_buildings();
            tprod *= full_production_buildings();
            tmp *= full_military_buildings();

            //times university
            ttax *= university();
            tprod *= university();
            tmp *= university();

            //times full growth boost
            ttax *= full_growth_bonus();
            tprod *= full_growth_bonus();
            tmp *= full_growth_bonus();

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;

            //n unrest over the entire time
            ptax += unrest(unrest);
            pprod += unrest(unrest);
            pmp += unrest(unrest);

        }


        tax += ptax / 100;
        prod += pprod / 100;
        mp += pmp / 100;

        tax = tax < 1 ? 1 : tax;
        prod = prod < 1 ? 1 : prod;
        mp = mp < 1 ? 1 : mp;

        output(scenario + " " + unrest, tax, prod, mp);
    }

    private static void paris_badly_Managed(String scenario) {

        int tax = 11;
        int prod = 11;
        int mp = 10;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            //flat malus
            ttax *= flat_malus();
            tprod *= flat_malus();
            tmp *= flat_malus();

            //times dev efficiency
            ttax *= dev_efficiency();
            tprod *= dev_efficiency();
            tmp *= dev_efficiency();

            //times farmlands * cloth
            ttax *= farmlands() * cloth();
            tprod *= farmlands() * cloth();
            tmp *= farmlands() * cloth();

            //times renaissance
            ttax *= renaissance();
            tprod *= renaissance();
            tmp *= renaissance();

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;
        }


        tax += ptax / 100;
        prod += pprod / 100;
        mp += pmp / 100;

        output(scenario, tax, prod, mp);
    }

    private static void decent_island(String scenario) {

        int tax = 3;
        int prod = 3;
        int mp = 3;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            //flat malus
            ttax *= flat_malus();
            tprod *= flat_malus();
            tmp *= flat_malus();

            //times dev efficiency
            ttax *= dev_efficiency();
            tprod *= dev_efficiency();
            tmp *= dev_efficiency();

            //times island * terrain
            ttax *= island() * coastline();
            tprod *= island() * coastline();
            tmp *= island() * coastline() ;

            //times full economic ideas * renaissance
            ttax *= full_economic_ideas() * renaissance();
            tprod *= full_economic_ideas() * renaissance();
            tmp *= full_economic_ideas() * renaissance();

            //times buildings * manufactory (only production) * forts (only military)
            ttax *= full_tax_buildings();
            tprod *= full_production_buildings();
            tmp *= full_military_buildings();

            //times university
            ttax *= university();
            tprod *= university();
            tmp *= university();

            //times full growth boost
            ttax *= full_growth_bonus();
            tprod *= full_growth_bonus();
            tmp *= full_growth_bonus();

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;
        }

        tax += ptax / 100;
        prod += pprod / 100;
        mp += pmp / 100;

        output(scenario, tax, prod, mp);
    }
}
