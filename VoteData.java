
/**
 * Created by Saahil on 12/4/2015.
 */
public interface VoteData {
    public void addOption(String cand);
    public void addTally(String first, String second, String third);
    public String getWinnerMostVotes();
    public String getWinnerMostPoints();

}

