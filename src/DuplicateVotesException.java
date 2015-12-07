/**
 * Created by saahil claypool on 12/3/2015.
 */
public class DuplicateVotesException extends Exception {
    String cand;
    DuplicateVotesException(String cand){
        this.cand = cand;
    }
}
