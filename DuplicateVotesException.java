/**
 * Created by saahil claypool on 12/3/2015.
 */
@SuppressWarnings("serial")
/**
 * thrown when a vote is processed with a duplicate candidate
 */
public class DuplicateVotesException extends Exception {
	private String cand;

	DuplicateVotesException(String cand){
		this.cand = cand;
	}

	public String getCand() {
		return cand;
	}


}
