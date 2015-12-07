
/**
 * Created by Saahil on 12/4/2015.
 */
public interface VoteData {
    /**
     * TODO Comments
     * 
     * @param cand
     */
    public void addOption(String cand);

    /**
     * TODO Comments
     * 
     * @param first
     * @param second
     * @param third
     */
    public void addTally(String first, String second, String third);

    /**
     * TODO Comments
     * 
     * @return
     */
    public String getWinnerMostVotes();

    /**
     * TODO Comments
     * 
     * @return
     */
    public String getWinnerMostPoints();
}
