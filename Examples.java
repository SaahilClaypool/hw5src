import tester.TestMethod;
import tester.Tester;

/**
 * Created by saahil claypool on 12/3/2015.
 */
public class Examples {
	@TestMethod
	// simple test should throw becase tim has already been added to the list
	public boolean testCandidateExists(Tester t)
			throws CandidateExistsException {
		ElectionData e = new ElectionData();
		e.addCandidate("tim");
		return t.checkException(new CandidateExistsException("tim"), e,
				"addCandidate", "tim");
	}

	@TestMethod
	// simple test that should throw because tom is entered twice
	public boolean testDuplicateVotes(Tester t) throws CandidateExistsException {
		ElectionData e = new ElectionData();
		e.addCandidate("tim");
		e.addCandidate("tom");
		return t.checkException(new DuplicateVotesException("tim"), e,
				"processVotes", "tim", "tim", "tom");
	}

	@TestMethod
    // Throws because unknown candidate is voted for
	public boolean testUnkownCandidate(Tester t) {
		ElectionData e = new ElectionData();
		try {
			e.addCandidate("tim");
			e.addCandidate("tom");
		} catch (CandidateExistsException exc) {
			return t.fail();
		}
		return t.checkException(new UnknownCandidateException("time"), e,
				"processVotes", "time", "tim", "tom");
	}

	@TestMethod
    // throws the unkown cadidate exception before the duplicate even though both are faulty votes
	public boolean testOrderOfException(Tester t) {
		ElectionData e = new ElectionData();
		// would fail both exceptions, should throw unkown first

		return t.checkException(new UnknownCandidateException("tim"), e,
				"processVotes", "tim", "tim", "tom");
	}

	@TestMethod
    // Winner should be "1" because it has the most first place votes but not most total
	public boolean testMostVotes(Tester t) {
		ElectionData e = getSampleElectionData();

		// Even though 5 has the most points, 1 should
		return t.checkExpect("1".equals(e.findWinnerMostFirstVotes()));
	}

	@TestMethod
    // 5 should win because it has the most points
	public boolean testMostPoints(Tester t) {
		ElectionData e = getSampleElectionData();

		return t.checkExpect("5", e.findWinnerMostPoints());
	}

	/*@TestMethod
	public boolean testMostPointsIntegration(Tester t) {
		ElectionData e = getSampleElectionData();

		return t.fail();
	}
*/
	/*
	 * (Non-javadoc)
	 * @formatter:off
	 * Election progress is in the current format:
	 * x   1 2 3 4 5
	 * --------------
	 * 1vs 1 1 1 1 1
	 * 
	 * 2vs 0 0 1 0 4
	 * 
	 * 3vs 1 0 1 3 0
	 * 
	 * sc  4 3 6 6 9
	 * @formatter:on
	 */
	public static ElectionData getSampleElectionData() {
		ElectionData e = new ElectionData();
		try {
			e.addCandidate("1");
			e.addCandidate("2");
			e.addCandidate("3");
			e.addCandidate("4");
			e.addCandidate("5");
			e.processVotes("1", "5", "3");
			e.processVotes("5", "3", "4");
			e.processVotes("2", "5", "4");
			e.processVotes("3", "5", "4");
			e.processVotes("4", "5", "1");
		} catch (Exception exc) {
			System.err.println("Error when building test data: "
					+ exc.getMessage());
			exc.printStackTrace();
		}

		return e;
	}

	public static void main(String[] args) {
		Tester.run(new Examples());

	}
}
