
/**
 * Created by Saahil on 12/4/2015.
 */
// interface for storing the data for a vote
public interface VoteData {
    // adds possible voting option
    public void addOption(String cand);
    // adds a vote to 3 candidates
    public void addTally(String first, String second, String third);
    // returns the winner with the most first place votes
    public String getWinnerMostVotes();
    // returns the winner with the most points
    public String getWinnerMostPoints();

}

