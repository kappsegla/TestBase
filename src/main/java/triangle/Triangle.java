package triangle;

public class Triangle {

    double[] sides;

    public Triangle(double a, double b, double c) {
        sides = new double[]{a, b, c};
    }

    public Triangle(double[] s) {
        sides = new double[s.length];
        System.arraycopy(s, 0, sides, 0, s.length);
    }

    public Triangle(Point a, Point b, Point c) {
        sides = new double[3];
        sides[0] = Math.sqrt(Math.pow(b.x - a.x, 2.0) + Math.pow(b.y - a.y, 2.0));
        sides[1] = Math.sqrt(Math.pow(b.x - c.x, 2.0) + Math.pow(b.y - c.y, 2.0));
        sides[2] = Math.sqrt(Math.pow(c.x - a.x, 2.0) + Math.pow(c.y - a.y, 2.0));
    }

    public Triangle(Point[] s) {
        sides = new double[s.length];
        sides[0] = Math.sqrt(Math.pow(s[1].x - s[0].x, 2.0) + Math.pow(s[1].y - s[0].y, 2.0));
        sides[1] = Math.sqrt(Math.pow(s[1].x - s[2].x, 2.0) + Math.pow(s[1].x - s[2].x, 2.0));
        sides[2] = Math.sqrt(Math.pow(s[2].x - s[0].x, 2.0) + Math.pow(s[2].x - s[0].x, 2.0));
    }

    private int uniqueSides() {

        int distinctIntegers = 0;

        for (int j = 0; j < sides.length; j++) {
            double thisInt = sides[j];
            boolean seenThisIntBefore = false;
            for (int i = 0; i < j; i++) {
                if (thisInt == sides[i]) {
                    seenThisIntBefore = true;
                }
            }
            if (!seenThisIntBefore) {
                distinctIntegers++;
            }
        }
        return distinctIntegers;
    }

    //All sides has different length
    public boolean isScalene() {
        return uniqueSides() == 3;
    }

    //All sides has same length
    public boolean isEquilateral() {
        if (uniqueSides() == 1) {
            return true;
        }
        return false;
    }

    //Two equal sides
    public boolean isIsosceles() {
        if (uniqueSides() == 2) {
            return true;
        }
        return false;
    }
}