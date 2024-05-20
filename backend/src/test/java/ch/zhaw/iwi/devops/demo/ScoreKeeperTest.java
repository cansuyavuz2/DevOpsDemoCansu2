package ch.zhaw.iwi.devops.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ScoreKeeperTest {
    private ScoreKeeper scoreKeeper;

    @BeforeEach
    void setUp() {
        scoreKeeper = new ScoreKeeper();
    }  
     //TESTFALL 1: 
     @Test
     void testInitialScore() {
         Assertions.assertEquals("000:000", scoreKeeper.getScore());
     }
     //TESTFALL 2: 
        
    @Test
    void testScoreTeamA3() {
        scoreKeeper.scoreTeamA3();
        Assertions.assertEquals("003:000", scoreKeeper.getScore());
    }
    //TESTFALL 3:
    @Test
    void testScoreTeamA2() {
        scoreKeeper.scoreTeamA2();
        Assertions.assertEquals("002:000", scoreKeeper.getScore());
    }

    //TESTFALL 4: 
    @Test
    void testScoreTeamA1() {
        scoreKeeper.scoreTeamA1();
        Assertions.assertEquals("001:000", scoreKeeper.getScore());
    }
    //TESTFALL 5:
    @Test
    void testScoreTeamB3() {
        scoreKeeper.scoreTeamB3();
        Assertions.assertEquals("000:003", scoreKeeper.getScore());
    }
    //TESTFALL 6:
    @Test
    void testScoreTeamB2() {
        scoreKeeper.scoreTeamB2();
        Assertions.assertEquals("000:002", scoreKeeper.getScore());
    }
     //TESTFALL 7:   
    @Test
    void testScoreTeamB1() {
    scoreKeeper.scoreTeamB1();
    Assertions.assertEquals("000:001", scoreKeeper.getScore());
}

    //TESTFALL 8:
@Test
    void testMultipleScores() {
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB3();
        Assertions.assertEquals("005:004", scoreKeeper.getScore());
    }
    //TESTFALL 9: 
    @Test
    void testSequentialScores() {
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamA1();
        Assertions.assertEquals("003:000", scoreKeeper.getScore());
    }
    //TESTFALL 10:
    @Test
    void testComplexScoreCombination() {
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamB2();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamB1();
        Assertions.assertEquals("006:006", scoreKeeper.getScore());
    }
    //TESTFALL 11:
    @Test
    void testResetScore() {
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamB3();
        scoreKeeper = new ScoreKeeper();  // Resetting by reinitializing
        Assertions.assertEquals("000:000", scoreKeeper.getScore());
    } 
    
}
