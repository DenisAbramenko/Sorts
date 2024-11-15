package org.example;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] teams = {
                {45, 31, 24, 22, 20, 17, 14, 13, 12, 10},
                {31, 18, 15, 12, 10, 8, 6, 4, 2, 1},
                {51, 30, 10, 9, 8, 7, 6, 5, 2, 1}
        };

        int[] nationalTeam = mergeAll(teams);
        System.out.println(Arrays.toString(nationalTeam)); // [51, 45, 31, 31, 30, 24, 22, 20, 18, 17]
    }

    /**
     * Метод для слияния всех команд в одну национальную
     */
    public static int[] mergeAll(int[][] teams) {
        int[] result = teams[0];
        for (int i = 1; i < teams.length; i++) {
            result = merge(result, teams[i]);
        }
        return result;
    }

    /**
     * Метод для слияния двух команд в одну
     */
    public static int[] merge(int[] teamA, int[] teamB) {
        int i = 0;
        int j = 0;
        int r = 0;
        int[] result = new int[10];
        while (i < teamA.length && j < teamB.length && r < 10) {
            if (teamA[i] > teamB[j]) {
                result[r++] = teamA[i++];
            } else {
                result[r++] = teamB[j++];
            }
        }
        while (i < teamA.length && r < 10) {
            result[r++] = teamA[i++];
        }
        while (j < teamB.length && r < 10) {
            result[r++] = teamB[j++];
        }
        return result;
    }
}