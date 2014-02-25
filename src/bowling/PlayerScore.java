package bowling;

import java.util.Iterator;

public class PlayerScore {

    private final String playerName;
    private final int[] scores;
    private int size;

    public PlayerScore(String playerName) {
        this.playerName = playerName;
        this.scores = new int[21];
        this.size = 0;
    }
    
    public String getPlayerName() {
        return playerName;
    }

    public void addThrow(int pins) {
        scores[size++] = pins;
    }

    public int getScore() {
        int score = 0;
        for (Frame frame : frames())
            score += frame.getPoints();
        return score;
    }
    
    private Iterable<Frame> frames() {
        return () -> createIteratorOfFrames();
    }

    private Iterator<Frame> createIteratorOfFrames() {
        return new Iterator<Frame>() {
            
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return new Frame(index).isCalculable();
            }
            
            @Override
            public Frame next() {
                Frame frame = new Frame(index);
                index += (frame.isStrike() ? 1 : 2);
                return frame;
            }
        };
    }
    
    private class Frame {

        private final int index;
        
        public Frame(int index) {
            this.index = index;
        }
        
        public int getPoints() {
            if (!isCalculable()) return 0;
            if (isFull()) return scores[index] + scores[index + 1] + scores[index + 2];
            return scores[index] + scores[index + 1];
        }
        
        private boolean isCalculable() {
            return index + (isFull() ? 2 : 1) < size;
        }

        private boolean isFull() {
            return isSpare() || isStrike();
        }

        private boolean isSpare() {
            return (scores[index] + scores[index + 1] == 10);
        }

        private boolean isStrike() {
            return (scores[index] == 10);
        }
    }
}
