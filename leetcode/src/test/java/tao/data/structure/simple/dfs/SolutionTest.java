package tao.data.structure.simple.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    /**
     * 8
     * [[1,0],[2,6],[1,7],[5,1],[6,4],[7,0],[0,5]]
     */
    @Test
    public void case_1() {
        int[][] table= new int[7][2];
        table[0][0] = 1;
        table[0][1] = 0;
        table[1][0] = 2;
        table[1][1] = 6;
        table[2][0] = 1;
        table[2][1] = 7;
        table[3][0] = 5;
        table[3][1] = 1;
        table[4][0] = 6;
        table[4][1] = 4;
        table[5][0] = 7;
        table[5][1] = 0;
        table[6][0] = 0;
        table[6][1] = 5;
        final boolean result = solution.canFinish(8, table);
        assertThat(result).isFalse();
    }
}