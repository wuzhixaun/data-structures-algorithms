package com.wuzx.algorithmicThinking.back;


/**
 * 回溯算法:N皇后问题
 */
public class NQueens {

    int QUEENS;
    int[] result; // 下标表示行,值表示queen存储在哪一列

    /**
     * 构建n皇后哦
     *
     * @param n
     */
    public NQueens(int n) {
        this.QUEENS = n;
        this.result = new int[n];
    }


    /**
     * 在对应的行放置 皇后
     *
     * @param row
     */
    public void setQueens(int row) {

        if (row == QUEENS) {
            printQueens();
            return;
        }

        // 在每行一次放置列
        for (int col = 0; col < QUEENS; col++) {
            if (!isOk(row, col)) {
                continue;
            }
            //设置列
            result[row] = col;
            // 开始下一行
            setQueens(row + 1);
        }


    }


    public boolean isOk(int row, int col) {

        int leftup = col - 1;
        int rightup = col + 1;
// 逐行往上考察每一行
        for (int i = row - 1; i >= 0; i--) { //列上存在queen
            if (result[i] == col) return false; //左上对角线存在queen
            if (leftup >= 0) {
                if (result[i] == leftup) return false;
            }
//右下对角线存在queen
            if (rightup < QUEENS) {
                if (result[i] == rightup) return false;
            }
            leftup--;
            rightup++; }
        return true;


    }


    /**
     * 打印输出 */
    private void printQueens() {
        for (int i = 0; i < QUEENS; i++) {
            for (int j = 0; j < QUEENS; j++) {
                if (result[i] == j) {
                    System.out.print("Q| ");
                }
                else {
                    System.out.print("*| ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        NQueens queens=new NQueens(8);
        queens.setQueens(0);
    }

}



