package misc; 

import java.util.Random;

public class OverlappingRectangles {

	// overlapping rectangles in a matrix
	// find number of regions created by these overlapping rectangles
	// and the largest region

	private static final int NO_SHADE  = 0;
	private static final int MAX_RECTS = 100;
	private static int MAX_ORDER = 1500;

	private static int XMAX = 0;
	private static int XMIN = MAX_ORDER;
	private static int YMAX = 0;
	private static int YMIN = MAX_ORDER;



	public static void main(String[] args) {
		Random random = new Random();

		int[][] vertices = new int[MAX_RECTS][4];
		for(int rect = 0; rect < MAX_RECTS; rect ++) {
			vertices[rect][0] = random.nextInt(MAX_ORDER);
			vertices[rect][1] = random.nextInt(MAX_ORDER);
			vertices[rect][2] = random.nextInt(MAX_ORDER);
			vertices[rect][3] = random.nextInt(MAX_ORDER);
		}

		for(int rect = 0; rect < MAX_RECTS; rect ++) {
			XMIN = minOf(XMIN, vertices[rect][0], vertices[rect][2]);
			XMAX = maxOf(XMAX, vertices[rect][0], vertices[rect][2]);
			YMIN = minOf(YMIN, vertices[rect][1], vertices[rect][3]);
			YMAX = maxOf(YMAX, vertices[rect][1], vertices[rect][3]);
		}

		//int maxOrder = maxOf(XMAX, YMAX) - minOf(XMIN, YMIN) +1;
		int maxOrder = maxOf(XMAX, YMAX) + 1; MAX_ORDER = maxOrder;
		int[][] matrix = new int[maxOrder][maxOrder];

		// in JAVA all values default to 0, need not initialize to 0

		// lay the rectangles in the matrix
		int maxShade = 0;
		for(int rect = 0; rect < MAX_RECTS; rect ++) {
			if(vertices[rect][0] <= vertices[rect][2]) {
				if (vertices[rect][1] <= vertices[rect][3])  {
					for(int x = vertices[rect][0]; x <= vertices[rect][2]; x++)
						for(int y = vertices[rect][1]; y <= vertices[rect][3]; y++) {
							matrix[x][y] += 1;
							maxShade = maxOf(maxShade, matrix[x][y]);
						}
				}
			} else if (vertices[rect][1] >= vertices[rect][3]) {
				for(int x = vertices[rect][0]; x <= vertices[rect][2]; x++)
					for(int y = vertices[rect][1]; y >= vertices[rect][3]; y--) {
						matrix[x][y] += 1;
						maxShade = maxOf(maxShade, matrix[x][y]);
					}
			}
			if(vertices[rect][0] >= vertices[rect][2]) {
				if	(vertices[rect][1] <= vertices[rect][3]) {
					for(int x = vertices[rect][0]; x >= vertices[rect][2]; x--)
						for(int y = vertices[rect][1]; y <= vertices[rect][3]; y++) {
							matrix[x][y] += 1;
							maxShade = maxOf(maxShade, matrix[x][y]);
						}
				} else if (vertices[rect][1] >= vertices[rect][3]) {
					for(int x = vertices[rect][0]; x >= vertices[rect][2]; x--)
						for(int y = vertices[rect][1]; y >= vertices[rect][3]; y--) {
							matrix[x][y] += 1;
							maxShade = maxOf(maxShade, matrix[x][y]);
						}
				}
			}
		}

		System.out.println("Matrix of max order " + maxOrder);
		/*for(int x = 0; x < MAX_ORDER; x++, System.out.println())
			for(int y = 0, area = 0; y < MAX_ORDER; System.out.print(matrix[x][y] + " "), y++);*/		

		System.out.println("Area calculations");
		// find the regions of each shade 
		int maxArea = 0, regions = 0;

		for(int shade = maxShade; shade > NO_SHADE; shade --) {
			for(int x = 0; x < MAX_ORDER; x++)
				for(int y = 0, area = 0; y < MAX_ORDER; y++) {
					area = area(x, y, shade, matrix);
					if(area > 0) regions++;
					maxArea = maxOf(maxArea, area);
				}
		}

		System.out.println("Max area - " + maxArea + ", Regions - " + regions);
	}

	static int area(int x, int y, int shade, int[][] matrix) {
		//System.out.println("Maxorder- " + MAX_ORDER + ", " + x + " " + y);
		if(matrix[x][y] != shade) return 0;

		int xRight =0, xLeft =0, yUp = 0, yDown = 0;

		matrix[x][y] = NO_SHADE;

		if(x < XMAX) xRight = area(x+1, y, shade, matrix);
		if(x > 0) 	 xLeft  = area(x-1, y, shade, matrix);
		if(y < YMAX) yUp    = area(x, y+1, shade, matrix);
		if(y > 0) 	 yDown  = area(x, y-1, shade, matrix);


		return 1 + xRight + xLeft + yUp + yDown;
	}

	static int minOf(int a, int b, int c) {
		return (a < b)? minOf(a, c) : minOf(b, c);
	}

	static int maxOf(int a, int b, int c) {
		return (a > b)? maxOf(a, c) : maxOf(b, c);
	}

	static int minOf(int a, int b) {
		return (a < b)? a : b;
	}

	static int maxOf(int a, int b) {
		return (a > b)? a : b;
	}

}
