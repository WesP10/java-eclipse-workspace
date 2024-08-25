package shapes;

import java.util.ArrayList;
import java.util.Collections;

public class ShapeMain {

	public static void main(String[] args) {
//		Shape s = new Shape(); Can't intalize abstract classes
		Shape r1 = new Rectangle(0, 0, 100, 200);
		Shape t1 = new Triangle(0, 0, 100, 200);
		Shape r2 = new Rectangle(10, 0, 50, 50);
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(r1);
		shapes.add(t1);
		shapes.add(r2);
		
		Collections.sort(shapes);
		for(Shape s: shapes) 
			System.out.println(s.getArea());

	}

}
