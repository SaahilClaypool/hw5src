/**
 * Created by saahil claypool on 12/2/2015.
 */
@SuppressWarnings("serial")
public class CandidateExistsException extends Exception {
    String cand;

    CandidateExistsException(String candidate) {
        cand = candidate;
    }
}
