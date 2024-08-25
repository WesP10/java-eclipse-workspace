package Functions;

public class EquationsMain {

	public static void main(String[] args) {
		Function f = new LinearFunction(1, 6);
		Function g = new QuadraticFunction(1, -5, 6);
		System.out.println(f + "\n" + g);
		Equation e = new Equation(f, g);
		System.out.println(e.solve());
	}

}
