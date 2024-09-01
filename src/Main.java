import Vectors.XYZVector;

import Utilities.*;

public class Main {
    public static void main(String[] args) {
        XYZVector vecOne = new XYZVector(3, 6, 0);
        XYZVector vecTwo = new XYZVector(-1, 0, 0);
        XYZVector vecThree = new XYZVector(1, 1, 1);
        XYZVector vecFour = new XYZVector(1, 1, 1); 

        ArrayOperations.printDoubleArray(VectorOperations.getProjection(vecOne, vecTwo));
    }
}
