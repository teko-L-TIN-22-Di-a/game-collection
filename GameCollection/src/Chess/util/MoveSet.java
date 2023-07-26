package Chess.util;

import java.util.ArrayList;

public class MoveSet {
    public static ArrayList<int[]> getCardinalCoordinates(int x, int y) {
        ArrayList<int[]> coordinates = new ArrayList<>();

        for(int i = 0; i < Chessboard.rows; i++) {
            // West
            if (y - i >= 0) {
                coordinates.add(new int[]{x, y - i});
            }

            // East
            if (y + i <= 7) {
                coordinates.add(new int[]{x, y + i});
            }

            // East
            if (x + i <= 7) {
                coordinates.add(new int[]{x + i, y});
            }

            // West
            if (x - i >= 0) {
                coordinates.add(new int[]{x - i, y});
            }
        }

        return coordinates;
    }
}
