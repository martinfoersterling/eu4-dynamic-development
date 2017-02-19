package checker;

import java.text.DecimalFormat;

/**
 * Trying to find a formula that is similar to what Paradox uses with scaling dev costs, but easier to calculate.
 * <p>Turns out, it's not THAT much of a hassle to use paradox's formula, so this thing isn't used.</p>
 */
public class DevScaling {

    static DecimalFormat formatter = new DecimalFormat("000");

    public static void main(String[] args) {

        //22 dev -> 48%
        //32 dev -> 117%
        for (int dev = 3; dev < 50; dev++) {
            log(dev, paradox(dev), mafoe(dev));
        }
    }

    private static void log(int dev, double paradox, double mafoe) {

        String pf = formatter.format(paradox);
        String mf = formatter.format(mafoe);

        System.err.println("paradox / mafoe / diff "
                + formatter.format(dev)
                + "   "
                + pf + "/"
                + mf + "/"
                + formatter.format(paradox - mafoe));
    }

    private static double paradox(int dev) {
        double ret = 0;
        for (int i = 1; i <= dev; i++) {
            if (i > 9 && i < 20) {
                ret += 3;
            }
            if (i > 19 && i < 30) {
                ret += 6;
            }
            if (i > 29 && i < 40) {
                ret += 9;
            }
            if (i > 39 && i < 50) {
                ret += 12;
            }
        }
        return ret;
    }

    private static double mafoe(int dev) {
        //eh, good enuff
        return dev < 10 ? 0 : 0.08 * dev * dev;
    }
}
