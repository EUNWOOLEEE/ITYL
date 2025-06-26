import java.util.*;

class Main {
	public class Item {
		int[] red
	}

	public static void main(String[] argv) {
		Scanner sc = new Scanner(System.in);

		int height = sc.nextInt();
		int width = sc.nextInt();
		int[] red, blue, hole;
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

		sc.nextLine();
		char[][] map = new char[height][];
		for (int i = 0; i < height; i++) {
			map[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < width; j++) {
				if (map[i][j] == 'R') red = new int[]{i, j};
				else if (map[i][j] == 'B') blue = new int[]{i, j};
				else if (map[i][j] == 'O') hole = new int[]{i, j};
			}
		}
	}
}