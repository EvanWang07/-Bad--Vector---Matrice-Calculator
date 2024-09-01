package Vectors;

public class XYZVector {
    private double[] vector = new double[3];

    public XYZVector(double x, double y, double z) {
        vector[0] = x;
        vector[1] = y;
        vector[2] = z;
    }

    public XYZVector(double[] vectorArray) {
        vector[0] = vectorArray[0];
        vector[1] = vectorArray[1];
        vector[2] = vectorArray[2];
        if (vectorArray.length > 3) {
            System.out.println("WARNING: Some parts of the array were not used! Reason: Array was too long");
        }
    }

    public double getXComponent() {
        return vector[0];
    }

    public double getYComponent() {
        return vector[1];
    }

    public double getZComponent() {
        return vector[2];
    }

    public double getComponent(int index) {
        return vector[index];
    }

    public void changeXComponent(double newX) {
        vector[0] = newX;
    }

    public void changeYComponent(double newY) {
        vector[1] = newY;
    }

    public void changeZComponent(double newZ) {
        vector[2] = newZ;
    }

    public void changeComponent(int index, double newValue) {
        vector[index] = newValue;
    }

    public void clearComponents() {
        vector[0] = 0;
        vector[1] = 0;
        vector[2] = 0;
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2) + Math.pow(vector[2], 2));
    }

    public void scalarMultiply(double scalarFactor) {
        vector[0] *= scalarFactor;
        vector[1] *= scalarFactor;
        vector[2] *= scalarFactor;
    }

    public void changeToUnitVector() {
        scalarMultiply(1 / getMagnitude());
    }
}
