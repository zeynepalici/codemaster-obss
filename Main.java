package com.company;

public class Main {

    public static int sum(int[] C) {
        int sum = 0; // initialize sum
        int i;

        // Iterate through all elements and add them to sum
        for (i = 0; i < C.length; i++)
            sum += C[i];

        return sum;
    }

    public static String solution(int U, int L, int[] C) {
        if (sum(C) != U + L) {
            return "IMPOSSIBLE";
        }

        int column = C.length;

        int[][] M = new int[2][column];

        int firstcount = 0;

        for (int i = 0; i < C.length; i++) {
            if (C[i] == 2) {
                M[0][i] = 1;
                M[1][i] = 1;
                firstcount++;
            } else if (C[i] == 0) {
                M[0][i] = 0;
                M[1][i] = 0;
            } else if (C[i] == 1) {
                if (firstcount < U) {
                    M[0][i] = 1;
                    firstcount++;
                } else if (firstcount >= U) {
                    M[1][i] = 1;
                }
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < M.length; ++i) {

            {
                for (int j = 0; j < M[i].length; ++j)
                    if (j > 0)
                        result.append(M[i][j]);
                    else
                        result.append(M[i][j]);
            }

            if (i != M.length - 1)
                result.append(',');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] C = {2, 1, 1, 0, 1};
        System.out.println(solution(3, 2, C));
    }
}
