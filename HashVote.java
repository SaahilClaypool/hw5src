import java.util.HashMap;

/**
 * Created by Saahil on 12/4/2015.
 * Holds Voting Data
 */

public class HashVote implements VoteData {

    // Hashmap for first second and third choices
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
    // takes in three votes and adds tallies to the respective candidates
    public void addTally(String first, String second, String third) {
        firstChoice.put(first, firstChoice.get(first) +1);
        secondChoice.put(second , secondChoice.get(second) +1);
        thirdChoice.put(third, thirdChoice.get(third) +1);
    }

    @Override
    // returns the winner with the most first place votes
    public String getWinnerMostVotes() {
        final String[] keyMax = {""};
        final int[] maxVal = {0};
        firstChoice.forEach((key,value)->{
            if(value> maxVal[0]){
                maxVal[0] = value;
                keyMax[0] = key;
            }
        });
        return keyMax[0];
    }
    // Helper method returns a map that is the sum
    private HashMap<String, Integer> getSumMap(){
        final HashMap<String, Integer> totalPoints = new HashMap<String,Integer>();
        totalPoints.putAll(firstChoice);
        // 3 points for first choice, 2 for second, one for third
        firstChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + 3* value);
        });
        secondChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + 2* value);
        });
        thirdChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + value);
        });
        return totalPoints;
    }
    @Override
    // returns the winner with the most points
    public String getWinnerMostPoints() {
        HashMap<String,Integer> totalPoints = getSumMap();
        final int[] maxVal = {0};
        final String[] maxKey = {""};
        totalPoints.forEach((key,value)-> {
            if(value > maxVal[0]){
                maxVal[0] = value;
                maxKey[0] = key;
            }
        });
        return maxKey[0];
    }


}
