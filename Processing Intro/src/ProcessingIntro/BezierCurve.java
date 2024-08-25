package ProcessingIntro;

import java.awt.Point;

import javax.xml.transform.Templates;

public class BezierCurve {

	private Point[] weights;
	private boolean cubic, generated;
	private Point[] points = new Point[1000];

	public BezierCurve(Point one, Point two, Point three) {
		weights = new Point[4];
		weights[0] = one;
		weights[1] = two;
		weights[2] = three;
		cubic = true;
	}
	public BezierCurve(int a1, int a2, int b1, int b2, int c1, int c2) {
		weights = new Point[4];
		weights[0] = new Point(a1, a2);
		weights[1] = new Point(b1, b2);
		weights[2] = new Point(c1, c2);
		cubic = true;
	}
	public BezierCurve(Point one, Point two, Point three, Point four) {
		weights = new Point[4];
		weights[0] = one;
		weights[1] = two;
		weights[2] = three;
		weights[3] = four;
		cubic = false;
	}
	public BezierCurve(int a1, int a2, int b1, int b2, int c1, int c2, int d1, int d2) {
		weights = new Point[4];
		weights[0] = new Point(a1, a2);
		weights[1] = new Point(b1, b2);
		weights[2] = new Point(c1, c2);
		weights[3] = new Point(d1, d2);
		cubic = false;
	}
	public Point[] getPoints() {
		if(generated) return points;
		for(int i = 0; i < points.length; i++) {
			double[] temp = getCurvePoint((float)i/points.length);
			points[i] = new Point((int)temp[0], (int)temp[1]);
		}
		generated=true;
		return points;
	}
	public double[] getCurvePoint(double t) {
		if(cubic) return getCurvePointC(t);
		double oneX = lerp(weights[0].getX(), weights[1].getX(), t);
		double oneY = lerp(weights[0].getY(), weights[1].getY(), t);
		double twoX = lerp(weights[1].getX(), weights[2].getX(), t);
		double twoY = lerp(weights[1].getY(), weights[2].getY(), t);
		double threeX = lerp(weights[2].getX(), weights[3].getX(), t);
		double threeY = lerp(weights[2].getY(), weights[3].getY(), t);
		double lerpOneX = lerp(oneX, twoX, t);
		double lerpOneY = lerp(oneY, twoY, t);
		double lerpTwoX = lerp(twoX, threeX, t);
		double lerpTwoY = lerp(twoY, threeY, t);
		return new double[] {lerp(lerpOneX, lerpTwoX, t), lerp(lerpOneY, lerpTwoY, t)};
	}
	private double[] getCurvePointC(double t) {
		return new double[] {lerp(lerp(weights[0].getX(), weights[1].getX(), t),
				lerp(weights[1].getX(), weights[2].getX(), t), t),
				lerp(lerp(weights[0].getY(), weights[1].getY(), t),
				lerp(weights[1].getY(), weights[2].getY(), t), t)};
	}
	public float[] getCurvePointF(double t) {
		double[] temp = getCurvePoint(t);
		return new float[] {(float)temp[0], (float)temp[1]};
	}
	private double lerp(double one, double two, double t) {
		return (one+(two-one)*t);
	}
}
