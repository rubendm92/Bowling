package bowling;

import org.junit.Test;

public class ScoreBoardTests {

    @Test
    public void singleThrowTest() {
        PlayerScore board = new PlayerScore("Will");
        board.addThrow(4);
        Assert.assertEquals("Will", board.getPlayerName());
        Assert.assertEquals(0, board.getScore());
    }
    
    @Test
    public void otherSingleThrowTest() {
        PlayerScore board = new PlayerScore("Bill");
        board.addThrow(8);
        Assert.assertEquals(0, board.getScore());
    }
    
    @Test
    public void twoThrowTest() {
        PlayerScore playerScore = new PlayerScore("Matt");
        playerScore.addThrow(8);
        playerScore.addThrow(1);
        Assert.assertEquals(9, playerScore.getScore());
    }
    
    @Test
    public void twoThrowTestWithStrike() {
        PlayerScore playerScore = new PlayerScore("Matt");
        playerScore.addThrow(10);
        playerScore.addThrow(1);
        Assert.assertEquals(0, playerScore.getScore());
    }
    
    @Test
    public void twoThrowTestWithSpare() {
        PlayerScore playerScore = new PlayerScore("Matt");
        playerScore.addThrow(9);
        playerScore.addThrow(1);
        Assert.assertEquals(0, playerScore.getScore());
    }
    
    @Test
    public void zattiWithTwoSparesTest() {
        PlayerScore playerScore = new PlayerScore("Zatti");
        playerScore.addThrow(9);
        playerScore.addThrow(0);
        playerScore.addThrow(9);
        playerScore.addThrow(1);
        playerScore.addThrow(7);
        playerScore.addThrow(3);
        playerScore.addThrow(9);
        playerScore.addThrow(0);
        Assert.assertEquals(54, playerScore.getScore());
    }
    
    @Test
    public void zattiWithTwoSparesAndOneStrikeTest() {
        PlayerScore playerScore = new PlayerScore("Zatti");
        playerScore.addThrow(9);
        playerScore.addThrow(0);
        playerScore.addThrow(9);
        playerScore.addThrow(1);
        playerScore.addThrow(7);
        playerScore.addThrow(3);
        playerScore.addThrow(9);
        playerScore.addThrow(0);
        playerScore.addThrow(9);
        playerScore.addThrow(1);
        playerScore.addThrow(10);
        playerScore.addThrow(8);
        playerScore.addThrow(1);
        Assert.assertEquals(102, playerScore.getScore());
    }
}