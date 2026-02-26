package test13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkylineProblem {

    static class Building {
        int left, height, right;
        Building(int left, int height, int right) {
            this.left = left;
            this.height = height;
            this.right = right;
        }
    }

    // Merge two skylines
    private static List<int[]> mergeSkylines(List<int[]> leftSky, List<int[]> rightSky) {
        List<int[]> merged = new ArrayList<>();
        int h1 = 0, h2 = 0;
        int i = 0, j = 0;

        while (i < leftSky.size() && j < rightSky.size()) {
            int x;
            int y;
            if (leftSky.get(i)[0] < rightSky.get(j)[0]) {
                x = leftSky.get(i)[0];
                h1 = leftSky.get(i)[1];
                y = Math.max(h1, h2);
                i++;
            } else if (leftSky.get(i)[0] > rightSky.get(j)[0]) {
                x = rightSky.get(j)[0];
                h2 = rightSky.get(j)[1];
                y = Math.max(h1, h2);
                j++;
            } else { // same x-coordinate
                x = leftSky.get(i)[0];
                h1 = leftSky.get(i)[1];
                h2 = rightSky.get(j)[1];
                y = Math.max(h1, h2);
                i++;
                j++;
            }

            // Only add point if height changes
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] != y) {
                merged.add(new int[]{x, y});
            }
        }

        // Append remaining points
        while (i < leftSky.size()) merged.add(leftSky.get(i++));
        while (j < rightSky.size()) merged.add(rightSky.get(j++));

        return merged;
    }

    // Divide-and-conquer to compute skyline for n buildings
    public static List<int[]> getSkyline(Building[] buildings, int left, int right) {
        if (left == right) {
            List<int[]> skyline = new ArrayList<>();
            skyline.add(new int[]{buildings[left].left, buildings[left].height});
            skyline.add(new int[]{buildings[left].right, 0});
            return skyline;
        }

        int mid = (left + right) / 2;
        List<int[]> leftSky = getSkyline(buildings, left, mid);
        List<int[]> rightSky = getSkyline(buildings, mid + 1, right);

        return mergeSkylines(leftSky, rightSky);
    }

    public static void main(String[] args) {
        Building[] buildings = {
                new Building(1, 11, 5),
                new Building(2, 6, 7),
                new Building(3, 13, 9),
                new Building(12, 7, 16),
                new Building(14, 3, 25)
        };

        List<int[]> skyline = getSkyline(buildings, 0, buildings.length - 1);

        System.out.println("Skyline:");
        for (int[] p : skyline) {
            System.out.println(Arrays.toString(p));
        }
    }
}


