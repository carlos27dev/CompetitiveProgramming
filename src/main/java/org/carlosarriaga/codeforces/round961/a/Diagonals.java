package org.carlosarriaga.codeforces.round961.a;

import java.util.Scanner;

public class Diagonals {
    private Integer[] diagonals(int sideLength) {
        Integer[] diagonals = new Integer[2 * sideLength - 1];
        diagonals[0] = sideLength;
        int step = 1;
        for (int i = 1; i < 2 * sideLength - 1; i += 2) {
            diagonals[i] = sideLength - step;
            diagonals[i + 1] = sideLength - step;
            step++;
        }
        return diagonals;
    }
    public int placer(int sideLength, int chips) {
        if (chips == 0) {
            return 0;
        }
        Integer[] diagonals = this.diagonals(sideLength);
        for (int i = 0; i < 2 * sideLength - 1; i++) {
            chips -= diagonals[i];
            if (chips <= 0) {
                return i + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Diagonals sol = new Diagonals();
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            int sideLength = sc.nextInt();
            int chips = sc.nextInt();
            int result = sol.placer(sideLength, chips);
            System.out.println(result);
        }
        sc.close();
    }
}
