/**
 * Created by saahil claypool on 12/2/2015.
 */
@SuppressWarnings("serial")
// Thrown when a candidatd that already has been added the ballot is added again
public class CandidateExistsException extends Exception {
	private String cand;
	CandidateExistsException (String candidate) {
		cand = candidate;
	}


	public String getCand() {
		return this.cand;
	}
}
