package util;


import checker.DevChecker;

public class Util {

    public static final int PROD_BUILDING_BONUS = 10;
    public static final int MANUFACTORY_BONUS = 30;
    public static final int FLAT_MALUS = -50;
    public static final int MIL_BUILDING_BONUS = 8;
    public static final int FORT_BONUS = 5;
    public static final int TAX_BUILDING_BONUS = 20;
    public static final int UNIVERSITY = 50;
    public static final int GROWTH_BONUS = 50;

    public static double unrest(double unrest) {
        if (unrest > 0) {
            return unrest * -1.5 - 1.5;
        }
        return 0;
    }

    public static double arid() {
        return bonus(-15);
    }

    public static double desert() {
        return bonus(-35);
    }

    public static double glacial() {
        return bonus(-50);
    }

    public static double arctic() {
        return bonus(-50);
    }

    public static double full_production_buildings() {
        return bonus(PROD_BUILDING_BONUS, 1453) * bonus(PROD_BUILDING_BONUS, 1479) * bonus(PROD_BUILDING_BONUS, 1622) * bonus(PROD_BUILDING_BONUS, 1687) * bonus(PROD_BUILDING_BONUS, 1715) * bonus(MANUFACTORY_BONUS, 1544);
    }

    public static double flat_malus() {
        return bonus(FLAT_MALUS);
    }

    public static double cloth() {
        return bonus(10);
    }

    public static double dev_efficiency() {
        return bonus(10, 1622) * bonus(10, 1700) * bonus(10, 1760);
    }

    public static double farmlands() {
        return bonus(5);
    }


    public static double island() {
        return bonus(-20);
    }
    public static double coastline() {
        return bonus(-25);
    }

    public static double renaissance() {
        return bonus(5, 1450);
    }

    public static double bonus(double percent) {
        return 1 + percent / 100;
    }

    public static double bonus(double percent, int fromYear) {
        if (fromYear <= DevChecker.year) {
            return 1 + percent / 100;
        }
        return 1;
    }

    public static double full_military_buildings() {
        return bonus(MIL_BUILDING_BONUS, 1479)
                * bonus(MIL_BUILDING_BONUS, 1505)
                * bonus(MIL_BUILDING_BONUS, 1609)
                * bonus(MIL_BUILDING_BONUS, 1687)
                * bonus(MIL_BUILDING_BONUS, 1479)
                * bonus(MIL_BUILDING_BONUS, 1505)
                * bonus(MIL_BUILDING_BONUS, 1648)
                * bonus(MIL_BUILDING_BONUS, 1715)
                * bonus(FORT_BONUS, 1390)
                * bonus(FORT_BONUS, 1583)
                * bonus(FORT_BONUS, 1648)
                * bonus(FORT_BONUS, 1715);
    }

    public static double full_tax_buildings() {
        return bonus(TAX_BUILDING_BONUS, 1453) * bonus(TAX_BUILDING_BONUS, 1505) * bonus(TAX_BUILDING_BONUS, 1648) * bonus(TAX_BUILDING_BONUS, 1687);
    }

    public static double full_economic_ideas() {
        return bonus(20, 1500);
    }

    public static double university() {
        return bonus(UNIVERSITY, 1622);
    }

    public static double full_growth_bonus() {
        return bonus(GROWTH_BONUS);
    }
}
