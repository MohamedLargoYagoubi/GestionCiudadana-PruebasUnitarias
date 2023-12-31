package interfaces;

import org.junit.jupiter.api.Test;

public interface ScrutinyInterfaceTest {
    @Test
    void testInitVoteCount();
    @Test
    void testScrutinize();

    @Test
    void scrutinizeBlankVoteTest();

    @Test
    void getVotesForValidVoteTest();

    @Test
    void getNullsTest();

    @Test
    void getBlanksTest();

    @Test
    void getTotalTest();
}
