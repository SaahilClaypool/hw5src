/**
 * Created by saahil claypool on 12/3/2015.
 */
public class UnknownCandidateException extends Exception {
    String cand;
    public UnknownCandidateException(String cand){
        this.cand = cand;
    }
}
