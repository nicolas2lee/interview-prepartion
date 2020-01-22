package tao.data.structure.simple.stack;

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
    public void case_1() {
        final boolean result = solution.isValid("()");
        assertThat(result).isEqualTo(true);

    }
}