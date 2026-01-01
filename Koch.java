/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		// Tests the snowflake function:
//Gets n, and draws a Koch 
//snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
	
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
		StdDraw.line(x1, y1, x2, y2);
		return;
		}
		double dx = (x2 - x1) / 3.0;
		double dy = (y2 - y1) / 3.0;

		double ax = x1 + dx;
		double ay = y1 + dy;

		double bx = x1 + 2.0 * dx;
		double by = y1 + 2.0 * dy;

		double cx = -(Math.sqrt(3) / 2.0) * (ay - by) + (ax + bx) / 2.0;
		double cy = -(Math.sqrt(3) / 2.0) * (bx - ax) + (ay + by) / 2.0;

		curve(n - 1, x1, y1, ax, ay);
		curve(n - 1, ax, ay, cx, cy);
		curve(n - 1, cx, cy, bx, by);
		curve(n - 1, bx, by, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double side = 0.75;
		double h = Math.sqrt(3) / 2.0 * side;

		double cx = 0.5;
		double cy = 0.5;

		double x1 = cx - side / 2.0;
		double y1 = cy - h / 3.0;

		double x2 = cx + side / 2.0;
		double y2 = cy - h / 3.0;

		double x3 = cx;
		double y3 = cy + 2.0 * h / 3.0;

		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}