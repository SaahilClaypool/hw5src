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
    private HashMap<String, Integer> getSumMap(){
        final HashMap<String, Integer> totalPoints = new HashMap<String,Integer>();
        totalPoints.putAll(firstChoice);
        firstChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + value);
        });
        secondChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + value);
        });
        secondChoice.forEach((key, value)->{
            totalPoints.put(key, totalPoints.get(key) + value);
        });
        return totalPoints;
    }
    @Override
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
