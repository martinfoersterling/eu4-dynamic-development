package checker;

import java.util.Arrays;
import java.util.EnumSet;

public class Bonus {

    private int year;
    private double bonus;
    private EnumSet<Mana> manas = EnumSet.noneOf(Mana.class);

    public static Bonus bonus(double bonus, int year) {
        Bonus ret = new Bonus();
        ret.bonus = 1 + bonus / 100;
        ret.year = year;
        ret.manas.addAll(Arrays.asList(Mana.values()));
        return ret;
    }

    public static Bonus bonus(double bonus, int year, Mana mana) {
        Bonus ret = new Bonus();
        ret.bonus = 1 + bonus / 100;
        ret.year = year;
        ret.manas.add(mana);
        return ret;
    }

    public static Bonus bonus(double bonus) {
        return bonus(bonus, 1400);
    }

    public static Bonus bonus(double bonus, Mana mana) {
        return bonus(bonus, 1400, mana);
    }

    public double getBonus(int year, Mana mana) {
        return year >= this.year && manas.contains(mana) ? bonus : 1;
    }
}
