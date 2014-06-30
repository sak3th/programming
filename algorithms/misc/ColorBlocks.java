package misc;

import java.awt.Point;
import java.util.Random;
import java.util.Stack;

public class ColorBlocks {

    public static void main(String[] args) {
        Random random = new Random();
        int[][] grid = new int[1000][1000];
        for(int x = 0; x < grid.length; x++, System.out.println()) {
            for(int y = 0; y < grid.length; y++) {
                grid[x][y] = random.nextInt(9) + 1;
                System.out.print(grid[x][y] + " ");
            }
        }
        long before = System.currentTimeMillis();
        new ColorBlocks().solve(grid);
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
    
    public void solve(int[][] grid) {
        int numClicks = 0; int clicks = 0; int maxArea = 0;
        for(int x = 0; x < grid.length; x++) {
            for(int y = 0; y < grid.length; y++, clicks = 0) {
                if(grid[x][y] != 0) clicks = dfsClick(grid, x, y);
                if(clicks > 0) {
                    numClicks++;
                    maxArea = (maxArea > clicks)? maxArea : clicks;
                }
            }
        }
        
        System.out.println(numClicks + " " + maxArea);
    }
    
    public int dfsClick(int[][] grid, int x, int y) {
        int clicks = 0;
        int color = grid[x][y];
        int fence = grid.length - 1;
        
        Stack<Point> stack = new Stack<Point>();
        stack.push(new Point(x,y));
        Point p = null;
        while(!stack.isEmpty()) {
            p = stack.pop();
            if(p.x < 0 || p.x > fence) continue;
            if(p.y < 0 || p.y > fence) continue;
            if(grid[p.x][p.y] == 0 ) continue;
            if(grid[p.x][p.y] != color) continue;
            clicks++; grid[p.x][p.y] = 0;

            if(p.x - 1 >= 0     && p.y - 1 >= 0    )    stack.push(new Point(p.x - 1, p.y - 1));
            if(                    p.y - 1 >= 0    )    stack.push(new Point(p.x    , p.y - 1));
            if(p.x + 1 <= fence && p.y - 1 >= 0    )    stack.push(new Point(p.x + 1, p.y - 1));
            if(p.x - 1 >= 0                        )    stack.push(new Point(p.x - 1, p.y    ));
            if(p.x + 1 <= fence                    )    stack.push(new Point(p.x + 1, p.y    ));
            if(p.x - 1 >= 0     && p.y + 1 <= fence)    stack.push(new Point(p.x - 1, p.y + 1));
            if(                    p.y + 1 <= fence)    stack.push(new Point(p.x    , p.y + 1));
            if(p.x + 1 <= fence && p.y + 1 <= fence)    stack.push(new Point(p.x + 1, p.y + 1));
        }
        
        return clicks;
    }

}
