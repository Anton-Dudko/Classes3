public class Utils {
    public static String convert(int a) {
        String s = ((a / 100) + "," + ((a % 100) / 10) + (a % 10));
        return s;
    }

    public static String convert(double a) {
        String s = String.format("%.3f",a/100);
        return s;
    }
}
