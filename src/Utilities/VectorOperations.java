package Utilities;

import Utilities.RoundingErrorFix;
import Vectors.XYZVector;

public final class VectorOperations {
    public static double XYZDotProduct(XYZVector vectorOne, XYZVector vectorTwo) {
        double result = 0;
        for (int i = 0; i < 3; i++) {
            result += vectorOne.getComponent(i) * vectorTwo.getComponent(i);
        }
        return result;
    }

    public static double[] XYZCrossProduct(XYZVector vectorOne, XYZVector vectorTwo) {
        double[] result = {0, 0, 0};
        result[0] = vectorOne.getYComponent() * vectorTwo.getZComponent() - vectorOne.getZComponent() * vectorTwo.getYComponent();
        result[1] = vectorOne.getZComponent() * vectorTwo.getXComponent() - vectorOne.getXComponent() * vectorTwo.getZComponent();
        result[2] = vectorOne.getXComponent() * vectorTwo.getYComponent() - vectorOne.getYComponent() * vectorTwo.getXComponent();
        // Formula: <a2b3 - a3b2, a3b1 - a1b3, a1b2 - a2b1>
        return result;
    }

    public static double XYZCrossProductMagnitude(XYZVector vectorOne, XYZVector vectorTwo) {
        return vectorOne.getMagnitude() * vectorTwo.getMagnitude() * Math.sin(findTheta(vectorOne, vectorTwo, false));
    }

    public static boolean checkOrthogonality(XYZVector vectorOne, XYZVector vectorTwo) {
        if (XYZDotProduct(vectorOne, vectorTwo) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkParallel(XYZVector vectorOne, XYZVector vectorTwo) {
        if (findTheta(vectorOne, vectorTwo, true) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static double findTheta(XYZVector vectorOne, XYZVector vectorTwo, boolean degrees) {
        double magOne = vectorOne.getMagnitude();
        double magTwo = vectorTwo.getMagnitude();
        double magProduct = magOne * magTwo;
        double cosValue = RoundingErrorFix.fixRoundingError(XYZDotProduct(vectorOne, vectorTwo) / magProduct, 0.0000000001);
        // (a dot b) / (mag(a) * mag(b)) = cos(theta)
        double theta = Math.acos(cosValue);
        if (degrees) {
            return Math.toDegrees(theta);
        } else {
            return theta;
        }
    }

    public static double[] getProjection(XYZVector projVector, XYZVector baseVector) {
        XYZVector dupeBaseVector = baseVector;
        double scalarProjection = XYZDotProduct(projVector, baseVector) / baseVector.getMagnitude();
        dupeBaseVector.changeToUnitVector();
        dupeBaseVector.scalarMultiply(scalarProjection);
        double[] projection = {dupeBaseVector.getXComponent(), dupeBaseVector.getYComponent(), dupeBaseVector.getZComponent()};
        return projection;
    }
}
