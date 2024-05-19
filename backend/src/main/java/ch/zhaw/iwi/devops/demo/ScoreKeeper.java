package ch.zhaw.iwi.devops.demo;

public class ScoreKeeper {
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    //TESTFALL 1: 
    public String getScore() {
        return String.format("%03d:%03d", scoreTeamA, scoreTeamB);
    }
     
    //TESTFALL 2:
    public void scoreTeamA3() {
        scoreTeamA += 3;
    }
    
    //TESTFALL 3
       public void scoreTeamA2() {
        scoreTeamA += 2;
       }
       
    //TESTFALL 4: 
    public void scoreTeamA1() {
        scoreTeamA += 1;
    }
    //TESTFALL 5:
    public void scoreTeamB3() {
        scoreTeamB += 3;
    }
    //TESTFALL 6:    
    public void scoreTeamB2() {
        scoreTeamB += 2;
    }
    //TESTFALL 7:
    public void scoreTeamB1() {
        scoreTeamB += 1;
    }

}
