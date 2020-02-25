package edu.exercises.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static com.google.common.collect.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(Parameterized.class)
public class IsomorphicTest {
    @Parameter(0)
    public String stringOne;

    @Parameter(1)
    public String stringTwo;

    @Parameter(2)
    public boolean result;

    @Parameters(name = "When string one is: {0} and string two is: {1}, then result must be: {2}")
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][]{
                {"aa", "ab", false},
                {"ca", "ab", true},
                {"foo", "bar", false},
                {"add", "egg", true},
                {"egg", "add", true},
                {"abca", "zbxz", true},
                {"abc", "zbxz", false},
                {"", "zbxz", false},
                {null, "zbxz", false}
        });
    }

    @Test
    public void checksIsomorphic() throws Exception {
        assertThat(Isomorphic.areIsomorphic(stringOne, stringTwo))
                .as("is %s isomorphic to %s", stringOne, stringTwo)
                .isEqualTo(result);
    }
}