package util;


import checker.Bonus;
import checker.Mana;

import java.util.Arrays;

import static checker.Bonus.bonus;
import static java.util.Collections.singleton;

public class Util {

    public static final int PROD_BUILDING_BONUS = 10;
    public static final int MANUFACTORY_BONUS = 30;
    public static final int FLAT_MALUS = -50;
    public static final int MIL_BUILDING_BONUS = 8;
    public static final int FORT_BONUS = 5;
    public static final int TAX_BUILDING_BONUS = 20;
    public static final int UNIVERSITY = 50;
    public static final int GROWTH_BONUS = 50;
    public static final int IRRIGATION = 10;
    public static final int DEV_EFFICIENCY_STEP = 10;

    public static Iterable<Bonus> arid() {
        return singleton(bonus(-15));
    }

    public static Iterable<Bonus> desert() {
        return singleton(bonus(-35));
    }

    public static Iterable<Bonus> glacial() {
        return singleton(bonus(-50));
    }

    public static Iterable<Bonus> arctic() {
        return singleton(bonus(-50));
    }

    public static Iterable<Bonus> full_production_buildings() {
        return Arrays.asList(
                bonus(PROD_BUILDING_BONUS, 1453, Mana.BIRD),
                bonus(PROD_BUILDING_BONUS, 1479, Mana.BIRD),
                bonus(PROD_BUILDING_BONUS, 1622, Mana.BIRD),
                bonus(PROD_BUILDING_BONUS, 1687, Mana.BIRD),
                bonus(PROD_BUILDING_BONUS, 1715, Mana.BIRD),
                bonus(MANUFACTORY_BONUS, 1544, Mana.BIRD));
    }

    public static Iterable<Bonus> flat_malus() {
        return singleton(bonus(FLAT_MALUS));
    }

    public static Iterable<Bonus> cloth() {
        return singleton(bonus(10));
    }

    public static Iterable<Bonus> dev_efficiency() {
        return Arrays.asList(
                bonus(DEV_EFFICIENCY_STEP, 1622),
                bonus(DEV_EFFICIENCY_STEP, 1700),
                bonus(DEV_EFFICIENCY_STEP, 1760));
    }

    public static Iterable<Bonus> farmlands() {
        return singleton(bonus(5));
    }

    public static Iterable<Bonus> island() {
        return singleton(bonus(-20));
    }

    public static Iterable<Bonus> coastline() {
        return singleton(bonus(-25));
    }

    public static Iterable<Bonus> renaissance() {
        return singleton(bonus(5, 1450));
    }

    public static Iterable<Bonus> full_military_buildings() {
        return Arrays.asList(
                bonus(MIL_BUILDING_BONUS, 1479, Mana.SWORD),
                bonus(MIL_BUILDING_BONUS, 1505, Mana.SWORD),
                bonus(MIL_BUILDING_BONUS, 1609, Mana.SWORD),
                bonus(MIL_BUILDING_BONUS, 1687, Mana.SWORD),
                bonus(MIL_BUILDING_BONUS, 1479, Mana.SWORD),
                bonus(MIL_BUILDING_BONUS, 1505, Mana.SWORD),
                bonus(MIL_BUILDING_BONUS, 1648, Mana.SWORD),
                bonus(MIL_BUILDING_BONUS, 1715, Mana.SWORD),
                bonus(FORT_BONUS, 1390, Mana.SWORD),
                bonus(FORT_BONUS, 1583, Mana.SWORD),
                bonus(FORT_BONUS, 1648, Mana.SWORD),
                bonus(FORT_BONUS, 1715, Mana.SWORD));
    }

    public static Iterable<Bonus> full_tax_buildings() {
        return Arrays.asList(
                bonus(TAX_BUILDING_BONUS, 1453, Mana.PAPER),
                bonus(TAX_BUILDING_BONUS, 1505, Mana.PAPER),
                bonus(TAX_BUILDING_BONUS, 1648, Mana.PAPER),
                bonus(TAX_BUILDING_BONUS, 1687, Mana.PAPER));
    }

    public static Iterable<Bonus> full_economic_ideas() {
        return singleton(bonus(20, 1500));
    }

    public static Iterable<Bonus> university() {
        return singleton(bonus(UNIVERSITY, 1622));
    }

    public static Iterable<Bonus> irrigated() {
        return singleton(bonus(IRRIGATION, 1500));
    }

    public static Iterable<Bonus> full_growth_bonus() {
        return singleton(bonus(GROWTH_BONUS));
    }
}
