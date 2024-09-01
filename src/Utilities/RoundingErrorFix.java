package Utilities;

public final class RoundingErrorFix {
    public static double fixRoundingError(double number, double threshold) {
        if (Math.abs(Math.round(number) - number) < threshold) {
            return Math.round(number);
        } else {
            return number;
        }
    }
}
