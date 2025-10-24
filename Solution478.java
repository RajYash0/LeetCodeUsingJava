import java.util.Random;

class Solution {
    private double r, x0, y0;
    private Random rnd = new Random();
    public Solution(double radius, double x_center, double y_center) {
        r = radius; x0 = x_center; y0 = y_center;
    }
    public double[] randPoint() {
        double len = Math.sqrt(rnd.nextDouble()) * r;
        double ang = rnd.nextDouble() * 2 * Math.PI;
        return new double[] { x0 + len * Math.cos(ang), y0 + len * Math.sin(ang) };
    }
}