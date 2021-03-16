package triangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void isScaleneWithSameSides() {
        Triangle triangle = new Triangle(1, 1, 1);

        var actual = triangle.isScalene();

        assertFalse(actual);
    }

    @Test
    void isScaleneWithDifferentSides() {
        Triangle triangle = new Triangle(1, 2, 3);

        var actual = triangle.isScalene();

        assertTrue(actual);
    }

    @Test
    void isEquilateralWithTwoSidsEqual() {
        double[] sides = {2, 2, 3};
        Triangle triangle = new Triangle(sides);

        var actual = triangle.isEquilateral();

        assertFalse(actual);
    }

    @Test
    void isEquilateralWithThreeSidsEqual() {
        double[] sides = {2, 2, 2};
        Triangle triangle = new Triangle(sides);

        var actual = triangle.isEquilateral();

        assertTrue(actual);
    }


    @Test
    void isIsoscelesWithTwoSidesEqual() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0, 1);
        Triangle triangle = new Triangle(p1, p2, p3);

        var actual = triangle.isIsosceles();

        assertTrue(actual);
    }

    @Test
    void isIsoscelesWithThreeSidesEqual() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(0, 2);
        Point[] points = {p1,p2,p3};
        Triangle triangle = new Triangle(points);

        var actual = triangle.isIsosceles();

        assertFalse(actual);
    }
}