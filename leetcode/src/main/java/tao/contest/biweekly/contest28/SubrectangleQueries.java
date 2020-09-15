package tao.contest.biweekly.contest28;


class SubrectangleQueries {
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle =rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i=row1; i<=row2; i++){
            for (int j=col1; j<=col2; j++){
                rectangle[i][j]=newValue;
            }
        }

    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public static void main(String[] args) {
        int[][] map = {{1,2,1},{4, 3, 4}, {3, 2, 1}, {1,1,1}};

        SubrectangleQueries s = new SubrectangleQueries(map);
        System.out.println(s.getValue(0, 2));
        s.updateSubrectangle(0,0, 3, 2, 5);

        System.out.println(s.getValue(0, 2));
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */

