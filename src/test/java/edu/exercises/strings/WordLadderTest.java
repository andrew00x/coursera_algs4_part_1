package edu.exercises.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.List;
import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static edu.exercises.strings.WordLadder.ladder;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class WordLadderTest {
    private static Set<String> dictionary = newHashSet("hot", "dot", "dog", "cat", "cot", "cog", "con");

    @Parameter(0)
    public String start;

    @Parameter(1)
    public String end;

    @Parameter(2)
    public List<String> result;

    @Parameterized.Parameters(name = "When start word is: {0} and end word is: {1}, then result must be: {2}")
    public static Iterable<Object[]> testData() {
        return newArrayList(new Object[][]{
                {"cat", "cog", newArrayList("cat", "cot", "cog")},
                {"hit", "cog", newArrayList("hit", "hot", "cot", "cog")},
                {"hit", "cat", newArrayList("hit", "hot", "cot", "cat")},
                {"hit", "hop", newArrayList()}
        });
    }

    @Test
    public void testWordLadder() throws Exception {
        assertThat(ladder(start, end, dictionary)).isEqualTo(result);
    }
}