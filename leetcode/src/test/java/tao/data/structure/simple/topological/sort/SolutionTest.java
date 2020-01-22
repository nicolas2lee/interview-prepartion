package tao.data.structure.simple.topological.sort;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
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

        final int[] result = solution.findOrder(2, table);
        assertThat(result).isEmpty();
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

        final int[] result = solution.findOrder(3, table);
        assertThat(result).isEmpty();
    }

    @Test
    public void case_3() {
        int[][] table= new int[1][2];
        table[0][0] = 1;
        table[0][1] = 0;

        final int[] result = solution.findOrder(2, table);
        Arrays.stream(result).forEach(System.out::println);
    }

    @Test
    public void case_4() {
        int[][] table= new int[1][2];
        table[0][0] = 0;
        table[0][1] = 1;

        final int[] result = solution.findOrder(2, table);
        Arrays.stream(result).forEach(System.out::println);
    }

    @Test
    public void case_5() {
        int[][] table= {};

        final int[] result = solution.findOrder(2, table);
        Arrays.stream(result).forEach(System.out::println);
    }


}