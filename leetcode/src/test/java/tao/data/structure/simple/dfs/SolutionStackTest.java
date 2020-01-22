package tao.data.structure.simple.dfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionStackTest {

    private SolutionStack solution;

    @Before
    public void setUp() throws Exception {
        solution = new SolutionStack();
    }

    /**
     * 2
     * [[0,1],[1,0]]
     */
    @Test
    public void case_1() {
        int[][] table= new int[2][2];
        table[0][0] = 0;
        table[0][1] = 1;
        table[1][0] = 1;
        table[1][1] = 0;

        final boolean result = solution.canFinish(2, table);
        assertThat(result).isFalse();
    }

    /**
     * 3
     * [[1,0],[2,0],[0,2]]
     */
    @Test
    public void case_2() {
        int[][] table= new int[3][2];
        table[0][0] = 1;
        table[0][1] = 0;
        table[1][0] = 2;
        table[1][1] = 0;
        table[1][0] = 0;
        table[1][1] = 2;

        final boolean result = solution.canFinish(3, table);
        assertThat(result).isFalse();
    }

}