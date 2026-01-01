/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
    if (n <= 0) {
			return;
		}
		StdDraw.setPenColor(StdDraw.BLACK);

		// big trianlge draw		
    double height = Math.sqrt(3) / 2;
    double x1 = 0;
    double y1 = (1 - height) / 2;
    double x2 = 1;
    double y2 = y1;
		double x3 = 0.5;
    double y3 = y1 + height;
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);

		sierpinski(n, x1, x2, x3, y1, y2, y3);

		StdDraw.show();
	}

	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3, double y1, double y2, double y3) {
    if (n == 1) {
			return;
		}
    double midX12 = (x1 + x2) / 2;
    double midY12 = (y1 + y2) / 2;
    double midX23 = (x2 + x3) / 2;
    double midY23 = (y2 + y3) / 2;
    double midX31 = (x3 + x1) / 2;
    double midY31 = (y3 + y1) / 2;

    // draw the middle triangle
    StdDraw.line(midX12, midY12, midX23, midY23);
    StdDraw.line(midX23, midY23, midX31, midY31);
    StdDraw.line(midX31, midY31, midX12, midY12);

		// left corner
		sierpinski(n - 1, x1, midX12, midX31, y1, midY12, midY31);
		// right corner
		sierpinski(n - 1, midX12, x2, midX23, midY12, y2, midY23);
		// top corner
		sierpinski(n - 1, midX31, midX23, x3, midY31, midY23, y3);
	}
}