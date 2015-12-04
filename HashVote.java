import java.util.HashMap;

/**
 * Created by Saahil on 12/4/2015.
 */
public class HashVote implements VoteData {

    HashMap<String, Integer> firstChoice = new HashMap<>();
    HashMap<String, Integer> secondChoice = new HashMap<>();
    HashMap<String, Integer> thirdChoice = new HashMap<>();
    @Override
    public void addOption(String cand) {
        firstChoice.put(cand, 0);
        secondChoice.put(cand , 0);
        thirdChoice.put(cand, 0);
    }

    @Override
    public void addTally(String first, String second, String third) {
        firstChoice.put(first, firstChoice.get(first) +1);
        secondChoice.put(second , secondChoice.get(second) +1);
        thirdChoice.put(third, thirdChoice.get(third) +1);
    }

    @Override
    public String getWinnerMostVotes() {
        return null;
    }

    @Override
    public String getWinnerMostPoints() {
        return null;
    }


}
