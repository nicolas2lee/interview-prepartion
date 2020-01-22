package tao.data.structure.simple.string.longest.palindromic.string;

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
    public void case_odd() {
        final String result = solution.longestPalindrome("babad");
        assertThat(result).isEqualTo("bab");

    }
    @Test
    public void case_even() {
        final String result = solution.longestPalindrome("cbbd");
        assertThat(result).isEqualTo("bb");

    }

    @Test
    public void case_even2() {
        final String result = solution.longestPalindrome("bb");
        assertThat(result).isEqualTo("bb");

    }

    @Test
    public void case_even3() {
        final String result = solution.longestPalindrome("abb");
        assertThat(result).isEqualTo("bb");

    }
    @Test
    public void case_empty() {
        final String result = solution.longestPalindrome("");
        assertThat(result).isEqualTo("");

    }
}