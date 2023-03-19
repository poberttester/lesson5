package com.company;

public class Chess {
    private int array[][] = new int[8][8];
    private int count = 0;


    private boolean tryFerz(int a, int b) {
        for (int i = 0; i < a; ++i){
            if (array[i][b] == 1)
                return false;

        }

        for (int i = 1; i <= a && b - i >= 0; ++i){
            if (array[a - i][b - i] == 1)
                return false;

        }

        for (int i = 1; i <= a && b + i < array.length; i++){
            if (array[a - i][b + i] == 1)
                return false;

        }
        return true;
    }

    public void setFerz(int a) {
        if (a == array.length) {
            ++count;
            System.out.print("Result #" + count + '\n');
            showBoard();
            return;
        }

        for (int i = 0; i < array.length; ++i) {
            if (tryFerz(a, i)) {
                array[a][i] = 1;
                setFerz(a + 1);
                array[a][i] = 0;
            }
        }
    }

    private void showBoard() {
        for (int a = 0; a < array.length; ++a) {
            for (int b = 0; b < array.length; ++b) {
                System.out.print((array[a][b] == 1) ? "x " : "0 ");
            }
            System.out.print('\n');
        }
    }
}
