package tao.data.structure.simple.bfs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void test_case_1() {
        int[][] table= new int[1][2];
        table[0][0] = 1;
        table[0][1] = 0;
        final boolean result = solution.canFinish(2, table);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void test_case_2() {
        int[][] table= new int[1][2];
        table[0][0] = 0;
        table[0][1] = 1;
        final boolean result = solution.canFinish(2, table);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void test_case_3() {
        int[][] table= new int[2][2];
        table[0][0] = 0;
        table[0][1] = 1;
        table[1][0] = 1;
        table[1][1] = 0;
        final boolean result = solution.canFinish(2, table);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void test_case_4() {
        int[][] table= new int[5][2];
        table[0][0] = 2;
        table[0][1] = 0;
        table[1][0] = 1;
        table[1][1] = 0;
        table[2][1] = 3;
        table[2][1] = 1;
        table[3][1] = 3;
        table[3][1] = 2;
        table[4][1] = 1;
        table[4][1] = 3;
        final boolean result = solution.canFinish(4, table);
        assertThat(result).isEqualTo(false);
    }

    /*
    4
            [[0,1],[3,1],[1,3],[3,2]]
    */
    @Test
    public void test_case_5() {
        int[][] table= new int[4][2];
        table[0][0] = 0;
        table[0][1] = 1;
        table[1][0] = 3;
        table[1][1] = 1;
        table[2][1] = 1;
        table[2][1] = 3;
        table[3][1] = 3;
        table[3][1] = 2;
        final boolean result = solution.canFinish(4, table);
        assertThat(result).isEqualTo(false);
    }

    /**
     * 3
     * [[0,1],[0,2],[1,2]]
     */
    @Test
    public void test_case_6() {
        int[][] table= new int[3][2];
        table[0][0] = 0;
        table[0][1] = 1;
        table[1][0] = 0;
        table[1][1] = 2;
        table[2][0] = 1;
        table[2][1] = 2;
        final boolean result = solution.canFinish(3, table);
        assertThat(result).isEqualTo(true);
    }

}