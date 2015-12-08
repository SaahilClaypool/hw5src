import java.util.LinkedList;


class ElectionData {
	private LinkedList<String> ballot = new LinkedList<String>();
	// LinkedList<String> votes = new LinkedList<String>();
	private VoteData votes = new HashVote();



	ElectionData() {
		this.ballot.add("Gompei");
		this.ballot.add("Husky");
	}

	public void printBallot() {
		System.out.println("The candidates are ");
		for (String s : ballot) {
			System.out.println(s);
		}
	}
    // Takes in 3 votes, throws a duplicate if unknown candidate or duplicate vote
	public void processVotes(String first, String second, String third)
			throws DuplicateVotesException, UnknownCandidateException {
		if (!ballot.contains(first)) {
			throw new UnknownCandidateException(first);
		}
		if (!ballot.contains(second)) {
			throw new UnknownCandidateException(second);
		}
		if (!ballot.contains(third)) {
			throw new UnknownCandidateException(third);
		}
		if (first.equals(second) || first.equals(third)) {
			throw new DuplicateVotesException(first);
		}
		if (second.equals(third)) {
			throw new DuplicateVotesException(second);
		}
		// move to data class
		votes.addTally(first, second, third);
	}

    // adds candidate to ballot and voting data

	public void addCandidate(String cand) throws CandidateExistsException {
		if (ballot.contains(cand)) {
			throw new CandidateExistsException(cand);
		}

		ballot.add(cand);
		votes.addOption(cand);
	}
    // returns winner with most firt choice votes
	public String findWinnerMostFirstVotes() {
		return votes.getWinnerMostVotes();
	}

	// getSum of individual list, return sum of all three.

    /**
     * returns winner with most total points
     * @return
     */
	public String findWinnerMostPoints() {
		return votes.getWinnerMostPoints();
	}

	public static void main(String[] args) {
		ElectionData el = new ElectionData();
		VotingMachine ma = new VotingMachine(el);
		ma.screen();

	}
}