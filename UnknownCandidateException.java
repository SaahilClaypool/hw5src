/**
 * Created by saahil claypool on 12/3/2015.
 */
@SuppressWarnings("serial")
/**
 * thrown when an unknown candidate is voted for
 */
public class UnknownCandidateException extends Exception {
	private String cand;

	public UnknownCandidateException(String cand) {
		this.cand = cand;
	}

	public Object getCand() {
		return cand;
	}
}
