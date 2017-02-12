public class DevChecker {

    static int year;

    public static void main(String[] args) {

        paris();
    }

    private static void paris() {

        int tax = 11;
        int prod = 11;
        int mp = 10;

        double ptax = 0, pprod = 0, pmp = 0;

        for (year = 1444; year < 1815; year++) {


            for (int monat = 1; monat < 13; monat++) {

                double ttax = 0, tprod = 0, tmp = 0;

                ttax += 1;
                tprod += 1;
                tmp += 1;

                //mal capital bonus * dev efficiency
                ttax *= bonus(5, 1400) * bonus(10, 1622) * bonus(10, 1700) * bonus(10, 1760);
                tprod *= bonus(5, 1400) * bonus(10, 1622) * bonus(10, 1700) * bonus(10, 1760);
                tmp *= bonus(5, 1400) * bonus(10, 1622) * bonus(10, 1700) * bonus(10, 1760);

                //mal farmlands * cloth * university
                ttax *= bonus(5, 1400) * bonus(10, 1400) * bonus(20, 1622);
                tprod *= bonus(5, 1400) * bonus(10, 1400) * bonus(20, 1622);
                tmp *= bonus(5, 1400) * bonus(10, 1400) * bonus(20, 1622);

                //mal full economic ideas * renaissance
                ttax *= bonus(20, 1500) * bonus(5, 1450);
                tprod *= bonus(20, 1500) * bonus(5, 1450);
                tmp *= bonus(20, 1500) * bonus(5, 1450);

                //mal gebäude * manufactory (only production) * forts (only military)
                ttax *= bonus(5, 1453) * bonus(5, 1505) * bonus(5, 1648) * bonus(5, 1687);
                tprod *= bonus(5, 1453) * bonus(5, 1479) * bonus(5, 1622) * bonus(5, 1687) * bonus(5, 1715) * bonus(20, 1544);
                tmp *= bonus(5, 1479)
                        * bonus(5, 1505)
                        * bonus(5, 1609)
                        * bonus(5, 1687)
                        * bonus(5, 1479)
                        * bonus(5, 1505)
                        * bonus(5, 1648)
                        * bonus(5, 1715);
                tmp *= bonus(2, 1390) * bonus(2, 1583) * bonus(2, 1648) * bonus(2, 1715);

                ptax += ttax;
                pprod += tprod;
                pmp += tmp;
            }
            System.err.println(year + ": " + (int) ptax + "/" + (int) pprod + "/" + (int) pmp);
        }

        //4452 progress if 1 per month

        tax += ptax / 1000;
        prod += pprod / 1000;
        mp += pmp / 1000;

        System.err.println("Paris: " + tax + "/" + prod + "/" + mp + " : " + (tax + prod + mp));
    }

    static double bonus(double percent, int fromYear) {
        if (fromYear <= year) {
            return 1 + percent / 100;
        }
        return 1;
    }
}
