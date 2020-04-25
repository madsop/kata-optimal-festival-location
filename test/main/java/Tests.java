import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Tests {

    private FestivalLocationFinder festivalLocationFinder;

    @Before
    public void setUp() {
        festivalLocationFinder = new FestivalLocationFinder();
    }

    @Test
    public void onePersonAtOneOneGives0() {
        assertThat(festivalLocationFinder.find(List.of(1), List.of(1), List.of(1)), is(0));
    }

    @Test
    public void onePersonAtOneOneAndOneAtTwoTwoGives2() {
        assertThat(festivalLocationFinder.find(List.of(1,1), List.of(1,2), List.of(1,2)), is(2));
    }

    @Test
    public void onePersonAtOneOneAndOneAtTwoTwoAndOneAtThreeOneGives3() {
        assertThat(festivalLocationFinder.find(List.of(1,1,1), List.of(1,2,3), List.of(1,2,1)), is(3));
    }

    @Test
    public void twoPersonsAtOneOneAndOneAtThreeTwoGives3() {
        assertThat(festivalLocationFinder.find(List.of(2,1), List.of(1,3), List.of(1,2)), is(3));
    }

    @Test
    public void onePersonAtThreeThreeThenOneAtOneFiveAndThenAnotherOneAtThreeThreeGives4() {
        assertThat(festivalLocationFinder.find(List.of(1,1,1), List.of(3,1,3), List.of(3,5,3)), is(4));
    }
}
