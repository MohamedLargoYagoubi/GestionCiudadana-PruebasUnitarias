import data.VotingOption;
import doubles.ScrutiyOk;
import doublesTest.interfaces.ScrutinyInterfaceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrutinyDoubleTest implements ScrutinyInterfaceTest {

    ScrutiyOk scrutiny;
    List<VotingOption> validParties;
    @BeforeEach
    public void setUp() {
        scrutiny = new ScrutiyOk();
        validParties = Arrays.asList(new VotingOption("Partido A"), new VotingOption("Partido B"), new VotingOption("Partido C"));

    }
    @Override
    @Test
    public void testInitVoteCount() {
        scrutiny.initVoteCount(validParties);

        assertEquals(3, scrutiny.getTotal());
        assertEquals(0, scrutiny.getNulls());
        assertEquals(0, scrutiny.getBlanks());

    }
    @Override
    @Test
    public void scrutinizeBlankVoteTest() {
        scrutiny.scrutinize(new VotingOption("BLANCO"));
        assertEquals(1, scrutiny.getBlanks());
    }
    @Override
    @Test
    public void getNullsTest() {
        scrutiny.scrutinize(null);

        assertEquals(1, scrutiny.getNulls());
    }
    @Override
    @Test
    public void getBlanksTest() {
        scrutiny.scrutinize(new VotingOption("BLANCO"));

        assertEquals(1, scrutiny.getBlanks());
    }

}
