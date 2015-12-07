/**
 * Created by saahil claypool on 12/2/2015.
 */
public class CandidateExistsException extends Exception {
    String cand;
    CandidateExistsException (String candidate) {
        cand = candidate;
    }
}
