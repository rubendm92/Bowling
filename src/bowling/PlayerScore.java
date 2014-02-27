package bowling;

import java.util.ArrayList;
import java.util.stream.Stream;

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
        return getStream().reduce(0, (sum, frame) -> sum + frame.getPoints(), Integer::sum);
    }

    private Stream<Frame> getStream() {
        return getFrameList().stream();
    }

    private ArrayList<Frame> getFrameList() {
        ArrayList<Frame> result = new ArrayList<>();
        int index = 0;
        while (new Frame(index).isCalculable()) {
            result.add(new Frame(index));
            index += (new Frame(index).isStrike() ? 1 : 2);
        }
        return result;
    }

    private class Frame {

        private final int index;

        public Frame(int index) {
            this.index = index;
        }

        public int getPoints() {
            if (!isCalculable()) {
                return 0;
            }
            if (isFull()) {
                return scores[index] + scores[index + 1] + scores[index + 2];
            }
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
