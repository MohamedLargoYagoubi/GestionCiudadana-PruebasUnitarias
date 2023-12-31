package doublesTest;

import data.VotingOption;
import doubles.ScrutiyOk;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScrutinyDoubleTest implements interfaces.ScrutinyInterfaceTest{

    ScrutiyOk scrutiny;
    List<VotingOption> validParties;
    @BeforeEach
    public void setUp() {
        scrutiny = new ScrutiyOk();
        validParties = Arrays.asList(new VotingOption("Partido A"), new VotingOption("Partido B"));
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
    public void testScrutinize() {
        scrutiny.scrutinize(new VotingOption("BLANCO"));

        assertEquals(1, scrutiny.getBlanks());
        assertEquals(0, scrutiny.getTotal());
    }

    @Override
    @Test
    public void scrutinizeBlankVoteTest() {
        scrutiny.scrutinize(new VotingOption("BLANCO"));
        assertEquals(1, scrutiny.getBlanks());
    }

    @Override
    @Test
    public void getVotesForValidVoteTest() {
        scrutiny.scrutinize(new VotingOption("Partido A"));

        int votes = scrutiny.getVotesFor(new VotingOption("Partido A"));

        assertEquals(1, votes);
    }

    @Override
    @Test
    public void getNullsTest() {
        scrutiny.scrutinize(null);

        assertEquals(1, scrutiny.getNulls());
        assertEquals(1, scrutiny.getTotal());
    }

    @Override
    @Test
    public void getBlanksTest() {
        scrutiny.scrutinize(new VotingOption("BLANCO"));

        assertEquals(1, scrutiny.getBlanks());
        assertEquals(1, scrutiny.getTotal());
    }

    @Override
    @Test
    public void getTotalTest() {
        scrutiny.scrutinize(new VotingOption("Partido A"));

        int total = scrutiny.getTotal();
        assertEquals(2, total);
    }
}
