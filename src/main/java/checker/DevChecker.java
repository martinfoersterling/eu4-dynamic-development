package checker;

import com.google.common.base.Strings;

import static checker.Mana.*;
import static util.Util.*;


public class DevChecker {

    public static void main(String[] args) {

        calc("Paris perfekt", 11,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                full_economic_ideas(),
                full_growth_bonus(),
                renaissance(),
                university(),
                full_tax_buildings(),
                full_production_buildings(),
                full_military_buildings()
        );
        calc("Paris, bonus tax only", 11,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                full_economic_ideas(),
                full_growth_bonus(),
                renaissance(),
                university(),
                full_tax_buildings()
        );
        calc("Paris, bonus prod only", 11,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                full_economic_ideas(),
                full_growth_bonus(),
                renaissance(),
                university(),
                full_production_buildings()
        );
        calc("Paris, bonus mp only", 11,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                full_economic_ideas(),
                full_growth_bonus(),
                renaissance(),
                university(),
                full_military_buildings()
        );

        calc("Paris medium", 11,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 0", 11, 0,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 0.01", 11, 0.01,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 0.1", 11, 0.1,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 1", 11, 1,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 2", 11, 2,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 4", 11, 4,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 6", 11, 6,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 8", 11, 8,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 10", 11, 10,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                renaissance()
        );
        calc("Paris with unrest 10, well", 11, 10,
                flat_malus(),
                dev_efficiency(),
                cloth(),
                farmlands(),
                full_economic_ideas(),
                full_growth_bonus(),
                renaissance(),
                university(),
                full_tax_buildings(),
                full_production_buildings(),
                full_military_buildings()
        );

        calc("Arctic well", 1,
                flat_malus(),
                dev_efficiency(),
                arctic(),
                glacial(),
                university(),
                renaissance(),
                full_growth_bonus(),
                full_tax_buildings()
        );
        calc("Arctic meh", 1,
                flat_malus(),
                dev_efficiency(),
                arctic(),
                glacial()
        );

        calc("Desert irrigated", 1,
                flat_malus(),
                dev_efficiency(),
                desert(),
                irrigated(),
                university(),
                renaissance(),
                full_growth_bonus(),
                full_tax_buildings()
        );
        calc("Desert well", 1,
                flat_malus(),
                dev_efficiency(),
                desert(),
                university(),
                renaissance(),
                full_growth_bonus(),
                full_tax_buildings()
        );
        calc("Desert meh", 1,
                flat_malus(),
                dev_efficiency(),
                desert()
        );
        calc("Desert meh arid", 1,
                flat_malus(),
                dev_efficiency(),
                desert(),
                arid()
        );

        calc("Island meh", 3,
                flat_malus(),
                dev_efficiency(),
                coastline(),
                island()
        );

        calc("Desert w/o buildings", 1,
                flat_malus(),
                dev_efficiency(),
                desert(),
                university(),
                renaissance(),
                full_growth_bonus()
        );
        calc("Desert w/o, irrigated", 1,
                flat_malus(),
                dev_efficiency(),
                desert(),
                irrigated(),
                university(),
                renaissance(),
                full_growth_bonus()
        );

        calc("Farmlands w/o buildings", 1,
                flat_malus(),
                dev_efficiency(),
                farmlands(),
                university(),
                renaissance(),
                full_growth_bonus()
        );
        calc("Farmlands all buildings", 1,
                flat_malus(),
                dev_efficiency(),
                farmlands(),
                university(),
                renaissance(),
                full_growth_bonus(),
                full_tax_buildings(),
                full_production_buildings(),
                full_military_buildings()
        );

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

    private static void calc(String scenario, int devInitial, Iterable<Bonus>... boni) {
        calc(scenario, devInitial, 0, boni);
    }

    private static void calc(String scenario, int devInitial, double unrest, Iterable<Bonus>... boni) {

        int tax = devInitial;
        int prod = devInitial;
        int mp = devInitial;

        double ptax = 0, pprod = 0, pmp = 0;

        for (int year = 1444; year < 1815; year = year + 2) {

            double ttax = 0, tprod = 0, tmp = 0;

            ttax += 5;
            tprod += 5;
            tmp += 5;

            for (Iterable<Bonus> boniList : boni) {
                for (Bonus bonus : boniList) {
                    ttax *= bonus.getBonus(year, PAPER);
                    tprod *= bonus.getBonus(year, BIRD);
                    tmp *= bonus.getBonus(year, SWORD);
                }
            }

            if (unrest > 0.5) {
                double normalizedUnrest = -1.2 * unrest - 1.5;
                ttax += normalizedUnrest;
                tprod += normalizedUnrest;
                tmp += normalizedUnrest;
            }

            ptax += ttax;
            pprod += tprod;
            pmp += tmp;

            //thats how I gotta calculate it in Paradox language...
            if (ptax >= 100) {
                tax += 1;
                ptax -= 100;
            }
            if (pprod >= 100) {
                prod += 1;
                pprod -= 100;
            }
            if (pmp >= 100) {
                mp += 1;
                pmp -= 100;
            }

            if (ptax <= -100) {
                tax -= 1;
                ptax += 100;
            }
            if (pprod <= -100) {
                prod -= 1;
                pprod += 100;
            }
            if (pmp <= -100) {
                mp -= 1;
                pmp += 100;
            }

            //if >200, then we gotta check twice
            if (ptax > 100 || pprod > 100 || pmp > 100) {
                throw new IllegalStateException("Progress values are over 100");
            }
            if (ptax < -100 || pprod < -100 || pmp < -100) {
                throw new IllegalStateException("Progress values are below -100");
            }
        }

        output(scenario, tax, prod, mp);
    }

    private static void output(String scenario, int tax, int prod, int mp) {
        System.err.println(Strings.padEnd(scenario, 30, ' ') + tax + "/" + prod + "/" + mp + " : " + (tax + prod + mp));
    }
}